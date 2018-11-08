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
        <title>Controle de Estoque</title>
    </head>
    <body>
        <h1>Gerenciamento dos Livros</h1>
        <table border =1 whidth =100% >
            <tr> <th>Livros</th> <th>Situação</th> </tr>
                    <%
                        ManipulaArquivos ma = new ManipulaArquivos();

                        String lerArquivos = ma.LerArquivos("Livros");

                        String[] x = lerArquivos.split(",");

                        for (int i = 0; i < x.length; i++) {
                            String[] valores = x[i].split(":");
                            out.println("<tr><td>" + valores[0] + "</td>");
                            if (valores[1].trim().equals("0")) {
                                out.println("<td>Indisponivel</td> </tr>");
                            } else {
                                out.println("<td>Disponivel</td> </tr>");
                            }

                        }

                    %>
        </table>
    </body>
</html>
