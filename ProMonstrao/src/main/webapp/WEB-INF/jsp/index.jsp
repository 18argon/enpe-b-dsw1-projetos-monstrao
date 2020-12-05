<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<fmt:bundle basename="message">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="title"/></title>
  </head>
  <body>
  <h2><fmt:message key="title" /></h2>

  <c:if test="${usuarioLogado != null}">
    <fmt:message key="home.greeting"/>, ${usuarioLogado.getEmail()}
    <a href="./logout"><fmt:message key="auth.login" /></a>
  </c:if>
  <c:if test="${usuarioLogado == null}">
    <a href="login.jsp"><fmt:message key="auth.logout" /></a>
  </c:if>
  <div>
    <button type="button" onclick="alert('LISTADO TODAS AS PROMOÇÕES!')">
      Listar Promoções
    </button>
    <button type="button" onclick="alert('LISTADO TODOS OS TEATROS!')">
      Listar Teatros
    </button>
    <button type="button" onclick="alert('LISTADO TODOS OS TEATROS COM CIDADES!')">
      Listar Sites
    </button>
  </div>
  </body>
</fmt:bundle>
</html>
