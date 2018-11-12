<%-- 
    Document   : ControleEstoqueJSP
    Created on : 06/11/2018, 16:36:29
    Author     : igormodesto
--%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="Controller.ManipulaArquivos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--Instanciando-->
<%ManipulaArquivos ma = new ManipulaArquivos();%>
<!DOCTYPE html>
<html>
    <head>
        <title>Controle de Estoque</title>
    </head>
    <body>
        <fieldset style="position: relative; float:left; height:75px ">
            <legend>Gerenciamento dos Livros</legend>
            <form>
                <p>Cadastrar Livros : <input type="text" name="nomeLivro">
                    <button type="submit" onClick="CadastrarLivros()">Cadastrar</button>
                    <script>
                        function CadastrarLivros() {
                        <%
                            String nomeLivro = request.getParameter("nomeLivro");
                            if (nomeLivro != "" && nomeLivro != null) {
                                boolean preenchimento = ma.EscreverArquivo("Livros", nomeLivro + " : 1");
                                if (preenchimento) {
                                    JOptionPane.showMessageDialog(null, "Sucesso ao gravar livro", "Biblioteca Web", 1);

                                } else {
                                    JOptionPane.showMessageDialog(null, "Erro ao gravar livro", "Biblioteca Web", 0);
                                }
                            }
                        %>
                        }
                    </script>
                </p>
            </form>
        </fieldset>
        <fieldset style="position: relative; height:100%; float:left; width:305px  ; margin-top: 0px; margin-right: 600px;" >
            <legend>Livros</legend>
            <table border =1 whidth =100% >
                <tr> <th>Livros</th> <th>Situação</th> </tr>
                        <%
                            String lerArquivos = ma.LerArquivos("Livros");
                            String[] conteudo = lerArquivos.split(",");
                            for (int i = 0; i < conteudo.length; i++) {
                                String[] valores = conteudo[i].split(":");
                                if (valores[0] != " ") {
                                    out.println("<tr><td>" + valores[0] + "</td>");
                                    if (valores[1].trim().equals("0")) {
                                        out.println("<td>Indisponivel</td> </tr>");
                                    } else {
                                        out.println("<td>Disponivel</td> </tr>");
                                    }
                                }
                            }
                        %>
            </table>
        </fieldset>
    </body>
</html>
