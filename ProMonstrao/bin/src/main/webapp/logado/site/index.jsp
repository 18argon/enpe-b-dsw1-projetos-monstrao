<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu do Sistema</title>
    </head>
    <body>
        <h1>Página do Usuário Site</h1>
        <p>Olá ${sessionScope.usuarioLogado.nome}</p>

        <button type="button" onclick="alert('LISTADO TODAS AS PROMOCAO DO SITE!')">R8: CRIAR Listagem de todas as promoções de um Site</button>

        <ul>
            <li>
                <a href="${pageContext.request.contextPath}/logout.jsp">Sair</a>
            </li>
        </ul>
    </body>
</html>