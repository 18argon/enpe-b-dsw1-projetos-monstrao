<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<fmt:bundle basename="message">
  <head>
    <title><fmt:message key="title"/></title>
  </head>
  <body>
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
  </body>
</fmt:bundle>
</html>
