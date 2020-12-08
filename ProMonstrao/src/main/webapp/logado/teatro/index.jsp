<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Teatro</title>
    </head>
    <body>
    <div align="center">
        <h1>Olá ${sessionScope.teatroLogado.nome}</h1>
        
        <br>
        <button onclick="location.href='./formInsercaoPromo'" type="button">INSERIR NOVA PROMOÇÃO</button>
        <br><br>
		<button onclick="location.href='./formListaPromo'" type="button">MINHAS PROMOÇÕES</button>

        <ul>                 
           	<a href="${pageContext.request.contextPath}/logout.jsp">
    		<h3>SAIR</h3>
    		</a>
        </ul>
    </div>
    </body>
</html>