# RobotML - Langage de Contrôle de Robots Mobiles

Ce projet implémente le Domain-Specific Languages (DSL) RobotML. Un langage destiné à donner des instructions à un robot. Il couvre toutes les étapes de sa mise en oeuvre: la définition de métamodèle en utilisant ecore, la modelisation textuel avec Langium, la mise en place de l'interpréteur et du compilateur. 

## Structure du Projet

L'architecture du projet est organisée pour séparer la syntaxe, la sémantique et les outils web.

* Le dossier **ecore** contient le projet eclipse, on y retrouve dans le dossier **RobotML** le schema du metamodele ecore inclus dans **robotML.aird**. Le dossier **org.xtext.example.mydsl** a été généré à partir du modèle ecore. C'est la grammaire XText qui correspond au modèle, 
* Le dossier **rml** contient la grammaire langium dans **src/language** ainsi que la partie web avec les composanat de l'application **src/web**, interpreteur et compilateur **src/semantics**.

---
## 1. Métamodèle
### 1.1. Description du métamodèle

![](/metamodel.png "Metamodel").

Le métamodèle (défini initialement à la main puis avec Ecore) structure les concepts clés du langage.

### Concepts Clés

- **Programme et Fonctions** : La class *Programme* constitue la racine du métamodèle. Le programme contient ou non des déclarations de fonctions (*FuncDecl*). La signature d'une fonction est constituée d'un *Type* et de plusieurs déclarations de variables (*VarDecl*).

- **Types et unités** : Les types sont gérés par une classe abstraite *Type*. Cette classe peut ensuite être dérivée en 3 sous-classes: *Number*, *Void*, *Bool*. Les unités sont intégrées au type *Number* par aggrégation.

- **Listes de statements, statements, structures de contrôle** : Chaque fonction contient un *StatementList*, une liste de statements, qui elle-même contient des *Statement*s. Un statement peut être un appel de fonction *FuncCall*, une assignation de variable *VarAssign*, une déclaration de variable *VarDecl* ou un cppel de capteur/commande. Les structures de contrôle sont implémentées en sous-classes de *Statement* qui contiennent elles-mêmes un *StatementList*.

- **Expressions et opérations** : Une *Expression* est une structure qui peut être évaluée pour retourner une valeur: par exemple, une référence de variable *VariableRef*, un littéral *Literal* *Num-* ou *Bool*, un appel de fonction *FuncCall*, ou bien une *Operation*. Une opération peut être unaire ou binaire (*UnaryOperation* ou *BinaryOperation*), et une opération unaire ou binaire peut être *Num-* (s'évalue en *Number*) ou *Bool-* (s'évalue en *Bool*).

- **Capteurs et commandes** : Accès aux données environnementales (*Distance*, *Time*, *Battery*), et primitives de mouvement (*Forward*, *Backward*, *SideLeft*, *SideRight*). Chaque accès aux capteurs et chaque primitive de mouvement est représentée par sa propre classe. Les capteurs sont des *Expression*s; en effet, cela n'est pas très différent d'un appel de fonction. Les commandes sont des *Statement*s.

---

### 1.2. Décisions d'Ingénierie & Alternatives

### Gestion des unités

Nous traitons les unités (cm, mm, rad, deg) comme une simples propriété de la classe *Number* (attribut de type *Unit*), plutôt que comme des classes à part entière. Cela nous permet de simplifier grandement la structure de notre métamodèle. La contrepartie est que nous devons nous assurer de la compatibilité entre unités au niveau sémantique, alors que cela serait possible au niveau syntaxique avec des unités représentées en tant que classes.

<!-- * Les unités sont traitées comme des propriétés du type `Number` (ex: `150 in mm`) plutôt que de simples casts. -->
<!---->
<!-- * Cela permet une validation sémantique plus fine (empêcher l'addition de distances et d'angles) et facilite la conversion automatique vers les unités standard du robot (mm/s) lors de la compilation/interprétation. -->

### Séparation des opérations booléennes et arithmétiques

Nous avons décidé de distinguer les opérations booléennes des opérations arithmétiques dans le métamodèle et la grammaire. Cela permet de simplifier l'écriture des règles de validation et d'éviter les incohérences de type lors de la génération de code.

<!-- * Distinction explicite dans le métamodèle et la grammaire. -->
<!---->
<!-- * Cela simplifie l'écriture des règles de validation et évite les incohérences de type lors de la génération de code. -->

## 2. Compilation

La chaîne de compilation transforme un fichier RobotML (`.rml`) en code pour être utilisé sur un robot Arduino.

### 2.1. Architecture du Compilateur

Pour exécuter le programme, le visitor design pattern est utilisé. 
La classe `RobotMlCompiler` implémente l'interface `RobotMlVisitor` générée par Langium. Elle parcourt l'arbre de syntaxe abstraite (AST) produit par le parseur et génère le texte correspondant au code Arduino final.

### 2.2. Stratégie de traduction

La traduction s'effectue de la manière suivante:

* **Structure Globale** :
* Les bibliothèques Arduino nécessaires (`Omni4WD`, `MotorWheel`, `PID_Beta6`...) et les instances globales (moteurs `wheel1`...`wheel4`, interruptions `irqISR`) sont incluses automatiquement dans chaque en-tête de fichiers produits.
* La fonction `entry()` qui permet d'exécuter le code du RobotML est injectée dans la boucle infinie `void loop()` de l'Arduino.
* La fonction `setup()` est générée pour initialiser les timers et les interruptions est également ajouté à l'en-tête de chaque fichier.

