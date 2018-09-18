/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_Principal;

import Analizador_Columnas.Simple1;
import Analizador_Encuesta.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.JFrame;

/**
 *
 * @author fernando
 */
public class Ventana_Principal extends JFrame{
    Panel_Principal panel = new Panel_Principal();

    public Ventana_Principal() {
        setTitle("USAC-FORM");
        setSize(700,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        setLocationRelativeTo(null);
        //setVisible(true);
    }
    
    
    public static void main(String[] args) throws FileNotFoundException {
        new Ventana_Principal().probarParser();
    }
    
    
    public void probarParser() throws FileNotFoundException{
        /*try {
            gramatica parser = new gramatica(new FileReader("/home/fernando/NetBeansProjects/USAC_FORM/Lenguaje_XLS/carga.txt"));
            System.out.println(parser.initParser());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }*/
        /*
        try {
            ParserEncuesta parser_encuesta = new ParserEncuesta(new FileReader("/home/fernando/NetBeansProjects/USAC_FORM/Lenguaje_XLS/prueba.txt"));
            parser_encuesta.initParser();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        */
        try {
            Simple1 parser = new Simple1(new FileReader("/home/fernando/NetBeansProjects/USAC_FORM/Lenguaje_XLS/prueba_cnt_col.txt"));
            parser.initParser();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
          
        //ParserEncuesta lll;
    }
    
    
    
}
