<%-- 
    Document   : ControleEstoqueJSP
    Created on : 06/11/2018, 16:36:29
    Author     : igormodesto
--%>

<%@page import="Controller.ManipulaArquivos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Controle de estoque</title>
    </head>
    <body>
        <h1>Controle</h1>
        <table border =1 whidth =100% >
            <tr> <th>Livros</th> <th>Disponiveis</th> </tr>
                    <%
                        ManipulaArquivos ma = new ManipulaArquivos();
                        
                        String lerArquivos = ma.LerArquivos("Livros");
                        
                        String[] x = lerArquivos.split(",");
                        
                        for (int i = 0; i < x.length; i++) {
                            String[] valores = x[i].split(":");

                            out.println("<tr><td>" + valores[0] + "</td>");
                        
                            out.println("<td>" + valores[1] + "</td> </tr>");
                        }
                        
                    %>
        </table>
    </body>
</html>
