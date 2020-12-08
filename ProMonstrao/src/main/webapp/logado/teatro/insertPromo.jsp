<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<title>Inserir Promoção</title>

<div align="center">
	<h1>INSERIR PROMOÇÃO</h1>
	

	<form method="get" action="./inserePromo">
		<table border="1">
			
			
			<tr>
				<td><label>Site Responsável</label></td>		
				<td><select name="id_site">
						<c:forEach items="${sites}" var="sites">
							<option value="${sites.key}">${sites.value}</option>
						</c:forEach>
				</select></td>
			</tr>
			
			<tr>
				<td><label>Nome da Peça</label></td>
				<td><input type="text" id="nome_peca" name="nome_peca" size="45" required value="${promocao.nome_peca}"/></td>
			</tr>
			
			<tr>
				<td><label>Preço</label></td>
				<td><input type="text" id="preco_peca" name="preco_peca" size="45" required value="${promocao.preco_peca}" /></td>
			</tr>
			
			<tr>
				<td><label>Data da Peça</label></td>
				<td><input type="text" id="data_peca" name="data_peca" size="45" required value="${promocao.data_peca}" /></td>
			</tr>
			
			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="CONFIRMAR"/></td>		
			</tr>				
		</table>
		<br>
		<a href="./index.jsp">
		<h3>VOLTAR</h3>
		</a>
	</form>
</div>