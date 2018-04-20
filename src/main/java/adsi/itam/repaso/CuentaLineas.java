package adsi.itam.repaso;

import java.io.File;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class CuentaLineas{
    private final Logger LOG=Logger.getLogger(CuentaLineas.class);
    private int codigo,comentarios,lineas;
    private boolean esMultilinea;

    public CuentaLineas(){
        codigo=0;
        comentarios=0;
        lineas=0;
        esMultilinea=false;        
    }

    public int getCodigo(){
        return codigo;
    }

    public int getLineas(){
        return lineas;
    }

    public int getComentarios(){
        return comentarios;
    }

    private void resetear(){
        codigo=0;
        comentarios=0;
        lineas=0;

        esMultilinea=false;
    }

    public String toString(){
        return "Lineas totales: "+lineas+"\nLineas de codigo:"+codigo+"\nLineas de comentario: "+comentarios;
    }

    public void cuenta(String fileName){
        try{
            File file=new File(fileName);
            Scanner sc=new Scanner(file);

            String linea;
            
            resetear();

            while(sc.hasNext()){
                linea=sc.nextLine();

                if(esMultilinea){
                    lineas++;
                    comentarios++;

                    if(linea.contains("*/"))
                        esMultilinea=false;
                
                }else if (linea.contains("/*")){
                    esMultilinea=true;
                    comentarios++;
                    lineas++;
                    
                    if(linea.indexOf("/*")>0)
                        codigo++;

                }else if (!linea.equals("")){
                    
                    lineas++;

                    linea=linea.replaceAll("\".*?\"","");

                    if(linea.contains("//")){
                        comentarios++;

                        if(linea.indexOf("//")>0)
                            codigo++;
                    
                    }else
                        codigo++;

                }
            }

            sc.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
            LOG.error("No se pudo leer el archivo");
        }
    }


    private boolean checaComentario(String linea){
	    linea = linea.replaceAll("\".*?\"","");
        
        if(linea.contains("//")){
	        comentarios++;
            if(linea.indexOf("//") > 0)
		        codigo++;
	        return true;
        }
 
	    return false;
    }

}
