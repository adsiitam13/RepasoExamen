package adsi.itam.repaso;
import org.apache.log4j.Logger;
public class Ejecutable{
    private final static Logger LOG=Logger.getLogger(Ejecutable.class);

    public static void main(String[] args){
        LOG.info("Inicia ejecución");

        String file1="Archivo01.java";
        String file2="Archivo02.java";
        String file3="Archivo03.java";
        String file4="Archivo04.java";
        String file5="Archivo05.java";

        CuentaLineas c=new CuentaLineas();

        c.cuenta(file1);
            
        LOG.info("**********************");
        LOG.info("Resultado Archivo01");
        LOG.info(c.toString());

        c.cuenta(file2);

        LOG.info("**********************");
        LOG.info("Resultado Archivo02");
        LOG.info(c.toString());

        c.cuenta(file3);
  
        LOG.info("**********************");
        LOG.info("Resultado Archivo03");
        LOG.info(c.toString());

        c.cuenta(file4);
  
        LOG.info("**********************");
        LOG.info("Resultado Archivo04");
        LOG.info(c.toString());

        c.cuenta(file5);

        LOG.info("**********************");
        LOG.info("Resultado Archivo05");
        LOG.info(c.toString());

    }
}
