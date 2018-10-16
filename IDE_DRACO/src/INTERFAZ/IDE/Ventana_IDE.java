/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERFAZ.IDE;

import Interprete.Interpretacion;
import LEXICOX.Lexicox;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

/**
 *
 * @author fernando
 */
public class Ventana_IDE extends JFrame{

    public Ventana_IDE() throws HeadlessException, BadLocationException {
        super("ventana principal");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // JFrame con su título arriba
        JMenuBar barraMenu = new JMenuBar();
        JTextArea areaTexto = new JTextArea();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenu menuEditar = new JMenu("Editar");
        barraMenu.add(menuArchivo);
        barraMenu.add(menuEditar);
        
        JMenuItem copiar = new JMenuItem();
        JMenuItem cortar = new JMenuItem();
        JMenuItem pegar = new JMenuItem();
        JMenuItem buscar = new JMenuItem();
        menuEditar.add(copiar);
        menuEditar.add(cortar);
        menuEditar.add(pegar);
        menuEditar.add(new JSeparator()); // Una rayita separadora.
        menuEditar.add(buscar);

        this.getContentPane().add(barraMenu, BorderLayout.NORTH);
        //this.getContentPane().add(areaTexto, BorderLayout.CENTER);
        Panel_IDE p = new Panel_IDE();
        this.getContentPane().add(p, BorderLayout.CENTER);

        
        /**/
        setVisible(true);
    }
    
    public static void main(String[] args) throws HeadlessException, FileNotFoundException {
        //Lexicox hola = new Lexicox();
        //hola.ejecutar();
        Interpretacion interpretar = new Interpretacion();
        interpretar.iniciar_interpretacion();
    }
    
    public int []arr1 ()
    {
        int arr []= new int[WIDTH];
        return arr;
    }
}

