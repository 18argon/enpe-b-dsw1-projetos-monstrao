<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu do Sistema</title>
    </head>
    <body>
        <h1>Página do Usuário Teatro</h1>
        <p>Olá ${sessionScope.usuarioLogado.nome}</p>

        <button type="button" onclick="alert('TELA DE CRIAR PROMOCAO!')">R5 e R6: CRIAR PROMOCAO TEATRO</button>
        <button type="button" onclick="alert('LISTADO TODAS AS PROMOCAO DESTE TEATRO!')">R7: CRIAR Listagem de todas as promoções de um teatro</button>

        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/logout.jsp">Sair</a>
            </li>
        </ul>
    </body>
</html>