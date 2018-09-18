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
public class MatchCadena {
    
    public boolean isTrue(String s){
        return s.matches("verdadero");
    }
    
    public boolean isFalse(String s){
        return s.matches("falso");
    }
    
    public boolean isNumber(String s){
        return s.matches("^\\d+(\\.\\d+)?");
    }
    
    public boolean isID(String s){
        return s.matches("^[#] [\\[] (\\s)*([A-Z,a-z]([[A-Z,a-z]|[_]|[0-9]])*)[\\]]");
    }
    
    public String get_Valor(String valor, String tipo)
    {
        valor=valor.trim();
        switch(tipo.toLowerCase())
        {
            case "entero":
                if(isNumber(valor) || isTrue(valor) || isFalse(valor)){
                    return valor;
                }
                break;
            case "decimal":
                if(isNumber(valor) || isTrue(valor) || isFalse(valor)){
                    return valor;
                }
                break;
        }
        switch(tipo.toLowerCase())
        {
            default:
                if(isID(valor)){
                    return valor.replaceAll("#", "").replaceAll("[", "").replaceAll("]", "");
                }
        }
        return "";
    }
    
}
