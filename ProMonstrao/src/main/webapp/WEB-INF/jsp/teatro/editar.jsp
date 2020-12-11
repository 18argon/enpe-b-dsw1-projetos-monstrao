<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<fmt:bundle basename="message">
  <t:base>
    <jsp:attribute name="title">
      <fmt:message key="title"/>
    </jsp:attribute>
    <jsp:body>
      <form method="post">
        <input type="text" id="id" name="id" value="${teatro.id}" hidden/>
        <div>
          <label for="email"><fmt:message key="theater.edit.email"/>: </label>
          <input type="text" id="email" name="email" value="${teatro.email}" disabled/>
        </div>
        <div>
          <label for="nome"><fmt:message key="theater.edit.name"/>: </label>
          <input type="text" id="nome" name="nome" value="${teatro.nome}"/>
        </div>
        <div>
          <label for="cnpj"><fmt:message key="theater.edit.cnpj"/>: </label>
          <input type="text" id="cnpj" name="cnpj" value="${teatro.cnpj}"/>
        </div>
        <div>
          <label for="city"><fmt:message key="theater.edit.city"/>: </label>
          <input type="text" id="city" name="cidade" value="${teatro.cidade}"/>
        </div>
        <div>
          <button name="submit">
            <fmt:message key="theater.edit.submit"/>
          </button>
        </div>
      </form>
    </jsp:body>
  </t:base>
</fmt:bundle>
