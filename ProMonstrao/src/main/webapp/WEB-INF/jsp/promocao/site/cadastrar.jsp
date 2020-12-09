<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<div class="center">
  <h1>INSERIR PROMOÇÃO</h1>

  <form method="post" action="${pageContext.request.contextPath}/promocao/site/cadastrar">
    <div>
      <label for="teatro">Site Responsável</label>
      <select id="teatro" name="id_teatro">
        <option value="">--Escolha um teatro--</option>
        <c:forEach items="${teatros}" var="teatro">
          <option value="${teatro.id}">${teatro.nome}</option>
        </c:forEach>
      </select>
    </div>

    <div>
      <label for="nome_peca">Nome da Peça: </label>
      <input type="text" id="nome_peca" name="nome_peca" size="45" required value="${promocao.nome}"/>
    </div>

    <div>
      <label for="preco_peca">Preço: </label>
      <input type="text" id="preco_peca" name="preco_peca" size="45" required value="${promocao.preco}"/>
    </div>

    <div>
      <label for="data_peca">Data da Peça: </label>
      <input type="text" id="data_peca" name="data_peca" size="45" required value="${promocao.data}"/>
    </div>

    <div>
      <button>CRIAR</button>
    </div>
  </form>
</div>
</body>
</html>
