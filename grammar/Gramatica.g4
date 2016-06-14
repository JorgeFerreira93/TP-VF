/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

grammar Gramatica;

programa : preC instrs posC
         ;

preC : '{' cond '}'
     ;

posC : '{' cond '}'
     ;

instrs : instr instr*
       ;

instr : ifInstruction
      | whileInstruction
      | forInstruction
      | atr ';'
      ;

ifInstruction : 'if' '(' cond ')' '{' instrs '}' elseCondition?
            ;

elseCondition : 'else' '{' instrs '}'
              ;

whileInstruction : 'while' '(' cond ')' inv '{' instrs '}'
               ;

forInstruction : 'for' '(' atr ';' cond ';' atr ')' inv '{' instrs '}'
               ;

inv : '[' cond ']'
     ;

atr : ID '=' exp
    ;

exp : termo
    | exp opA=('+'|'-') termo
    ;

termo : fator
      | termo opM=('*'|'/') fator
      ;

fator : ID
      | INT
      ;

cond : comp
     | '(' cond ')'
     | cond opL=('&&'|'||') cond
     ;

comp : exp op exp
     ;

op : '>'
   | '<'
   | '<' '='
   | '>' '='
   | '=' '='
   | '!' '='
   | '=' '>'
   | '<' '=' '>'
   ;


/*--------------- Lexer ---------------------------------------*/
NOME:	STRING
    ;

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'-')*
    ;

DATA:   INT '-' INT '-' INT
    ;

INT :	'0'..'9'+
    ;

WS  :   [ \t\r\n]  -> skip
    ;

fragment
STRING
    :  '"' ( ESC_SEQ | ~('"') )* '"'
    ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F')
    ;