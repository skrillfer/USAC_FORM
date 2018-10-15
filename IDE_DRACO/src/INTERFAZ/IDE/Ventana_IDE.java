/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERFAZ.IDE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

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
    
    public static void main(String[] args) throws HeadlessException {
        try {
            new Ventana_IDE().show();
        } catch (BadLocationException ex) {
            Logger.getLogger(Ventana_IDE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
