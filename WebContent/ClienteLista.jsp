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
				
				<td>Nome</td>
				<td>CPF</td>
				<td>Data Nascimento</td>
				
			</tr>
			<c:forEach var="cliente" items="${listaCliente}">
				<tr>
					
					<td><c:out value= "${cliente.nome}"/></td>
					<td><c:out value="${cliente.cpf}" /></td>
					<td><fmt:formatDate value="${cliente.datanascimento}" type="both" pattern="dd/MM/yyyy"/></td>
					
				</tr>
			</c:forEach>
		</table>
				
	</div>
	<a href="index.jsp">Voltar</a>

</body>
</html>