/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Leonardo
 */
public class ManipulaArquivo {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

        //<editor-fold defaultstate="collapsed" desc="Atributos para retorno">
    private boolean verifica;
    private boolean verificadisponivel;
//</editor-fold>
    
    public void Manipulador(String nome, boolean verifica, boolean verificadisponivel) throws IOException 
    {
        
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
        while (br.ready())
        {
            String linha = br.readLine().replaceAll(" ", "").trim();
            lista.add(linha + "Disponivel");
        }
        br.close();
        fr.close();
        
//</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Verifica se contem o livro">
        
        for (int i = 0; i < lista.size(); i++)
        {
            if (lista.get(i).contains(nome))
            {
                this.verifica = verifica = true;              
            }
            if (verifica == true && lista.get(i).contains(nome + "Disponivel"))
            {             
                this.verificadisponivel = verificadisponivel = true;
            }
        }
//</editor-fold>
      
    }

    //<editor-fold defaultstate="collapsed" desc="GET VERIFICA">
    public boolean getVerifica() 
    {
        return this.verifica;
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GET VERIFICA DISPONIVEL">

    public boolean getVerificaDisponivel() 
    {
        return this.verificadisponivel;
    }
//</editor-fold>

}




