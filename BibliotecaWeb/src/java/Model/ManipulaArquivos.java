package Model;

import java.io.*;

/**
 * @author igormodesto
 */
public class ManipulaArquivos {

    /*A ideia dessa classe é tentar criar todos os métodos o mais genérico possível 
para que todos possam reaproveitar os códigos descritos */
    
    public String LerArquivos(String caminhoArquivo, String nomeArquivo) throws FileNotFoundException, IOException {
        //Declarando variaveis
        String conteudoArquivo = caminhoArquivo + nomeArquivo;
        String arquivo = null;

        //Instâncias
        BufferedReader br = new BufferedReader(new FileReader(conteudoArquivo));

        while (br.ready()) {
            arquivo += br.readLine() + "|";
        }
        return arquivo;
    }
}
