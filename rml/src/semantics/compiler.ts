import { RobotMlVisitor } from './robot-ml-visitor.js';
import { 
    Programme, FuncDecl, Statement, Movement, SetSpeed, Clock,
    StatementList, Loop, Conditional, Expression, BinaryOperation,
    NumLiteral, BoolLiteral, SensorAccess, VarDecl, VarAssign, FuncCall,
    TypeVar, Bool, Number_, Void
} from '../language/generated/ast.js';

export class RobotMlCompiler implements RobotMlVisitor {
    
    // Constantes physiques
    private readonly ACCEL_FACTOR = 2.9940119760479043; 
    private readonly ROTATION_FACTOR = 2.4638813;

    // Point d'entrée
    compile(model: Programme): string {
        return this.visitProgramme(model);
    }

    // Visiteurs

    visitProgramme(node: Programme): string {
        // Génération du code des fonctions utilisateur (sauf entry)
        const userFunctions = node.funcdecl
            .filter(f => f.name !== 'entry')
            .map(f => this.visitFuncDecl(f))
            .join('\n');

        // 2Génération du contenu du loop (corps de entry)
        const entryFunc = node.funcdecl.find(f => f.name === 'entry');
        const loopContent = entryFunc ? this.visitStatementList(entryFunc.statementlist) : '';

        // Assemblage final
        return `
                #include <PinChangeInt.h>
                #include <PinChangeIntConfig.h>
                #include <EEPROM.h>
                #define _NAMIKI_MOTOR
                #include <fuzzy_table.h>
                #include <PID_Beta6.h>
                #include <MotorWheel.h>
                #include <Omni4WD.h>

                irqISR(irq1, isr1);
                MotorWheel wheel1(3, 2, 4, 5, &irq1);
                irqISR(irq2, isr2);
                MotorWheel wheel2(11, 12, 14, 15, &irq2);
                irqISR(irq3, isr3);
                MotorWheel wheel3(9, 8, 16, 17, &irq3);
                irqISR(irq4, isr4);
                MotorWheel wheel4(10, 7, 18, 19, &irq4);
                Omni4WD Omni(&wheel1, &wheel2, &wheel3, &wheel4);

                int speed = 30;
                long dist_accel;
                long delaying;

                long senseDistance() {
                    long duration;
                    pinMode(6, OUTPUT);
                    digitalWrite(6, LOW);
                    delayMicroseconds(2);
                    digitalWrite(6, HIGH);
                    delayMicroseconds(5);
                    digitalWrite(6, LOW);
                    pinMode(6, INPUT);
                    duration = pulseIn(6, HIGH);
                    delay(100);
                    return duration / 29 / 2 * 10;
                }

                ${userFunctions}

                void setup() {
                    TCCR1B = TCCR1B & 0xf8 | 0x01;
                    TCCR2B = TCCR2B & 0xf8 | 0x01;
                    Omni.PIDEnable(0.31, 0.01, 0, 10);
                }

                void loop() {
                    ${loopContent}
                    while(1); // Stop après exécution
                }`;
    }

    visitFuncDecl(node: FuncDecl): string {
        const body = this.visitStatementList(node.statementlist);
        return `void ${node.name}() {${body}}`;
    }

    visitStatementList(node: StatementList): string {
        // Map chaque instruction vers sa chaîne C++ puis on joint par des retours ligne + indentation
        return node.state
            .map(stmt => this.visitStatement(stmt))
            .join('\n\t');
    }

    visitStatement(node: Statement): string {
        if (this.isMovement(node)) return this.visitMovement(node);
        if (this.isClock(node)) return this.visitClock(node);
        if (this.isSetSpeed(node)) return this.visitSetSpeed(node);
        if (this.isLoop(node)) return this.visitLoop(node);
        if (this.isConditional(node)) return this.visitConditional(node);
        if (this.isVarDecl(node)) return this.visitVarDecl(node);
        if (this.isVarAssign(node)) return this.visitVarAssign(node);
        if (this.isFuncCall(node)) return this.visitFuncCall(node);
        return "";
    }

    // Commandes de mouvement et de contrôle de vitesse
    visitSetSpeed(node: SetSpeed): string {
        const speedVal = this.visitExpression(node.speed);
        return `speed = ${speedVal} / 5;`;
    }

    visitMovement(node: Movement): string {
        const expr = this.visitExpression(node.distance);
        
        // Déterminer fonction Arduino selon direction
        let cmd = "Omni.setCarAdvance";
        if (node.side === 'Backward') cmd = "Omni.setCarBackoff";
        if (node.side === 'Sideleft') cmd = "Omni.setCarLeft";
        if (node.side === 'Sideright') cmd = "Omni.setCarRight";

        return `
                dist_accel = speed * ${this.ACCEL_FACTOR};
                delaying = (167 * (${expr} - dist_accel)) / speed;
                ${cmd}(speed);
                Omni.setCarSpeedMMPS(speed, 500);
                delay(delaying);
                Omni.setCarSlow2Stop(500);
                delay(500);`;
    }

    visitClock(node: Clock): string {
        // Rotation (comme Clock dans grammaire)
        const expr = this.visitExpression(node.distance);
        
        return `
                dist_accel = speed * ${this.ACCEL_FACTOR};
                delaying = (167 * ((${expr} * ${this.ROTATION_FACTOR}) - dist_accel)) / speed;
                Omni.setCarRotateRight(speed);
                Omni.setCarSpeedMMPS(speed, 500);
                delay(delaying);
                Omni.setCarSlow2Stop(500);
                delay(500);`;
    }

