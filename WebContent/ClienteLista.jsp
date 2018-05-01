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

<div align="center">
		<P>Lista de Clientes</P>
		<table border="1">
			<tr>
				<td>id</td>
				<td>Nome</td>
				<td>CPF</td>
				<td>Data Nascimento</td>
				<td>Comandos</td>
			</tr>
			<c:forEach var="cliente" items="${listaCliente}">
				<tr>
					<td>${cliente.id}</td>
					<td>${cliente.nome}</td>
					<td>${cliente.cpf}</td>
					<td><fmt:formatDate value="${cliente.datanascimento}" type="both" pattern="dd/MM/yyyy"/>  
					<td><a href="AlunoServlet?acao=Excluir&id=${cliente.id}">Excluir</a></td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${fn:length(listaCliente) > 0}">
   		Existem ${fn:length(listaCliente)} Clientes!
 		</c:if><br> 		
	</div>
	<a href="menu.jsp">Voltar</a>

</body>
</html>