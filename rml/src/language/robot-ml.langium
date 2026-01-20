grammar RobotMl
import 'Terminals'
import 'robotML-types'

entry Programme returns Programme:
    (funcdecl+=FuncDecl)* ;

Type returns Type:
    Bool | Number_ | Void 
;

TypeVar returns TypeVar:
    Bool | Number_ 
;

Bool returns Bool:
    {Bool} 'bool'  
;

Number_ returns Number_:
    {Number_} 'number' ('in' unit=Unit )?   
;

Void returns Void:
    {Void} 'void'  
;

Unit returns Unit:
    Unit_cm | Unit_mm 
;
Unit_cm returns Unit_cm: 'cm' ;
Unit_mm returns Unit_mm: 'mm' ;

Statement returns Statement:
    FuncCall | VarAssign | VarDecl | Movement | Clock | ControlStructure_Impl | SetSpeed 
;

StatementList returns StatementList:
    {StatementList} '{' (state+=Statement)* '}'
;

FuncDecl returns FuncDecl:
    'let' ^type=Type name=EString '()'  
        statementlist=StatementList 
    ;

FuncCall returns FuncCall:
    funcdecl=[FuncDecl:EString] '()' 
;

VarAssign returns VarAssign:
    vardecl=[VarDecl:EString] '=' expression=Expression  
;

VarDecl returns VarDecl:
    'var' ^type=TypeVar name=EString '=' expression=Expression ('in' unit=Unit)?
;

VariableRef returns VariableRef:
    vardecl=[VarDecl:EString] 
;

Movement returns Movement:
    side=Direction distance=Expression ('in' unit=Unit)?;

Clock returns Clock:
    'Clock' distance=Expression  
;

SetSpeed returns SetSpeed:
    'setSpeed' '(' speed=Expression ('in'? unit=Unit)? ')'   
;

ControlStructure_Impl returns ControlStructure:
    Loop | Conditional  
;

Loop returns Loop:
    'loop'  condition=Expression body=StatementList   
;

Conditional returns Conditional:
    'if' condition=Expression  ifBody=StatementList  ('else' elseBody=StatementList )?  
;

Expression returns Expression:
    BooleanExpression;

BooleanExpression returns Expression:
    ArithmeticExpression (
        {BoolBinaryOperation.operands+=current} 
        ^type=BoolBOp 
        operands+=ArithmeticExpression
    )*;

ArithmeticExpression returns Expression:
    Multiplication (
        {NumBinaryOperation.operands+=current} 
        ^type=('+' | '-') 
        operands+=Multiplication
    )*;

Multiplication returns Expression:
    PrimaryExpression (
        {NumBinaryOperation.operands+=current} 
        ^type=('*' | '/') 
        operands+=PrimaryExpression
    )*;

PrimaryExpression returns Expression:
    '(' Expression ')' |
    FuncCall |
    VariableRef |
    SensorAccess |
    NumLiteral |
    BoolLiteral |
    NumUnaryOperation |
    BoolUnaryOperation;

SensorAccess returns SensorAccess:
    sensorType=SensorType '()'
;

BoolLiteral returns BoolLiteral:
    val?='true' | 'false'  
;

NumLiteral returns NumLiteral:
    val=EInt  
;

BoolUnaryOperation returns BoolUnaryOperation:
    ^type=BoolUOp operand=Expression  
;

NumUnaryOperation returns NumUnaryOperation:
    ^type=NumUOp operand=Expression  
;

EString returns string:
    STRING | ID 
;

EBoolean returns boolean:
    'true' | 'false' 
;

EInt returns number:
    '-'? INT  
;

BoolUOp returns BoolUOp:
    '!';

BoolBOp returns BoolBOp:
    '==' | '!=' | '<=' | '>=' | '<' | '>';

NumUOp returns NumUOp:
    '-' | '+';

SensorType returns SensorType:
    'getDistance' | 'getTimestamp' | 'getBattery';

Direction returns Direction:
    'Backward' | 'Forward' | 'Sideleft' | 'Sideright';