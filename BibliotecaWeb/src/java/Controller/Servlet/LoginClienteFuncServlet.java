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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginClienteFunc</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginClienteFunc at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="GetLogin" >
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
                
        Integer cpf = Integer.parseInt(request.getParameter("cpf"));          
        Integer senha = Integer.parseInt(request. getParameter("Senha")); 
        boolean entrar = false;
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        ManipulaArquivos ma = new ManipulaArquivos();
        ma.EscreveLogin(cpf,senha,entrar);
        if(ma.getEntrar() == true) {
            out.println("Acesso feito com sucesso");
        }else{
        out.println("CPF ou Senha estão errados");
        }
        
        
    }//</editor-fold>

    /**
     * Handles the HTTP <code>POST</code> method.
     *22
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    //<editor-fold defaultstate="collapsed" desc="Não fiz o do Post">
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }//</editor-fold>
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
