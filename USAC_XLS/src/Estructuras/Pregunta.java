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
    public ArrayList<Atributo> atributos;
    public String TIPO="";
    
    public Pregunta() {
        this.atributos= new ArrayList<>();
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
    
    
}
