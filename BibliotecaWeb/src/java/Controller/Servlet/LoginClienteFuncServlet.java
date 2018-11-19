package Controller.Servlet;

import Controller.ManipulaArquivos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jean Mudesto
 */
@WebServlet(name = "LoginClienteFuncServlet", urlPatterns = {"/LoginClienteFuncServlet"})
public class LoginClienteFuncServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="GetLogin" >
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        String linha = cpf + ";" + senha;
        boolean entrar = false;

        try {
            ManipulaArquivos ma = new ManipulaArquivos();
            String lerCadastro = ma.LerArquivos("JeanMudesto", "CadastroClienteFuncionario.txt");

            if ((RetorneComparacao(lerCadastro, cpf, senha))) {
                out.println("<h2>Acesso feito com sucesso</h2>");
            } else {
                out.println("<h2>CPF ou Senha estão errados</h2>");
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }

    }//</editor-fold>

    public boolean RetorneComparacao(String recebe, String cpf, String senha) {
        boolean entrar = false;
        String[] conteudo = recebe.split(",");
        for (int x = 0; x < conteudo.length; x++) {
            String[] valor = conteudo[x].split(";");
            String c = valor[4];
            if (valor[2].contains(cpf) && c.contains(senha)) {
                entrar = true;
            }
        }
    return entrar;
    }
}
