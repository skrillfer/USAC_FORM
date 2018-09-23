/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneracionXFORM;

import Analizador_ColumnaMultimedia.ParserMultimedia;
import Estructuras.Atributo;
import Estructuras.ERROR;
import Estructuras.Formulario;
import Estructuras.Multimedia;
import Estructuras.Opcion;
import Estructuras.Pregunta;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author fernando
 */
public class Generador_XForm {
    public ArrayList<Opcion> LT_Opciones=new ArrayList<>();
    public String nombre_archivoxls="";

    Stack<Pregunta> stack_padres = new Stack<>();
    ArrayList<Pregunta> pila_padres = new ArrayList<>();
    int Linea_Actual = 0;
    int Columna_Actual = 0;
    public ArrayList<ERROR> Lista_Errores = new ArrayList<>();
    public ArrayList<Pregunta> Lista_Preguntas = new ArrayList<>();
    Pregunta Pregunta_Actual = null;

    Pregunta Grupo_Actual = null;

    String STR = "";
    String SPR = "";

    public boolean esFichero(String valor) {
        String va1 = valor.replace("fichero", "");
        if (va1.trim().equals("")) {
            return true;
        } else if (!va1.trim().equals("") && valor.contains("fichero")) {

            Pregunta_Actual.filtros_fichero = va1.trim();
            return true;

        }
        return false;
    }

    public boolean esSeleciona_Uno(String valor) {
        String va1 = valor.replace("selecciona_uno", "");
        if (va1.trim().equals("")) {
            return true;
        }else if (!va1.trim().equals("") && valor.contains("selecciona_uno")) {
            Pregunta_Actual.Id_L1$T4 = va1.trim();
            return true;
        }
        return false;
    }
    
    public boolean esSeleciona_Multiples(String valor) {
        String va1 = valor.replace("selecciona_multiples", "");
        if (va1.trim().equals("")) {
            return true;
        }else if (!va1.trim().equals("") && valor.contains("selecciona_multiples")) {
            Pregunta_Actual.Id_L1$T4 = va1.trim();
            return true;
        }
        return false;
    }
    public void agregarAtributo(String nombre_atr, String valor) {
        //valor= valor.substring(1,valor.length()-1);

        ERROR check = null;
        Atributo at0 = null;
        nombre_atr = nombre_atr.toLowerCase();
        switch (nombre_atr) {
            case "tipo":
                //Se crea de una vez la respuesta, del tipo que corresponde
                valor = valor.toLowerCase();
                valor = valor.trim();
                Pregunta_Actual.TIPO = valor;

                boolean agregar_respuesta = true;
                if (valor.equals("nota")) {
                    valor = "cadena";
                }
                
                if (esFichero(valor)) {
                    Pregunta_Actual.TIPO = "fichero";
                    valor = "fichero";
                    agregar_respuesta = false;
                }
                
                if (esSeleciona_Uno(valor)) {
                    Pregunta_Actual.TIPO = "selecciona_uno";
                    valor = "cadena";
                    agregar_respuesta = true;
                }
                if (esSeleciona_Multiples(valor)) {
                    Pregunta_Actual.TIPO = "selecciona_multiples";
                    valor = "entero";
                    agregar_respuesta = true;
                }
                if (agregar_respuesta) {
                    at0 = new Atributo("respuesta", null, valor);
                    check = Pregunta_Actual.agregar_Atributo(at0);
                    check_error_al_agregar_atributo(check);
                }

                break;
            case "codigo_pre":
            case "codigo_post":
                at0 = new Atributo(nombre_atr, valor, "cadena");
                check = Pregunta_Actual.agregar_Atributo(at0);
                check_error_al_agregar_atributo(check);
                break;
            case "etiqueta":
                at0 = new Atributo(nombre_atr, valor, "cadena");
                check = Pregunta_Actual.agregar_Atributo(at0);
                check_error_al_agregar_atributo(check);
                break;
            case "sugerir":
                at0 = new Atributo(nombre_atr, valor, "cadena");
                check = Pregunta_Actual.agregar_Atributo(at0);
                check_error_al_agregar_atributo(check);
                break;
            case "requeridomsn":
                at0 = new Atributo(nombre_atr, valor, "cadena");
                check = Pregunta_Actual.agregar_Atributo(at0);
                check_error_al_agregar_atributo(check);
                break;
            case "ruta":
                at0 = new Atributo(nombre_atr, valor, "cadena");
                check = Pregunta_Actual.agregar_Atributo(at0);
                check_error_al_agregar_atributo(check);
                break;
            case "requerido":
                at0 = new Atributo(nombre_atr, valor, "booleano");
                check = Pregunta_Actual.agregar_Atributo(at0);
                check_error_al_agregar_atributo(check);
                break;
            case "lectura":
                at0 = new Atributo(nombre_atr, valor, "booleano");
                check = Pregunta_Actual.agregar_Atributo(at0);
                check_error_al_agregar_atributo(check);
                break;
            case "restringir":
                at0 = new Atributo(nombre_atr, valor, "booleano");
                check = Pregunta_Actual.agregar_Atributo(at0);
                check_error_al_agregar_atributo(check);
                break;
            case "repetir":
                at0 = new Atributo(nombre_atr, valor, "cadena");
                check = Pregunta_Actual.agregar_Atributo(at0);
                check_error_al_agregar_atributo(check);
                break;
            case "predeterminado":
                Pregunta_Actual.setearValor_Atributo("respuesta", valor);
                break;
            case "parametro":
                at0 = new Atributo(nombre_atr, valor, "");
                check = Pregunta_Actual.agregar_Atributo(at0);
                check_error_al_agregar_atributo(check);
                break;
            case "idpregunta":
                at0 = new Atributo(nombre_atr, valor, "");
                check = Pregunta_Actual.agregar_Atributo(at0);
                check_error_al_agregar_atributo(check);
                break;
            case "multimedia":
                try {
                    ParsearMultimedia(valor);
                } catch (Exception e) {
                    System.out.println("Error al parsear multimedia:" + valor);
                }
                break;
            case "calculo":
                String vac = (new Atributo().Parsear_OtrosValor(valor));
                vac=vac.replaceAll("\\.", "respuesta");
                vac=vac.replaceAll("pvnt0", ".");
                if (!vac.equals("")) {
                    Pregunta_Actual.Calculo = vac;
                }
                break;
            case "aplicable":
                String va1c = (new Atributo().Parsear_OtrosValor(valor));
                va1c=va1c.replaceAll("\\.", "respuesta");
                va1c=va1c.replaceAll("pvnt0", ".");
                
                if (!va1c.equals("")) {
                    Pregunta_Actual.Aplicable = va1c;
                }
                break;
        }
    }

