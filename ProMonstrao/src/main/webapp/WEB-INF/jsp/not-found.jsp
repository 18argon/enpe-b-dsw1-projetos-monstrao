<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<fmt:bundle basename="message">
  <head>
    <title><fmt:message key="title"/></title>
  </head>
  <body>
  "${pageContext.request.pathInfo}"
  404 - Not Found
  </body>
</fmt:bundle>
</html>
