<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/css.css" rel="stylesheet" />
<script type="text/javascript" src="js/javascript/validar.js"></script>


<title>Insert title here</title>
</head>
<body>

	<div align="center" style="float: left; width: 32%;">

		<form method="post" action="ClienteServlet" name="form" id="form" >
			<table title="Cadastro">
				<h1>Cadastro de Clientes!</h1>
				
				
				<tr>
					<td>Nome:</td>
					<td><input type="text" name="nome" id="nome" autofocus="autofocus" placeholder="Nome"  value="${cliente.nome}"></td>
					
				</tr>
				<tr>
					<td>CPF:</td>
					<td><input type="text" name="cpf" id="cpf" autofocus="autofocus" placeholder="cpf"  value="${cliente.cpf}"></td>
				</tr>

				<tr>
					<td>Data nascimento:</td>
					<td><input  type="text"  name="datanascimento" id="datanascimento" autofocus="autofocus" 
					placeholder="10/10/2014"></td>
				</tr>
				
				<tr>
					<td>CNPJ:</td>
					<td><input type="text" name="cnpj" id="cnpj" value="${empresa.cnpj}" placeholder="CNPJ"></td>
				</tr>

				<tr>
					<td>Nome Empresa:</td>
					<td><input type="text" name="nomemp" id="nomemp" value="${empresa.nome}" placeholder="Nome Empresa"></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="enviar" name="enviar" id="enviar"> <input
						type="reset" value="Limpar"></td>
				</tr>

			</table>

		</form>
		
		<a href="index.jsp">Voltar</a>
		<a href="contatos.jsp">novo Contato</a>

	</div>
</body>
</html>

