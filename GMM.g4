grammar GMM;

prog
    : (functionDef | blockDef)*;

functionDef
    : Type ID LParan formalParameters? RParan LCurl scopedStmt* RCurl;

blockDef
    : ID LSquare machineOptions? RSquare LCurl scopedStmt* RCurl;

formalParameters
    : formalParameter (CommaSeperator formalParameter)*;

formalParameter
    : Type ID;

machineOptions
    : machineOption (CommaSeperator machineOption )*;

machineOption
    : BlockParam;

scopedStmt
    : blockDef # Block
    | While LParan expression RParan LCurl scopedStmt* RCurl # WhileLoop
    | If LParan expression RParan LCurl scopedStmt* RCurl # IfStatement
    | functionCall # ScopedStmtFunctionCall
    | ID Equals expression # Assignment
    | ID DotOperator ID Equals expression # VectorComponentAssign
    | Type ID Equals expression # Declaration
    | MoveCommand vectorCommandParameter? singleCommandParameter* #Move
    | RightCircleCommand vectorCommandParameter? singleCommandParameter* #RightCircle
    | LeftCircleCommand vectorCommandParameter? singleCommandParameter* #LeftCircle
    | RapidMoveCommand vectorCommandParameter? singleCommandParameter* # Jump
    | Return expression # FunctionReturn
    | GCode # ExplicitGCode
    ;

functionCall
    :ID LParan parameters? RParan;

vectorCommandParameter
    : expression;

singleCommandParameter
    : CommandParameter Equals expression;

parameters
    : expression (CommaSeperator expression)*;

expression
    : logic;

logic
    : logic And booleanExpr # AndLogic
    | logic Or booleanExpr # OrLogic
    | booleanExpr # LogicDerivation
    ;

booleanExpr
    : expr Equality expr # EqualityExpr
    | expr InEquality expr # InEqualityExpr
    | expr GreaterThan expr # GreaterThanExpr
    | expr LessThan expr # LessThanExpr
    | LParan logic RParan # ParanLogic
    | expr # BooleanExprDerivation
    ;

expr
    : expr Plus term # PlusExpr
    | expr Minus term # MinusExpr
    | term # ExprDerivation;

term
    : term Times factor # TimesTerm
    | term Divide factor # DivideTerm
    | factor # TermDerivation;



factor
    : LParan expr RParan # ParanExpr
    | INT # LiteralInt
    | True # LiteralTrue
    | False # LiteralFalse
    | ID # Variable
    | ID DotOperator ID # AccessVector
    | Sqrt LParan expr RParan # SquareRoot
    | functionCall # ExpressionFunctionCall
    | LParan expression CommaSeperator expression CommaSeperator expression RParan # LiteralVector
    | Minus factor # NegatedFactor
    ;

Sqrt
    : 'sqrt';

Return
    : 'return ';

Equals
    : '=';

Plus: '+';
Minus: '-';
Times: '*';
Divide: '/';

And: '&&';
Or: '||';

Equality: '==';
InEquality: '!=';

GreaterThan: '>';
LessThan: '<';

True: 'true';
False: 'false';

INT
    : Digit+
    | Digit+ DotOperator Digit? Digit? Digit? Digit?;

SemiColon
    : ';';

CommaSeperator
    : ',';

DotOperator
    : '.';

Colon
    : ':';

While
    : 'while';

If
    : 'if';

LParan : '(';
RParan : ')';

LSquare : '[';
RSquare : ']';

LCurl : '{';
RCurl : '}';

RapidMoveCommand
    : 'jump ';
MoveCommand
    : 'move ';
LeftCircleCommand
    : 'leftCircle ';
RightCircleCommand
    : 'rightCircle ';

Type
    : 'num '
    | 'vector '
    | 'bool '
    | 'void ';


AbsoluteParameter
    : '$';

CommandParameter
    : 'X' | 'Y' | 'Z' | 'I' | 'J'| 'R';


GCode
    : '@' (Letter | Digit | WS | GCodeVarRef)* '@';

GCodeVarRef
    : '{' ID '}';

ID
    : Letter (Letter | Digit | '_')*;

BlockParam
    : ID WS* Colon WS* (Letter | Digit)+;

fragment Letter
    : ([a-z] | [A-Z]);
fragment Digit
    : [0-9];

WS
    : ( ' ' | '\t' | '\r' | '\n') -> skip;