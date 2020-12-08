<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista de Teatros</title>
</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<h1>Gerenciamento de Teatros</h1>
	<h2>
		<a href="/<%=contextPath%>">Menu Principal</a> &nbsp;&nbsp;&nbsp; 
		<a href="/<%=contextPath%>/livros/cadastro">Adicione Novo Livro</a>
	</h2>
	<div align="center">
		<table border="1">
			<caption>Lista de Teatros</caption>
			<tr>
				<th>ID</th>
				<th>Cnpj</th>
				<th>Nome</th>
				<th>Cidade</th>
			</tr>
			<c:forEach var="livro" items="${requestScope.listaTeatros}">
				<tr>
					<td>${livro.id}</td>
					<td>${livro.cnpj}</td>
					<td>${livro.nome}</td>
					<td>${livro.cidade}</td>					
					<td><a href="/<%= contextPath%>/teatro/edicao?id=${livro.id}">Edição</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/<%= contextPath%>/teatro/remocao?id=${livro.id}"
						onclick="return confirm('Tem certeza de que deseja excluir este item?');">
						Remoção </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>