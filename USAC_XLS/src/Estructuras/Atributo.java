/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Analizador_Columnas.Simple1;
import Analizador_OtrasColumnas.ParserOtras;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class Atributo {

    
    public String nombre = "";
    public String valor = "";
    public String tipo = "";
    public String codigoXForm = "";
    
    public Atributo(String nombre, String valor, String tipo) {
        this.nombre = nombre;
        this.valor = valor;
        this.tipo = tipo;
    }

    public Atributo() {
    }

    public String es_Nulo_o_Vacio(String val_r) {
        if (val_r != null) {
            if (!"".equals(val_r)) {
                return val_r;
            }
        }

        return "";
    }

    public String generarCodigoXForm_Forma1(Pregunta pregunta) {
        String code = "";
        try {
            valor = valor.replaceAll("\'", "\"");
        } catch (Exception e) {
        }
        
        switch (this.nombre.toLowerCase()) {
            
            case "etiqueta":
                this.valor = Parsear_Valor(this.valor,pregunta);
                code += "\t\t" + this.tipo + " etiqueta = " + es_Nulo_o_Vacio(this.valor) + ";\n";
                break;
            case "sugerir":
                this.valor = Parsear_Valor(this.valor,pregunta);
                code += "\t\t" + this.tipo + " sugerir = " + es_Nulo_o_Vacio(this.valor) + ";\n";
                break;
            case "requeridomsn":
                this.valor = Parsear_Valor(this.valor,pregunta);
                code += "\t\t" + this.tipo + " requeridomsn = " + es_Nulo_o_Vacio(this.valor) + ";\n";
                break;
            case "requerido":
                this.valor = Parsear_Valor(this.valor,pregunta);
                this.valor =es_Nulo_o_Vacio(this.valor);
                code += "\t\t" + this.tipo + " requerido ";
                if(this.valor.equals(""))
                {
                    code += ";\n";
                }else
                {
                    try {
                        this.valor = this.valor.substring(1, this.valor.length()-1);
                    } catch (Exception e) {code += ";\n";}
                    if(this.valor.equals("verdadero") || this.valor.equals("falso") 
                    || this.valor.equals("0") || this.valor.equals("1"))
                    {
                        code+=" = "+this.valor+";\n";
                    }else
                    {
                     code += ";\n";
                    }
                }
                break;
            case "lectura":
                this.valor = Parsear_OtrosValor(this.valor);
                this.valor = es_Nulo_o_Vacio(this.valor);
                code += "\t\t" + this.tipo + " lectura ";
                if(this.valor.equals(""))
                {
                    code += ";\n";
                }else
                {
                    if(this.valor.equals("verdadero") || this.valor.equals("falso") 
                    || this.valor.equals("0") || this.valor.equals("1"))
                    {
                        code+=" = "+this.valor+";\n";
                    }else
                    {
                     code += ";\n";
                    }
                }
                break;
            case "ruta":
                this.valor = Parsear_Valor(this.valor,pregunta);
                code += "\t\t" + this.tipo + " ruta = " + es_Nulo_o_Vacio(this.valor) + ";\n";
                break;
            case "respuesta":
                String TiPOfinal = this.tipo;
                switch(TiPOfinal){
                    case "calcular":
                        TiPOfinal = "decimal";
                        break;
                    case "rango":
                        TiPOfinal = "entero";
                        break;
                    case "texto":
                        TiPOfinal = "cadena";
                        break;
                    case "condicion":
                        TiPOfinal = "booleano";
                        break;
                    case "multimedia":
                        TiPOfinal = "cadena";
                        break;
                    case "seleccion_uno":
                    case "selecciona_uno":
                        TiPOfinal = "cadena";
                        break;
                    case "seleccion_multiples":
                    case "selecciona_multiples":
                        TiPOfinal = "cadena";
                        break;
                }
                code += "\t\t" + TiPOfinal + " respuesta";
                if (this.valor == null) {
                    code += ";\n";
                }else
                {
                    MatchCadena mach = new MatchCadena();
                    String cmpr=mach.get_Valor(this.valor,this.tipo);
                    if(cmpr.equals(""))
                    {
                        this.valor = Parsear_Valor(this.valor,pregunta);
                        if(!this.valor.equals(""))
                        {
                            code += "="+this.valor+";\n";
                        }
                        else
                        {
                            code += ";\n";
                        }
                    }else
                    {
                        if(!cmpr.equals("")){
                            code += "="+this.valor+";\n";
                        }else
                        {
                            code += ";\n";
                        }
                    }
                    
                }
                break;

        }

        return code;
    }
    
    /*
        La columna multimedia me ayuda a definir autoreproduccion ADEMAS e DEBE generar el codigo de la funcion MOSTRAR
    */

    public String Parsear_Valor(String vl,Pregunta pregunta) {
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
