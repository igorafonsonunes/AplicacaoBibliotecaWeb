<%-- 
    Document   : ControleEstoqueLivros
    Created on : 29/09/2018, 15:47:44
    Author     : igormodesto
--%>

<%@page import="Model.ManipulaArquivos"%>
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
                    ManipulaArquivos lista = new ManipulaArquivos();
                    
                    String livros = lista.LerArquivos("/media/igormodesto/LinuxBase/Arquivos/TrabalhoBibliotecaWeb/AplicacaoBibliotecaWeb/BibliotecaWeb/ArquivosTXT/", "Livros.txt");

                    String[] tamanho = livros.split("|");                                       
                    
                    for(int i = 0;i<=6 ;i++)
                    {
                      out.print("<li>");
                      out.print(tamanho[i]);
                      out.print("</li>");
                    }
                    %>
                </ul>
            </fieldset>            
        </form>
    </body>
</html>

