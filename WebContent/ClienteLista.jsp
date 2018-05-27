<%@page import="entidade.Cliente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Clientes</title>
</head>
<body>
	<form method="post" action="listaClientes">

		<fieldset>
			<legend>
				<strong>Lista de Clientes</strong>
			</legend>
			<table align="center" border="1" width="80%">
				<tr>

					<td>Nome</td>
					<td>CPF</td>
					<td>Data Nascimento</td>
					<td>Data Empresa</td>

				</tr>
				<%
					try {
						List<Cliente> listas = (List<Cliente>) request.getAttribute("listas");
						java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");

						for (Cliente cli : listas) {
				%>
				<tr>

					<td><%=cli.getNome()%></td>
					<td><%=cli.getCpf()%></td>
					<td><%=df.format(cli.getDataNascimento())%></td>
					<td><%=df.format(cli.getDataEmpresa())%></td>

				</tr>
				<%
					}
					} catch (Exception e) {
						
					}
				%>
			</table>
		</fieldset>

	</form>
	<a href="index.jsp">Voltar</a>

</body>
</html>