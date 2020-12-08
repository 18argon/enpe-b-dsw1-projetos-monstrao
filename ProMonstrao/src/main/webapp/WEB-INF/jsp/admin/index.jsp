<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<jsp:useBean id="usuarioLogado" scope="session" type="br.ufscar.dc.dsw.domain.Usuario"/>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<fmt:bundle basename="message">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Menu do Sistema</title>
  </head>
  <body>
  <h1>Página do Administrador</h1>

  <fmt:message key="home.greeting"/>,
  <jsp:getProperty name="usuarioLogado" property="email"/>
  <a href="./logout"><fmt:message key="auth.login"/></a>

  <button type="button">
    <a href="#">Sites</a>
  </button>
  <button type="button">
    <a href="#">Teatros</a>
  </button>
  </body>
</fmt:bundle>
</html>