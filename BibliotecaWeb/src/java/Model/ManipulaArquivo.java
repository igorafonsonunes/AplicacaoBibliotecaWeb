package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo and Igor
 */
public class ManipulaArquivo {

//<editor-fold defaultstate="collapsed" desc="Métodos Manipulador ">
    //<editor-fold defaultstate="collapsed" desc="Atributos para retorno">
    private boolean verifica;
    private boolean verificadisponivel;
//</editor-fold>

    public void Manipulador(String nome, boolean verifica, boolean verificadisponivel) throws IOException {

        ArrayList<String> lista = new ArrayList();

        //<editor-fold defaultstate="collapsed" desc="Cria o arquivo e verifica se o mesmo existe">
        File arquivo = new File("**ATENÇÃO CAMINHO A SER PASSADO****");
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Escreve no Arquivo">
        /* FileWriter fw = new FileWriter(arquivo,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(nome);
        bw.newLine();
        bw.close();
        fw.close();*/
//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Leitura de Arquivo">
        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);
        while (br.ready()) {
            String linha = br.readLine().replaceAll(" ", "").trim();
            lista.add(linha + "Disponivel");
        }
        br.close();
        fr.close();

//</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Verifica se contem o livro">
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).contains(nome)) {
                this.verifica = verifica = true;
            }
            if (verifica == true && lista.get(i).contains(nome + "Disponivel")) {
                this.verificadisponivel = verificadisponivel = true;
            }
        }
//</editor-fold>

    }

    //<editor-fold defaultstate="collapsed" desc="GET VERIFICA">
    public boolean getVerifica() {
        return this.verifica;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET VERIFICA DISPONIVEL">
    public boolean getVerificaDisponivel() {
        return this.verificadisponivel;
    }
//</editor-fold>
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="ImprimirArquivo">
    //Retorna todo o conteudo do arquivo em apenas uma unica string que vai ser tratada em métodos posteriores
    public String[] imprimirArquivo(String caminhoarquivo, String nomearquivo) throws IOException {
        try {
            String texto = "";
            String[] conteudo = null;
            String arquivo = caminhoarquivo + nomearquivo;
            int c = 0;
            BufferedReader br = new BufferedReader(new FileReader(arquivo));

            while (br.ready()) {

                String linha = br.readLine();
                texto = linha;
                conteudo[c] =  texto.toString();                                
                c++;    
            }

            return conteudo;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManipulaArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//</editor-fold>

}
