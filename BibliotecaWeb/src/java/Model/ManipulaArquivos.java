package Model;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author igormodesto
 */
public class ManipulaArquivos {

    /*A ideia dessa classe é tentar criar todos os métodos o mais genérico possível 
para que todos possam reaproveitar os códigos descritos */
    public String LerArquivos(String caminhoArquivo, String nomeArquivo) {
        //Declarando variaveis
        String conteudoArquivo = caminhoArquivo + nomeArquivo;
        String arquivo = null;
        try {
            //Instâncias
            BufferedReader br;

            br = new BufferedReader(new FileReader(conteudoArquivo));

            while (br.ready()) {
                arquivo += br.readLine() + "|";
            }

            return arquivo;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManipulaArquivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManipulaArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arquivo;
    }
}
