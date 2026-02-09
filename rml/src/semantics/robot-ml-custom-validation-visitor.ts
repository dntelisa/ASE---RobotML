import { RobotMlValidationVisitor } from './robot-ml-visitor.js';
import { VarDecl, VarAssign, Expression, TypeVar, StatementList, Programme, FuncDecl } from '../language/generated/ast.js';

export class RobotMlCustomValidationVisitor extends RobotMlValidationVisitor {

    // Méthode pour parcourir l'arbre
    visitChildren(node: any) {
        for (const key in node) {
            if (Object.prototype.hasOwnProperty.call(node, key)) {
                // Ignore les propriétés internes de Langium pour éviter la récursion infinie
                if (key.startsWith('$')) continue;

                const child = node[key];
                if (Array.isArray(child)) {
                    for (const c of child) {
                        if (c && typeof (c as any).accept === 'function') {
                            (c as any).accept(this);
                        }
                    }
                } else if (typeof child === 'object' && child !== null && typeof (child as any).accept === 'function') {
                    (child as any).accept(this);
                }
            }
        }
    }

    // Validation des déclarations de variables

    visitVarDecl(node: VarDecl): any {
        if (node.expression) {
            const declaredType = this.getTypeString(node.type);
            const inferredType = this.inferType(node.expression);

            if (inferredType && declaredType !== inferredType) {
                this.validationAccept('error', 
                    `Type mismatch: expected '${declaredType}' but got '${inferredType}'.`, 
                    { node: node, property: 'expression' }
                );
            }
        }
        this.visitChildren(node); 
    }

    visitVarAssign(node: VarAssign): any {
        const targetVar = node.vardecl?.ref; 
        if (targetVar) {
            const declaredType = this.getTypeString(targetVar.type);
            if (node.expression) {
                const inferredType = this.inferType(node.expression);
                if (inferredType && declaredType !== inferredType) {
                    this.validationAccept('error', 
                        `Type mismatch: cannot assign '${inferredType}' to variable of type '${declaredType}'.`, 
                        { node: node, property: 'expression' }
                    );
                }
            }
        }
        this.visitChildren(node);
    }

    // Validation des commandes spécifiques

    visitMovement(node: any) {
        // Forward/Backward attendent un nombre
        if (node.distance) {
            const type = this.inferType(node.distance);
            if (type && type !== 'number') {
                this.validationAccept('error', 
                    `Movement distance must be a number, but got '${type}'.`, 
                    { node, property: 'distance' }
                );
            }
        }
        this.visitChildren(node);
    }

    visitClock(node: any) {
        // Clock attend un nombre 
        if (node.distance) { 
            const type = this.inferType(node.distance);
            if (type && type !== 'number') {
                this.validationAccept('error', 
                    `Clock angle must be a number, but got '${type}'.`, 
                    { node, property: 'distance' } 
                );
            }
        }
        this.visitChildren(node);
    }

    visitSetSpeed(node: any) {
        if (node.speed) { 
            const type = this.inferType(node.speed);
            if (type && type !== 'number') {
                this.validationAccept('error', 
                    `Speed must be a number, but got '${type}'.`, 
                    { node, property: 'speed' }
                );
            }
        }
        this.visitChildren(node);
    }

    // Validation des opérations

    visitNumBinaryOperation(node: any): any {
        this.checkBinaryOp(node, 'number');
        this.visitChildren(node);
    }

    visitBoolBinaryOperation(node: any): any {
        if (['and', 'or', '&&', '||'].includes(node.operator)) {
            this.checkBinaryOp(node, 'bool');
        } else {
            // Comparaisons attendent des nombres
            if(['<', '>', '<=', '>='].includes(node.operator)) {
                 this.checkBinaryOp(node, 'number');
            }
        }
        this.visitChildren(node);
    }

