package Controller.Servlet;

import Model.CaminhoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author igormodesto
 */
@WebServlet(name = "PaginaPrincipalServlet", urlPatterns = {"/PaginaPrincipalServlet"})
public class PaginaPrincipalServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String mensagem = (String) request.getAttribute("compartilhar");
            String[] dados = mensagem.split(",");

            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <meta charset=UTF-8\">\n"
                    + "        <title>Pagina Principal</title>\n"
                    + "    </head>\n"
                    + "   <body>\n"
                    + "        <div whidth=\"50%\" height=\"50%\">"
                    + "<h1>Bem Vindo " + dados[1] + " </h1>"
                    + "<nav>\n"
                    + "     <a href= AlugarLivro.html >Alugar Livros</a> |\n"
                    + "     <a href= JSP/ControleEstoqueJSP.jsp >Controle de Estoque</a> | \n"
                    + "     <a href= JSP/ControleAluguelJSP.jsp >Controle de Aluguel</a> \n"
                    + "</nav>"
                    + "</div>"
                    + "</body>\n"
                    + "</html>"
            );

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
