/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Analizador_Columnas.Simple1;
import Analizador_OtrasColumnas.ParserOtras;

/**
 *
 * @author fernando
 */
public class Opcion {
    public String nombre_lista="";
    public String nombre="";
    public String etiqueta="";
    public String multimedia="";
    
    
    public void setNombreLista(String p1)
    {
        try {
            p1 = p1.substring(1, p1.length()-1);
        } catch (Exception e) {}
        nombre_lista = Parsear_OtrosValor(p1);
    }
    
    public void setNombre(String p1)
    {
        try {
            p1 = p1.substring(1, p1.length()-1);
        } catch (Exception e) {}
        nombre = Parsear_OtrosValor(p1);
    }
    
    public void setEtiqueta(String p1)
    {
        try {
            p1 = p1.substring(1, p1.length()-1);
        } catch (Exception e) {}
        etiqueta = Parsear_Valor(p1);
    }
    
    public void setMultimedia(String p1)
    {
        try {
            p1 = p1.substring(1, p1.length()-1);
        } catch (Exception e) {}
        multimedia = Parsear_Valor(p1);
    }
    
    public String Parsear_Valor(String vl) {
        String val = "";
        try {
            if (vl != null) {
                Simple1 parser = new Simple1(new java.io.StringReader(vl));
                parser.ReInit(new java.io.StringReader(vl));
                val = parser.initParser();
                
            }
        } catch (Exception e) {
            System.out.println("Error_ParsearValor\n"+e.getMessage());
            val = "";
        }
        return val;
    }


    public String Parsear_OtrosValor(String vl) {
        String val = "";
        try {
            if (vl != null) {
                ParserOtras parser = new ParserOtras(new java.io.StringReader(vl));
                parser.ReInit(new java.io.StringReader(vl));
                val = parser.initParser();
            }
        } catch (Exception e) {
            System.out.println("Error_ParsearValor\n"+e.getMessage());
            val = "";
        }
        return val;
    }
    
}
