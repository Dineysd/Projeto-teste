package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import dao.ContatosDao;
import dao.EmpresaDao;
import dao.EnderecoDao;
import entidade.Cliente;
import entidade.Contato;
import entidade.Empresa;
import entidade.Endereco;

@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String destino = "sucesso.jsp";
		String mensagem = "";
		List<Cliente> lista = new ArrayList<>();
		List<Cliente> lista2 = new ArrayList<>();
 
 
		Cliente cli = new Cliente();
		Contato cont = new Contato();
		Empresa emp = new Empresa();
		Endereco ende = new Endereco();
		
		ClienteDao dao = new ClienteDao();
		ContatosDao dao2 = new ContatosDao();
		EmpresaDao dao3 = new EmpresaDao();
		EnderecoDao dao4 = new EnderecoDao();
 
		try {
 
			//Se a ação for DIFERENTE de Listar são lidos os dados da tela
			if (!acao.equalsIgnoreCase("Listar")) {
				
				cli.setNome(request.getParameter("nome"));
				cli.setCpf(request.getParameter("cpf"));
				
				cont.setDDD(Integer.parseInt(request.getParameter("DDD")));
				cont.setTelefone(request.getParameter("telefone"));
				
				ende.setLogradouro(request.getParameter("logradouro"));
				ende.setBairro(request.getParameter("bairro"));
				ende.setCep(request.getParameter("cep"));
				ende.setNumero(request.getParameter("numero"));
				
				emp.setCnpj(request.getParameter("cnpj"));
				emp.setNome(request.getParameter("nome"));
				
					DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");					
					cli.setDataNascimento(df2.parse(request.getParameter("datanascimento")));
				
 
			}
 
			if (acao.equalsIgnoreCase("Incluir")) {
				
				if (dao.existe(cli)) {
					mensagem = "cliente informado já existe!";
					
				} else {
					dao.inserir(cli);
					dao2.cadastrar(cont);
					dao3.cadastrar(emp);
					dao4.cadastrar(ende);
				}
			} else  if (acao.equalsIgnoreCase("Excluir")) {
				dao.excluir(cli);
				destino = "cliente.jsp";
			} 
		} catch (Exception e) {
			mensagem += e.getMessage();
			destino = "erro.jsp";
			e.printStackTrace();
		}
 
		
		if (mensagem.length() == 0) {
			mensagem = "Cliente Cadastrado com sucesso!";
		} else {
			destino = "erro.jsp";
		}
		
		cont.setDDD(Integer.parseInt(request.getParameter("DDD")));
 
		// Lista todos os registros existente no Banco de Dados
		lista = dao.listar();
		
		request.setAttribute("listaCliente", lista);
		request.setAttribute("mensagem", mensagem);
 
 
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}

}
