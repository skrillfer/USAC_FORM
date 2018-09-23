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
public class Multimedia {
    public String repro_automatica="";
    public String url="";
    public String tipoMedia="";

    public Multimedia() {
    }

    
    public Multimedia(String rpa, String url, String tipom) 
    {
        this.repro_automatica=rpa;
        this.url=url;
        this.tipoMedia=tipom;
    }
    
    public String generar_Codigo_Multimedia()
    {
        String STR="";
        if(!tipoMedia.equals("") && !url.equals(""))
        {
            STR += tipoMedia + "("+url;
            
            
            if(!repro_automatica.equals(""))
            {
                STR+=","+repro_automatica;
            }

            STR+=");";
        }
        return STR;
    }
    
    public String generar_CodigoMostrar()
    {
        String cad="\t\tpublico Mostrar(){\n\t\t\t"+generar_Codigo_Multimedia()+"\n\t\t}\n";
        return cad;
    }
    
}
