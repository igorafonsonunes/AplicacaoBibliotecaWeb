package Model;

/**
 *
 * @author igormodesto
 */
public class CaminhoUsuario {

    public String RetornarUsuario() {
        String caminhoUsuario = "";
        String usuario = System.getProperty("user.name");

        if (usuario.equals("igormodesto")) {
            caminhoUsuario = "/media/igormodesto/LinuxBase/Arquivos/TrabalhoBibliotecaWeb/"
                    + "AplicacaoBibliotecaWeb/BibliotecaWeb/arquivostxt/"; 
        }else if (usuario.equals("JeanMudesto")){
            caminhoUsuario = "D:/Trabalho Valério/Biblioteca/Teste/Teste1/BibliotecaWeb/arquivostxt";
        }
        
        else if (usuario.equals("RODOLPHO")){
            caminhoUsuario = "C://Users/RODOLPHO/Documents/NetBeans/AplicacaoBibliotecaWeb-master/BibliotecaWeb/arquivostxt/";
        }
        else {
            caminhoUsuario = "C:/Users/" + usuario + "/Documents/NetBeansProjects/BibliotecaWeb/arquivostxt/";
        }
        return caminhoUsuario;
    }
}
