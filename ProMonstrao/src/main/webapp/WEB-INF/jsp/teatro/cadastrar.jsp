<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<fmt:bundle basename="message">
  <head>
    <title><fmt:message key="title"/></title>
  </head>
  <body>
  <form method="post">
    <div>
      <label for="email"><fmt:message key="theater.create.email"/>: </label>
      <input type="text" id="email" name="email" value="${teatro.email}"/>
    </div>
    <div>
      <label for="password"><fmt:message key="theater.create.password"/>: </label>
      <input type="text" id="password" name="senha" value="${teatro.password}"/>
    </div>
    <div>
      <label for="name"><fmt:message key="theater.create.name"/></label>
      <input type="text" id="name" name="nome" value="${teatro.nome}"/>
    </div>
    <div>
      <label for="cnpj"><fmt:message key="theater.create.cnpj"/>: </label>
      <input type="text" id="cnpj" name="cnpj" value="${teatro.cnpj}"/>
    </div>
    <div>
      <label for="city"><fmt:message key="theater.create.city"/>: </label>
      <input type="text" id="city" name="cidade" value="${teatro.cidade}"/>
    </div>
    <div>
      <input type="submit" name="submit" value="<fmt:message key="theater.create.submit"/>"/>
    </div>
  </form>
  </body>
</fmt:bundle>
</html>
