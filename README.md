# RobotML - Langage de Contrôle de Robots Mobiles

Ce projet implémente le Domain-Specific Languages (DSL) RobotML. Un langage destiné à donner des instructions à un robot. Il couvre toutes les étapes de sa mise en oeuvre: la définition de métamodèle en utilisant ecore, la modelisation textuel avec Langium, la mise en place de l'interpréteur et du compilateur. 

Ce Read Me est voué à évoluer et à ce point du projet, il va essentiellement concerner la partie métamodèle.

## Structure du Projet

L'architecture du projet est organisée pour séparer la syntaxe, la sémantique et les outils web.

* Le dossier **ecore** contient le projet eclipse, on y retrouve dans le dossier **RobotML** le schema du metamodele ecore inclus dans **robotML.aird**. Le dossier **org.xtext.example.mydsl** a été généré à partir du modèle ecore. C'est la grammaire XText qui correspond au modèle, 
* Le dossier **rml** contient la grammaire langium dans **src/language** ainsi que la partie web avec les composanat de l'application **src/web**, interpreteur et compilateur **src/semantics**.

---

## 1. Description du métamodèle

Le métamodèle (défini initialement à la main puis avec Ecore) structure les concepts clés du langage.

### Concepts Clés

- **Programme et Fonctions** : La class *Programme* constitue la racine du métamodèle. Le programme contient ou non des déclarations de fonctions (*FuncDecl*). La signature d'une fonction est constituée d'un *Type* et de plusieurs déclarations de variables (*VarDecl*).

- **Types et unités** : Les types sont gérés par une classe abstraite *Type*. Cette classe peut ensuite être dérivée en 3 sous-classes: *Number*, *Void*, *Bool*. Les unités sont intégrées au type *Number* par aggrégation.

- **Listes de statements, statements, structures de contrôle** : Chaque fonction contient un *StatementList*, une liste de statements, qui elle-même contient des *Statement*s. Un statement peut être un appel de fonction *FuncCall*, une assignation de variable *VarAssign*, une déclaration de variable *VarDecl* ou un cppel de capteur/commande. Les structures de contrôle sont implémentées en sous-classes de *Statement* qui contiennent elles-mêmes un *StatementList*.

- **Expressions et opérations** : Une *Expression* est une structure qui peut être évaluée pour retourner une valeur: par exemple, une référence de variable *VariableRef*, un littéral *Literal* *Num-* ou *Bool*, un appel de fonction *FuncCall*, ou bien une *Operation*. Une opération peut être unaire ou binaire (*UnaryOperation* ou *BinaryOperation*), et une opération unaire ou binaire peut être *Num-* (s'évalue en *Number*) ou *Bool-* (s'évalue en *Bool*).

- **Capteurs et commandes** : Accès aux données environnementales (*Distance*, *Time*, *Battery*), et primitives de mouvement (*Forward*, *Backward*, *SideLeft*, *SideRight*). Chaque accès aux capteurs et chaque primitive de mouvement est représentée par sa propre classe. Les capteurs sont des *Expression*s; en effet, cela n'est pas très différent d'un appel de fonction. Les commandes sont des *Statement*s.

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


---

## 2. Décisions d'Ingénierie & Alternatives
