package com.rex.compiladormultilenguajeservidor.utilidades.proyecto.analisis;

import java_cup.runtime.*;
import static com.rex.compiladormultilenguajeservidor.utilidades.proyecto.analisis.ParserSym.*;

%%

%class Lexer
%unicode
%cup
%line
%column
%public

%state CONTENIDO_ETIQUETA,CLC

ESPECIAL = [ \t\r\n]+

%{

%}


%%

//------------------------------------------------------------------------------------------------
//inicial

//palabras reservadas 
<YYINITIAL>{

	"<PROYECTO_W>"	        								{ return new Symbol(ET_PROYECTO_INIC, yyline, yycolumn, yytext()); }
	"</PROYECTO_W>"	        								{ return new Symbol(ET_PROYECTO_FIN, yyline, yycolumn, yytext()); }
	"<NOMBRE_PROYECTO>"       								{ return new Symbol(ET_NOMBRE_PROYECTO_INIC, yyline, yycolumn, yytext()); }
	"</NOMBRE_PROYECTO>"       								{ return new Symbol(ET_NOMBRE_PROYECTO_FIN, yyline, yycolumn, yytext()); }
    "<PAQUETE_PRINCIPAL>"      								{ return new Symbol(ET_PAQUETE_PRINCIPAL_INIC, yyline, yycolumn, yytext()); }
	"</PAQUETE_PRINCIPAL>"     								{ return new Symbol(ET_PAQUETE_PRINCIPAL_FIN, yyline, yycolumn, yytext()); }
    "<PAQUETE>"      								        { return new Symbol(ET_PAQUETE_INIC, yyline, yycolumn, yytext()); }
	"</PAQUETE>"     								        { return new Symbol(ET_PAQUETE_FIN, yyline, yycolumn, yytext()); }
    "<NOMBRE_PAQUETE>"      								{ return new Symbol(ET_NOMBRE_PAQUETE_INIC, yyline, yycolumn, yytext()); }
	"</NOMBRE_PAQUETE>"     								{ return new Symbol(ET_NOMBRE_PAQUETE_FIN, yyline, yycolumn, yytext()); }
    "<ID_PAQUETE>"      								    { return new Symbol(ET_ID_PAQUETE_INIC, yyline, yycolumn, yytext()); }
	"</ID_PAQUETE>"     								    { return new Symbol(ET_ID_PAQUETE_FIN, yyline, yycolumn, yytext()); }
    "<PAQUETES_PAQUETE>"      								{ return new Symbol(ET_PAQUETES_PAQUETE_INIC, yyline, yycolumn, yytext()); }
	"</PAQUETES_PAQUETE>"     								{ return new Symbol(ET_PAQUETES_PAQUETE_FIN, yyline, yycolumn, yytext()); }
    "<ARCHIVOS_PAQUETE>"      								{ return new Symbol(ET_ARCHIVOS_PAQUETE_INIC, yyline, yycolumn, yytext()); }
	"</ARCHIVOS_PAQUETE>"     								{ return new Symbol(ET_ARCHIVOS_PAQUETE_FIN, yyline, yycolumn, yytext()); }
    "<ARCHIVO>"      								        { return new Symbol(ET_ARCHIVO_INIC, yyline, yycolumn, yytext()); }
	"</ARCHIVO>"     								        { return new Symbol(ET_ARCHIVO_FIN, yyline, yycolumn, yytext()); }
    "<NOMBRE_ARCHIVO>"      								{ return new Symbol(ET_NOMBRE_ARCHIVO_INIC, yyline, yycolumn, yytext()); }
	"</NOMBRE_ARCHIVO>"     								{ return new Symbol(ET_NOMBRE_ARCHIVO_FIN, yyline, yycolumn, yytext()); }
    "<ID_ARCHIVO>"      								    { return new Symbol(ET_ID_ARCHIVO_INIC, yyline, yycolumn, yytext()); }
	"</ID_ARCHIVO>"     								    { return new Symbol(ET_ID_ARCHIVO_FIN, yyline, yycolumn, yytext()); }
    "<PAQUETE_ARCHIVO>"      								{ return new Symbol(ET_PAQUETE_ARCHIVO_INIC, yyline, yycolumn, yytext()); }
	"</PAQUETE_ARCHIVO>"     								{ return new Symbol(ET_PAQUETE_ARCHIVO_FIN, yyline, yycolumn, yytext()); }
    "<CODIGO_ARCHIVO>"      								{ return new Symbol(ET_CODIGO_ARCHIVO_INIC, yyline, yycolumn, yytext()); }
	"</CODIGO_ARCHIVO>"     								{ return new Symbol(ET_CODIGO_ARCHIVO_FIN, yyline, yycolumn, yytext()); }

}

<YYINITIAL>{
    [a-zA-Z0-9_]+("."[a-zA-Z0-9_]+)*        { return new Symbol(ID_NOMBRE, yyline, yycolumn, yytext()); }
    {ESPECIAL}                              { /*IGNORAR*/ }
    "*!+\"@@@\"###$$$"~"$$$###\"@@@\"+!*"   { return new Symbol(CODIGO, yyline, yycolumn, yytext().substring(14,yytext().length()-14)); }
	[^]                                     { System.out.println("CARACTER NO PERTENECE AL LENGUAJE"); }
}