    //Al generar una pregunta se setea la pregunta ACTUAL
    public Pregunta generar_Pregunta(boolean esciclo, boolean esgrupo) {
        Pregunta preg = new Pregunta();
        Pregunta_Actual = preg;
        preg.es_ciclo = esciclo;
        preg.es_grupo = esgrupo;
        if (preg.es_grupo) {
            preg.TIPO = "agrupacion";
            preg.crear_lista_preguntas();
            if (pila_padres.isEmpty()) {
                Lista_Preguntas.add(preg);
            } else {
                Grupo_Actual.lista_preguntas.add(preg);
            }
            set_Grupo_actual(preg);
            pila_padres.add(preg);

            stack_padres.push(preg);
        }else if(preg.es_ciclo)
        {
            preg.TIPO = "ciclo";
            preg.crear_lista_preguntas();
            if (pila_padres.isEmpty()) {
                Lista_Preguntas.add(preg);
            } else {
                Grupo_Actual.lista_preguntas.add(preg);
            }
            set_Grupo_actual(preg);
            pila_padres.add(preg);
            stack_padres.push(preg);
        }
        return preg;
    }

    public void set_Grupo_actual(Pregunta preg) {
        Grupo_Actual = preg;
    }

    public void reset_GrupoActual() {
        Grupo_Actual = null;
        if (stack_padres.size() > 0) {
            stack_padres.pop();
            if (stack_padres.size() > 0) {
                Grupo_Actual = stack_padres.lastElement();
            }
        }
    }

    public void agregar_Pregunta() {
        if (Pregunta_Actual != null) {

            if (Pregunta_Actual.atributos.size() > 0) {
                if (Grupo_Actual != null) {
                    Grupo_Actual.lista_preguntas.add(Pregunta_Actual);
                } else {
                    Lista_Preguntas.add(Pregunta_Actual);
                }
            } else {
                Lista_Errores.add(new ERROR(String.valueOf(Linea_Actual), String.valueOf(Columna_Actual), "Semantico", "La pregunta no tiene atributos"));
            }
            Pregunta_Actual = null;
        } else {
            System.err.println("Pregunta Actual es Null");
        }
    }

    public void set_linea_actual(int linea) {
        this.Linea_Actual = linea;
    }

    public void set_columna_actual(int columna) {
        this.Columna_Actual = columna;
    }

    public void limpiar() {
        STR = "";
        SPR = "";
    }

    public void check_error_al_agregar_atributo(ERROR check) {
        if (check != null) {
            check.linea = String.valueOf(Linea_Actual);
            check.columna = String.valueOf(Columna_Actual);
            Lista_Errores.add(check);
        }
    }

