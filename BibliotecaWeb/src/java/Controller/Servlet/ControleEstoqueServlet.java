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
        String lerArquivos = ma.LerArquivos("ArquivosTXT/", "Livros.txt");
        String[] conteudo = null;
        int i = 0;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html><html><head><title>Controle de estoque</title></head><body>");
            out.println("<h1>Controle</h1>");
            
            for (String x : lerArquivos.split("|")) {
                conteudo[i] = x;
                i++;
            }
            
            out.println("<table border =1 whidth =100% >");
            out.println("<tr> <th>Livros</th> <th>Disponiveis</th> </tr>");
            
            
            out.println("<tr> <td></td> <td></td> </tr>");
            
            out.println("</table></body></html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
