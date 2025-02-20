grammar CGrammar;

// Palabras clave
INT: 'int';
CHAR: 'char';
FLOAT: 'float';
DOUBLE: 'double';
VOID: 'void';
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

// Identificadores y literales
IDENTIFIER: [a-zA-Z_][a-zA-Z_0-9]*;
NUMBER: [0-9]+;
CHAR_LITERAL: '\'' . '\'';
FLOAT_LITERAL: [0-9]+ '.' [0-9]+;
STRING_LITERAL: '"' (~["])* '"';

// Operadores
PLUS: '+';
MINUS: '-';
MUL: '*';
DIV: '/';
MOD: '%';
INCREMENT: '++';
DECREMENT: '--';
ASSIGN: '=';
AND: '&';
OR: '|';
LOGICAL_AND: '&&';
LOGICAL_OR: '||';
LOGICAL_NOT: '!';
LT: '<';
GT: '>';
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

// Ignorar espacios en blanco
WS: [ \t\r\n]+ -> skip;

// Reglas sintácticas
program: (functionDecl | varDecl)* EOF;

functionDecl: (INT | CHAR | FLOAT | DOUBLE | VOID) IDENTIFIER LPAREN (paramList)? RPAREN block;
paramList: param (COMMA param)*;
param: (INT | CHAR | FLOAT | DOUBLE) IDENTIFIER;

varDecl: (INT | CHAR | FLOAT | DOUBLE) IDENTIFIER (LBRACKET NUMBER RBRACKET)? SEMI;

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

exprStatement: expression? SEMI;

ifStatement: IF LPAREN expression RPAREN statement (ELSE statement)?;
whileStatement: WHILE LPAREN expression RPAREN statement;
doWhileStatement: DO statement WHILE LPAREN expression RPAREN SEMI;
forStatement: FOR LPAREN exprStatement exprStatement expression? RPAREN statement;

returnStatement: RETURN expression? SEMI;
breakStatement: BREAK SEMI;
continueStatement: CONTINUE SEMI;

switchStatement: SWITCH LPAREN expression RPAREN LBRACE caseStatement* defaultStatement? RBRACE;
caseStatement: CASE NUMBER COLON statement*;
defaultStatement: DEFAULT COLON statement*;

printfStatement: PRINTF LPAREN STRING_LITERAL (COMMA expression)* RPAREN SEMI;
scanfStatement: SCANF LPAREN STRING_LITERAL (COMMA '&'? IDENTIFIER)* RPAREN SEMI;

expression
    : IDENTIFIER ASSIGN expression
    | expression (PLUS | MINUS | MUL | DIV | MOD) expression
    | expression (LT | GT | EQ | NEQ) expression
    | expression (LOGICAL_AND | LOGICAL_OR) expression
    | LOGICAL_NOT expression
    | IDENTIFIER
    | NUMBER
    | CHAR_LITERAL
    | FLOAT_LITERAL
    | STRING_LITERAL
    | IDENTIFIER LBRACKET expression RBRACKET
    | LPAREN expression RPAREN
    | IDENTIFIER INCREMENT
    | IDENTIFIER DECREMENT
    ;
