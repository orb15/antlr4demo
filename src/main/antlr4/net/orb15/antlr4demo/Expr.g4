grammar Expr;

/* Parser Rules */

prog:	expr ;
expr:	'(' expr ')'                        #parenExpr
    | left=expr op=('*'|'/') right=expr   #opExpr
    |	left=expr op=('+'|'-') right=expr   #opExpr
    |	INT                                 #intExpr
    ;

/* Lexer Rules */
INT     : [0-9]+ ;