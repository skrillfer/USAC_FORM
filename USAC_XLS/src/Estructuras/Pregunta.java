/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.ArrayList;

/**
 *
 * @author fernando
 */


public class Pregunta {
    public String Id_L1$T4 = "";
    public String filtros_fichero = "";
    
    public ArrayList<String> LTP_Pregunta = new ArrayList<String>();
    
    public ArrayList<Pregunta> lista_preguntas = null;
    public boolean es_ciclo=false;
    public boolean es_grupo=false;
    
    public  String Aplicable="";
    public String Apariencia="";
    public Multimedia multimedia;
    public String Calculo="";
    public ArrayList<Atributo> atributos;
    public String TIPO="";
    
    public Pregunta() {
        this.atributos= new ArrayList<>();
    }
    
    
    public void crear_lista_preguntas()
    {
        lista_preguntas = new ArrayList<>();
    }
    
    public void setearValor_Atributo(String nombre_atr, String valor){
        for (Atributo atr : this.atributos) {
            if(atr.nombre.toLowerCase().equals(nombre_atr.toLowerCase())){
                atr.valor=valor;
                break;
            }
        }
    }
    
    //Agrega un atributo, si este atributo ya existe entonces se crea un nuevo error;
    public ERROR agregar_Atributo(Atributo atrIn){
        ERROR retorno=null;
        boolean existe=false;
        //Recorre la lista de atributos de esta pregunta
        for (Atributo atr : this.atributos) {
            if(atr.nombre.equals(atrIn.nombre)){
                existe=true;
                break;
            }
        }
        //Si No existe se agrega
        if(!existe){
            
            
            this.atributos.add(atrIn);
        }
        //Si Existe entonces es error
        else{
            retorno =  new ERROR ("", "", "Semantico", "El atributo " + atrIn.nombre + "  ya existe en la pregunta");
        }
        return retorno;
    }
    
    
    public  Atributo getAtributo_X_Nombre(String nm){
        for (Atributo atributo : atributos) {
            if(atributo.nombre.toLowerCase().equals(nm))
            {
                return atributo;
            }
        }
        return null;
    }
    
    public String generar_CodigoCalcular()
    {
        String cad="";
        if(!this.Calculo.equals(""))
        {
            cad+="\t\tpublico calcular(decimal valor){\n";
            cad+="\t\t\trespuesta = "+this.Calculo+";\n";
            cad+="\t\t}\n";
        }
        return cad;
    }
    
    public String generar_Codigo_Selecciona_Uno(ArrayList<Opcion> LT)
    {
        String str="";
        if(!Id_L1$T4.trim().equals(""))
        {
            str="\t\tOpciones "+Id_L1$T4+" = nuevo Opciones();\n";
            for (Opcion opcion : LT) {
                if(opcion.nombre_lista.toLowerCase().equals(Id_L1$T4.toLowerCase()))
                {   
                       str+= "\t\t"+Id_L1$T4.toLowerCase()+".agregar(\""+opcion.nombre+"\","+opcion.etiqueta;
                       if(!opcion.multimedia.trim().equals(""))
                       {
                           str+=","+opcion.multimedia+");\n";
                       }else
                       {
                           str+=");\n";
                       }
                }
            }
        }
        
        return str;
    }
    
}
