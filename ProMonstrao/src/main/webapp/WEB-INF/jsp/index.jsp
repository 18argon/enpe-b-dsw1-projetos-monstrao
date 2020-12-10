<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--  TODO: Extrair strings --%>
<html>
<fmt:bundle basename="message">
  <head>
    <title><fmt:message key="title"/></title>
  </head>
  <body>
  <h2><fmt:message key="title"/></h2>

  <c:if test="${usuarioLogado != null}">
    <fmt:message key="home.greeting"/>, ${usuarioLogado.email}
    <a href="${pageContext.request.contextPath}/logout"><fmt:message key="auth.logout"/></a>
  </c:if>
  <c:if test="${usuarioLogado == null}">
    <a href="${pageContext.request.contextPath}/login"><fmt:message key="auth.login"/></a>
  </c:if>
  <div>
      <%-- TODO: Extrair strings --%>

    <c:if test="${usuarioLogado != null}">
      <c:if test="${usuarioLogado.papel == \"ADMIN\"}">
        <a href="${pageContext.request.contextPath}/teatro/">
          Listar Teatros
        </a>
        <a href="${pageContext.request.contextPath}/site/">
          Listar Sites
        </a>
      </c:if>

      <c:if test="${usuarioLogado.papel == \"SITE\"}">
        <a href="${pageContext.request.contextPath}/promocao/">
          Listar Promoções do Site
        </a>
      </c:if>

      <c:if test="${usuarioLogado.papel == \"TEATRO\"}">
        <a href="${pageContext.request.contextPath}/promocao/">
          Listar Promoções do Teatro
        </a>
      </c:if>
    </c:if>
  </div>

  <div>
    <h1>LISTA DE TEATROS</h1>
      <c:choose>
        <c:when test="${param.ordenar != null}">
          <a href="${pageContext.request.contextPath}">Resetar ordenação</a>
        </c:when>
        <c:otherwise>
          <a href="${pageContext.request.contextPath}?ordenar">Ordenar por cidade</a>
        </c:otherwise>
      </c:choose>
    <table>
      <thead>
      <tr>
          <%--        <th>ID</th>--%>
        <th>Nome</th>
        <th>Cnpj</th>
        <th>Cidade</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="teatro" items="${requestScope.listaTeatros}">
        <tr>
            <%--          <td>${teatro.id}</td>--%>
          <td>${teatro.nome}</td>
          <td>${teatro.cnpj}</td>
          <td>${teatro.cidade}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
  </body>
</fmt:bundle>
</html>
