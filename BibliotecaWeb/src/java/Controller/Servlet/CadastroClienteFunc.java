package Controller.Servlet;

import Controller.ManipulaArquivos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastroClienteFunc", urlPatterns = {"/CadastroClienteFunc"})
public class CadastroClienteFunc extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String tipo = request.getParameter("tipo");
        String linha = tipo + ";" + nome + ";" + cpf + ";" + email + ";" + senha;

        boolean entrar = false;
        try {
            ManipulaArquivos man = new ManipulaArquivos();

            man.CadastroClienteFunc(linha, entrar);

            if (man.getEntrar() == true) {
                out.println("<h2>Cadastro feito com sucesso</h2>");
                out.println("<a href=\"index.html\"><input type=\"button\" value=\"Retornar página inicial\"><br><br>");
            } else {
                out.println("<h2>Dados incorretos</h2>");
            }
        } catch (Exception e) {

        }
        out.println("");
    }

}
