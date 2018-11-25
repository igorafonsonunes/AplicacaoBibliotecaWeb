package Controller.Servlet;

import Controller.ManipulaArquivos;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leonardo
 */
@WebServlet(name = "AlugarLivroServlet", urlPatterns = {"/AlugarLivroServlet"})
public class AlugarLivroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String livro = request.getParameter("livro");
        Integer numero = Integer.parseInt(request.getParameter("telefone"));
        Integer cpf = Integer.parseInt(request.getParameter("cpf"));
        boolean confirma = false;

        Date date = new Date();
        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String DataHora = formato.format(date);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String conteudo = nome +":"+livro+":"+"0";

        ManipulaArquivos ma = new ManipulaArquivos();
        boolean gravacao = ma.EscreverArquivo("Aluguel",conteudo);

        if (gravacao) {
            out.println("Parabéns " + nome + " livro alugado no dia " + DataHora);
        } else {
            out.println("Infelizmente nao foi possível fazer o aluguel");
        }

    }

}
