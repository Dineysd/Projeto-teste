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

	<h1>Cadastro de Clientes!</h1>

	
		<div style="float: left; width: 32%;" id="teste1">

			<form method="post" action="CadastroSalvo.jsp" >
				<table title="Cadastro">
					
					<tr>
						<td>Nome:</td>
						<td><input type="text" name="nome"></td>
					</tr>
					<tr>
						<td>CPF:</td>
						<td><input type="text"  name="cpf"></td>
					</tr>

					<tr>
						<td>Data nascimento:</td>
						<td><input type="text" 
							name="datanascimento">
						</td>
					</tr>
					
					<tr>
						<td>Telefone:</td>
						<td><input type="text" id="numero" name="numero" size="3" placeholder="DDD">  
							<input size="12"type="text" name="numero"></td>
					</tr>

					<tr>
						<td>Logradouro:</td>
						<td><input type="text" name="logradouro"></td>
					</tr>
					
					<tr>
						<td>numero:</td>
						<td> <input type="text" name="numero"></td>
					</tr>
					
					<tr>
						<td>CEP:</td>
						<td><input type="text" name="cep"></td>
					</tr>
					
					<tr>
						<td>CNPJ:</td>
						<td><input type="text"  name="cnpj"></td>
					</tr>
					
					<tr>
						<td>Nome Empresa:</td>
						<td><input type="text"  name="nome"></td>
					</tr>
					
					<tr>
						<td />
						<td><input type="submit" value="Salvar"  /> 
						</td>
					</tr>
				</table>

			</form>

		</div>
</body>
</html>