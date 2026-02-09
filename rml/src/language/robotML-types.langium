type Unit = Unit_cm | Unit_mm;
type Unit_cm = 'cm';
type Unit_mm = 'mm';

type Direction = Direction_Backward | Direction_Forward | Direction_Sideleft | Direction_Sideright;
type Direction_Backward = 'Backward';
type Direction_Forward = 'Forward';
type Direction_Sideleft = 'Sideleft';
type Direction_Sideright = 'Sideright';

type BoolUOp = BoolUOp_NOT;
type BoolUOp_NOT = '!';

type NumUOp = NumUOp_MINUS | NumUOp_PLUS;
type NumUOp_MINUS = '-';
type NumUOp_PLUS = '+';

type BoolBOp = BoolBOp_EQ | BoolBOp_NEQ | BoolBOp_LEQ | BoolBOp_GEQ | BoolBOp_LE | BoolBOp_GR;
type BoolBOp_EQ = '==';
type BoolBOp_NEQ = '!=';
type BoolBOp_LEQ = '<=';
type BoolBOp_GEQ = '>=';
type BoolBOp_LE = '<';
type BoolBOp_GR = '>';

type NumBOp = NumBOp_MINUS | NumBOp_PLUS | NumBOp_MULTIPLY | NumBOp_DIVIDE;
type NumBOp_MINUS = '-';
type NumBOp_PLUS = '+';
type NumBOp_MULTIPLY = '*';
type NumBOp_DIVIDE = '/';

type SensorType = SensorType_Distance | SensorType_Time | SensorType_Battery;
type SensorType_Distance = 'getDistance';
type SensorType_Time = 'getTimestamp';
type SensorType_Battery = 'getBattery';

interface Programme {
    funcdecl: FuncDecl[]
}

interface FuncDecl {
    ^type: Type
    statementlist: StatementList
    name?: string
}

interface Type {
}

interface StatementList {
    state: Statement[]
}

interface Statement {
}

interface Expression {
}

interface PrimaryExpression extends Expression {
}

interface TypeVar extends Type {
}

interface Bool extends TypeVar {
}

interface Number_ extends TypeVar {
    unit?: Unit
}

interface Void extends Type {
}

interface FuncCall extends Statement, Expression {
    funcdecl?: @FuncDecl
}

interface VarAssign extends Statement {
    vardecl?: @VarDecl
    expression: Expression
}

interface VarDecl extends Statement {
    name?: string
    ^type: TypeVar
    expression?: Expression
    unit?: Unit
}

interface Movement extends Command {
    distance: Expression
    side?: Direction
    unit?: Unit 
}

interface Command extends Statement {
}

interface Clock extends Command {
    distance: Expression
}

interface ControlStructure extends Statement {
    condition: Expression
}

interface Loop extends ControlStructure {
    body: StatementList
}

interface Conditional extends ControlStructure {
    ifBody: StatementList
    elseBody?: StatementList
}

interface SetSpeed extends Command {
    speed: Expression
    unit?: Unit
}

interface VariableRef extends Expression {
    vardecl?: @VarDecl
}

interface BoolLiteral extends Literal {
    val: boolean
}

interface Literal extends Expression {
}

interface NumLiteral extends Literal {
    val?: number
}

interface BoolUnaryOperation extends UnarOperation {
    operator?: BoolUOp
}

interface UnarOperation extends Operation {
    operand: Expression
}

interface Operation extends Expression {
}

interface NumUnaryOperation extends UnarOperation {
    operator?: NumUOp
}

interface BoolBinaryOperation extends BinaryOperation {
    operator?: BoolBOp
}

interface BinaryOperation extends Operation {
    operands: Expression[]
}

interface NumBinaryOperation extends BinaryOperation {
    operator?: NumBOp
}

interface SensorAccess extends Expression {
    sensorType?: SensorType
}