* **Les types** :

| RobotML   | Arduino |
|:---------:|:-------:|
| `Number`  | `long`  | 
|`Bool`     | `bool`  |
|`Void`     | `void`  |


* **Gestion des Capteurs** :
* L'appel à `getDistance()` est traduits par un appel à une fonctions générée `senseDistance()` qui encapsulent la logique bas niveau (gestion des pins `OUTPUT`/`INPUT`, `pulseIn`, conversions).
* `getTimestamp()` est traduit par la fonction Arduino `millis()`.

### 2.3. Gestion des mouvements

En plus de traduire la syntaxe, le compilateur intègre la logique physique du robot. Les commandes de haut niveau (ex: `Forward 30`) sont transformées en séquences de contrôle moteur :

1. **Calcul de l'accélération et du délai** : Utilisation de constantes physiques définies dans le compilateur (`ACCEL_FACTOR` , `ROTATION_FACTOR` ) pour convertir la distance ou l'angle demandé en temps d'exécution (`delay`), en fonction de la vitesse courante.
2. **Séquence de commande** :
* Définition de la direction (ex: `Omni.setCarAdvance`).
* Application de la vitesse (`Omni.setCarSpeedMMPS`).
* Attente active (`delay(delaying)`).
* Arrêt progressif (`Omni.setCarSlow2Stop`).


### 2.4. Validation et CLI (Command Line Interface)

L'interface en ligne de commande (`src/cli`) met en place deux commandes :

1. `parseAndValidate <file.rml>` : Analyse le fichier et rapporte les erreurs de syntaxe ou de typage.
2. `generate <file.rml>` : Lance la validation complète puis, en cas de succès, génère le fichier `.ino`.

Un système de **validation personnalisée** (`RobotMlCustomValidationVisitor`) a été implémenté pour vérifier la cohérence des types (ex: empêcher l'assignation d'un booléen à une variable numérique) avant toute tentative de génération.

---

### 2.5. Décisions d'ingénierie

#### Utilisation du pattern visitor pour la vompilation

Le pattern visitor permet de séparer la logique de traversée de l'AST de la définition des nœuds, plutôt que d'ajouter des méthodes de génération directement dans les classes du modèle.
Le modèle (AST) ne dépend pas de la cible de compilation. Si nous devions générer du code Python ou Java pour un simulateur, il suffirait de créer un nouveau visiteur sans toucher au modèle existant.

#### Validation et génération

Le CLI (`cli-util.ts`) bloque le processus si une erreur de syntaxe (parser) ou de sémantique (validator) est détectée. Le compilateur ne démarre jamais sur un AST invalide.

---

## 3. Installation et Utilisation

### Prérequis

* **Node.js** (version 16 ou supérieure)
* **npm**

### Installation

Pour installer les dépendances et compiler le projet Langium, exécutez les commandes suivantes à la racine du dossier `rml` :

```bash
npm install
npm run langium:generate
npm run build

```

### Commandes disponibles

L'outil en ligne de commande (CLI) a été défini dans le dossier `rml/src/cli` et généré pour l'exécution dans `rml/out/cli`. Voici les commandes pour l'utiliser :

#### 1. Valider un fichier (`parseAndValidate`)

Cette commande permet de vérifier qu'un fichier `.rml` ne contient pas d'erreurs de syntaxe ou de sémantique (types incohérents, variables non déclarées, etc.), sans générer de code.

```bash
node out/cli/index.js parseAndValidate <chemin_vers_le_fichier.rml>

```

**Exemple :**

```bash
node out/cli/index.js parseAndValidate test.rml

```

#### 2. Générer le code Arduino (`generate`)

Cette commande compile le fichier RobotML. Si le fichier est valide, elle génère un fichier `.ino` portant le même nom dans le même dossier.

```bash
node out/cli/index.js generate <chemin_vers_le_fichier.rml>

```

**Exemple :**

```bash
node out/cli/index.js generate test.rml
# Résultat : Crée un fichier test.ino prêt à être téléversé sur l'Arduino.

```

## 4. Localisation des Fichiers Sources

Voici où trouver les fichiers essentiels implémentant la logique décrite précédemment :

* **Grammaire (Syntaxe)** :
* `src/language/robot-ml.langium` : Définition de la grammaire et des règles de parsing.
* `src/language/robotML-types.langium` : Définition des interfaces TypeScript pour l'AST.


* **Sémantique & Compilation** :
* `src/semantics/compiler.ts` : Le **Visiteur** responsable de la génération du code C++ Arduino.
* `src/semantics/robot-ml-custom-validation-visitor.ts` : Le **Visiteur** responsable de la validation sémantique (vérification des types, unicité des noms, etc.).


* **CLI (Outil en ligne de commande)** :
* `src/cli/main.ts` : Point d'entrée du programme, définition des commandes `generate` et `parseAndValidate`.
* `src/cli/cli-util.ts` : Fonctions utilitaires pour charger le modèle et bloquer l'exécution en cas d'erreurs ("Fail-Fast").



