<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/css.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>



	<div align="center" style="float: left; width: 32%;" id="teste1">

		<form method="post" action="ClienteServlet">
			<table title="Cadastro">
				<h1>Cadastro de Clientes!</h1>
				
				
				<tr>
					<td>Nome:</td>
					<td><input name="nome" autofocus="autofocus" placeholder="Nome"  value="${cliente.nome}"></td>
				</tr>
				<tr>
					<td>CPF:</td>
					<td><input name="cpf" autofocus="autofocus" placeholder="cpf"  value="${cliente.cpf}"></td>
				</tr>

				<tr>
					<td>Data nascimento:</td>
					<td><input  type="date" size="12" name="datanascimento" value="${cliente.datanascimento}"
					placeholder="10/10/2014"></td>
				</tr>

				<tr>
					<td>Telefone:</td>
					<td><input type="text" id="numero" name="numero" size="3"
						placeholder="DDD"> <input size="12" type="tel" name="telefone"
						 placeholder="9999-9999" value="${contato.telefone}"></td>
				</tr>

				<tr>
					<td>Logradouro:</td>
					<td><input type="text" name="logradouro" value="${endereco.logradouro}" placeholder="Logradouro"></td>
				</tr>

				<tr>
					<td>numero:</td>
					<td><input type="text" name="numero" value="${endereco.numero}" placeholder="numero"></td>
				</tr>

				<tr>
					<td>CEP:</td>
					<td><input type="text" name="cep"  value="${endereco.cep}" placeholder="CEP"></td>
				</tr>

				<tr>
					<td>CNPJ:</td>
					<td><input type="text" name="cnpj" value="${empresa.cnpj}" placeholder="CNPJ"></td>
				</tr>

				<tr>
					<td>Nome Empresa:</td>
					<td><input type="text" name="nome" value="${empresa.nome}" placeholder="Nome Empresa"></td>
				</tr>
				<tr>
					<td>Ação</td>
					<td><select name="acao" required>
							<option selected value="Incluir">Incluir</option>
							<option value="Excluir">Excluir</option>
							<option value="Consultar">Consultar</option></td>
					</select>
				</tr>
				<tr>
					<td><input type="submit" value="Enviar"> <input
						type="reset" value="Limpar"></td>
				</tr>

			</table>

		</form>
		
		<a href="index.jsp">Voltar</a>

	</div>
</body>
</html>

