//-----------------------------------   LEXICAL DEFINITIONS     -----------------------------------//
%lex

DECIMAL           [0-9]
NO_ZERO_DECIMAL   [1-9]
INTEGER           ("0"|{NO_ZERO_DECIMAL}{DECIMAL}*)
BSL               "\\".

%s  comment

%%

//Comments
"//".*     {/* ignore comments */}                      
"/*"                  { this.begin('comment'); }
<comment>"*/"         { this.popState();}
<comment>.            { /* skip comment content*/ }  

//Whitespaces
\s+                 {/* ignore whitespace */}

//Primitive data types
"float"   { console.log("FLOAT"); return 'FLOAT'; }
"int"     { console.log("INT"); return 'INT'; }
"char"    { console.log("CHAR"); return 'CHAR'; }
"boolean" { console.log("BOOLEAN"); return 'BOOLEAN'; }
"String"  { console.log("STRING"); return 'STRING'; }

//Empty type
"void"    { console.log("VOID"); return 'VOID'; }

//Null typeq
"null"    { console.log("NULL"); return 'NULL'; }

//Other operators
"++" { console.log("OPERATOR_INCREMENT"); return 'OPERATOR_INCREMENT'; }
"--" { console.log("OPERATOR_DECREMENT"); return 'OPERATOR_DECREMENT'; }

//Arithmetic operators
"+" { console.log("OPERATOR_ADDITION"); return 'OPERATOR_ADDITION'; }
"-" { console.log("OPERATOR_SUBSTRACTION"); return 'OPERATOR_SUBSTRACTION'; }
"*" { console.log("OPERATOR_MULTIPLICATION"); return 'OPERATOR_MULTIPLICATION'; } 
"/" { console.log("OPERATOR_DIVISION"); return 'OPERATOR_DIVISION'; }
"%" { console.log("OPERATOR_MODULE"); return 'OPERATOR_MODULE'; }

//Relational operators
"==" { console.log("OPERATOR_EQUAL"); return "OPERATOR_EQUAL"; }
"!=" { console.log("OPERATOR_NOT_EQUAL"); return "OPERATOR_NOT_EQUAL"; }
"<"  { console.log("OPERATOR_LESS_THAN"); return "OPERATOR_LESS_THAN"; }
">"  { console.log("OPERATOR_GREATER_THAN"); return "OPERATOR_GREATER_THAN"; } 
"<=" { console.log("OPERATOR_LESS_THAN_EQUAL"); return "OPERATOR_LESS_THAN_EQUAL"; } 
">=" { console.log("OPERATOR_GREATER_THAN_EQUAL"); return "OPERATOR_GREATER_THAN_EQUAL"; }

//Logical operators
"&&" { console.log("OPERATOR_AND"); return 'OPERATOR_AND'; }
"||" { console.log("OPERATOR_OR"); return 'OPERATOR_OR'; } 
"!"  { console.log("OPERATOR_NOT"); return 'OPERATOR_NOT'; }

//Assigment operators
"=" { console.log("OPERATOR_ASSIGNMENT"); return 'OPERATOR_ASSIGNMENT'; }

//Agrupation symbols
"[" { console.log("LBRACKET"); return 'LBRACKET'; }
"]" { console.log("RBRACKET"); return 'RBRACKET'; }
"(" { console.log("LPARENTHESIS"); return 'LPARENTHESIS'; }
")" { console.log("RPARENTHESIS"); return 'RPARENTHESIS'; }
"{" { console.log("LBRACE"); return 'LBRACE'; }
"}" { console.log("RBRACE"); return 'RBRACE'; } 

//Other Symbols
"." { console.log("DOT"); return 'DOT'; }
"," { console.log("COMMA"); return 'COMMA'; }
":" { console.log("COLON"); return 'COLON'; }
";" { console.log("SEMICOLON"); return 'SEMICOLON'; }