    // Structure de contrôle

    visitLoop(node: Loop): string {
        const cond = this.visitExpression(node.condition);
        const body = this.visitStatementList(node.body);
        return `
                while (${cond}) {
                    ${body}
                }`;
    }

    visitConditional(node: Conditional): string {
        const cond = this.visitExpression(node.condition);
        const ifBody = this.visitStatementList(node.ifBody);
        let out = `
                if (${cond}) {
                    ${ifBody}
                }`;
        if (node.elseBody) {
            const elseBody = this.visitStatementList(node.elseBody);
            out += ` else {
                    ${elseBody}
                }`;
        }
        return out;
    }

    visitVarDecl(node: VarDecl): string {
        const typeArduino = this.visitTypeVar(node.type);
        
        const val = this.visitExpression(node.expression!); 
        return `${typeArduino} ${node.name} = ${val};`;
    }

    visitVarAssign(node: VarAssign): string {
        const val = this.visitExpression(node.expression);
        const varName = node.vardecl?.ref?.name;
        return varName ? `${varName} = ${val};` : '';
    }
    
    visitFuncCall(node: FuncCall): string {
        const funcName = node.funcdecl?.ref?.name;
        return funcName ? `${funcName}();` : '';
    }

    // Expressions

    visitExpression(node: Expression): string {
        if (this.isBinaryOperation(node)) return this.visitBinaryOperation(node);
        if (this.isNumLiteral(node)) return this.visitNumLiteral(node);
        if (this.isBoolLiteral(node)) return this.visitBoolLiteral(node);
        if (this.isSensorAccess(node)) return this.visitSensorAccess(node);
        
        if ((node as any).$type === 'VariableRef') {
            return (node as any).vardecl?.ref?.name ?? "0";
        }
        // Gestion des parenthèses
        if ((node as any).$type === 'PrimaryExpression' && (node as any).expression) {
             return `(${this.visitExpression((node as any).expression)})`;
        }
        return "0";
    }

    visitNumLiteral(node: NumLiteral): string {
        return node.val ? node.val.toString() : "0";
    }

    visitBoolLiteral(node: BoolLiteral): string {
        return node.val ? 'true' : 'false';
    }

    visitBinaryOperation(node: BinaryOperation): string {
        const left = this.visitExpression(node.operands[0]);
        if (node.operands.length > 1) {
             const right = this.visitExpression(node.operands[1]);
             const op = (node as any).type; 
             return `(${left} ${op} ${right})`; 
        }
        return left;
    }

    visitSensorAccess(node: SensorAccess): string {
        switch(node.sensorType) {
            case 'getDistance': return "senseDistance()";
            case 'getTimestamp': return "millis()";
            case 'getBattery': return "getBattery()";
            default: return "0";
        }
    }

    // Type guards pour différencier les types d'instructions et d'expressions
    isMovement(n: any): n is Movement { return n.$type === 'Movement'; }
    isClock(n: any): n is Clock { return n.$type === 'Clock'; }
    isSetSpeed(n: any): n is SetSpeed { return n.$type === 'SetSpeed'; }
    isLoop(n: any): n is Loop { return n.$type === 'Loop'; }
    isConditional(n: any): n is Conditional { return n.$type === 'Conditional'; }
    isVarDecl(n: any): n is VarDecl { return n.$type === 'VarDecl'; }
    isVarAssign(n: any): n is VarAssign { return n.$type === 'VarAssign'; }
    isFuncCall(n: any): n is FuncCall { return n.$type === 'FuncCall'; }
    isBinaryOperation(n: any): n is BinaryOperation { return n.$type === 'NumBinaryOperation' || n.$type === 'BoolBinaryOperation'; }
    isNumLiteral(n: any): n is NumLiteral { return n.$type === 'NumLiteral'; }
    isBoolLiteral(n: any): n is BoolLiteral { return n.$type === 'BoolLiteral'; }
    isSensorAccess(n: any): n is SensorAccess { return n.$type === 'SensorAccess'; }
    isBool(n: any): n is Bool { return n.$type === 'Bool'; }
    isNumber_(n: any): n is Number_ { return n.$type === 'Number_'; }

    // Gestion des types

    visitTypeVar(node: TypeVar): string {
        // TypeVar est une union (Bool | Number_) on dispatch vers le bon
        if (this.isBool(node)) return this.visitBool(node);
        if (this.isNumber_(node)) return this.visitNumber_(node);
        return "void";
    }

    visitBool(node: Bool): string {
        return "bool"; 
    }

    visitNumber_(node: Number_): string {
        return "long"; 
    }

    visitVoid(node: Void): string {
        return "void";
    }


    visitType(node: any) {}
    visitPrimaryExpression(node: any) {}
    visitOperation(node: any) {}
    visitUnarOperation(node: any) {}
    visitBoolBinaryOperation(node: any) {}
    visitNumBinaryOperation(node: any) {}
    visitBoolUnaryOperation(node: any) {}
    visitNumUnaryOperation(node: any) {}
    visitLiteral(node: any) {}
    visitVariableRef(node: any) {}
    visitCommand(node: any) {}
    visitControlStructure(node: any) {}
    
}