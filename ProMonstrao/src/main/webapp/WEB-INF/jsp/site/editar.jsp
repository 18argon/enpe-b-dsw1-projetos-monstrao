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
        <input type="text" id="id" name="id" value="${site.id}" hidden/>
        <div>
          <label for="email"><fmt:message key="site.edit.email"/>: </label>
          <input type="text" id="email" name="email" value="${site.email}" disabled/>
        </div>
        <div>
          <label for="nome"><fmt:message key="site.edit.name"/>: </label>
          <input type="text" id="nome" name="nome" value="${site.nome}"/>
        </div>
        <div>
          <label for="endereco"><fmt:message key="site.edit.address"/>: </label>
          <input type="text" id="endereco" name="endereco" value="${site.endereco}"/>
        </div>
        <div>
          <label for="telefone"><fmt:message key="site.edit.phone"/>: </label>
          <input type="text" id="telefone" name="telefone" value="${site.telefone}"/>
        </div>
        <div>
          <input type="submit" name="submit" value="<fmt:message key="site.edit.submit"/>"/>
        </div>
      </form>
    </jsp:body>
  </t:base>
</fmt:bundle>
