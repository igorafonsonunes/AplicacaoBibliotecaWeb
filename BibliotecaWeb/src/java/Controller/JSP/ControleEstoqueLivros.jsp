<%-- 
    Document   : ControleEstoqueLivros
    Created on : 29/09/2018, 15:47:44
    Author     : igormodesto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Controle de Livros</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form>
            <fieldset>
                <legend>Lista dos livros</legend>     
                <ul> 
                <% 
                for(int i = 0;i<=5;i++){
                     out.print("<li>");
                     out.print("Livro " + i);
                     out.print("</li>");
                    }
                %>
                </ul>
            </fieldset>            
        </form>
    </body>
</html>

