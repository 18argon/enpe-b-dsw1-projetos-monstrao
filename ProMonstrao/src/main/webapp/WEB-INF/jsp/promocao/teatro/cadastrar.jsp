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

  <form method="post" action="${pageContext.request.contextPath}/promocao/teatro/cadastrar">
    <div>
      <label for="site">Site Responsável</label>
      <select id="site" name="id_site">
        <option value="">--Escolha um site--</option>
        <c:forEach items="${sites}" var="site">
          <option value="${site.id}">${site.nome}</option>
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