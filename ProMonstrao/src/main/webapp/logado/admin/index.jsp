<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu do Sistema</title>
    </head>
    <body>
    <div align="center">
        <h1>Olá ${sessionScope.usuarioLogado.login}</h1>

        <button type="button" onclick="alert('R1: CRUD SITE!')">CRUD SITE</button>
        <br><br>
        <button type="button" onclick="alert('R2: CRUD TEATRO!')">CRUD TEATRO</button>

        <ul>                 
           	<a href="${pageContext.request.contextPath}/logout.jsp">
    		<h3>SAIR</h3>
    		</a>
        </ul>
    </div>
    </body>
</html>