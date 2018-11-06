package Controller.Servlet;

import Controller.*;
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
@WebServlet(name = "ControleEstoqueServlet", urlPatterns = {"/ControleEstoqueServlet"})
public class ControleEstoqueServlet extends HttpServlet {

    ManipulaArquivos ma;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lerArquivos = ma.LerArquivos("Livros.txt");
        String[] conteudo = null;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html><html><head><title>Controle de estoque</title></head><body>");
            out.println("<h1>Controle</h1>");

            String[] x = lerArquivos.split(",");

            out.println("<table border =1 whidth =100% >");
            out.println("<tr><th>Livros</th> <th>Disponiveis</th> </tr>");

            for(int i = 0; i < x.length; i++)
            {
                String[] valores = x[i].split(":");

                out.println("<tr><td>" + valores[0] + "</td>");
                out.println("<td>" + valores[1] + "</td> </tr>");
            }
            out.println("</table></body></html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