    public String generar_CODIGO_XFORM(ArrayList<Pregunta> LT) {
        String CODIGO_PREGUNTA = "";
        String CODIGO_ATRS = "";
        for (Pregunta pregunta : LT) {
            CODIGO_ATRS = "";
            Atributo id_pregunta = pregunta.getAtributo_X_Nombre("idpregunta");
            //Si existe el atributo
            if (id_pregunta != null) {
                //Si el atributo:idpregunta tiene valor
                if (!id_pregunta.valor.equals("")) {
                    if (pregunta.es_grupo) {
                        CODIGO_PREGUNTA += generar_CODIGO_XFORM(pregunta.lista_preguntas);
                        CODIGO_PREGUNTA += "\n" + getTabs(1) + "Grupo " + id_pregunta.valor + "(" + "){\n";
                        CODIGO_PREGUNTA += "\t\tRespuestas res;\n";
                    }else if(pregunta.es_ciclo)
                    {
                        CODIGO_PREGUNTA += generar_CODIGO_XFORM(pregunta.lista_preguntas);
                    }else {
                        CODIGO_PREGUNTA += "\n" + getTabs(1) + "Pregunta " + id_pregunta.valor + "(" + "){\n";
                    }

                    if (pregunta.es_grupo) {
                        Formulario form1 = new Formulario(nombre_archivoxls);
                        form1.LT_Opciones=this.LT_Opciones;
                        String D4T4 = form1.generar_codIn_FormGR_CIC(pregunta.lista_preguntas);
                        CODIGO_PREGUNTA += D4T4;
                    }else if(pregunta.es_ciclo){
                    } 
                    else {
                        for (Atributo atributo : pregunta.atributos) {
                            CODIGO_ATRS += atributo.generarCodigoXForm_Forma1(pregunta);
                        }
                    }

                }

            }

            if (!CODIGO_PREGUNTA.equals("")) {
                CODIGO_PREGUNTA += CODIGO_ATRS;
                /**
                 * ***********************************************************
                 */
                String cod_MetRespuesta = "";
                if (!pregunta.TIPO.equals("") && !pregunta.TIPO.equals("nota") && !pregunta.TIPO.equals("fichero") && !pregunta.TIPO.equals("agrupacion") && !pregunta.TIPO.equals("ciclo")) {
                    String TIPOFIN=pregunta.TIPO;
                    if(TIPOFIN.toLowerCase().equals("selecciona_uno"))
                    {
                        TIPOFIN="cadena";
                    }
                    if(TIPOFIN.toLowerCase().equals("selecciona_multiples"))
                    {
                        TIPOFIN="entero";
                    }
                    if(TIPOFIN.toLowerCase().equals("calcular"))
                    {
                        TIPOFIN="decimal";
                    }
                    cod_MetRespuesta += getTabs(2) + "publico respuesta(" + TIPOFIN + " param_1){\n";

                    /**
                     * **********Metodo Respuesta*********************************
                     */
                    Atributo restringir_ = pregunta.getAtributo_X_Nombre("restringir");

                    if (restringir_ != null) {
                        String restrc = restringir_.valor;
                        
                        restrc = restringir_.Parsear_OtrosValor(restrc);
                        restrc = restrc.replaceAll("\\.", "param_1");
                        
                        restrc=restrc.replaceAll("pvnt0", ".");
                        cod_MetRespuesta += getTabs(3) + "if (" + restrc + "){\n " + getTabs(4) + "respuesta = param_1;\n " + getTabs(3) + "}\n";

                    } else {
                        cod_MetRespuesta += getTabs(3) + "respuesta = param_1;\n";
                    }
                    if (!cod_MetRespuesta.equals("")) {
                        cod_MetRespuesta += getTabs(2) + "}\n";
                    }
                    CODIGO_PREGUNTA += cod_MetRespuesta;
                    //##############################################################

                }

                /**
                 * *********************Metodo Mostrar************************
                 */
                String cod_MetMostrar = "";
                /*if(!pregunta.TIPO.equals("") && pregunta.TIPO.equals("nota"))
                {*/
                if (pregunta.multimedia != null) {
                    cod_MetMostrar = pregunta.multimedia.generar_CodigoMostrar();
                }
                /*}*/
                CODIGO_PREGUNTA += cod_MetMostrar;
                //##############################################################

                /**
                 * *********************Metodo Calcular************************
                 */
                CODIGO_PREGUNTA += pregunta.generar_CodigoCalcular();
                //##############################################################

                if(!pregunta.TIPO.equals("ciclo"))
                {
                    CODIGO_PREGUNTA += getTabs(1) + "}\n";
                }
                
            }
        }
        return CODIGO_PREGUNTA;
        //System.out.println(CODIGO_PREGUNTA);
    }

    public void ParsearMultimedia(String vv) {
        try {
            ParserMultimedia parser_multimedia = new ParserMultimedia(new StringReader(vv));
            parser_multimedia.ReInit(new StringReader(vv));
            parser_multimedia.initParser();
            Multimedia ml = parser_multimedia.getMultimedia();
            if (ml != null) {
                Pregunta_Actual.multimedia = ml;
            }
        } catch (Exception e) {
            System.err.println("Parseando multimedia:" + e.getMessage() + "\nValor:" + vv);
        }
    }

    public String getTabs(int num) {
        String str = "";
        for (int i = 0; i < num; i++) {
            str += "\t";
        }
        return str;
    }
}