//Math Operations
"abs"    { console.log("ABS"); return 'ABS'; }
"ceil"   { console.log("CEIL"); return 'CEIL'; }
"floor"  { console.log("FLOOR"); return 'FLOOR'; }
"pow"    { console.log("POW"); return 'POW'; }
"sqrt"   { console.log("SQRT"); return 'SQRT'; }
"round"  { console.log("ROUND"); return 'ROUND'; }
"random" { console.log("RANDOM"); return 'RANDOM'; }
"max"    { console.log("MAX"); return 'MAX'; }
"min"    { console.log("MIN"); return 'MIN'; }
"acos"   { console.log("ACOS"); return 'ACOS'; }
"sin"    { console.log("SIN"); return 'SIN'; }
"atan"   { console.log("ATAN"); return 'ATAN'; }
"exp"    { console.log("EXP"); return 'EXP'; }
"toRadians" { console.log("TORADIANS"); return 'TORADIANS'; }

//Java methods
"equals"    { console.log("EQUALS"); return 'EQUALS'; }
"toString"  { console.log("TOSTRING"); return 'TOSTRING'; }

//Access modifiers
"public"    { console.log("PUBLIC"); return 'PUBLIC'; }
"protected" { console.log("PROTECTED"); return 'PROTECTED'; }
"private"   { console.log("PRIVATE"); return 'PRIVATE'; }

//Reserved Words
"class"     { console.log("CLASS"); return 'CLASS'; }
"final"     { console.log("FINAL"); return 'FINAL'; }
"extends"   { console.log("EXTENDS"); return 'EXTENDS'; }
"main"      { console.log("MAIN"); return 'MAIN'; }
"static"    { console.log("STATIC"); return 'STATIC'; }
"var"       { console.log("VAR"); return 'VAR'; }
"new"       { console.log("NEW"); return 'NEW'; }
"System"    { console.log("SYSTEM"); return 'SYSTEM'; }
"out"       { console.log("OUT"); return 'OUT'; }
"print"     { console.log("PRINT"); return 'PRINT'; }
"println"   { console.log("PRINTLN"); return 'PRINTLN'; }
"package"   { console.log("PACKAGE"); return 'PACKAGE'; }
"import"    { console.log("IMPORT"); return 'IMPORT'; }
"this"      { console.log("THIS"); return 'THIS'; }
"Math"      { console.log("MATH"); return 'MATH'; }
"readfloat" { console.log("READFLOAT"); return 'READFLOAT'; }
"readint"   { console.log("READINT"); return 'READINT'; }
"readchar"  { console.log("READCHAR"); return 'READCHAR'; }
"readstring" { console.log("READSTRING"); return 'READSTRING'; }
"readboolean" { console.log("READBOOLEAN"); return 'READBOOLEAN'; }


//Control Structures
"if"        { console.log("IF"); return 'IF'; }
"else"      { console.log("ELSE"); return 'ELSE'; }
"switch"    { console.log("SWITCH"); return 'SWITCH'; }
"case"      { console.log("CASE"); return 'CASE'; }
"default"   { console.log("DEFAULT"); return 'DEFAULT'; }
"while"     { console.log("WHILE"); return 'WHILE'; }
"do"        { console.log("DO"); return 'DO'; }
"for"       { console.log("FOR"); return 'FOR'; }
"break"     { console.log("BREAK"); return 'BREAK'; }
"continue"  { console.log("CONTINUE"); return 'CONTINUE'; }
"return"    { console.log("RETURN"); return 'RETURN'; }

//Annotations
"@Override" { console.log("OVERRIDE"); return 'OVERRIDE'; }
"@Getter"   { console.log("GETTER"); return 'GETTER'; }
"@Setter"   { console.log("SETTER"); return 'SETTER'; }

//Boolean values
"true"      { console.log("TRUE");  return 'TRUE'; }
"false"     { console.log("FALSE"); return 'FALSE'; }

//Float
{INTEGER}+"."{DECIMAL}+?\b  { console.log("FLOAT"); return 'FLOAT_VALUE'; }

//Integer
{INTEGER}[lL]?\b    { console.log("INTEGER_VALUE"); return 'INTEGER_VALUE'; }

//Identifier
[a-zA-Z][a-zA-Z0-9_]* { console.log("IDENTIFIER");  return 'IDENTIFIER'; }

