<%-- 
    Document   : ControleAluguelJSP
    Created on : 10/11/2018, 13:27:33
    Author     : igormodesto
--%>

<%@page import="Controller.ManipulaArquivos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%ManipulaArquivos ma = new ManipulaArquivos();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contole de Aluguel</title>
    </head>
    <body>
        <fieldset style="position:realative; height:100%; float:left;">
            <legend>Controle de Aluguel</legend>
            <table border =1 whidth =100%>
                <tr> <th>Clientes</th> <th>Livro</th> <th>Situação</th> </tr>  
                        <%
                            String lerArquivos = ma.LerArquivos("Aluguel");
                            String[] conteudo = lerArquivos.split(",");
                            for (int i = 0; i < conteudo.length; i++) {
                                String[] valores = conteudo[i].split(":");
                                out.println("<tr><td>" + valores[0] + "</td>");
                                out.println("<td>" + valores[1] + "</td>");
                                if (valores[2].trim().equals("1")) {
                                    out.println("<td>Normal</td></tr>");
                                } else {
                                    out.println("<td>Atrasado</td></tr>");
                                }
                            }
                        %>
            </table>
        </fieldset>
    </body>
</html>
