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

<style type="text/css">
.msg-erro {
	color: red;
}
</style>


<title>Insert title here</title>
</head>
<body>

	<div align="center" style="float: left; width: 32%;">

		<form method="post" action="ClienteServlet" name="form" id="form"
			onsubmit="validarForm(this); return false;">
			<table title="Cadastro">
				<h1>Cadastro de Clientes!</h1>


				<tr>
					<td>Nome:</td>
					<td><input type="text" name="nome" id="nome"
						autofocus="autofocus" placeholder="Nome" value="${cliente.nome}"></td>

				</tr>
				<tr>
					<td>CPF/CNPJ:</td>
					<td><input type="text" name="cpf" id="cpf"
						autofocus="autofocus" placeholder="cpf" value="${cliente.cpf}"></td>

				</tr>

				<tr>
					<td>Data nascimento:</td>
					<td><input type="text" name="datanascimento"
						id="datanascimento" autofocus="autofocus" placeholder="00/00/0000"></td>

				</tr>


				<tr>
					<td>Data Empresa:</td>
					<td><input type="text" name="dataemp" id="dataemp"
						autofocus="autofocus" placeholder="00/00/0000"></td>
				</tr>
				
				<tr>
					<td>Telefone (DDD):</td>
					<td><input type="text" name="ddd" id="ddd" autofocus="autofocus"
						size="3" placeholder="DDD" value="${cliente.ddd}"> <input
						size="12" type="text" name="telefone" id="telefone" autofocus="autofocus"
						placeholder="9999-9999" value="${cliente.telefone}"></td>
				</tr>
				
				<tr>
					<td>Logradouro:</td>
					<td><input type="text" name="logradouro" id="logradouro" autofocus="autofocus" value="${cliente.logradouro}" placeholder="Logradouro"></td>
				</tr>

				<tr>
					<td>Numero:</td>
					<td><input type="text" name="numero" id="numero" autofocus="auto focus" value="${cliente.numero}" placeholder="numero"></td>
				</tr>
				
				<tr>
					<td>Bairro:</td>
					<td><input type="text" name="bairro" id="bairro" autofocus="autofocus" value="${cliente.bairro}" placeholder="numero"></td>
					
				</tr>
				<tr>
					<td>Cidade:</td>
					<td><input type="text" name="cidade" id="cidade" autofocus="autofocus"  value="${cliente.cidade}" placeholder="cidade"></td>
				</tr>

				<tr>
					<td>CEP:</td>
					<td><input type="text" name="cep" id="cep" autofocus="autofocus"  value="${cliente.cep}" placeholder="CEP"></td>
				</tr>

				<tr>
					<td><input type="submit" value="enviar" name="enviar"
						id="enviar"> <input type="reset" value="Limpar"></td>
				</tr>

			</table>

		</form>

		<a href="index.jsp">Voltar</a>
	</div>
</body>
</html>

