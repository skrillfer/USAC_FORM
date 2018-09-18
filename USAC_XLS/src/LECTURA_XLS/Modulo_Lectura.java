/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LECTURA_XLS;

import java.io.File;
import java.io.FileInputStream;

import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Modulo_Lectura {

    String TAB = "    ";

    public static void main(String[] args) {
        new Modulo_Lectura().LEER_HOJAENCUESTA();
    }

    public void lectura_documento() {
        String nombreArchivo = "Libro1.xlsx";
        String rutaArchivo = "/home/fernando/NetBeansProjects/USAC_FORM/Lenguaje_XLS/" + nombreArchivo;
        String hoja = "Encuesta";
        boolean ENTRE = false;

        //============================Variables a usar======================
        int contador = 0;
        Row row_encabezado = null;
        String TEXTO = "<encuesta>\n";
        //==================================================================

        try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
            // leer archivo excel
            XSSFWorkbook worbook = new XSSFWorkbook(file);
            //obtener la hoja que se va leer
            XSSFSheet sheet = worbook.getSheetAt(1);
            //obtener todas las filas de la hoja excel
            Iterator<Row> rowIterator = sheet.iterator();

            Row row;

            // se recorre cada fila hasta el final
            while (rowIterator.hasNext()) {

                row = rowIterator.next();

                if (contador == 0) {
                    row_encabezado = row;
                    contador++;
                } else {
                    TEXTO += TAB + "<pregunta>\n";
                    ENTRE = false;
                    contador++;
                }

                //se obtiene las celdas por fila
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell;

                //se recorre cada celda
                while (cellIterator.hasNext()) {
                    // se obtiene la celda en específico y se la imprime
                    cell = cellIterator.next();
                    //System.out.println("Celda numero:"+cell.getColumnIndex());

                    //----------------------Se lee la columna-------------------
                    if (contador > 1 && !cell.getStringCellValue().equals("")) {
                        ENTRE = true;
                        TEXTO += TAB + TAB + "<" + row_encabezado.getCell(cell.getColumnIndex()).getStringCellValue().toLowerCase() + ">\n";
                        TEXTO += TAB + TAB + get_textcell(cell) + "\n";
                        TEXTO += TAB + TAB + "</" + row_encabezado.getCell(cell.getColumnIndex()).getStringCellValue().toLowerCase() + ">\n";
                    }

                    //----------------------------------------------------------
                    //System.out.print(cell.getStringCellValue() + " | ");
                }
                if (row_encabezado != null && ENTRE) {
                    TEXTO += TAB + "</pregunta>\n";
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        TEXTO += "</encuesta>\n";
        System.out.println("" + TEXTO);

    }

    public void LEER_HOJAENCUESTA() {
        String nombreArchivo = "Libro1.xlsx";
        String rutaArchivo = "/home/fernando/NetBeansProjects/USAC_FORM/Lenguaje_XLS/" + nombreArchivo;
        String hoja = "Escuesta";
        boolean ENTRE = false;
        boolean AGRUP = false;
        boolean ESCIC = false;
        //============================Variables a usar======================
        int contador = 0;
        Row row_encabezado = null;
        String TEXTO = "e~ncu~esta\n";
        String TEXTO_TMP1="";
        String TEXTO_TMP2="";
        //==================================================================

        try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
            // leer archivo excel
            XSSFWorkbook worbook = new XSSFWorkbook(file);
            //obtener la hoja que se va leer
            XSSFSheet sheet = worbook.getSheetAt(0);
            //obtener todas las filas de la hoja excel
            Iterator<Row> rowIterator = sheet.iterator();

            Row row;

            // se recorre cada fila hasta el final
            while (rowIterator.hasNext()) {

                row = rowIterator.next();

                if (contador == 0) {
                    row_encabezado = row;
                    contador++;
                } else {
                    TEXTO_TMP1=TEXTO;
                    
                    TEXTO += TAB + "p~r~egunta\n";
                    ENTRE = false;
                    AGRUP = false;
                    ESCIC = false;
                    contador++;
                }

                /*System.out.println(":)");
                if(row.getRowNum()!=0){
                    TEXTO=TEXTO_TMP1;
                    System.out.println("FRENO");
                    break;
                }*/
                //se obtiene las celdas por fila
                Iterator<Cell> cellIterator =row.cellIterator();
               
                Cell cell;
 
                Cell tmp_cell=null;
                try {
                    tmp_cell=cellIterator.next();
                } catch (Exception e) {
                    TEXTO=TEXTO_TMP1;
                    //System.out.println("FRENO");
                    break;
                }
                
                if(tmp_cell==null || tmp_cell.getStringCellValue().trim().equals("")){
                    TEXTO=TEXTO_TMP1;
                    //System.out.println("FRENO");
                    break;
                }else{
                    cellIterator = row.cellIterator();
                }
                
                
                
                //se recorre cada celda
                while (cellIterator.hasNext()) {
                    // se obtiene la celda en específico y se la imprime
                    cell = cellIterator.next();
                    //System.out.println("Celda numero:"+cell.getColumnIndex());
                    
                    
                    //----------------------Se lee la columna-------------------
                    if (contador > 1 && !cell.getStringCellValue().trim().equals("")) {
                        ENTRE = true;
                        if(cell.getStringCellValue().trim().toLowerCase().equals("iniciar agrupación") || cell.getStringCellValue().trim().toLowerCase().equals("iniciar agrupacion")){
                            TEXTO = TEXTO_TMP1;
                            TEXTO += TAB + "agrupacion~\n";
                            //TEXTO += TAB + "<agrupacion>\n";
                            AGRUP = true;
                            
                        }else if(cell.getStringCellValue().trim().toLowerCase().equals("iniciar ciclo") ){
                            TEXTO = TEXTO_TMP1;
                            TEXTO += TAB + "ciclo~\n";
                            //TEXTO += TAB + "<ciclo>\n";
                            ESCIC = true;
                            
                        }else if(cell.getStringCellValue().trim().toLowerCase().equals("finalizar agrupación") || cell.getStringCellValue().trim().toLowerCase().equals("finalizar agrupacion")){
                            TEXTO = TEXTO_TMP1;
                            TEXTO += TAB + "~~agrupacion\n";
                            //TEXTO += TAB + "</agrupacion>\n";
                            AGRUP = true;
                        }else if(cell.getStringCellValue().trim().toLowerCase().equals("finalizar ciclo") ){
                            TEXTO = TEXTO_TMP1;
                            TEXTO += TAB + "~~ciclo\n";
                            //TEXTO += TAB + "</ciclo>\n";
                            ESCIC = true;
                        }else{
                            
                            TEXTO += TAB + TAB + row_encabezado.getCell(cell.getColumnIndex()).getStringCellValue().toLowerCase() + "~\n";
                            TEXTO += TAB + TAB + get_textcell(cell) + "\n";
                            TEXTO += TAB + TAB + "~~" + row_encabezado.getCell(cell.getColumnIndex()).getStringCellValue().toLowerCase() + "\n";
                            //TEXTO += TAB + TAB + "<" + row_encabezado.getCell(cell.getColumnIndex()).getStringCellValue().toLowerCase() + ">\n";
                            //TEXTO += TAB + TAB + get_textcell(cell) + "\n";
                            //TEXTO += TAB + TAB + "</" + row_encabezado.getCell(cell.getColumnIndex()).getStringCellValue().toLowerCase() + ">\n";
                        }
                        
                        
                    }
                    
                    
                    //----------------------------------------------------------
                    //System.out.print(cell.getStringCellValue() + " | ");
                }
                if (row_encabezado != null && ENTRE && !AGRUP && !ESCIC) {
                    TEXTO += TAB + "pr~egu~nt~a\n";
                }
            }
        } catch (Exception e) {
            //System.out.println(e.getMessage()+"-"+e.getClass());
        }
        TEXTO += "en~cues~ta\n";
        System.out.println("" + TEXTO);
    }

    public void LEER_HOJAOPCIONES() {
        String nombreArchivo = "archivo.xls";
        String rutaArchivo = "/home/fernando/NetBeansProjects/USAC_FORM/Lenguaje_XLS/" + nombreArchivo;
        String hoja = "Opciones";
        boolean ENTRE = false;

        //============================Variables a usar======================
        int contador = 0;
        Row row_encabezado = null;
        String TEXTO = "<opciones>\n";
        //==================================================================

        try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
            // leer archivo excel
            HSSFWorkbook worbook = new HSSFWorkbook(file);
            //obtener la hoja que se va leer
            HSSFSheet sheet = worbook.getSheetAt(1);
            //obtener todas las filas de la hoja excel
            Iterator<Row> rowIterator = sheet.iterator();

            Row row;

            // se recorre cada fila hasta el final
            while (rowIterator.hasNext()) {

                row = rowIterator.next();

                if (contador == 0) {
                    row_encabezado = row;
                    contador++;
                } else {
                    TEXTO += TAB + "<opcion>\n";
                    ENTRE = false;
                    contador++;
                }

                //se obtiene las celdas por fila
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell;

                //se recorre cada celda
                while (cellIterator.hasNext()) {
                    // se obtiene la celda en específico y se la imprime
                    cell = cellIterator.next();
                    //System.out.println("Celda numero:"+cell.getColumnIndex());

                    
                    //----------------------Se lee la columna-------------------
                    if (contador > 1 && !cell.getStringCellValue().equals("")) {
                        ENTRE = true;
                        
                        TEXTO += TAB + TAB + "<" + row_encabezado.getCell(cell.getColumnIndex()).getStringCellValue().toLowerCase() + ">\n";
                        TEXTO += TAB + TAB + get_textcell(cell) + "\n";
                        TEXTO += TAB + TAB + "</" + row_encabezado.getCell(cell.getColumnIndex()).getStringCellValue().toLowerCase() + ">\n";
                    }

                    
                    //----------------------------------------------------------
                    //System.out.print(cell.getStringCellValue() + " | ");
                }
                if (row_encabezado != null && ENTRE) {
                    TEXTO += TAB + "</opcion>\n";
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        TEXTO += "</opciones>\n";
        System.out.println("" + TEXTO);

    }

    public String get_textcell(Cell cell) {
        String data = "";
        try {
            String dax=cell.toString();
            return dax.replaceAll("”", "\"").replaceAll("“", "\"");
            
        } catch (Exception e) {
            return Double.toString(cell.getNumericCellValue());
        }
    }

}
