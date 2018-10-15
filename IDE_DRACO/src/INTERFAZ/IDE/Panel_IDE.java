/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERFAZ.IDE;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author fernando
 */
public class Panel_IDE extends JPanel {
    PintarPalabras paint = new PintarPalabras();
    public Panel_IDE() throws BadLocationException {
        /*JTextArea areaTexto = new JTextArea(25,80);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(areaTexto);
        add(scroll);*/
        super(null);
        JTextPane textPane = new JTextPane();

        textPane.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("\nremoveUpdate");
                //System.out.println(e.getDocument().getEndPosition());
                try {
                    
                    
                    paint.paint_currentword(e.getDocument(),textPane.getCaretPosition()-1,textPane);
                    
                } catch (BadLocationException ex) {
                    Logger.getLogger(Panel_IDE.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    
                    String last_char = e.getDocument().getText(textPane.getCaretPosition(), 1);
                    System.out.println("LAST:"+last_char);
                    if(!last_char.equals(" "))
                    {
                        paint.paint_currentword(e.getDocument(),textPane.getCaretPosition(),textPane);
                    }
                } catch (BadLocationException ex) {
                    Logger.getLogger(Panel_IDE.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                /*try {
                    String last_char = arg0.getDocument().getText(arg0.getDocument().getEndPosition().getOffset() - 2, 1);

                    if(!last_char.equals(" "))
                    {
                        paint.paint_currentword(arg0.getDocument(),textPane.getCaretPosition(),textPane);
                    }
                } catch (BadLocationException ex) {
                    Logger.getLogger(Panel_IDE.class.getName()).log(Level.SEVERE, null, ex);
                }*/

            }
        });
        //StyledDocument doc = textPane.getStyledDocument();

        //Style style = textPane.addStyle("I'm a Style", null);
        //StyleConstants.setForeground(style, Color.red);

        //doc.insertString(doc.getLength(), "BLAH ", style);

        //StyleConstants.setForeground(style, Color.blue);

        //doc.insertString(doc.getLength(), "BLEH", style);
        JScrollPane scroll = new JScrollPane(textPane);
        scroll.setBounds(10, 10, 980, 600);

        add(scroll);
    }

}
