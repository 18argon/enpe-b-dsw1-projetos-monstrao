<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--  TODO: Extrair strings --%>
<fmt:bundle basename="message">
  <t:base>
    <jsp:attribute name="title">
      <fmt:message key="title"/>
    </jsp:attribute>
    <jsp:body>
      <h2><fmt:message key="title"/></h2>

      <c:if test="${usuarioLogado != null}">
        <fmt:message key="home.greeting"/>, ${usuarioLogado.email}
        <a href="${pageContext.request.contextPath}/logout">
          <fmt:message key="auth.logout"/>
        </a>
      </c:if>
      <c:if test="${usuarioLogado == null}">
        <a href="${pageContext.request.contextPath}/login">
          <fmt:message key="auth.login"/>
        </a>
      </c:if>
      <div>
          <%-- TODO: Extrair strings --%>

        <c:if test="${usuarioLogado != null}">
          <c:if test="${usuarioLogado.papel == \"ADMIN\"}">
            <a href="${pageContext.request.contextPath}/teatro/">
              <fmt:message key="home.list-theater-action" />
            </a>
            <a href="${pageContext.request.contextPath}/site/">
              <fmt:message key="home.list-websites-action" />
            </a>
          </c:if>

          <c:if test="${usuarioLogado.papel == \"SITE\"}">
            <a href="${pageContext.request.contextPath}/promocao/">
              <fmt:message key="home.list-my-promotions-action" />
            </a>
          </c:if>

          <c:if test="${usuarioLogado.papel == \"TEATRO\"}">
            <a href="${pageContext.request.contextPath}/promocao/">
              <fmt:message key="home.list-my-promotions-action" />
            </a>
          </c:if>
        </c:if>
      </div>

      <div>
        <h1><fmt:message key="home.theater.title" /></h1>
        <c:choose>
          <c:when test="${param.ordenar != null}">
            <a href="${pageContext.request.contextPath}">
              <fmt:message key="home.theater.reset-order" />
            </a>
          </c:when>
          <c:otherwise>
            <a href="${pageContext.request.contextPath}?ordenar">
              <fmt:message key="home.theater.order-by-city" />
            </a>
          </c:otherwise>
        </c:choose>
        <table>
          <thead>
          <tr>
              <%--        <th>ID</th>--%>
            <th><fmt:message key="home.theater.name-label" /></th>
            <th><fmt:message key="home.theater.cnpj-label" /></th>
            <th><fmt:message key="home.theater.city-label" /></th>
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
    </jsp:body>
  </t:base>
</fmt:bundle>
