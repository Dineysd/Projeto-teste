<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
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
					<td><input type="text" name="ddd" id="ddd" autofocus="autofocus" placeholder="DDD"  size="3" 
						value="${ddd}"></td>
				</tr>

				<tr>
					<td><input type="submit" value="Enviar"> <input
						type="reset" value="Limpar"></td>
				</tr>
			</table>
		</form>

	</div>

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
			try{
			    List<Cliente> listas = (List<Cliente>) request.getAttribute("listas");
				java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy");
			
			
			
				for(Cliente cli : listas){
			%>
			<tr>

				<td><%=cli.getNome()%></td>
				<td><%=cli.getCpf()%></td>
				<td><%=df.format(cli.getDataNascimento())%></td>
				<td><%=df.format(cli.getDataEmpresa())%></td>

			</tr>
			<%
				}
			}catch(Exception e){
		
			}
			%>
		</table>
	</fieldset>

	<a href="index.jsp">Voltar</a>


</body>
</html>