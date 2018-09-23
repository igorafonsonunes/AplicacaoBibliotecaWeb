package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.ManipulaArquivo;

/**
 *
 * @author igormodesto
 */
@WebServlet(name = "EstoqueLivrosServlet", urlPatterns = {"/EstoqueLivrosServlet"})
public class EstoqueLivrosServlet extends HttpServlet {

    ManipulaArquivo manipula;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.getParameter("estande");
            PrintWriter out = response.getWriter();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Primeira Aplicacao Web Servlet</title>");
            out.println("</head>");
            out.println("<body>");

            String[] lista = manipula.imprimirArquivo("/media/igormodesto/LinuxBase/Arquivos/TrabalhoBibliotecaWeb/AplicacaoBibliotecaWeb/BibliotecaWeb/ArquivosTxt/Livros", "Livros.txt");
            response.setContentType("text/html;charset=UTF-8");

            out.print("<ul>");
            for (int i = 0; i <= lista.length; i++) {
                out.print("<li>");
                out.print(lista[i]);
                out.print("<li>");
            }
            out.print("</ul>");

            out.println("<body>");
            out.println("</html>");

        } catch (Exception ex) {
            System.out.println("erro" + ex);
        }
    }
}
