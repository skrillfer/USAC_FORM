
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Mon Oct 15 16:38:02 CST 2018
//----------------------------------------------------

package ANALIZADORES.LenguajeD_PP;

import java_cup.runtime.*;
import java.util.*;
import ESTRUCTURAS.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Mon Oct 15 16:38:02 CST 2018
  */
public class Analizador_SD extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public Analizador_SD() {super();}

  /** Constructor which sets the default scanner. */
  public Analizador_SD(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Analizador_SD(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\053\000\002\002\004\000\002\002\003\000\002\012" +
    "\002\000\002\012\003\000\002\013\004\000\002\013\003" +
    "\000\002\014\003\000\002\015\006\000\002\015\006\000" +
    "\002\003\003\000\002\003\003\000\002\003\003\000\002" +
    "\003\003\000\002\003\003\000\002\004\004\000\002\004" +
    "\003\000\002\005\002\000\002\005\004\000\002\006\005" +
    "\000\002\006\005\000\002\006\004\000\002\006\003\000" +
    "\002\007\005\000\002\007\005\000\002\007\005\000\002" +
    "\007\005\000\002\007\005\000\002\007\005\000\002\007" +
    "\003\000\002\010\005\000\002\010\005\000\002\010\005" +
    "\000\002\010\005\000\002\010\005\000\002\010\004\000" +
    "\002\010\005\000\002\010\003\000\002\011\003\000\002" +
    "\011\003\000\002\011\003\000\002\011\003\000\002\011" +
    "\003\000\002\011\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\103\000\020\002\uffff\007\014\040\004\041\017\042" +
    "\007\043\005\044\006\001\002\000\004\007\ufff4\001\002" +
    "\000\004\007\ufff7\001\002\000\004\007\ufff5\001\002\000" +
    "\004\007\ufff8\001\002\000\004\002\105\001\002\000\020" +
    "\002\ufffc\007\ufffc\040\ufffc\041\ufffc\042\ufffc\043\ufffc\044" +
    "\ufffc\001\002\000\020\002\ufffe\007\014\040\004\041\017" +
    "\042\007\043\005\044\006\001\002\000\020\002\ufffb\007" +
    "\ufffb\040\ufffb\041\ufffb\042\ufffb\043\ufffb\044\ufffb\001\002" +
    "\000\004\007\020\001\002\000\004\007\020\001\002\000" +
    "\004\002\000\001\002\000\004\007\ufff6\001\002\000\010" +
    "\007\ufff2\024\ufff2\026\ufff2\001\002\000\010\007\022\024" +
    "\ufff1\026\023\001\002\000\010\007\ufff3\024\ufff3\026\ufff3" +
    "\001\002\000\024\004\032\005\042\006\035\007\034\011" +
    "\027\017\031\037\041\045\030\046\036\001\002\000\004" +
    "\024\025\001\002\000\020\002\ufffa\007\ufffa\040\ufffa\041" +
    "\ufffa\042\ufffa\043\ufffa\044\ufffa\001\002\000\010\024\ufff0" +
    "\035\045\036\044\001\002\000\022\004\032\005\042\006" +
    "\035\007\034\011\027\017\031\045\030\046\036\001\002" +
    "\000\040\010\uffd8\011\uffd8\012\uffd8\013\uffd8\014\uffd8\020" +
    "\uffd8\024\uffd8\027\uffd8\030\uffd8\031\uffd8\032\uffd8\033\uffd8" +
    "\034\uffd8\035\uffd8\036\uffd8\001\002\000\024\004\032\005" +
    "\042\006\035\007\034\011\027\017\031\037\041\045\030" +
    "\046\036\001\002\000\040\010\uffdc\011\uffdc\012\uffdc\013" +
    "\uffdc\014\uffdc\020\uffdc\024\uffdc\027\uffdc\030\uffdc\031\uffdc" +
    "\032\uffdc\033\uffdc\034\uffdc\035\uffdc\036\uffdc\001\002\000" +
    "\040\010\057\011\050\012\055\013\061\014\052\020\uffe5" +
    "\024\uffe5\027\053\030\051\031\056\032\060\033\062\034" +
    "\054\035\uffe5\036\uffe5\001\002\000\040\010\uffd7\011\uffd7" +
    "\012\uffd7\013\uffd7\014\uffd7\020\uffd7\024\uffd7\027\uffd7\030" +
    "\uffd7\031\uffd7\032\uffd7\033\uffd7\034\uffd7\035\uffd7\036\uffd7" +
    "\001\002\000\040\010\uffda\011\uffda\012\uffda\013\uffda\014" +
    "\uffda\020\uffda\024\uffda\027\uffda\030\uffda\031\uffda\032\uffda" +
    "\033\uffda\034\uffda\035\uffda\036\uffda\001\002\000\040\010" +
    "\uffd9\011\uffd9\012\uffd9\013\uffd9\014\uffd9\020\uffd9\024\uffd9" +
    "\027\uffd9\030\uffd9\031\uffd9\032\uffd9\033\uffd9\034\uffd9\035" +
    "\uffd9\036\uffd9\001\002\000\012\020\uffec\024\uffec\035\uffec" +
    "\036\uffec\001\002\000\040\010\uffdd\011\uffdd\012\uffdd\013" +
    "\uffdd\014\uffdd\020\uffdd\024\uffdd\027\uffdd\030\uffdd\031\uffdd" +
    "\032\uffdd\033\uffdd\034\uffdd\035\uffdd\036\uffdd\001\002\000" +
    "\024\004\032\005\042\006\035\007\034\011\027\017\031" +
    "\037\041\045\030\046\036\001\002\000\040\010\uffdb\011" +
    "\uffdb\012\uffdb\013\uffdb\014\uffdb\020\uffdb\024\uffdb\027\uffdb" +
    "\030\uffdb\031\uffdb\032\uffdb\033\uffdb\034\uffdb\035\uffdb\036" +
    "\uffdb\001\002\000\012\020\uffed\024\uffed\035\uffed\036\uffed" +
    "\001\002\000\024\004\032\005\042\006\035\007\034\011" +
    "\027\017\031\037\041\045\030\046\036\001\002\000\024" +
    "\004\032\005\042\006\035\007\034\011\027\017\031\037" +
    "\041\045\030\046\036\001\002\000\012\020\uffee\024\uffee" +
    "\035\uffee\036\044\001\002\000\012\020\uffef\024\uffef\035" +
    "\uffef\036\uffef\001\002\000\022\004\032\005\042\006\035" +
    "\007\034\011\027\017\031\045\030\046\036\001\002\000" +
    "\022\004\032\005\042\006\035\007\034\011\027\017\031" +
    "\045\030\046\036\001\002\000\022\004\032\005\042\006" +
    "\035\007\034\011\027\017\031\045\030\046\036\001\002" +
    "\000\022\004\032\005\042\006\035\007\034\011\027\017" +
    "\031\045\030\046\036\001\002\000\022\004\032\005\042" +
    "\006\035\007\034\011\027\017\031\045\030\046\036\001" +
    "\002\000\022\004\032\005\042\006\035\007\034\011\027" +
    "\017\031\045\030\046\036\001\002\000\022\004\032\005" +
    "\042\006\035\007\034\011\027\017\031\045\030\046\036" +
    "\001\002\000\022\004\032\005\042\006\035\007\034\011" +
    "\027\017\031\045\030\046\036\001\002\000\022\004\032" +
    "\005\042\006\035\007\034\011\027\017\031\045\030\046" +
    "\036\001\002\000\022\004\032\005\042\006\035\007\034" +
    "\011\027\017\031\045\030\046\036\001\002\000\022\004" +
    "\032\005\042\006\035\007\034\011\027\017\031\045\030" +
    "\046\036\001\002\000\024\010\057\011\050\012\055\013" +
    "\061\014\052\020\uffe6\024\uffe6\035\uffe6\036\uffe6\001\002" +
    "\000\040\010\uffe1\011\uffe1\012\uffe1\013\uffe1\014\052\020" +
    "\uffe1\024\uffe1\027\uffe1\030\uffe1\031\uffe1\032\uffe1\033\uffe1" +
    "\034\uffe1\035\uffe1\036\uffe1\001\002\000\024\010\057\011" +
    "\050\012\055\013\061\014\052\020\uffe7\024\uffe7\035\uffe7" +
    "\036\uffe7\001\002\000\040\010\uffe4\011\uffe4\012\055\013" +
    "\061\014\052\020\uffe4\024\uffe4\027\uffe4\030\uffe4\031\uffe4" +
    "\032\uffe4\033\uffe4\034\uffe4\035\uffe4\036\uffe4\001\002\000" +
    "\024\010\057\011\050\012\055\013\061\014\052\020\uffe8" +
    "\024\uffe8\035\uffe8\036\uffe8\001\002\000\040\010\uffe2\011" +
    "\uffe2\012\uffe2\013\uffe2\014\052\020\uffe2\024\uffe2\027\uffe2" +
    "\030\uffe2\031\uffe2\032\uffe2\033\uffe2\034\uffe2\035\uffe2\036" +
    "\uffe2\001\002\000\024\010\057\011\050\012\055\013\061" +
    "\014\052\020\uffea\024\uffea\035\uffea\036\uffea\001\002\000" +
    "\024\010\057\011\050\012\055\013\061\014\052\020\uffeb" +
    "\024\uffeb\035\uffeb\036\uffeb\001\002\000\040\010\uffe0\011" +
    "\uffe0\012\uffe0\013\uffe0\014\uffe0\020\uffe0\024\uffe0\027\uffe0" +
    "\030\uffe0\031\uffe0\032\uffe0\033\uffe0\034\uffe0\035\uffe0\036" +
    "\uffe0\001\002\000\024\010\057\011\050\012\055\013\061" +
    "\014\052\020\uffe9\024\uffe9\035\uffe9\036\uffe9\001\002\000" +
    "\040\010\uffe3\011\uffe3\012\055\013\061\014\052\020\uffe3" +
    "\024\uffe3\027\uffe3\030\uffe3\031\uffe3\032\uffe3\033\uffe3\034" +
    "\uffe3\035\uffe3\036\uffe3\001\002\000\010\020\077\035\045" +
    "\036\044\001\002\000\040\010\uffde\011\uffde\012\uffde\013" +
    "\uffde\014\uffde\020\uffde\024\uffde\027\uffde\030\uffde\031\uffde" +
    "\032\uffde\033\uffde\034\uffde\035\uffde\036\uffde\001\002\000" +
    "\040\010\uffdf\011\uffdf\012\055\013\061\014\052\020\uffdf" +
    "\024\uffdf\027\uffdf\030\uffdf\031\uffdf\032\uffdf\033\uffdf\034" +
    "\uffdf\035\uffdf\036\uffdf\001\002\000\010\007\022\024\ufff1" +
    "\026\023\001\002\000\004\024\103\001\002\000\020\002" +
    "\ufff9\007\ufff9\040\ufff9\041\ufff9\042\ufff9\043\ufff9\044\ufff9" +
    "\001\002\000\020\002\ufffd\007\ufffd\040\ufffd\041\ufffd\042" +
    "\ufffd\043\ufffd\044\ufffd\001\002\000\004\002\001\001\002" +
    "" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\103\000\016\002\007\003\014\012\015\013\011\014" +
    "\010\015\012\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\010\003\014\014\103\015\012\001\001" +
    "\000\002\001\001\000\004\004\100\001\001\000\004\004" +
    "\020\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\005\023\001\001\000\002\001\001\000" +
    "\012\006\025\007\036\010\032\011\037\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\010" +
    "\077\011\037\001\001\000\002\001\001\000\012\006\075" +
    "\007\036\010\032\011\037\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\012\006" +
    "\042\007\036\010\032\011\037\001\001\000\002\001\001" +
    "\000\002\001\001\000\012\006\046\007\036\010\032\011" +
    "\037\001\001\000\012\006\045\007\036\010\032\011\037" +
    "\001\001\000\002\001\001\000\002\001\001\000\006\010" +
    "\074\011\037\001\001\000\006\010\073\011\037\001\001" +
    "\000\006\010\072\011\037\001\001\000\006\010\071\011" +
    "\037\001\001\000\006\010\070\011\037\001\001\000\006" +
    "\010\067\011\037\001\001\000\006\010\066\011\037\001" +
    "\001\000\006\010\065\011\037\001\001\000\006\010\064" +
    "\011\037\001\001\000\006\010\063\011\037\001\001\000" +
    "\006\010\062\011\037\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\005\101\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Analizador_SD$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Analizador_SD$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Analizador_SD$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    
    public void syntax_error(Symbol s){
        System.err.println("Error en la Línea " + (s.right+1) +" Columna "+(s.left+1)+ ". Identificador "
        +s.value + " no reconocido." );
        //Inicio.reporteError.agregar("Sintactico",s.right+1,s.left+1,"Identificador "+s.value+" no reconocido");
    }
    
    public Nodo getRoot(){
        return action_obj.root;
    }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$Analizador_SD$actions {


    public int Index=1;
    public Nodo root;  

  private final Analizador_SD parser;

  /** Constructor */
  CUP$Analizador_SD$actions(Analizador_SD parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$Analizador_SD$do_action(
    int                        CUP$Analizador_SD$act_num,
    java_cup.runtime.lr_parser CUP$Analizador_SD$parser,
    java.util.Stack            CUP$Analizador_SD$stack,
    int                        CUP$Analizador_SD$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Analizador_SD$result;

      /* select the action based on the action number */
      switch (CUP$Analizador_SD$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 42: // dato ::= ID 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("dato",7, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 41: // dato ::= FALSO 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("dato",7, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 40: // dato ::= VERDADERO 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("dato",7, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 39: // dato ::= DECIMAL_LITERAL 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("dato",7, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // dato ::= NUM_LITERAL 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("dato",7, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // dato ::= STRING_LITERAL 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("dato",7, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // expa ::= dato 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("expa",6, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // expa ::= APAR expl CPAR 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("expa",6, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-2)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // expa ::= MENOS expa 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("expa",6, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // expa ::= expa POT expa 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("expa",6, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-2)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // expa ::= expa DIV expa 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("expa",6, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-2)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // expa ::= expa POR expa 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("expa",6, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-2)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // expa ::= expa MENOS expa 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("expa",6, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-2)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // expa ::= expa MAS expa 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("expa",6, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-2)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // expr ::= expa 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // expr ::= expa MAYIQ expa 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-2)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // expr ::= expa MAYQ expa 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-2)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // expr ::= expa MENIQ expa 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-2)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // expr ::= expa MENQ expa 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-2)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // expr ::= expa DIF expa 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-2)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // expr ::= expa IG_IG expa 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("expr",5, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-2)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // expl ::= expr 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("expl",4, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // expl ::= NOT expl 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("expl",4, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // expl ::= expl OR expl 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("expl",4, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-2)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // expl ::= expl AND expl 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("expl",4, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-2)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // asignacion_var ::= IGUAL expl 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("asignacion_var",3, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // asignacion_var ::= 
            {
              Nodo RESULT =null;
		
              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("asignacion_var",3, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // lista_id ::= ID 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("lista_id",2, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // lista_id ::= lista_id ID 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("lista_id",2, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // tipo_dato ::= CADENA 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("tipo_dato",1, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // tipo_dato ::= BOOLEANO 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("tipo_dato",1, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // tipo_dato ::= CARACTER 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("tipo_dato",1, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // tipo_dato ::= DECIMAL 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("tipo_dato",1, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // tipo_dato ::= ENTERO 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("tipo_dato",1, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // declaracion_variable ::= ID lista_id asignacion_var PYC 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("declaracion_variable",11, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-3)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // declaracion_variable ::= tipo_dato lista_id asignacion_var PYC 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("declaracion_variable",11, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-3)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // declaraciones ::= declaracion_variable 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("declaraciones",10, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // contenido_cuerpo ::= declaraciones 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("contenido_cuerpo",9, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // contenido_cuerpo ::= contenido_cuerpo declaraciones 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("contenido_cuerpo",9, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // cuerpo_documento ::= contenido_cuerpo 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("cuerpo_documento",8, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // cuerpo_documento ::= 
            {
              Nodo RESULT =null;
		
              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("cuerpo_documento",8, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // inicio ::= cuerpo_documento 
            {
              Nodo RESULT =null;

              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          return CUP$Analizador_SD$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= inicio EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-1)).right;
		Nodo start_val = (Nodo)((java_cup.runtime.Symbol) CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-1)).value;
		RESULT = start_val;
              CUP$Analizador_SD$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.elementAt(CUP$Analizador_SD$top-1)), ((java_cup.runtime.Symbol)CUP$Analizador_SD$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Analizador_SD$parser.done_parsing();
          return CUP$Analizador_SD$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}