    private checkBinaryOp(node: any, expectedType: 'number' | 'bool') {
        let leftExpr = node.left;
        let rightExpr = node.right;

        // Cas où les opérandes sont dans une liste
        if (!leftExpr && node.operands && node.operands.length > 0) leftExpr = node.operands[0];
        if (!rightExpr && node.operands && node.operands.length > 1) rightExpr = node.operands[1];

        if (leftExpr && rightExpr) {
             const type1 = this.inferType(leftExpr);
             const type2 = this.inferType(rightExpr);
             
             if (type1 && type2) {
                 if (type1 !== expectedType || type2 !== expectedType) {
                     this.validationAccept('error', 
                        `Operation '${node.operator}' expects operands of type '${expectedType}', but got '${type1}' and '${type2}'.`, 
                        { node }
                     );
                 }
             }
        }
    }
    
    // Méthodes utilitaires pour l'inférence de type

    private getTypeString(typeNode: TypeVar): 'number' | 'bool' | 'void' {
        if (typeNode.$type === 'Number_') return 'number';
        if (typeNode.$type === 'Bool') return 'bool';
        return 'void';
    }

    private inferType(expr: Expression): 'number' | 'bool' | 'void' | undefined {
        if (!expr) return undefined;

        if (expr.$type === 'NumLiteral') return 'number';
        if (expr.$type === 'BoolLiteral') return 'bool';
        
        if (expr.$type === 'VariableRef') {
            const ref = (expr as any).vardecl?.ref;
            return ref ? this.getTypeString(ref.type) : undefined;
        }

        if (expr.$type === 'SensorAccess') {
             const s = (expr as any).sensorType;
             return (s === 'getDistance' || s === 'getTimestamp') ? 'number' : undefined;
        }

        // Récursivité pour les opérations imbriquées
        if (expr.$type === 'NumBinaryOperation' || expr.$type === 'NumUnaryOperation') return 'number';
        
        // Pour les booléens < et AND renvoient bool
        if (expr.$type === 'BoolBinaryOperation' || expr.$type === 'BoolUnaryOperation') return 'bool';
        
        return undefined; 
    }

    // Visiteurs génériques pour parcourir l'arbre

    visitProgramme(node: Programme) { this.visitChildren(node); }
    visitFuncDecl(node: FuncDecl) { this.visitChildren(node); }
    visitStatementList(node: StatementList) { this.visitChildren(node); }
    visitStatement(node: any) { this.visitChildren(node); }
    visitExpression(node: Expression) { this.visitChildren(node); }
    visitFuncCall(node: any) { this.visitChildren(node); }
    visitLiteral(node: any) { this.visitChildren(node); }
    visitBoolLiteral(node: any) { /* Feuille */ }
    visitNumLiteral(node: any) { /* Feuille */ }
    visitOperation(node: any) { this.visitChildren(node); }
    
    visitBinaryOperation(node: any) { 
        // Délégation vers les visiteurs spécifiques selon le type d'opération
        this.visitChildren(node); 
    }

    visitUnarOperation(node: any) { this.visitChildren(node); }
    visitBoolUnaryOperation(node: any) { this.visitChildren(node); }
    visitNumUnaryOperation(node: any) { this.visitChildren(node); }
    visitPrimaryExpression(node: any) { this.visitChildren(node); }
    visitSensorAccess(node: any) { this.visitChildren(node); }
    visitVariableRef(node: any) { this.visitChildren(node); }
    visitCommand(node: any) { this.visitChildren(node); }
    
    visitControlStructure(node: any) { this.visitChildren(node); }
    
    visitConditional(node: any) { 
        if (node.condition) {
            const type = this.inferType(node.condition);
            if (type && type !== 'bool') {
                 this.validationAccept('error', `Condition must be boolean`, { node, property: 'condition' });
            }
        }
        this.visitChildren(node); 
    }
    
    visitLoop(node: any) { 
        if (node.condition) {
            const type = this.inferType(node.condition);
            if (type && type !== 'bool') {
                this.validationAccept('error', 
                    `Loop condition must be a boolean, got '${type}'.`, 
                    { node, property: 'condition' }
                );
            }
        }
        this.visitChildren(node); 
    }

    visitType(node: any) { this.visitChildren(node); }
    visitTypeVar(node: any) { this.visitChildren(node); }
    visitBool(node: any) { }
    visitNumber_(node: any) { }
    visitVoid(node: any) { }
}