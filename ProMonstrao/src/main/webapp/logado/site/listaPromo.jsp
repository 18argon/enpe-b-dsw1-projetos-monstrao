<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista de Promoções</title>
</head>
<body>
	<%
		String contextPath = request.getContextPath().replace("/", "");
	%>
	<div align="center">
		<table border="1">
			<h1>LISTA DE PROMOÇÕES</h1>
			<tr>
				<th>ID</th>
				<th>Teatro</th>
				<th>Nome da Peça</th>
				<th>Preço</th>
				<th>Data</th>
			</tr>
			<c:forEach var="promocao" items="${requestScope.listaPromocoes}">
				<tr>
					<td>${promocao.id}</td>
					<td>${promocao.getIdTeatro()}</td>
					<td>${promocao.getNomePeca()}</td>
					<td>${promocao.getPrecoPeca()}</td>
					<td>${promocao.getDataPeca()}</td>					
				</tr>
			</c:forEach>
		</table>
		<br>
		<a href="./index.jsp">
		<h3>VOLTAR</h3>
		</a>
	</div>
</body>