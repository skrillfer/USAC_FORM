/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GeneracionXFORM;

import Estructuras.Atributo;
import Estructuras.ERROR;
import Estructuras.Pregunta;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class Generador_XForm {
    int Linea_Actual=0;
    int Columna_Actual=0;
    ArrayList<ERROR> Lista_Errores = new ArrayList<>();
    ArrayList<Pregunta> Lista_Preguntas = new ArrayList<>();
    Pregunta Pregunta_Actual=null;
    
    
    
    String STR="";
    String SPR="";
    
    public void agregarAtributo(String nombre_atr, String valor){
        //valor= valor.substring(1,valor.length()-1);
        
        ERROR check=null;
        Atributo at0=null;
        nombre_atr= nombre_atr.toLowerCase();
        switch(nombre_atr){
            case "tipo":
                //Se crea de una vez la respuesta, del tipo que corresponde
                valor=valor.toLowerCase();
                Pregunta_Actual.TIPO=valor;
                at0 = new Atributo("respuesta", null, valor);
                check = Pregunta_Actual.agregar_Atributo(at0);
                check_error_al_agregar_atributo(check);
                break;
            case "codigo_pre":
                /*at0 = new Atributo(nombre_atr, valor, "cadena");
                check = Pregunta_Actual.agregar_Atributo(at0);
                check_error_al_agregar_atributo(check);*/
                System.out.println(valor);
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
            case "predeterminado":
                Pregunta_Actual.setearValor_Atributo("respuesta", valor);
                break;
            case "idpregunta":
                at0 = new Atributo(nombre_atr, valor, "");
                check = Pregunta_Actual.agregar_Atributo(at0);
                check_error_al_agregar_atributo(check);
                
                break;
        }
    }
    
    
    
    //Al generar una pregunta se setea la pregunta ACTUAL
    public Pregunta generar_Pregunta(){
        Pregunta preg = new Pregunta();
        Pregunta_Actual=preg;
        return preg;
    }
    
    public void agregar_Pregunta(){
        if(Pregunta_Actual!=null){
            
            if(Pregunta_Actual.atributos.size()>0){
                Lista_Preguntas.add(Pregunta_Actual);
            }else{
                Lista_Errores.add(new ERROR(String.valueOf(Linea_Actual),String.valueOf(Columna_Actual),"Semantico","La pregunta no tiene atributos"));
            }
            Pregunta_Actual=null;
        }else{
            System.err.println("Pregunta Actual es Null");
        }
        
    }
    
    public void set_linea_actual(int linea){
        this.Linea_Actual=linea;
    }
    
    public void set_columna_actual(int columna){
        this.Columna_Actual=columna;
    }
    
    /*public void agregarPregunta(String valor){
        SPR="Pregunta "+valor+"(){" + STR +"}";
        list_preguntas.add(SPR);
        limpiar();
    }*/
    
    public void limpiar(){
        STR="";
        SPR="";
    }
    
    public void check_error_al_agregar_atributo(ERROR check){
        if(check!=null){
            check.linea=String.valueOf(Linea_Actual);
            check.columna=String.valueOf(Columna_Actual);
            Lista_Errores.add(check);
        }
    }
    
    public void generar_CODIGO_XFORM()
    {   String CODIGO_PREGUNTA="";
        String CODIGO_ATRS="";
        for (Pregunta pregunta : Lista_Preguntas) { 
            Atributo id_pregunta = pregunta.getAtributo_X_Nombre("idpregunta");
            //Si existe el atributo
            if(id_pregunta!=null){
                //Si el atributo:idpregunta tiene valor
                if(!id_pregunta.valor.equals("")){
                    CODIGO_PREGUNTA += "Pregunta "+ id_pregunta.valor+"(){\n";
                    for (Atributo atributo : pregunta.atributos) {
                       CODIGO_ATRS +=atributo.generarCodigoXForm_Forma1();
                    }
                }
                    
            }
            
            if(!CODIGO_PREGUNTA.equals(""))
            {
                CODIGO_PREGUNTA += CODIGO_ATRS;
                /**************************************************************/
                String cod_MetRespuesta="";
                if(!pregunta.TIPO.equals("") && !pregunta.TIPO.equals("nota"))
                {
                    cod_MetRespuesta+="\t"+"publico respuesta("+pregunta.TIPO+" param_1){\n";
                }
                /**************************************************************/
                Atributo restringir_ = pregunta.getAtributo_X_Nombre("restringir");
                if(restringir_!=null)
                {
                    String restrc= restringir_.valor;
                    restrc=restrc.replaceAll("\\.", "param_1");
                    cod_MetRespuesta+="\t"+"\t"+"if ("+restrc+"){\n \t\t\trespuesta = param_1;\n \t\t}\n";
                }else
                {
                    cod_MetRespuesta+="\t\trespuesta = param_1;\n";
                }
                if(!cod_MetRespuesta.equals(""))
                {
                    cod_MetRespuesta+="\t}\n";
                }
                CODIGO_PREGUNTA+=cod_MetRespuesta;
                /**************************************************************/
                CODIGO_PREGUNTA += "}\n";
            }
        }
       
        System.out.println(CODIGO_PREGUNTA);
    }
    
}
