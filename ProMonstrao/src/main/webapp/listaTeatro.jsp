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
	<div align="center">
		<h1>LISTA DE TEATROS</h1>
		<table border="1">			
			<tr>
				<th>ID</th>
				<th>Cnpj</th>
				<th>Nome</th>
				<th>Cidade</th>
			</tr>
			<c:forEach var="teatro" items="${requestScope.listaTeatros}">
				<tr>
					<td>${teatro.id}</td>
					<td>${teatro.cnpj}</td>
					<td>${teatro.nome}</td>
					<td>${teatro.cidade}</td>					
				</tr>
			</c:forEach>
		</table>
		<br>
		<a href="./index.jsp">
		<h3>VOLTAR</h3>
		</a>
	</div>
</body>