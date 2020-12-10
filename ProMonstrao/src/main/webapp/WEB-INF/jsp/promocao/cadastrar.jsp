<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--  TODO: Extrair strings --%>
<html>
<head>
  <title>Title</title>
</head>
<body>
<div class="center">
  <h1>INSERIR PROMOÇÃO</h1>

  <form method="post" action="${pageContext.request.contextPath}/promocao/cadastrar">
    <div>
      <label for="site">Site</label>
      <select id="site" name="id_site">
        <option value="">--Escolha um teatro--</option>
        <c:forEach items="${sites}" var="site">
          <option value="${site.id}">${site.nome}</option>
        </c:forEach>
      </select>
    </div>

    <div>
      <label for="nome_peca">Nome: </label>
      <input type="text" id="nome_peca" name="nome" size="45" required value="${promocao.nome}"/>
    </div>

    <div>
      <label for="preco_peca">Preço: </label>
      <input type="text" id="preco_peca" name="preco" size="45" required value="${promocao.preco}"/>
    </div>

    <div>
      <label for="data_peca">Data: </label>
      <input type="text" id="data_peca" name="data" size="45" required value="${promocao.data}"/>
    </div>

    <div>
      <button name="submit">CRIAR</button>
    </div>
  </form>
</div>
</body>
</html>
