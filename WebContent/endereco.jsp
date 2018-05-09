<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div align="center" style="float: left; width: 32%;" id="teste1">

		<form method="post" action="enderecoServlet">
			<table title="Cadastro">
				<h1>Cadastro de Endereço!</h1>
				


				<tr>
					<td>Logradouro:</td>
					<td><input type="text" name="logradouro" autofocus="autofocus" value="${endereco.logradouro}" placeholder="Logradouro"></td>
				</tr>

				<tr>
					<td>Numero:</td>
					<td><input type="text" name="numero" autofocus="autofocus" value="${endereco.numero}" placeholder="numero"></td>
				</tr>
				
				<tr>
					<td>Bairro:</td>
					<td><input type="text" name="bairro" autofocus="autofocus" value="${endereco.bairro}" placeholder="numero"></td>
				</tr>

				<tr>
					<td>CEP:</td>
					<td><input type="text" name="cep" autofocus="autofocus"  value="${endereco.cep}" placeholder="CEP"></td>
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