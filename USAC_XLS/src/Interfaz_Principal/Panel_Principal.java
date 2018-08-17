/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_Principal;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 *
 * @author fernando
 */
public class Panel_Principal extends JPanel{
    JTextArea area_CODIGO_XFORM= new JTextArea();
    
    Boton_Redondo btn_GENERAR = new Boton_Redondo("Generar XForm");
    //-------------------------------------------------------------------------
    Boton_Disenado btn_ABRIR = new Boton_Disenado("Abrir");
    Boton_Disenado btn_GUARDAR = new Boton_Disenado("Guardar");
    Boton_Disenado btn_ERRORES = new Boton_Disenado("Errores");

    public Panel_Principal() {
        setLayout(null);
        int Y=30;
        
        btn_ABRIR.setBounds(100, Y, 150, 50);
        btn_ABRIR.setColor1(Color.YELLOW);
        btn_GUARDAR.setBounds(270, Y, 150, 50);
        btn_GUARDAR.setColor1(Color.GREEN);
        
        btn_ERRORES.setBounds(440, Y, 150, 50);
        btn_ERRORES.setColor1(Color.RED);
        
        btn_GENERAR.setBounds(100, Y+100, 180, 70);
        
        
        TitledBorder border = new TitledBorder("Codigo XFORM");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.BLUE);
        
        area_CODIGO_XFORM.setFont(new Font("Monospace", Font.PLAIN, 10));
        
        JScrollPane fff =new JScrollPane(area_CODIGO_XFORM);
        fff.setBorder(border);
        fff.setBounds(10, Y+200, 680, 300);
        
        
        add(btn_ABRIR);
        add(btn_GUARDAR);
        add(btn_ERRORES);
        add(btn_GENERAR);
        add(fff);
    }
    
    
    
    
}