//String
\"[^\"]*\"   { console.log("STRING_VALUE"); yytext = yytext.substr(1, yyleng-2); return 'STRING_VALUE'; }

//Character
"'"(.|{BSL})"'" { console.log("CHAR_VALUE"); yytext = yytext.substr(1, yyleng-2); return 'CHAR_VALUE';}

//End of file
<<EOF>>     { console.log("EOF"); return 'EOF'; }

//Error
.   { console.error('Este es un error léxico: ' + yytext + ', en la linea: ' + yylloc.first_line + ', en la columna: ' + yylloc.first_column); }

/lex

//-----------------------------------   ASSOCIATIVITY AND PRECEDENCE     -----------------------------------//
%left OPERATOR_OR
%left OPERATOR_AND
%left OPERATOR_EQUAL OPERATOR_NOT_EQUAL
%left OPERATOR_LESS_THAN OPERATOR_GREATER_THAN OPERATOR_LESS_THAN_EQUAL OPERATOR_GREATER_THAN_EQUAL
%left OPERATOR_ADDITION OPERATOR_SUBSTRACTION
%left OPERATOR_MULTIPLICATION OPERATOR_DIVISION OPERATOR_MODULE
%right UMINUS OPERATOR_NOT

//-----------------------------------   GRAMMAR      -----------------------------------//
%start code

%% 

//-----------------------------------   Code     -----------------------------------//
code
        : file code
        | file EOF
;      

file
        : package imports class
        | package class
;

//-----------------------------------   Package     -----------------------------------//
package
        : PACKAGE name SEMICOLON
;

name
        : IDENTIFIER
        | name DOT IDENTIFIER
;

//-----------------------------------   Imports     -----------------------------------//
imports
        : import imports
        | import
;

import
        : IMPORT name SEMICOLON
;

//-----------------------------------   Class     -----------------------------------//
class
        : class_atributes CLASS IDENTIFIER class_extends LBRACE class_body RBRACE 
;

class_atributes
        : PUBLIC class_atributes
        | FINAL class_atributes
        | GETTER class_atributes
        | SETTER class_atributes
        |
;

class_extends
        : EXTENDS IDENTIFIER   
        |
;

//-----------------------------------   Class     -----------------------------------//
class_body
        : properties method class_body
        | method class_body
        | main class_body
        | properties declaration SEMICOLON class_body
        | declaration SEMICOLON class_body
        | properties declaration_assignment SEMICOLON class_body
        | declaration_assignment SEMICOLON class_body
        |
;

//-----------------------------------   Method     -----------------------------------//
method
        //Constructor
        : IDENTIFIER LPARENTHESIS params_declaration RPARENTHESIS LBRACE method_body RBRACE
        | IDENTIFIER LPARENTHESIS RPARENTHESIS LBRACE method_body RBRACE
        //Method
        | primitive_type IDENTIFIER LPARENTHESIS params_declaration RPARENTHESIS LBRACE method_body RBRACE
        | primitive_type IDENTIFIER LPARENTHESIS RPARENTHESIS LBRACE method_body RBRACE
        | VOID IDENTIFIER LPARENTHESIS params_declaration RPARENTHESIS LBRACE method_body RBRACE
        | VOID IDENTIFIER LPARENTHESIS RPARENTHESIS LBRACE method_body RBRACE
;

method_body
        : declaration SEMICOLON method_body
        | declaration_assignment SEMICOLON method_body   
        | assignment SEMICOLON method_body 
        | THIS DOT assignment SEMICOLON method_body 
        | call SEMICOLON method_body
        | THIS DOT call SEMICOLON method_body
        | IDENTIFIER DOT call SEMICOLON method_body
        | RETURN op SEMICOLON method_body
        | BREAK SEMICOLON method_body
        | CONTINUE SEMICOLON method_body
        | if method_body
        | while method_body
        | do_while method_body
        | for method_body
        | switch method_body
        | output SEMICOLON method_body
        | input SEMICOLON method_body
        | IDENTIFIER OPERATOR_INCREMENT SEMICOLON method_body
        | IDENTIFIER OPERATOR_DECREMENT SEMICOLON method_body
        | THIS DOT IDENTIFIER OPERATOR_INCREMENT SEMICOLON method_body
        | THIS DOT IDENTIFIER OPERATOR_DECREMENT SEMICOLON method_body
        | IDENTIFIER DOT IDENTIFIER OPERATOR_INCREMENT SEMICOLON method_body
        | IDENTIFIER DOT IDENTIFIER OPERATOR_DECREMENT SEMICOLON method_body
        |
