package Controller;

import Model.CaminhoUsuario;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author igormodesto
 *
 * A ideia dessa classe é tentar criar todos os métodos o mais genérico possível
 * para que todos possam reaproveitar os códigos descritos
 */
public class ManipulaArquivos {

    CaminhoUsuario cau = new CaminhoUsuario();
    //<editor-fold defaultstate="collapsed" desc="Atributos para retorno">
    private boolean verifica;
    private boolean verificadisponivel;
    private boolean confirma;
    private boolean entrar;
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Ler Arquivos">
    public String LerArquivos(String nomeArquivo) throws FileNotFoundException {
        String arquivo = "";
        try {
            String caminhoArquivo = cau.RetornarUsuario();
            BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo + nomeArquivo));
            while (br.ready()) {
                arquivo += br.readLine() + ",";
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(ManipulaArquivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arquivo;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Escrever Arquivo">
    public boolean EscreverArquivo(String nomeArquivo, String conteudoArquivo) {
        boolean arquivoPreenchido = false;
        try {
            String caminhoArquivo = cau.RetornarUsuario();
            BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo + nomeArquivo, true));
            bw.write(conteudoArquivo);
            bw.newLine();
            bw.close();
            arquivoPreenchido = true;

        } catch (IOException e) {
            System.out.println(e);
        }

        return arquivoPreenchido;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos Manipulador ">
    public void Manipulador(String nome, boolean verifica, boolean verificadisponivel) throws IOException {

        ArrayList<String> lista = new ArrayList();
        File arquivo = new File("C:/Users/Leonardo/Documents/NetBeansProjects/Web.txt");

        //<editor-fold defaultstate="collapsed" desc="Cria o arquivo e verifica se o mesmo existe">
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Escreve Arquivo">
    public void EscreveArquivo(String livro, boolean confirma, String nome, Integer numero, Integer cpf) throws IOException {
        Date date = new Date(); //data
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String DataHora = formato.format(date);
        File arquivo = new File("../Aluguel.txt");

        FileWriter fw = new FileWriter(arquivo, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Livro: " + livro + " - Alugado no dia " + DataHora + " - por " + nome + " - CPF: " + cpf + " - Múmero: " + numero);
        confirma = true;
        this.confirma = confirma;
        bw.newLine();
        bw.close();
        fw.close();

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET CONFIRMA">
    public boolean getConfirma() {
        return this.confirma;
    }
//</editor-fold>

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
                conteudo[c] = texto.toString();
                c++;
            }

            return conteudo;
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(ManipulaArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Escrevendo Login">
    public void EscreveLogin(Integer cpf, Integer senha, boolean entrar) throws IOException {

        File cadastro = new File("../CadastroLogin.txt");
        try {
            if (!cadastro.exists()) {
                cadastro.createNewFile();
            }
            //escrevendo no arq.Login
            FileWriter fw2 = new FileWriter(cadastro, true);
            BufferedWriter bw2 = new BufferedWriter(fw2);
            bw2.write("cpf" + cpf + "senha" + senha);
            entrar = true;
            this.entrar = entrar;
            bw2.newLine();
            bw2.close();
            fw2.close();
            //leitura
            FileReader fr2 = new FileReader(cadastro);
            BufferedReader br2 = new BufferedReader(fr2);
            while (br2.ready()) {
                String linha = br2.readLine();
                System.out.println(linha);
            }
            br2.close();
            fr2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Cadastrando dados">
    public void CadastroClienteFunc(String linha, boolean entrar) throws IOException {

        File cadastro = new File("C://Users/RODOLPHO/Documents/NetBeans/AplicacaoBibliotecaWeb-master/BibliotecaWeb/arquivostxt/CadastroClienteFuncionario.txt");
        try {
            if (!cadastro.exists()) {
                cadastro.createNewFile();
            }
            //escrevendo no arq.Login
            BufferedWriter bw = new BufferedWriter(new FileWriter(cadastro, true));
            bw.write(linha);
            bw.newLine();
            bw.close();
            entrar = true;
            this.entrar = entrar;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET ENTRAR">
    public boolean getEntrar() {
        return this.entrar;
    }//</editor-fold>
}
