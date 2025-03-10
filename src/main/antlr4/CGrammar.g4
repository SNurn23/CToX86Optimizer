grammar CGrammar;

// 🔹 PALABRAS CLAVE Y TIPOS BÁSICOS
type: baseType (LBRACKET RBRACKET)*;
baseType: VOID | INT | CHAR | FLOAT | DOUBLE;

VOID: 'void';
INT: 'int';
CHAR: 'char';
FLOAT: 'float';
DOUBLE: 'double';
RETURN: 'return';
IF: 'if';
ELSE: 'else';
WHILE: 'while';
DO: 'do';
FOR: 'for';
SWITCH: 'switch';
CASE: 'case';
DEFAULT: 'default';
BREAK: 'break';
CONTINUE: 'continue';
PRINTF: 'printf';
SCANF: 'scanf';
SIZEOF: 'sizeof';

// 🔹 IDENTIFICADORES Y LITERALES
IDENTIFIER: [a-zA-Z_][a-zA-Z_0-9]*;
NUMBER: '-'? [0-9]+;
CHAR_LITERAL: '\'' (Escape | .) '\'';
FLOAT_LITERAL: '-'? ([0-9]+ '.' [0-9]* ([eE] [-+]? [0-9]+)? | '.' [0-9]+ ([eE] [-+]? [0-9]+)?);
STRING_LITERAL: '"' (Escape | ~["\\\r\n])* '"';

// 🔹 OPERADORES
PLUS: '+';
MINUS: '-';
MUL: '*';
DIV: '/';
MOD: '%';
INCREMENT: '++';
DECREMENT: '--';
ASSIGN: '=';
PLUS_ASSIGN: '+=';
MINUS_ASSIGN: '-=';
MUL_ASSIGN: '*=';
DIV_ASSIGN: '/=';
MOD_ASSIGN: '%=';
AND: '&';
OR: '|';
LOGICAL_AND: '&&';
LOGICAL_OR: '||';
LOGICAL_NOT: '!';
LT: '<';
LE: '<=';
GT: '>';
GE: '>=';
EQ: '==';
NEQ: '!=';
SEMI: ';';
COLON: ':';
COMMA: ',';
LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
LBRACKET: '[';
RBRACKET: ']';

// 🔹 FRAGMENTOS
fragment Escape: '\\' [tnr"\\];

// 🔹 IGNORAR ESPACIOS Y COMENTARIOS
WS: [ \t\r\n]+ -> skip;
COMMENT: '//' ~[\r\n]* -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;
DOC_COMMENT: '/**' .*? '*/' -> skip;

// 🔹 REGLAS PRINCIPALES
program: (functionDecl | varDecl)+ EOF;

// 🔹 FUNCIONES Y PARÁMETROS
functionDecl: type IDENTIFIER LPAREN (paramList | VOID)? RPAREN (block | SEMI);
paramList: VOID | (param (COMMA param)*);
param: type IDENTIFIER;

// 🔹 DECLARACIÓN DE VARIABLES (ARREGLADO PARA SOPORTAR ASIGNACIONES)
varDecl: type IDENTIFIER (LBRACKET NUMBER? RBRACKET)* (ASSIGN (expression | arrayInitializer))? SEMI;
arrayInitializer: LBRACE (expression (COMMA expression)*)? RBRACE;

// 🔹 BLOQUES Y SENTENCIAS
block: LBRACE statement* RBRACE;

statement
    : varDecl
    | exprStatement
    | ifStatement
    | whileStatement
    | doWhileStatement
    | forStatement
    | returnStatement
    | switchStatement
    | breakStatement
    | continueStatement
    | printfStatement
    | scanfStatement
    | block
    ;

// 🔹 CONTROL DE FLUJO
exprStatement: expression SEMI;
ifStatement: IF LPAREN expression RPAREN statement (ELSE statement)?;
whileStatement: WHILE LPAREN expression RPAREN statement;
doWhileStatement: DO statement WHILE LPAREN expression RPAREN SEMI;
forStatement: FOR LPAREN (varDecl | exprStatement) expression? SEMI expression? RPAREN statement;
returnStatement: RETURN expression? SEMI;
breakStatement: BREAK SEMI;
continueStatement: CONTINUE SEMI;

// 🔹 SWITCH Y CASE
switchStatement: SWITCH LPAREN expression RPAREN LBRACE caseStatement* defaultStatement? RBRACE;
caseStatement: CASE expression COLON statement*;
defaultStatement: DEFAULT COLON statement*;

// 🔹 PRINTF Y SCANF (AHORA SCANF NO REQUIERE `&`)
printfStatement: PRINTF LPAREN STRING_LITERAL (COMMA expression)* RPAREN SEMI;
scanfStatement: SCANF LPAREN STRING_LITERAL (COMMA expression)* RPAREN SEMI;

// 🔹 EXPRESIONES Y OPERADORES



// 🔹 EXPRESIONES CON PRECEDENCIA EXPLÍCITA
expression
    : logicalOrExpression
    ;

logicalOrExpression
    : logicalAndExpression (LOGICAL_OR logicalAndExpression)*
    ;

logicalAndExpression
    : equalityExpression (LOGICAL_AND equalityExpression)*
    ;

equalityExpression
    : relationalExpression ((EQ | NEQ) relationalExpression)*
    ;

relationalExpression
    : additiveExpression ((LT | GT | LE | GE) additiveExpression)*
    ;

additiveExpression
    : multiplicativeExpression ((PLUS | MINUS) multiplicativeExpression)*
    ;

multiplicativeExpression
    : prefixExpression ((MUL | DIV | MOD) prefixExpression)*
    ;

prefixExpression
    : (INCREMENT | DECREMENT | LOGICAL_NOT | AND | MUL) prefixExpression
    | postfixExpression
    ;

postfixExpression
    : primaryExpression
      (
        LBRACKET expression RBRACKET   // Array access
        | LPAREN expressionList? RPAREN // Function call
        | INCREMENT | DECREMENT        // Postfix operators
      )*
    ;

    expressionList: (expression (COMMA expression)*)?;

primaryExpression
    : IDENTIFIER                       # identifierExpression
    | literal                          # literalExpression
    | LPAREN expression RPAREN         # parenExpression
    | SIZEOF LPAREN (type | expression) RPAREN  # sizeofExpression
    | LPAREN type RPAREN expression    # castExpression
    ;
// 🔹 LITERALES
literal
    : NUMBER
    | CHAR_LITERAL
    | FLOAT_LITERAL
    | STRING_LITERAL
    ;
