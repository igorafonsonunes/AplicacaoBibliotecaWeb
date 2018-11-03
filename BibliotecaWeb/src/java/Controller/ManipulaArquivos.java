package Controller;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author igormodesto
 */
public class ManipulaArquivos {

    /*A ideia dessa classe é tentar criar todos os métodos o mais genérico possível 
para que todos possam reaproveitar os códigos descritos */
    public String LerArquivos(String nomeArquivo) throws FileNotFoundException {
        String arquivo = null;
        try {

            BufferedReader br = new BufferedReader(new FileReader("/home/igormodesto/Área de Trabalho/ArquivosTXT/Livros"));

            while (br.ready()) {
                arquivo += br.readLine() + ",";
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(ManipulaArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arquivo;
    }
}
