/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Analizador_Parametros.ParserParam;
import java.io.StringReader;
import java.util.ArrayList;

/**
 *
 * @author fernando
 */
public class Formulario {
    public ArrayList<Opcion> LT_Opciones=new ArrayList<>();
    private String titulo="";
    private String idFormulario="";
    private String estilo="";
    private String importaciones="";
    private String codigoMain="";
    private String codigoGlobal="";
    private String nombre_archivoxls="";
    
    public Formulario(String name) {
        nombre_archivoxls=name;
    }
    
    public  void setear_valores(ArrayList<Struct_Form> LT_Structs)
    {
        for (Struct_Form struct : LT_Structs) {
            if(!struct.titulo.equals("")){
                this.titulo = struct.titulo;
            }
            if(!struct.idFormulario.equals("")){
                this.idFormulario = struct.idFormulario;
            }
            if(!struct.estilo.equals("")){
                this.estilo = struct.estilo;
            }
            
            if(!struct.importaciones.equals("")){
                this.importaciones += struct.importaciones+"\n";
            }
            
            if(!struct.codigoMain.equals("")){
                this.codigoMain += struct.codigoMain+"\n";
            }
            
            if(!struct.codigoGlobal.equals("")){
                this.codigoGlobal += struct.codigoGlobal+"\n";
            }
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(titulo);
        System.out.println(idFormulario);
        System.out.println(estilo);
        System.out.println(importaciones);
        System.out.println(codigoMain);
        System.out.println(codigoGlobal);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    public String generar_codigoXForm(String codigo_preguntas, ArrayList<Pregunta> Lista_Preguntas)
    {
        String idFinal = "";
        String str="";
        str+= importaciones+"\n";
        
        if(idFormulario.trim().equals(""))
        {
            idFinal = nombre_archivoxls;
        }else
        {
            idFinal=idFormulario;
        }
        
        if(titulo.trim().equals(""))
        {
            titulo=idFinal;
        }
        
        str+="clase " + idFinal+"{\n";
            str+= getTabs(1)+codigoGlobal+"\n";
            str+= generar_codigoMain(idFinal)+"\n";
            str+= codigo_preguntas;
            str+=getTabs(1)+"Formulario "+idFinal+"(){\n";
            str+=getTabs(2)+"Respuestas res;\n";
            str+= generar_codIn_FormGR_CIC(Lista_Preguntas);
            str+="\n\t}";
        str+="\n}";    
        return str;
    }
    
    public String Parsear_Parametro(String val, int op)
    {
        String parametro="";
        if(op==1)//Es de Texto
        {
            try {
                ParserParam parser = new ParserParam(new StringReader(val));
                parser.initParser();
                parametro+=parser.getMin();
                parametro+=","+parser.getMax();
                parametro+=","+parser.getFil();
            } catch (Exception e) {}
        }else if(op==2)//Es de Rango
        {
            try {
                ParserParam parser = new ParserParam(new StringReader(val));
                parser.initParser();
                
                String ini="Nada";
                if(!parser.getIni().trim().equals(""))
                {
                    ini =  parser.getIni();
                }
                
                String fin = parser.getFin();
                if(!fin.trim().equals(""))
                {
                    if(ini.equals("")){ ini="0";}
                }else
                {
                    fin="Nada";
                }
                
                parametro+=ini;
                parametro+=","+fin;
                
            } catch (Exception e) {}
        }
        
        return parametro;
    }
    
    
    
    public String generar_codIn_FormGR_CIC(ArrayList<Pregunta> Lista_Preguntas)
    {
        String str="";
        for (Pregunta pregunta : Lista_Preguntas) {
                    switch(pregunta.TIPO.toLowerCase())
                    {
                        case "cadena":
                        case "texto":
                            
                            //Codigo Pre------
                            str+=gen_CodigoPre(pregunta);
                            
                                Atributo atr11 = pregunta.getAtributo_X_Nombre("parametro");
                                String parametro11="";
                                if(atr11!=null)
                                {
                                    parametro11=Parsear_Parametro(atr11.valor.trim(),1);
                                }
                                str+=Cod_PregCon_AparienciayParametro(pregunta,"cadena","cadena",parametro11);
                            //Codigo Post-----
                            str+=gen_CodigoPost(pregunta);
                            //----------------
                            break;
                        
                        case "entero":
                        case "decimal":
                        case "fecha":
                        case "hora":
                        case "fechahora":
                            //Codigo Pre------
                            str+=gen_CodigoPre(pregunta);
                            //----------------
                            if(pregunta.TIPO.toLowerCase().equals("texto")){
                                pregunta.TIPO="cadena";
                            }
                            
                            if(!pregunta.Apariencia.equals("")){
                                str+=Cod_PregCon_Apariencia(pregunta,pregunta.Apariencia);
                            }else
                            {
                                str+=Cod_PregCon_Apariencia(pregunta,pregunta.TIPO);
                            }
                            //Codigo Post-----
                            str+=gen_CodigoPost(pregunta);
                            //----------------
                            break;
                        case "nota":
                            if(pregunta.multimedia!=null)
                            {
                                str+=Cod_Preg_Nota_Mostrar(pregunta,pregunta.multimedia.tipoMedia);
                            }else
                            {
                                str+=Cod_Preg_Nota(pregunta);
                            }
                            break;
                        case "calcular":
                            str+=Cod_Preg_X1(pregunta,pregunta.TIPO.toLowerCase());
                            break;
                        case "fichero":
                            //Codigo Pre------
                            str+=gen_CodigoPre(pregunta);
                            //----------------
                            
                            str+=Cod_Preg_Fichero(pregunta,"Fichero",pregunta.filtros_fichero);
                            
                            //Codigo Post-----
                            str+=gen_CodigoPost(pregunta);
                            //----------------
                            break;    
                        case "condicion":
                            //Codigo Pre------
                            str+=gen_CodigoPre(pregunta);
                            //----------------
                                Atributo atr = pregunta.getAtributo_X_Nombre("parametro");
                                String parametro="";
                                if(atr!=null)
                                {
                                    String val_atr = atr.valor.trim();
                                    String []lt = val_atr.split("=");
                                    if(lt.length==2)
                                    {
                                        switch(lt[1].toLowerCase())
                                        {
                                            case "v_f":
                                                parametro="\"verdadero\",\"falso\"";
                                                break;
                                            case "si_no":
                                                parametro="\"Si\",\"No\"";
                                                break;
                                        }
                                    }
                                }
                                str+=Cod_PregCon_AparienciayParametro(pregunta,"booleano",pregunta.TIPO.toLowerCase(),parametro);
                            //Codigo Post-----
                            str+=gen_CodigoPost(pregunta);
                            //----------------
                            break;    
                        case "rango":
                            //Codigo Pre------
                            str+=gen_CodigoPre(pregunta);
                            //----------------
                                Atributo atr1 = pregunta.getAtributo_X_Nombre("parametro");
                                String parametro1="";
                                if(atr1!=null)
                                {
                                    parametro1=Parsear_Parametro(atr1.valor.trim(),2);
                                }
                                
                                str+=Cod_PregCon_AparienciayParametro(pregunta,"entero",pregunta.TIPO.toLowerCase(),parametro1);
                            //Codigo Post-----
                            str+=gen_CodigoPost(pregunta);
                            //----------------
                            break;
                        case "selecciona_uno":
                            //Codigo Pre------
                            str+=gen_CodigoPre(pregunta);
                            //----------------                                
                                str+=pregunta.generar_Codigo_Selecciona_Uno(LT_Opciones);
                                str+=Cod_PregCon_AparienciayParametro(pregunta,"cadena","seleccionar_1",pregunta.Id_L1$T4);
                            //Codigo Post-----
                            str+=gen_CodigoPost(pregunta);
                            //----------------
                            break;
                        case "selecciona_multiples":
                            //Codigo Pre------
                            str+=gen_CodigoPre(pregunta);
                            //----------------
                                str+=pregunta.generar_Codigo_Selecciona_Uno(LT_Opciones);
                                str+=Cod_PregCon_AparienciayParametro(pregunta,"entero","seleccionar",pregunta.Id_L1$T4);
                            //Codigo Post-----
                            str+=gen_CodigoPost(pregunta);
                            //----------------
                            break;
                            
                            
                    }
                    
                    if(pregunta.es_grupo)
                    {
                        Atributo atr = pregunta.getAtributo_X_Nombre("idpregunta");
                        //--puede que aqui tenga que llamar recursivamente tambien
                        if(!pregunta.Aplicable.equals(""))
                        {
                            str+=getTabs(2)+"Si("+pregunta.Aplicable+"){\n";
                                str+=getTabs(3)+atr.valor+"();\n";
                            str+=getTabs(2)+"}\n";
                        }else
                        {
                            str+=getTabs(2)+atr.valor+"();\n";
                        }
                        
                    }
                    
                    if(pregunta.es_ciclo)
                    {
                        Atributo atr = pregunta.getAtributo_X_Nombre("idpregunta");
                        Atributo repet = pregunta.getAtributo_X_Nombre("repetir");

                        
                        String dec_para = "entero "+atr.valor+"=0";
                        String cond_para;
                        
                        if(repet!=null)
                        {
                            String repet_parseado = repet.Parsear_OtrosValor(repet.valor);
                            cond_para = atr.valor+"<"+repet_parseado;
                        }else
                        {
                            cond_para = "0==0";//ciclo infinito
                        }
                        
                        str+=getTabs(2)+"Para("+dec_para+"; "+cond_para+"; "+atr.valor+"++){\n";
                            if(!pregunta.Aplicable.equals(""))
                            {
                                str+=getTabs(3)+"Si("+pregunta.Aplicable+"){\n";
                                try {
                                    str+=getTabs(4)+generar_codIn_FormGR_CIC(pregunta.lista_preguntas);
                                } catch (Exception e) {
                                    System.err.println(e.getMessage());
                                }
                                    
                                str+=getTabs(3)+"}\n";
                            }else
                            {
                                try {
                                    str+=getTabs(3)+generar_codIn_FormGR_CIC(pregunta.lista_preguntas);
                                } catch (Exception e) {
                                    System.err.println(e.getMessage());
                                }
                                
                            }
                        str+=getTabs(2)+"}\n";
                    }
                    
            }
        return str;
    }
    
    
    public String parametro_Rango(Atributo atr)
    {   String parametro="";
        if(atr!=null)
        {
            String val_atr = atr.valor.trim();
            String []lt = val_atr.split(",");
            
            if(lt.length==2)
            {   
                String iniciar = lt[0];
                String finalizar = lt[1];
                String []Ltiniciar = iniciar.split("=");
                String []Ltfinalizar = finalizar.split("=");
                if(Ltiniciar.length==2)
                {
                    parametro += Ltiniciar[1];
                    if(Ltfinalizar.length==2)
                    {
                        parametro += ","+Ltfinalizar[1];
                    }
                }
                
            }else if(lt.length==1)
            {
                String finalizar = lt[0];
                String []Ltfinalizar = finalizar.split("=");
                if(Ltfinalizar.length==2)
                {
                    
                    parametro += "0,"+Ltfinalizar[1];
                }
            }
        }
        return parametro;
    }
    
    
    
    public String gen_CodigoPre(Pregunta pregunta)
    {
        String str="";
        Atributo atr = pregunta.getAtributo_X_Nombre("idpregunta");

        Atributo codPre =pregunta.getAtributo_X_Nombre("codigo_pre");
        if(codPre!=null)
        {
            String str1= getTabs(2)+codPre.valor+"\n";
            str+=str1;
        }
        return str;
    }
    
    
    public String gen_CodigoPost(Pregunta pregunta)
    {
        String str="";
        Atributo atr = pregunta.getAtributo_X_Nombre("idpregunta");

        Atributo codPost =pregunta.getAtributo_X_Nombre("codigo_post");
        if(codPost!=null)
        {
            String str1= codPost.valor;
            str1 = str1.replaceAll("@", atr.valor+"()"+"respuesta");
            str+=getTabs(2)+str1+"\n";
        }
        return str;
    }
    /*public String Cod_PregSin_Apariencia(Pregunta pregunta)
    {   String str="";
        Atributo atr = pregunta.getAtributo_X_Nombre("idpregunta");
        if(!pregunta.Aplicable.equals("")){
            str+=getTabs(2)+"Si("+pregunta.Aplicable+"){\n";
                str+=getTabs(3)+atr.valor+"().respuesta(res.es"+pregunta.TIPO.toLowerCase()+")."+pregunta.TIPO+"();\n";
            str+=getTabs(2)+"}\n";
        }
        str+=getTabs(2)+atr.valor+"().respuesta(res.es"+pregunta.TIPO.toLowerCase()+")."+pregunta.TIPO+"();\n";
        return str;
    }*/
    
    
    public String Cod_Preg_Fichero(Pregunta pregunta,String Apariencia,String parametro)
    {   String str="";
        Atributo atr = pregunta.getAtributo_X_Nombre("idpregunta");
        if(!pregunta.Aplicable.equals("")){
            str+=getTabs(2)+"Si("+pregunta.Aplicable+"){\n";
                str+=getTabs(3)+atr.valor+"()."+Apariencia+"("+parametro+");\n";
            str+=getTabs(2)+"}\n";
        }else
        {
            str+=getTabs(2)+atr.valor+"()."+Apariencia+"("+parametro+");\n";
        }
        
        return str;
    }
    
    public String Cod_PregCon_AparienciayParametro(Pregunta pregunta,String tipo,String Apariencia,String parametro)
    {   String str="";
        Atributo atr = pregunta.getAtributo_X_Nombre("idpregunta");
        if(!pregunta.Aplicable.equals("")){
            str+=getTabs(2)+"Si("+pregunta.Aplicable+"){\n";
                str+=getTabs(3)+atr.valor+"().respuesta(res.es"+tipo.toLowerCase()+")."+Apariencia+"("+parametro+");\n";
            str+=getTabs(2)+"}\n";
        }else
        {
            str+=getTabs(2)+atr.valor+"().respuesta(res.es"+tipo.toLowerCase()+")."+Apariencia+"("+parametro+");\n";
        }
        
        return str;
    }
    
    public String Cod_PregCon_Apariencia(Pregunta pregunta,String Apariencia)
    {   String str="";
        Atributo atr = pregunta.getAtributo_X_Nombre("idpregunta");
        if(!pregunta.Aplicable.equals("")){
            str+=getTabs(2)+"Si("+pregunta.Aplicable+"){\n";
                str+=getTabs(3)+atr.valor+"().respuesta(res.es"+pregunta.TIPO.toLowerCase()+")."+Apariencia+"();\n";
            str+=getTabs(2)+"}\n";
        }else
        {
            str+=getTabs(2)+atr.valor+"().respuesta(res.es"+pregunta.TIPO.toLowerCase()+")."+Apariencia+"();\n";
        }
        
        return str;
    }
    
    
    public String get_Tipo_Match(String n_m)
    {
        switch(n_m.toLowerCase())
        {
            case "texto":
                return "cadena";
            case "entero":
            case "decimal":
            case "fecha":
            case "hora":
            case "fechahora":    
                return n_m.toLowerCase();
            case "condicion":    
                return "booleano";
            case "calcular":    
                return "decimal";
        }
        return "";
    }
    
    public String Cod_Preg_X1(Pregunta pregunta,String tipo)
    {   String str="";
        Atributo atr = pregunta.getAtributo_X_Nombre("idpregunta");
        if(!pregunta.Aplicable.equals("")){
            str+=getTabs(2)+"Si("+pregunta.Aplicable+"){\n";
                str+=getTabs(3)+atr.valor+"()."+tipo+"();\n";
            str+=getTabs(2)+"}\n";
        }else
        {
            str+=getTabs(2)+atr.valor+"()."+tipo+"();\n";
        }
        
        return str;
    }
    
    public String Cod_Preg_Nota_Mostrar(Pregunta pregunta,String tipo_multimedia)
    {   String str="";
        Atributo atr = pregunta.getAtributo_X_Nombre("idpregunta");
        if(!pregunta.Aplicable.equals("")){
            str+=getTabs(2)+"Si("+pregunta.Aplicable+"){\n";
                str+=getTabs(3)+atr.valor+"().mostrar()."+tipo_multimedia+"();\n";
            str+=getTabs(2)+"}\n";
        }else
        {
            str+=getTabs(2)+atr.valor+"().mostrar()."+tipo_multimedia+"();\n";
        }
        
        return str;
    }
    
    
    public String Cod_Preg_Nota(Pregunta pregunta)
    {   String str="";
        Atributo atr = pregunta.getAtributo_X_Nombre("idpregunta");
        if(!pregunta.Aplicable.equals("")){
            str+=getTabs(2)+"Si("+pregunta.Aplicable+"){\n";
                str+=getTabs(3)+atr.valor+"().nota();\n";
            str+=getTabs(2)+"}\n";
        }else
        {
            str+=getTabs(2)+atr.valor+"().nota();\n";
        }
        
        return str;
    }
    
    
    public  String getTabs(int num){
        String str="";
        for (int i = 0; i < num; i++) {
            str+="\t";
        }
        return str;
    }
    
    public String generar_codigoMain(String id_final)
    {
        String str="\tPrincipal (){\n";
        str+="\t\t"+codigoMain+"\n";
        str+="\t\t"+"nuevo "+id_final+"()"+getEstilo()+";\n";
        str+="\n\t}";
        return str;
    }
    
    public String getEstilo()
    {
        if(!this.estilo.equals(""))
        {
            switch(this.estilo.toLowerCase())
            {
                case "pagina":
                case "todo":
                case "cuadricula":
                    return "."+this.estilo.toLowerCase();
                    
            }
        }
        return "";
    }
    
    /*
    El identificador del formulario se extrae del nombre del archivo XLS 
    si la columna “idForm” está en blanco o falta
    */
    
}
