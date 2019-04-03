grammar GMM;

prog
    : (functionDef | blockDef)*;

functionDef
    : FunctionType ID LParan formalParameters? RParan LCurl functionStmt* RCurl;

blockDef
    : ID LSquare machineOptions? RSquare LCurl scopedStmt* RCurl;

formalParameters
    : formalParameter (CommaSeperator formalParameter)*;

formalParameter
    : Type ID;

machineOptions
    : machineOption (CommaSeperator machineOption )*;

machineOption
    : ID Colon expression;

functionStmt
    : scopedStmt # FunctionScopedStmt
    | Return expression # FunctionReturn;

scopedStmt
    : blockDef # Block
    | While LParan expression RParan LCurl scopedStmt* RCurl # WhileLoop
    | If LParan expression RParan LCurl scopedStmt* RCurl # IfStatement
    | functionCall # ScopedStmtFunctionCall
    | ID Equals expression # Assignment
    | Type ID Equals expression # Declaration
    | MoveCommand commandParameter+ #Move
    | RightCircleCommand commandParameter+ #RightCircle
    | LeftCircleCommand commandParameter+ #LeftCircle;

functionCall
    :ID LParan parameters? RParan;

commandParameter
    : CommandParameter Equals expression # RelativeParameter
    | CommandParameter Equals AbsoluteParameter expression # AbsoluteParameter;

parameters
    : expression (CommaSeperator expression)*;

expression
    : logic;

  //expressions
logic // Det er ikke muligt at bruge parenteser til bolske operationer
    : logic And booleanExpr # AndLogic
    | logic Or booleanExpr # OrLogic
    | booleanExpr # LogicDerivation
    ;

booleanExpr
    : expr Equality expr # EqualityExpr
    | expr InEquality expr # InEqualityExpr
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
    | functionCall # ExpressionFunctionCall;

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

True: 'true';
False: 'false';

INT
    : Digit+;

SemiColon
    : ';';

CommaSeperator
    : ',';

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

MoveCommand
    : 'move ';
LeftCircleCommand
    : 'leftCircle ';
RightCircleCommand
    : 'rightCircle ';

FunctionType
    : 'void '
    | Type;

Type
    : 'num '
    | 'vector '
    | 'bool ';

AbsoluteParameter
    : '$';

CommandParameter
    : 'X' | 'Y' | 'Z' | 'I' | 'J'| 'R';

ID
    : Letter (Letter | Digit | '_')*;

fragment Letter
    : ([a-z] | [A-Z]);
fragment Digit
    : [0-9];

WS
    : ( ' ' | '\t' | '\r' | '\n') -> skip;