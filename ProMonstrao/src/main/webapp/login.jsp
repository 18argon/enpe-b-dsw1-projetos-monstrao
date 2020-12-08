<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autorização de Usuário</title>
        <link href="${pageContext.request.contextPath}/layout.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
    <div align="center">
        <h1>AUTORIZAÇÃO DE USUÁRIO</h1>
        <c:if test="${mensagens.existeErros}">
            <div id="erro">
                <ul>
                    <c:forEach var="erro" items="${mensagens.erros}">
                        <li> ${erro} </li>
                        </c:forEach>
                </ul>
            </div>
        </c:if>
        <form method="post" action="logando.jsp">
            <table>
                <tr>
                    <th>LOGIN: </th>
                    <td><input type="text" name="login"
                               value="${param.login}"/></td>
                </tr>
                <tr>
                    <th>SENHA: </th>
                    <td><input type="password" name="senha" /></td>
                </tr>                
                <tr>
                    <td colspan="2"> 
                        <input type="submit" name="bOK" value="ENTRAR"/>
                    </td>
                </tr>
            </table>
            <br>
			<a href="./index.jsp">
			<h3>VOLTAR</h3>
			</a>
        </form>
     </div>
    </body>
</html>