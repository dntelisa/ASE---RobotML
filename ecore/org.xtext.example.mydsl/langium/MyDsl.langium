grammar MyDsl
import 'Terminals'
import 'robotML-types'

entry Programme returns Programme:
    {Programme} 'Programme' '{' ('funcdecl' '{' funcdecl+=FuncDecl  ("," funcdecl+=FuncDecl  )* '}' )? '}'  
;

Type returns Type:
    Bool | Number | Void 
;

Statement returns Statement:
    FuncCall | VarAssign | VarDecl | Movement | Clock | ControlStructure_Impl | Loop | Conditional | SetSpeed 
;

Expression returns Expression:
    FuncCall | VariableRef | BoolLiteral | NumLiteral | BoolUnaryOperation | NumUnaryOperation | BoolBinaryOperation | NumBinaryOperation | SensorAccess 
;

TypeVar returns TypeVar:
    Bool | Number 
;

FuncDecl returns FuncDecl:
    'FuncDecl' name=EString  '{' 'type' ^type=Type  'statementlist' statementlist=StatementList  '}'  
;

StatementList returns StatementList:
    {StatementList} 'StatementList' '{' ('state' '{' state+=Statement  ("," state+=Statement  )* '}' )? '}'  
;

EString returns string:
    STRING | ID 
;

Bool returns Bool:
    {Bool} 'Bool'  
;

Number returns Number:
    {Number} 'Number' '{' ('unit' unit=Unit  )? '}'  
;

Void returns Void:
    {Void} 'Void'  
;

Unit returns Unit:
    Unit_cm | Unit_mm | Unit_none | Unit_deg | Unit_rad
;
Unit_cm returns Unit_cm: 'cm' ;
Unit_mm returns Unit_mm: 'mm' ;
Unit_none returns Unit_none: 'none' ;
Unit_deg returns Unit_deg: 'deg' ;
Unit_rad returns Unit_rad: 'rad' ;

FuncCall returns FuncCall:
    {FuncCall} 'FuncCall' '{' ('funcdecl' funcdecl=[FuncDecl:EString ] )? '}'  
;

VarAssign returns VarAssign:
    'VarAssign' '{' ('vardecl' vardecl=[VarDecl:EString ] )? 'expression' expression=Expression  '}'  
;

VarDecl returns VarDecl:
    'VarDecl' name=EString  '{' 'type' ^type=TypeVar  ('expression' expression=Expression  )? '}'  
;

Movement returns Movement:
    'Movement' '{' ('side' side=Direction  )? 'distance' distance=Expression  '}'  
;

Clock returns Clock:
    'Clock' '{' 'distance' distance=Expression  '}'  
;

ControlStructure_Impl returns ControlStructure:
    'ControlStructure' '{' 'condition' condition=Expression  '}'  
;

Loop returns Loop:
    'Loop' '{' 'condition' condition=Expression  'body' body=StatementList  '}'  
;

Conditional returns Conditional:
    'Conditional' '{' 'condition' condition=Expression  'ifBody' ifBody=StatementList  ('elseBody' elseBody=StatementList  )? '}'  
;

SetSpeed returns SetSpeed:
    'SetSpeed' '{' 'speed' speed=Expression  '}'  
;

VariableRef returns VariableRef:
    {VariableRef} 'VariableRef' '{' ('vardecl' vardecl=[VarDecl:EString ] )? '}'  
;

BoolLiteral returns BoolLiteral:
    {BoolLiteral} (val?='val' )? 'BoolLiteral'  
;

NumLiteral returns NumLiteral:
    {NumLiteral} 'NumLiteral' '{' ('val' val=EInt  )? '}'  
;

BoolUnaryOperation returns BoolUnaryOperation:
    'BoolUnaryOperation' '{' ('type' ^type=BoolUOp  )? 'operand' operand=Expression  '}'  
;

NumUnaryOperation returns NumUnaryOperation:
    'NumUnaryOperation' '{' ('type' ^type=NumUOp  )? 'operand' operand=Expression  '}'  
;

BoolBinaryOperation returns BoolBinaryOperation:
    'BoolBinaryOperation' '{' ('type' ^type=BoolBOp  )? 'operands' '{' operands+=Expression  ("," operands+=Expression  )* '}' '}'  
;

NumBinaryOperation returns NumBinaryOperation:
    'NumBinaryOperation' '{' ('type' ^type=NumBOp  )? 'operands' '{' operands+=Expression  ("," operands+=Expression  )* '}' '}'  
;

SensorAccess returns SensorAccess:
    {SensorAccess} 'SensorAccess' '{' ('sensorType' sensorType=SensorType  )? '}'  
;

EBoolean returns boolean:
    'true' | 'false' 
;

EInt returns number:
    '-'? INT  
;

BoolUOp returns BoolUOp:
    BoolUOp_NOT
;
BoolUOp_NOT returns BoolUOp_NOT: 'NOT' ;

NumUOp returns NumUOp:
    NumUOp_MINUS | NumUOp_PLUS
;
NumUOp_MINUS returns NumUOp_MINUS: 'MINUS' ;
NumUOp_PLUS returns NumUOp_PLUS: 'PLUS' ;

BoolBOp returns BoolBOp:
    BoolBOp_EQ | BoolBOp_NEQ | BoolBOp_LEQ | BoolBOp_GEQ | BoolBOp_LE | BoolBOp_GR
;
BoolBOp_EQ returns BoolBOp_EQ: 'EQ' ;
BoolBOp_NEQ returns BoolBOp_NEQ: 'NEQ' ;
BoolBOp_LEQ returns BoolBOp_LEQ: 'LEQ' ;
BoolBOp_GEQ returns BoolBOp_GEQ: 'GEQ' ;
BoolBOp_LE returns BoolBOp_LE: 'LE' ;
BoolBOp_GR returns BoolBOp_GR: 'GR' ;

NumBOp returns NumBOp:
    NumBOp_MINUS | NumBOp_PLUS | NumBOp_MULTIPLY | NumBOp_DIVIDE
;
NumBOp_MINUS returns NumBOp_MINUS: 'MINUS' ;
NumBOp_PLUS returns NumBOp_PLUS: 'PLUS' ;
NumBOp_MULTIPLY returns NumBOp_MULTIPLY: 'MULTIPLY' ;
NumBOp_DIVIDE returns NumBOp_DIVIDE: 'DIVIDE' ;

SensorType returns SensorType:
    SensorType_Distance | SensorType_Time | SensorType_Battery
;
SensorType_Distance returns SensorType_Distance: 'Distance' ;
SensorType_Time returns SensorType_Time: 'Time' ;
SensorType_Battery returns SensorType_Battery: 'Battery' ;

Direction returns Direction:
    Direction_Backward | Direction_Forward | Direction_Sideleft | Direction_Sideright
;
Direction_Backward returns Direction_Backward: 'Backward' ;
Direction_Forward returns Direction_Forward: 'Forward' ;
Direction_Sideleft returns Direction_Sideleft: 'Sideleft' ;
Direction_Sideright returns Direction_Sideright: 'Sideright' ;

