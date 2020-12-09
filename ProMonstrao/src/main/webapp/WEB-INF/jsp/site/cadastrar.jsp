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
      <label for="email"><fmt:message key="site.create.email"/>: </label>
      <input type="text" id="email" name="email" value="${site.email}"/>
    </div>
    <div>
      <label for="password"><fmt:message key="site.create.password"/>: </label>
      <input type="text" id="password" name="senha" value="${site.password}"/>
    </div>
    <div>
      <label for="name"><fmt:message key="site.create.name"/></label>
      <input type="text" id="name" name="nome" value="${site.nome}"/>
    </div>
    <div>
      <label for="endereco"><fmt:message key="site.create.address"/>: </label>
      <input type="text" id="endereco" name="endereco" value="${site.endereco}"/>
    </div>
    <div>
      <label for="telefone"><fmt:message key="site.create.phone"/>: </label>
      <input type="text" id="telefone" name="telefone" value="${site.telefone}"/>
    </div>
    <div>
      <input type="submit" name="submit" value="<fmt:message key="site.create.submit"/>"/>
    </div>
  </form>
  </body>
</fmt:bundle>
</html>
