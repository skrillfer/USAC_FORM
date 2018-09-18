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
        ERROR check=null;
        Atributo at0=null;
        switch(nombre_atr){
            case "tipo":
                at0 = new Atributo("respuesta", null, valor);
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
                if("".equals(valor)){
                    valor="falso";
                }
                at0 = new Atributo(nombre_atr, valor, "booleano");
                check = Pregunta_Actual.agregar_Atributo(at0);
                check_error_al_agregar_atributo(check);
                
                break;
            case "predeterminado":
                Pregunta_Actual.setearValor_Atributo("respuesta", valor);
                break;
            /*case "idpregunta":
                SPR+="Pregunta "+valor+"(){";
                break;*/
        }
    }
    
    
    
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
    
    public static void main(String[] args) {
        
        //generadorXform.agregarAtributo(nombre_atr, valor);
    }
}