;

//-----------------------------------   Main     -----------------------------------//
main
        : VOID MAIN LPARENTHESIS RPARENTHESIS LBRACE method_body RBRACE
;

//-----------------------------------   Declarations    -----------------------------------//
declaration
        //Primitive types
        : primitive_type id_list 
        //Objects
        | IDENTIFIER id_list 
        //Primitive type Array
        | primitive_type array_dimensions_declaration id_list 
        //Object Array
        | IDENTIFIER array_dimensions_declaration id_list 
        | VAR id_list
;       

id_list
        : IDENTIFIER COMMA id_list
        | IDENTIFIER
;

//-----------------------------------   Declarations and Assignments    -----------------------------------//
declaration_assignment
        //Primitive types
        : declaration OPERATOR_ASSIGNMENT op
        //Objects
        | declaration OPERATOR_ASSIGNMENT NEW IDENTIFIER LPARENTHESIS params RPARENTHESIS
        | declaration OPERATOR_ASSIGNMENT NEW IDENTIFIER LPARENTHESIS RPARENTHESIS
        //Primitive type Array
        | declaration OPERATOR_ASSIGNMENT NEW primitive_type array_dimensions_definition
        //Object  Arrays
        | declaration OPERATOR_ASSIGNMENT NEW IDENTIFIER array_dimensions_definition
;

//-----------------------------------   Assignments     -----------------------------------//
assignment
        : IDENTIFIER OPERATOR_ASSIGNMENT op
        | IDENTIFIER OPERATOR_ASSIGNMENT NEW IDENTIFIER LPARENTHESIS params RPARENTHESIS
        | IDENTIFIER OPERATOR_ASSIGNMENT NEW IDENTIFIER LPARENTHESIS RPARENTHESIS
        | IDENTIFIER OPERATOR_ASSIGNMENT NEW primitive_type array_dimensions_definition
        | IDENTIFIER OPERATOR_ASSIGNMENT NEW IDENTIFIER array_dimensions_definition
;

//-----------------------------------   If     -----------------------------------//
if
        : IF LPARENTHESIS op RPARENTHESIS LBRACE method_body RBRACE else-if 
        | IF LPARENTHESIS op RPARENTHESIS LBRACE method_body RBRACE else
;

else-if
        : ELSE IF LPARENTHESIS op RPARENTHESIS LBRACE method_body RBRACE else-if
        | ELSE IF LPARENTHESIS op RPARENTHESIS LBRACE method_body RBRACE else
;

else
        : ELSE LBRACE method_body RBRACE
        |
;

//-----------------------------------   While     -----------------------------------//
while
        : WHILE LPARENTHESIS op RPARENTHESIS LBRACE method_body RBRACE
;

//-----------------------------------   Do While     -----------------------------------//
do_while
        : DO LBRACE method_body RBRACE WHILE LPARENTHESIS op RPARENTHESIS SEMICOLON
;

//-----------------------------------   For     -----------------------------------//
for
        : FOR LPARENTHESIS for_declaration SEMICOLON op SEMICOLON for_assignment RPARENTHESIS LBRACE method_body RBRACE
;

for_declaration
        : INT IDENTIFIER OPERATOR_ASSIGNMENT op 
        | FLOAT IDENTIFIER OPERATOR_ASSIGNMENT op 
        | CHAR IDENTIFIER OPERATOR_ASSIGNMENT op
        | VAR IDENTIFIER OPERATOR_ASSIGNMENT op
        | IDENTIFIER OPERATOR_ASSIGNMENT op
;

for_assignment
        : IDENTIFIER OPERATOR_INCREMENT
        | IDENTIFIER OPERATOR_DECREMENT
        | IDENTIFIER OPERATOR_ASSIGNMENT op
