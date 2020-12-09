<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<fmt:bundle basename="message">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Menu do Sistema</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  </head>
  <body>
  <h1><fmt:message key="theater.header"/></h1>

  <jsp:useBean id="usuarioLogado" scope="session" type="br.ufscar.dc.dsw.domain.Usuario"/>
  <fmt:message key="home.greeting"/>,
  <jsp:getProperty name="usuarioLogado" property="email"/>
  <a href="${pageContext.request.contextPath}/logout"><fmt:message key="auth.logout"/></a>

  <div>
    <a href="${pageContext.request.contextPath}/teatro/cadastrar"><fmt:message key="theater.create_new"/></a>
  </div>
  <table>
    <thead>
    <tr>
      <th><fmt:message key="theater.list.id"/></th>
      <th><fmt:message key="theater.list.name"/></th>
      <th><fmt:message key="theater.list.email"/></th>
      <th><fmt:message key="theater.list.cnpj"/></th>
      <th><fmt:message key="theater.list.city"/></th>
      <th><fmt:message key="theater.list.actions"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="teatro" items="${requestScope.listaTeatros}">
      <tr>
        <td>${teatro.id}</td>
        <td>${teatro.nome}</td>
        <td>${teatro.email}</td>
        <td>${teatro.cnpj}</td>
        <td>${teatro.cidade}</td>
        <td>
          <a href="${pageContext.request.contextPath}/teatro/editar?id=${teatro.id}">
            <fmt:message key="theater.list.edit_action"/>
          </a>
          <span>   </span>
          <a href="${pageContext.request.contextPath}/teatro/deletar?id=${teatro.id}">
            <fmt:message key="theater.list.delete_action"/>
          </a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  </body>
</fmt:bundle>
</html>