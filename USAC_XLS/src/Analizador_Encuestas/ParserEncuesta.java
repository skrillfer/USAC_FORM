/* Generated By:JavaCC: Do not edit this line. ParserEncuesta.java */
package Analizador_Encuestas;
import Estructuras.*;
import GeneracionXFORM.*;

public class ParserEncuesta implements ParserEncuestaConstants {

    private static Generador_XForm generador = new Generador_XForm();
    private static String nm="";
    public void  initParser() throws ParseException, TokenMgrError
    {
        Inicio();
    }
    public Generador_XForm get_Generador()
    {
        return this.generador;
    }

  static final public void Inicio() throws ParseException {
    Encuesta();
    jj_consume_token(0);
  }

  static final public void Encuesta() throws ParseException {
    jj_consume_token(ENCUESTA_OPEN);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PREGUNTA_OPEN:
      case AGRUPACION_OPEN:
      case CICLO_OPEN:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      Fila();
    }
    jj_consume_token(ENCUESTA_CLOSE);

  }

  static final public void Fila() throws ParseException {
 Pregunta n_pre;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PREGUNTA_OPEN:
      jj_consume_token(PREGUNTA_OPEN);
                          n_pre = generador.generar_Pregunta(false,false);
      Pregunta();
      jj_consume_token(PREGUNTA_CLOSE);
      break;
    case AGRUPACION_OPEN:
      jj_consume_token(AGRUPACION_OPEN);
                          n_pre = generador.generar_Pregunta(false,true);
      Pregunta();
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PREGUNTA_OPEN:
        case AGRUPACION_OPEN:
        case CICLO_OPEN:
          ;
          break;
        default:
          jj_la1[1] = jj_gen;
          break label_2;
        }
        Fila();
      }
      jj_consume_token(AGRUPACION_CLOSE);
                                                                                                                      generador.reset_GrupoActual();
      break;
    case CICLO_OPEN:
      jj_consume_token(CICLO_OPEN);
                     n_pre = generador.generar_Pregunta(true,false);
      Pregunta();
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case PREGUNTA_OPEN:
        case AGRUPACION_OPEN:
        case CICLO_OPEN:
          ;
          break;
        default:
          jj_la1[2] = jj_gen;
          break label_3;
        }
        Fila();
      }
      jj_consume_token(CICLO_CLOSE);
                                                                                                            generador.reset_GrupoActual();
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
        //Se agrega la pregunta
        generador.agregar_Pregunta();
  }

  static final public void Pregunta() throws ParseException {
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDPREGUNTA_OPEN:
      case ETIQUETA_OPEN:
      case CODIGOPRE_OPEN:
      case CODIGOPOST_OPEN:
      case RESTRINGIR_OPEN:
      case REQUERIDO_OPEN:
      case REQUERIDOMSN_OPEN:
      case PREDETERMINADO_OPEN:
      case APLICABLE_OPEN:
      case LECTURA_OPEN:
      case CALCULO_OPEN:
      case REPETIR_OPEN:
      case MULTIMEDIA_OPEN:
      case PARAMETRO_OPEN:
      case RUTA_OPEN:
      case TIPO_OPEN:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_4;
      }
      Columna();
    }
  }

  static final public void Columna() throws ParseException {
 Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TIPO_OPEN:
      t = Tipo();
      break;
    case IDPREGUNTA_OPEN:
      t = IdPregunta();
      break;
    case ETIQUETA_OPEN:
      t = Etiqueta();
      break;
    case REQUERIDOMSN_OPEN:
      t = RequeridoMsn();
      break;
    case RUTA_OPEN:
      t = Ruta();
      break;
    case REQUERIDO_OPEN:
      t = Requerido();
      break;
    case REPETIR_OPEN:
      t = Repetir();
      break;
    case RESTRINGIR_OPEN:
      t = Restringir();
      break;
    case PREDETERMINADO_OPEN:
      t = Predeterminado();
      break;
    case CODIGOPRE_OPEN:
      t = Codigo_Pre();
      break;
    case CODIGOPOST_OPEN:
      t = Codigo_Post();
      break;
    case LECTURA_OPEN:
      t = Lectura();
      break;
    case MULTIMEDIA_OPEN:
      t = Multimedia();
      break;
    case CALCULO_OPEN:
      t = Calculo();
      break;
    case APLICABLE_OPEN:
      t = Aplicable();
      break;
    case PARAMETRO_OPEN:
      t = Parametro();
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
        try {
            t.image = t.image.substring(1, t.image.length()-1);
        } catch (Exception e) {}
        //Para agregar el atributo se setea la linea
        generador.set_linea_actual(t.beginLine);
        //Para agregar el atributo se setea la columna
        generador.set_linea_actual(t.beginColumn);
        //Se Agregar el Atributo a la pregunta
        generador.agregarAtributo(nm,t.image);
  }

