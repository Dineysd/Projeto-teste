<%@page import="entidade.Contato"%>
<%@page import="dao.ClienteDao"%>
<%@page import="entidade.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div align="center" style="float: left; width: 32%;" id="teste1">

		<form method="post" action="ClientePorDDD">

			<h1>Lista de Clientes por DDD!</h1>
			<table>
				<tr>
					<td>Informe o DDD da sua cidade:</td>
					<td><input type="text" name="DDD" size="3"
						placeholder="DDD" "></td>
				</tr>

				<tr>
					<td><input type="submit" value="Enviar"> <input
						type="reset" value="Limpar"></td>
				</tr>
			</table>
		</form>

	</div>
	
	

	<div align="center">
		<P>Lista de Clientes</P>
		<table border="1">
			<tr>

				<td>Nome</td>
				<td>CPF</td>
				<td>Data Nascimento</td>

			</tr>
			<c:forEach var="cliente" items="${listaPorDDD}">
				<tr>

					<td><c:out value="${cliente.nome}" /></td>
					<td><c:out value="${cliente.cpf}" /></td>
					<%
						//<td><fmt:formatDate value="${cliente.datanascimento}" type="both" pattern="dd/MM/yyyy HH:mm:ss"/></td>
					%>

				</tr>
			</c:forEach>
		</table>

	</div>
	<a href="index.jsp">Voltar</a>


</body>
</html>