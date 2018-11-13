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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();;
        
        Integer cpf = Integer.parseInt(request.getParameter("cpf"));          
        Integer senha = Integer.parseInt(request. getParameter("senha")); 
        boolean entrar = false;
        
        try{
            ManipulaArquivos ma = new ManipulaArquivos();
            ma.LerCadastro(cpf,senha,entrar);
            if(ma.getEntrar() == true) {
            out.println("<h2>Acesso feito com sucesso</h2>");
            }else{
            out.println("<h2>CPF ou Senha estão errados</h2>");
            }
        }catch(Exception e){
            out.println(e.getMessage());
        }
       
        

    }//</editor-fold>


}
