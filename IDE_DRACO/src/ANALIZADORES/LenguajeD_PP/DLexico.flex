
package ANALIZADORES.LenguajeD_PP;
import ESTRUCTURAS.*;
import java.util.LinkedList;
import java_cup.runtime.*;

%%
%{
   
%}

%class Analizador_LD
%public
%full
%unicode
%line
%column
%char
%ignorecase
%cup


LineTerminator = \r|\n|\r\n|\n\r|\t
WhiteSpace = {LineTerminator} | [ \t\f]|\t
Numero = [:digit:][[:digit:]]* 
Decimal = ([:digit:][[:digit:]]*)? ([.][:digit:][[:digit:]]*)?

Id = [:jletter:]["�"|"�"|"�"|"�"|"�"|[:jletterdigit:]|"_"|]*


Cadena = [\"] [^\"]* [\"]

//Comentario1 = "/*" ["*"]* [^*] ~"*/" | "/*" ["*"]* "*/"
//Comentario2 = "//" [^\r\n]* [^\r\n]

%%


/* OPERADORES Y SIGNOS */

/*ARITMETICOS*/
<YYINITIAL> "+" {return new Symbol(sym.MAS, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "-" {return new Symbol(sym.MENOS, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "*" {return new Symbol(sym.POR, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "/" {return new Symbol(sym.DIV, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "^" {return new Symbol(sym.POT, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "++" {return new Symbol(sym.INC, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "--" {return new Symbol(sym.DEC, new token(yycolumn, yyline, yytext()));}

/*RELACIONALES*/
<YYINITIAL> "==" {return new Symbol(sym.IG_IG, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "<" {return new Symbol(sym.MENQ, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "<=" {return new Symbol(sym.MENIQ, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> ">" {return new Symbol(sym.MAYQ, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> ">=" {return new Symbol(sym.MAYIQ, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "<>" {return new Symbol(sym.DIF, new token(yycolumn, yyline, yytext()));}

/*LOGICOS*/

<YYINITIAL> "||" {return new Symbol(sym.OR, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "&&" {return new Symbol(sym.AND, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "!" {return new Symbol(sym.NOT, new token(yycolumn, yyline, yytext()));}


<YYINITIAL> "(" {return new Symbol(sym.APAR, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> ")" {return new Symbol(sym.CPAR, new token(yycolumn, yyline, yytext()));}

<YYINITIAL> "[" {return new Symbol(sym.ACORCH, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "]" {return new Symbol(sym.CCORCH, new token(yycolumn, yyline, yytext()));}

<YYINITIAL> "," {return new Symbol(sym.COMA, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> ";" {return new Symbol(sym.PYC, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> ":" {return new Symbol(sym.DSPTS, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "=" {return new Symbol(sym.IGUAL, new token(yycolumn, yyline, yytext()));}



/*Palabras Reservadas*/

/*TIPOS DE DATOS*/
<YYINITIAL> "cadena" {return new Symbol(sym.CADENA, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "caracter" {return new Symbol(sym.CARACTER, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "entero" {return new Symbol(sym.ENTERO, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "decimal" {return new Symbol(sym.DECIMAL, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "booleano" {return new Symbol(sym.BOOLEANO, new token(yycolumn, yyline, yytext()));}


/*VALORES BOOLEANOS*/
<YYINITIAL> "falso" {return new Symbol(sym.FALSO, new token(yycolumn, yyline, yytext()));}
<YYINITIAL> "verdadero" {return new Symbol(sym.VERDADERO, new token(yycolumn, yyline, yytext()));}


/*LITERALES VALORES*/
<YYINITIAL> {Numero} {return new Symbol(sym.NUM_LITERAL, new token(yycolumn, yyline, yytext()));}

<YYINITIAL> {Decimal} {return new Symbol(sym.DECIMAL_LITERAL, new token(yycolumn, yyline, yytext()));}

<YYINITIAL> {Id} {return new Symbol(sym.ID, new token(yycolumn, yyline, yytext()));}

<YYINITIAL> {Cadena} {return new Symbol(sym.STRING_LITERAL, new token(yycolumn, yyline, yytext()));}


{LineTerminator} {/* ignorar */}
{WhiteSpace} {/* ignorar */}
. {System.out.println(yyline+","+yycolumn+"=["+yytext()+"],"+yychar); }
