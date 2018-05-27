<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/javascript/validarcontato.js"></script>

<title>Insert title here</title>
</head>
<body>

	<div align="center" style="float: left; width: 32%;" >

		<form method="post" action="contatoServlet" name="form2" id="form2" onsubmit="validarForm2(this); return false;">
			<table title="Cadastro">
				<h1>Cadastro de Contatos!</h1>


				<tr>
					<td>Telefone (DDD):</td>
					<td><input type="text" name="ddd" id="ddd" autofocus="autofocus"
						size="3" placeholder="DDD" value="${contato.ddd}"> <input
						size="12" type="text" name="telefone" id="telefone" autofocus="autofocus"
						placeholder="9999-9999" value="${contato.telefone}"></td>
				</tr>


				<tr>
					<td><input type="submit" value="Enviar" name="enviar2" id="enviar2"> <input
						type="reset" value="Limpar"></td>
				</tr>

			</table>

		</form>

		<a href="index.jsp">Voltar</a>

	</div>

</body>
</html>