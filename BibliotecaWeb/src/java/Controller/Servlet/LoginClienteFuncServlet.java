package Controller.Servlet;

import Controller.ManipulaArquivos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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

    String Compartilhar;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String tipo = request.getParameter("tipo");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        String linha = cpf + ";" + senha;

        try {
            ManipulaArquivos ma = new ManipulaArquivos();
            String lerCadastro = ma.LerArquivos("CadastroClienteFuncionario");

            if ((RetorneComparacao(lerCadastro, cpf, senha))) {
                request.setAttribute("compartilhar",Compartilhar);
                RequestDispatcher rd = request.getRequestDispatcher ("PaginaPrincipalServlet");  
                rd.forward(request, response);
                
            } else {
                out.println("<h2>CPF ou Senha estão errados</h2>");
                out.println("<a href=\"index.html\"><input type=\"button\" value=\"Retornar\"></a></p>");
            }
        } catch (Exception e) {
            out.println(e.getMessage());
        }

    }

    public boolean RetorneComparacao(String recebe, String cpf, String senha) {
        boolean entrar = false;
        String[] conteudo = recebe.split(",");
        for (int x = 0; x < conteudo.length; x++) {
            String[] valor = conteudo[x].split(";");
            String c = valor[4];
            String b = valor[2];
            if (b.equals(cpf) && c.equals(senha)) {
                Compartilhar = valor[0] + "," + valor[1];
                return entrar = true;
            }
        }
        return entrar;
    }
}
