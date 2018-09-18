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

    public Pregunta() {
        this.atributos= new ArrayList<>();
    }
    
    public void setearValor_Atributo(String nombre_atr, String valor){
        for (Atributo atr : this.atributos) {
            if(atr.nombre.equals(nombre_atr)){
                atr.valor=valor;
                break;
            }
        }
    }
    
    public ERROR agregar_Atributo(Atributo atrIn){
        ERROR retorno=null;
        boolean existe=false;
        for (Atributo atr : this.atributos) {
            if(atr.nombre.equals(atrIn.nombre)){
                existe=true;
                break;
            }
        }
        if(!existe){
            this.atributos.add(atrIn);
        }else{
            retorno =  new ERROR ("", "", "Semantico", "El atributo " + atrIn.nombre + "  ya existe en la pregunta");
        }
        return retorno;
    }
    
    
}
