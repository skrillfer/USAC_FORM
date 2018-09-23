/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz_Principal;

import ANALIZADOR_CONFIGURACION.ParserConfig;
import ANALIZADOR_OPCIONES.gram_opciones;
import Analizador_Encuestas.ParserEncuesta;
import Estructuras.Formulario;
import Estructuras.Opcion;
import Estructuras.Struct_Form;
import GeneracionXFORM.Generador_XForm;
import LECTURA_XLS.Modulo_Lectura;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author fernando
 */
public class Panel_Principal extends JPanel implements ActionListener {
    String nombre_archivo_actual="";
    String ruta_archivo_actual = "";

    JTextArea area_CODIGO_XFORM = new JTextArea();

    Boton_Redondo btn_GENERAR = new Boton_Redondo("Generar XForm");
    //-------------------------------------------------------------------------
    Boton_Disenado btn_ABRIR = new Boton_Disenado("Abrir");
    Boton_Disenado btn_GUARDAR = new Boton_Disenado("Guardar");
    Boton_Disenado btn_ERRORES = new Boton_Disenado("Errores");

    public Panel_Principal() {
        setLayout(null);
        int Y = 30;

        btn_ABRIR.setBounds(100, Y, 150, 50);
        btn_ABRIR.setColor1(Color.YELLOW);
        btn_GUARDAR.setBounds(270, Y, 150, 50);
        btn_GUARDAR.setColor1(Color.GREEN);

        btn_ERRORES.setBounds(440, Y, 150, 50);
        btn_ERRORES.setColor1(Color.RED);

        btn_GENERAR.setBounds(100, Y + 100, 180, 70);

        TitledBorder border = new TitledBorder("Codigo XFORM");
        border.setTitleJustification(TitledBorder.CENTER);
        border.setTitlePosition(TitledBorder.TOP);
        border.setTitleColor(Color.BLUE);

        area_CODIGO_XFORM.setFont(new Font("Monospace", Font.PLAIN, 10));

        JScrollPane fff = new JScrollPane(area_CODIGO_XFORM);
        fff.setBorder(border);
        fff.setBounds(10, Y + 200, 680, 300);

        btn_ABRIR.addActionListener(this);
        add(btn_ABRIR);
        
        btn_GUARDAR.addActionListener(this);
        add(btn_GUARDAR);
        
        btn_ERRORES.addActionListener(this);
        add(btn_ERRORES);
        
        btn_GENERAR.addActionListener(this);
        add(btn_GENERAR);
        
        add(fff);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == btn_ABRIR) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                
                if(selectedFile.getName().contains(".xlsx"))
                {
                    ruta_archivo_actual=selectedFile.getAbsolutePath();
                    nombre_archivo_actual =selectedFile.getName().replace(".xlsx", "");
                    System.out.println(ruta_archivo_actual);
                    System.out.println(nombre_archivo_actual);
                }else
                {
                    JOptionPane.showMessageDialog(this, "Debes Abrir un Archivo .xlsx");
                }
             
            }

        } else if (source == btn_GUARDAR) {
            guardarArchivo();
        } else if (source == btn_GENERAR) {
            if(!nombre_archivo_actual.equals(""))
            {
                Generar_Mi_Formato();
            }
        } else if (source == btn_ERRORES) {

        }

    }

    public void Generar_Mi_Formato() {
        boolean encuesta_=false;
        boolean opciones_=false;
        boolean configuracion_=false;
        Modulo_Lectura modulo = new Modulo_Lectura();
        if(!ruta_archivo_actual.equals(""))
        {
            //1. Convertir a mi lenguaje para javacc
            String TEXTO=modulo.LEER_HOJAENCUESTA(ruta_archivo_actual, nombre_archivo_actual);
            if(!TEXTO.equals("")){encuesta_=true;}
            escribir(TEXTO, "escu3st4.txt");
            
            TEXTO=modulo.LEER_HOJAOPCIONES(ruta_archivo_actual, nombre_archivo_actual);
            if(!TEXTO.equals("")){opciones_=true;}
            escribir(TEXTO, "OpCiOn3S.txt");
            
            
            TEXTO=modulo.LEER_HOJACONFIGURACIONES(ruta_archivo_actual, nombre_archivo_actual);
            if(!TEXTO.equals("")){configuracion_=true;}
            escribir(TEXTO,"CoNfIgUrAcIoNeS.txt");
            
            if(encuesta_)
            {
                //2. Parsear cada uno de los archivos creados.
                //x.1 Compilar el archivo de Opciones para ser utilizado
                ArrayList<Opcion> LT_Opciones = null;
                try {
                    gram_opciones par_opciones = new gram_opciones(new FileReader("OpCiOn3S.txt"));
                    par_opciones.initParser();
                    LT_Opciones = par_opciones.getLTOpciones();
                } catch (Exception e) {
                    System.err.println("Parseando Opciones" + e.getMessage());
                }

                //x.2 Compilar el archivo de encuesta y obtener el generador
                Generador_XForm generador = null;

                try {
                    ParserEncuesta parser_encuesta = new ParserEncuesta(new FileReader("escu3st4.txt"));
                    parser_encuesta.initParser();
                    generador = parser_encuesta.get_Generador();
                } catch (Exception e) {
                    System.err.println("Parseando encuesta:" + e.getMessage());
                }

                ArrayList<Struct_Form> LT_Structs = null;

                try {
                    ParserConfig par_conf = new ParserConfig(new FileReader("CoNfIgUrAcIoNeS.txt"));
                    par_conf.initParser();
                    LT_Structs = par_conf.getLT();
                } catch (Exception e) {
                    System.err.println("Parseando Configuraciones" + e.getMessage());
                }

                if (generador != null) {
                    if (LT_Opciones != null) {
                        generador.LT_Opciones = LT_Opciones;

                    }
                    generador.nombre_archivoxls=nombre_archivo_actual;
                    Formulario formulario = new Formulario(nombre_archivo_actual);
                    if (LT_Opciones != null) {
                        formulario.LT_Opciones = LT_Opciones;
                    }
                    formulario.setear_valores(LT_Structs);
                    String STR = formulario.generar_codigoXForm(generador.generar_CODIGO_XFORM(generador.Lista_Preguntas), generador.Lista_Preguntas);
                    
                    area_CODIGO_XFORM.setText(STR);
                    //System.out.println(STR);
                }    
            }
        }else
        {
            JOptionPane.showMessageDialog(this, "Debes Abrir primero un archivo xls");
        }
        

        

    }

    private String abrirArchivo() {
        String aux = "";
        String texto = "";
        try {
            /**
             * llamamos el metodo que permite cargar la ventana
             */
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(this);
            /**
             * abrimos el archivo seleccionado
             */
            File abre = file.getSelectedFile();

            /**
             * recorremos el archivo, lo leemos para plasmarlo en el area de texto
             */
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);
                while ((aux = lee.readLine()) != null) {
                    texto += aux + "\n";
                }
                lee.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        return texto;//El texto se almacena en el JTextArea
    }

    private void guardarArchivo() {
        if (!area_CODIGO_XFORM.getText().trim().equals("")) {
            try {
                String nombre = "";
                JFileChooser file = new JFileChooser();
                file.showSaveDialog(this);
                File guarda = file.getSelectedFile();

                if (guarda != null) {
                    FileWriter save = new FileWriter(guarda + ".xform");
                    save.write(this.area_CODIGO_XFORM.getText());
                    save.close();
                    JOptionPane.showMessageDialog(null,
                            "El archivo se a guardado Exitosamente",
                            "Información", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,
                        "Su archivo no se ha guardado",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }

    }
    
    
    public void escribir(String texto,String direccion) {
        try {
            FileWriter writer = new FileWriter(direccion);
            PrintWriter print = new PrintWriter(writer);
            print.print(texto);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
