/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Servlet;

import Controller.ManipulaArquivos;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonardo
 */
@WebServlet(name = "ControleDisponibiladeServlet", urlPatterns = {"/ControleDisponibiladeServlet"})
public class ControleDisponibiladeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String livro = request.getParameter("livro");
        response.setContentType("text/html;charset=UTF-8");
        try {
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Primeira Aplicacao Web Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Livro buscado: " + " " + livro + "</h1>");

            ManipulaArquivos arq = new ManipulaArquivos();
            boolean verifica = false;
            boolean verificadisponivel = false;
            arq.Manipulador(livro, verifica, verificadisponivel);
            if (arq.getVerifica() == true) {
                out.println("<h2>Contém este livro na biblioteca</h2>");
            } else {
                out.println("<h2>Infelizmente não contém este livro na biblioteca </h2>");
            }
            if (arq.getVerificaDisponivel() == true) {

                out.println("<h2> [Livro está disponivel] </h2>");
                out.println("<a href='AlugarLivro.html'> <input type='submit' value='Alugar Livro'</a>");

            }

            if (arq.getVerifica() == true) {
                if (arq.getVerificaDisponivel() == false) {
                    out.println("<h2>[Infelizmente o livro está Indisponivel] </h2> ");
                }
            }
            out.println("</body>");
            out.println("</html>");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "ERRO", "Ocorreu um erro durante a operação", 0);
        } finally {
            out.close();
        }
    }
}
