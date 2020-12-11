<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--  TODO: Extrair strings --%>
<t:base>
  <jsp:attribute name="title">
    Autorização de Usuário
  </jsp:attribute>
  <jsp:body>
    <h1>Autorização de Usuário</h1>
    <c:if test="${mensagens.existeErros}">
      <div id="erro">
        <ul>
          <c:forEach var="erro" items="${mensagens.erros}">
            <li> ${erro} </li>
          </c:forEach>
        </ul>
      </div>
    </c:if>
  </jsp:body>
</t:base>