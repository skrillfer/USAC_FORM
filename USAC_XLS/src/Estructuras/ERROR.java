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
public class ERROR {
    public String linea;
    public String columna;
    public String tipo;
    public String descripcion;

    public ERROR(String linea, String columna, String tipo, String descripcion) {
        this.linea = linea;
        this.columna = columna;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }
    
    
}