;

//-----------------------------------   Switch     -----------------------------------//
switch
        : SWITCH LPARENTHESIS IDENTIFIER RPARENTHESIS LBRACE cases RBRACE
        | SWITCH LPARENTHESIS IDENTIFIER RPARENTHESIS LBRACE RBRACE
;

cases
        : CASE primitive_value COLON method_body cases
        | CASE primitive_value COLON method_body
        | DEFAULT COLON method_body cases
        | DEFAULT COLON method_body          
;

//-----------------------------------   Console Output    -----------------------------------//
output
        : SYSTEM DOT OUT DOT PRINTLN LPARENTHESIS op RPARENTHESIS 
        | SYSTEM DOT OUT DOT PRINT LPARENTHESIS op RPARENTHESIS 
        | SYSTEM DOT OUT DOT PRINTLN LPARENTHESIS RPARENTHESIS 
        | SYSTEM DOT OUT DOT PRINT LPARENTHESIS RPARENTHESIS 
;

//-----------------------------------   Console Input    -----------------------------------//
input
        : READFLOAT LPARENTHESIS IDENTIFIER RPARENTHESIS
        | READINT LPARENTHESIS IDENTIFIER RPARENTHESIS
        | READCHAR LPARENTHESIS IDENTIFIER RPARENTHESIS
        | READSTRING LPARENTHESIS IDENTIFIER RPARENTHESIS
        | READBOOLEAN LPARENTHESIS IDENTIFIER RPARENTHESIS
;

//-----------------------------------   Operations     -----------------------------------//
op      
        //Arithmetic Operations
        : OPERATOR_SUBSTRACTION op %prec UMINUS 
        | op OPERATOR_ADDITION op     
        | op OPERATOR_SUBSTRACTION op  
        | op OPERATOR_MULTIPLICATION op 
        | op OPERATOR_DIVISION op 
        | op OPERATOR_MODULE op 
        //Relational Operations
        | op OPERATOR_EQUAL op
        | op OPERATOR_NOT_EQUAL op
        | op OPERATOR_LESS_THAN op
        | op OPERATOR_GREATER_THAN op
        | op OPERATOR_LESS_THAN_EQUAL op
        | op OPERATOR_GREATER_THAN_EQUAL op
        //Logical Operations
        | op OPERATOR_AND op
        | op OPERATOR_OR op
        | OPERATOR_NOT op
        //Agrupation
        | LPARENTHESIS op RPARENTHESIS
        //Values
        | value

;

//-----------------------------------   Call     -----------------------------------//
call
        : IDENTIFIER LPARENTHESIS params RPARENTHESIS
        | IDENTIFIER LPARENTHESIS RPARENTHESIS  
        | MATH DOT math_call
;

math_call
        : ABS LPARENTHESIS op RPARENTHESIS
        | CEIL LPARENTHESIS op RPARENTHESIS
        | FLOOR LPARENTHESIS op RPARENTHESIS
        | POW LPARENTHESIS op COMMA op RPARENTHESIS
        | SQRT LPARENTHESIS op RPARENTHESIS
        | ROUND LPARENTHESIS op RPARENTHESIS
        | RANDOM LPARENTHESIS RPARENTHESIS
        | MAX LPARENTHESIS op COMMA op RPARENTHESIS
        | MIN LPARENTHESIS op COMMA op RPARENTHESIS
        | ACOS LPARENTHESIS op RPARENTHESIS
        | SIN LPARENTHESIS op RPARENTHESIS
        | ATAN LPARENTHESIS op RPARENTHESIS
        | EXP LPARENTHESIS op RPARENTHESIS
        | TORADIANS LPARENTHESIS op RPARENTHESIS
;

//-----------------------------------   Values     -----------------------------------//
value
        : primitive_value
        | object_attirbute
        | IDENTIFIER array_dimensions_definition
        | object_method_call
        | object_method_call array_dimensions_definition
        | this_method_call
        | this_method_call array_dimensions_definition
        | IDENTIFIER
        | call
        | NULL
        | THIS

        //ToString
        | object_attirbute to_string
        | IDENTIFIER array_dimensions_definition to_string
        | object_method_call array_dimensions_definition to_string
        | this_method_call array_dimensions_definition to_string
        | IDENTIFIER to_string
        | call to_string
        | THIS to_string
