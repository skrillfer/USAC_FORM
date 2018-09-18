/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author fernando
 */
public class Atributo {
    String nombre;
    String valor;
    String tipo;
    String codigoXForm="";
    
    public Atributo(String nombre, String valor,String tipo) {
        this.nombre = nombre;
        this.valor = valor;
        this.tipo=tipo;
    }

    public Atributo() {
    }
    
    
    public String generarCodigoXForm_Forma1(){
       String code="";
       if(valor!=null){
            if(this.tipo.equals("cadena")){
                valor="\""+valor+"\"";
            }else if(this.tipo.equals("fecha") || this.tipo.equals("fechahora") || this.tipo.equals("hora")){
                valor="\'"+valor+"\'";
            }
            code=this.tipo +" "+ nombre +" "+ valor + ";\n"; 
       }else{
            code=this.tipo +" "+ nombre +";\n"; 
       }
       return code;
    }
    
    
}