/*----------------------------___COLUMNAS___----------------------------------*/
  static final public Token Tipo() throws ParseException {
 Token t;
    jj_consume_token(TIPO_OPEN);
    t = jj_consume_token(VALOR);
    jj_consume_token(TIPO_CLOSE);
                                                    nm="tipo"; {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public Token IdPregunta() throws ParseException {
 Token t;
    jj_consume_token(IDPREGUNTA_OPEN);
    t = jj_consume_token(VALOR);
    jj_consume_token(IDPREGUNTA_CLOSE);
                                                     nm="idpregunta"; {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public Token RequeridoMsn() throws ParseException {
 Token t;
    jj_consume_token(REQUERIDOMSN_OPEN);
    t = jj_consume_token(VALOR);
    jj_consume_token(REQUERIDOMSN_CLOSE);
                                                         nm="requeridomsn"; {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public Token Ruta() throws ParseException {
 Token t;
    jj_consume_token(RUTA_OPEN);
    t = jj_consume_token(VALOR);
    jj_consume_token(RUTA_CLOSE);
                                         nm="ruta"; {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public Token Requerido() throws ParseException {
 Token t;
    jj_consume_token(REQUERIDO_OPEN);
    t = jj_consume_token(VALOR);
    jj_consume_token(REQUERIDO_CLOSE);
                                                   nm="requerido"; {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public Token Lectura() throws ParseException {
 Token t;
    jj_consume_token(LECTURA_OPEN);
    t = jj_consume_token(VALOR);
    jj_consume_token(LECTURA_CLOSE);
                                               nm="lectura"; {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public Token Restringir() throws ParseException {
 Token t;
    jj_consume_token(RESTRINGIR_OPEN);
    t = jj_consume_token(VALOR);
    jj_consume_token(RESTRINGIR_CLOSE);
                                                     nm="restringir"; {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public Token Predeterminado() throws ParseException {
 Token t;
    jj_consume_token(PREDETERMINADO_OPEN);
    t = jj_consume_token(VALOR);
    jj_consume_token(PREDETERMINADO_CLOSE);
                                                             nm="predeterminado"; {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public Token Codigo_Pre() throws ParseException {
 Token t;
    jj_consume_token(CODIGOPRE_OPEN);
    t = jj_consume_token(VALOR);
    jj_consume_token(CODIGOPRE_CLOSE);
                                                   nm="codigo_pre"; {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public Token Codigo_Post() throws ParseException {
 Token t;
    jj_consume_token(CODIGOPOST_OPEN);
    t = jj_consume_token(VALOR);
    jj_consume_token(CODIGOPOST_CLOSE);
                                                     nm="codigo_post"; {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public Token Multimedia() throws ParseException {
 Token t;
    jj_consume_token(MULTIMEDIA_OPEN);
    t = jj_consume_token(VALOR);
    jj_consume_token(MULTIMEDIA_CLOSE);
                                                     nm="multimedia"; {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public Token Calculo() throws ParseException {
 Token t;
    jj_consume_token(CALCULO_OPEN);
    t = jj_consume_token(VALOR);
    jj_consume_token(CALCULO_CLOSE);
                                                      nm="calculo"; {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public Token Aplicable() throws ParseException {
 Token t;
    jj_consume_token(APLICABLE_OPEN);
    t = jj_consume_token(VALOR);
    jj_consume_token(APLICABLE_CLOSE);
                                                          nm="aplicable"; {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public Token Parametro() throws ParseException {
 Token t;
    jj_consume_token(PARAMETRO_OPEN);
    t = jj_consume_token(VALOR);
    jj_consume_token(PARAMETRO_CLOSE);
                                                          nm="parametro"; {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public Token Etiqueta() throws ParseException {
 Token t;
    jj_consume_token(ETIQUETA_OPEN);
    t = jj_consume_token(VALOR);
    jj_consume_token(ETIQUETA_CLOSE);
                                                nm="etiqueta"; {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static final public Token Repetir() throws ParseException {
 Token t;
    jj_consume_token(REPETIR_OPEN);
    t = jj_consume_token(VALOR);
    jj_consume_token(REPETIR_CLOSE);
                                              nm="repetir"; {if (true) return t;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public ParserEncuestaTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[6];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x80,0x80,0x80,0x80,0xaa8a8a00,0xaa8a8a00,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0xa000,0xa000,0xa000,0xa000,0x20a2a,0x20a2a,};
   }

  /** Constructor with InputStream. */
  public ParserEncuesta(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public ParserEncuesta(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ParserEncuestaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public ParserEncuesta(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ParserEncuestaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public ParserEncuesta(ParserEncuestaTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(ParserEncuestaTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 6; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[52];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 6; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 52; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
