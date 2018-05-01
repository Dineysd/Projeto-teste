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

 
				//Faz a leitura da data de cadastro. Caso ocorra um erro de formatação
				// o sistema utilizará a data atual
				try {
					DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");					
					cli.setDataNascimento(df2.parse(request.getParameter("datanascimento")));
				} catch (Exception e) {
					System.out.println("erro na data de nascimento "+ e);;	
				}
 
			}
 
			if (acao.equalsIgnoreCase("Incluir")) {
				// Verifica se a matrícula informada já existe no Banco de Dados
				// Se existir enviar uma mensagem senão faz a inclusão
				if (dao.existe(cli)) {
					mensagem = "id informada já existe!";
					
				} else {
					dao.inserir(cli);
					dao2.cadastrar(cont);
					dao3.cadastrar(emp);
					dao4.cadastrar(ende);
				}
			} else  if (acao.equalsIgnoreCase("Excluir")) {
				dao.excluir(cli);
			} else if (acao.equalsIgnoreCase("Consultar")) {
				request.setAttribute("cliente", cli);
				
				cli = dao.consultar(cli);
				
				destino = "cliente.jsp";
			}
		} catch (Exception e) {
			mensagem += e.getMessage();
			destino = "erro.jsp";
			e.printStackTrace();
		}
 
		// Se a mensagem estiver vazia significa que houve sucesso!
		// Senão será exibida a tela de erro do sistema.
		if (mensagem.length() == 0) {
			mensagem = "Cliente Cadastrado com sucesso!";
		} else {
			destino = "erro.jsp";
		}
 
		// Lista todos os registros existente no Banco de Dados
		lista = dao.listar();
		request.setAttribute("listaCliente", lista);
		request.setAttribute("mensagem", mensagem);
 
 
		//O sistema é direcionado para a página 
		//sucesso.jsp Se tudo ocorreu bem
		//erro.jsp se houver algum problema.
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}

}
