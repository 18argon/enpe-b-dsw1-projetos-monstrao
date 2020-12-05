<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<fmt:bundle basename="message">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="title"/></title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
  <h1><fmt:message key="login.label"/></h1>
  <c:if test="${mensagens.existeErros}">
    <div id="erro">
      <ul>
        <c:forEach var="erro" items="${mensagens.erros}">
          <li> ${erro} </li>
        </c:forEach>
      </ul>
    </div>
  </c:if>
  <form method="POST">
    <div>
      <label for="email"><fmt:message key="login.email"/>: </label>
      <input type="text" id="email" name="email" value="${param.email}"/>
    </div>
    <div>
      <label for="password"><fmt:message key="login.password"/>: </label>
      <input type="password" id="password" name="password"/>
    </div>
    <div>
      <input type="submit" name="bOK" value="<fmt:message key="login.submit"/>"/>
    </div>
  </form>
  </body>
</fmt:bundle>
</html>