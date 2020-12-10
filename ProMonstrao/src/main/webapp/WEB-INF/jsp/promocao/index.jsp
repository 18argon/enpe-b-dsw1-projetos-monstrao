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
  <h2><fmt:message key="title"/></h2>

  <c:if test="${usuarioLogado != null}">
    <fmt:message key="home.greeting"/>, ${usuarioLogado.email}
    <a href="${pageContext.request.contextPath}/logout"><fmt:message key="auth.logout"/></a>
  </c:if>
  <c:if test="${usuarioLogado == null}">
    <a href="${pageContext.request.contextPath}/login"><fmt:message key="auth.login"/></a>
  </c:if>

  <div>
    <h1>Lista de Promoções</h1>
    <c:if test="${usuarioLogado.papel == \"TEATRO\"}">
      <a href="${pageContext.request.contextPath}/promocao/cadastrar">Cadastrar nova promoção</a>
    </c:if>
    <table>
      <thead>
      <tr>
        <th>ID</th>
        <%-- TODO: Mudar para nomes --%>
        <th>ID Site</th>
        <th>ID Teatro</th>
        <th>Nome</th>
        <th>Preço</th>
        <th>Data</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="promocao" items="${requestScope.listaPromocao}">
        <tr>
          <td>${promocao.id}</td>
          <td>${promocao.idSite}</td>
          <td>${promocao.idTeatro}</td>
          <td>${promocao.nome}</td>
          <td>${promocao.preco}</td>
          <td>${promocao.data}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
  </body>
</fmt:bundle>
</html>
