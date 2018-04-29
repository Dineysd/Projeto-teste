<%@page import="entidade.Contato"%>
<%@page import="dao.ClienteDao"%>
<%@page import="entidade.Cliente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina - Salvar cadastro</title>
</head>
<body>
<%

String snome = request.getParameter("nome");
String scpf = request.getParameter("cpf");
String sdataNascimento = request.getParameter("datanascimento");

String sddd = request.getParameter("DDD");
String stelefone = request.getParameter("telefone");



Cliente cli = new Cliente(snome,scpf,sdataNascimento);

ClienteDao clien = new ClienteDao();
clien.cadastrar(cli);


Contato cont = new Contato();

cont.setDDD(Integer.parseInt(sddd));
cont.setTelefone(stelefone);




%>

<h1>Salvo com Sucesso!</h1>

</body>
</html>