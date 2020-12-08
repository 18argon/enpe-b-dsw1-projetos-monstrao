<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<fmt:bundle basename="message">
  <head>
    <title><fmt:message key="title"/></title>
  </head>
  <body>
  <h2><fmt:message key="title" /></h2>

  <c:if test="${usuarioLogado != null}">
    <fmt:message key="home.greeting"/>, ${usuarioLogado.getEmail()}
    <a href="${pageContext.request.contextPath}/logout"><fmt:message key="auth.logout" /></a>
  </c:if>
  <c:if test="${usuarioLogado == null}">
    <a href="${pageContext.request.contextPath}/login"><fmt:message key="auth.login" /></a>
  </c:if>
  <div>
    <button type="button" onclick="alert('LISTADO TODAS AS PROMOÇÕES!')">
      Listar Promoções
    </button>
    <a href="${pageContext.request.contextPath}/teatro/">
      Listar Teatros
    </a>
    <a href="${pageContext.request.contextPath}/site/">
      Listar Sites
    </a>
  </div>
  </body>
</fmt:bundle>
</html>
