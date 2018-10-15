/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERFAZ.IDE;

import java.awt.Color;
import java.awt.Cursor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author fernando
 */
public class PintarPalabras {

    public  void paint_currentword(Document doc, int caret_position, JTextPane textpane) throws BadLocationException {
        Runnable doAssist = new Runnable() {
            @Override
            public void run() {
                MutableAttributeSet attrs = textpane.getInputAttributes();

                StyledDocument styledoc = textpane.getStyledDocument();

                int doc_end_position = doc.getEndPosition().getOffset();
                int text_length = doc.getLength();

                System.out.println("doc_end:" + doc_end_position);
                System.out.println("text_length:" + text_length);

                if (doc_end_position > caret_position+1 && caret_position!=0) {

                    try {
                        
                        int counter = caret_position + 1;
                        
                        while (counter >= 2 && !( es_Separador(doc.getText(counter - 2, 1)) ) ) {
                            counter--;
                        }
                        
                        if (counter > 1) {
                            System.out.println("----------------------------------------------------------------------");
                            if(caret_position+1 != doc_end_position){
                                int counter_front=counter-1;
                                while(counter_front<doc_end_position-1 && !(es_Separador(doc.getText(counter_front, 1))))
                                {
                                    System.out.println(">>"+doc.getText(counter_front, 1));
                                    counter_front++;
                                }
                                counter_front++;
                                doc_end_position = counter_front;

                            }
                            
                            String word = doc.getText(counter - 1, doc_end_position - counter);
                            System.out.println("word:" + word);
                            System.out.println("----------------------------------------------------------------------");
                            switch (word) {
                                case "cad1":
                                    StyleConstants.setForeground(attrs, Color.red);
                                    styledoc.setCharacterAttributes(counter-1, doc_end_position-counter, attrs, false);
                                    StyleConstants.setForeground(attrs, Color.black);
                                    break;
                                default:
                                    StyleConstants.setForeground(attrs, Color.black);
                                    styledoc.setCharacterAttributes(counter-1 - 1, doc_end_position-counter, attrs, false);
                                    StyleConstants.setForeground(attrs, Color.black);
                                    break;
                            }
                        }
                    } catch (BadLocationException ex) {
                        Logger.getLogger(PintarPalabras.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }else if(caret_position==0)
                {
                    try {
                        int counter = caret_position + 1;
                        
                        while (!(es_Separador(doc.getText(counter, 1))) ) {
                            counter++;
                        }
                        String word = doc.getText(0, counter);
                        System.out.println("|"+word+"|");
                        switch (word) {
                            case "cad1":
                                StyleConstants.setForeground(attrs, Color.red);
                                    styledoc.setCharacterAttributes(0, counter, attrs, false);
                                //setCharacterAttributes(i+5, doc.getLength()+1, attrs, false);
                                break;
                            default:
                                break;
                        }
                    } catch (BadLocationException ex) {
                        Logger.getLogger(PintarPalabras.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else
                {
                    System.out.println("mergas");
                }
            }
        };
        SwingUtilities.invokeLater(doAssist);
    }
    
    
    public boolean es_Separador(String separador)
    {
        switch(separador)
        {
            case " ":
            case "\t":
            case "\n":
                return true;
                default:
                    return false;
        }
    }
    
    public boolean es_palabra_reservada(String reservada)
    {
        switch(reservada)
        {
            case "publico":
                return true;
            default: 
                return false;
        }
    }

}