;

//-----------------------------------   Primitive Values     -----------------------------------//
primitive_value
        : INTEGER_VALUE
        | FLOAT_VALUE
        | CHAR_VALUE
        | STRING_VALUE
        | TRUE
        | FALSE
;

//-----------------------------------   Array Dimensions     -----------------------------------//
array_dimensions_definition
        : LBRACKET op RBRACKET array_dimensions_definition
        | LBRACKET op RBRACKET
;

array_dimensions_declaration
        : LBRACKET RBRACKET array_dimensions_declaration
        | LBRACKET RBRACKET
;

//-----------------------------------   Object Call     -----------------------------------//
object_method_call
        : IDENTIFIER DOT IDENTIFIER LPARENTHESIS params RPARENTHESIS method_call
        | IDENTIFIER DOT IDENTIFIER LPARENTHESIS RPARENTHESIS method_call
        | IDENTIFIER DOT IDENTIFIER LPARENTHESIS params RPARENTHESIS 
        | IDENTIFIER DOT IDENTIFIER LPARENTHESIS RPARENTHESIS 
;

this_method_call
        : THIS DOT IDENTIFIER LPARENTHESIS params RPARENTHESIS method_call
        | THIS DOT IDENTIFIER LPARENTHESIS RPARENTHESIS method_call
        | THIS DOT IDENTIFIER LPARENTHESIS params RPARENTHESIS 
        | THIS DOT IDENTIFIER LPARENTHESIS RPARENTHESIS 
;

method_call        
        : DOT IDENTIFIER LPARENTHESIS params RPARENTHESIS method_call
        | DOT IDENTIFIER LPARENTHESIS RPARENTHESIS method_call
        | DOT IDENTIFIER LPARENTHESIS params RPARENTHESIS
        | DOT IDENTIFIER LPARENTHESIS RPARENTHESIS
        | DOT TOSTRING LPARENTHESIS RPARENTHESIS
;

//-----------------------------------   Object  Attribute Access      -----------------------------------//  
object_attirbute
        : IDENTIFIER DOT IDENTIFIER 
        | THIS DOT IDENTIFIER 
        | THIS DOT IDENTIFIER array_dimensions_definition 
        | IDENTIFIER DOT IDENTIFIER array_dimensions_definition 
;

//-----------------------------------   Parameters     -----------------------------------//
params
        : op COMMA params
        | NEW IDENTIFIER LPARENTHESIS params RPARENTHESIS COMMA params
        | op
        | NEW IDENTIFIER LPARENTHESIS params RPARENTHESIS
;

params_declaration
        //Primitive type
        : primitive_type IDENTIFIER COMMA params_declaration
        | primitive_type IDENTIFIER 
        //Object          
        | IDENTIFIER IDENTIFIER COMMA params_declaration
        | IDENTIFIER IDENTIFIER 
        //Primitive type Array
        | primitive_type array_dimensions_declaration IDENTIFIER COMMA params_declaration
        | primitive_type array_dimensions_declaration IDENTIFIER 
        //Object Array
        | IDENTIFIER array_dimensions_declaration IDENTIFIER COMMA params_declaration
        | IDENTIFIER array_dimensions_declaration IDENTIFIER       
;

//-----------------------------------   Access Modifier     -----------------------------------//
access_modifier
        : PUBLIC
        | PROTECTED
        | PRIVATE
;

//-----------------------------------   Primitive Types     -----------------------------------//
primitive_type
        : FLOAT
        | INT
        | CHAR
        | BOOLEAN
        | STRING
;

properties
        : access_modifier properties
        | STATIC properties
        | FINAL properties
        | GETTER properties
        | SETTER properties
        | OVERRIDE properties
        | access_modifier
        | STATIC
        | FINAL
        | OVERRIDE
        | GETTER
        | SETTER
;

//-----------------------------------   Java Methods     -----------------------------------//
to_string
        : DOT TOSTRING LPARENTHESIS RPARENTHESIS
;