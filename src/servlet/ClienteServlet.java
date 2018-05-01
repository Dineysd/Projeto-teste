package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.classfile.Attribute;

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
		Empresa emp =new Empresa();
		Endereco ende = new Endereco();
		
		
		ContatosDao daoCont = new ContatosDao();
		EmpresaDao daoemp = new EmpresaDao();
		EnderecoDao daoEnde = new EnderecoDao();
		
		
		ClienteDao dao = new ClienteDao();
 
		
 
			//Se a ação for DIFERENTE de Listar são lidos os dados da tela
			if (!acao.equalsIgnoreCase("Listar")) {
				
				cli.setNome(request.getParameter("nome"));
				cli.setCpf(request.getParameter("cpf"));

						DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
						Date data;
						try {
							data = new Date(df2.parse(request.getParameter("datanascimento")).getTime());
							cli.setDataNascimento(data);
						} catch (ParseException e) {
							e.printStackTrace();
						}
					
					dao.inserir(cli);
					try {
						cont.setDDD(Long.parseLong(request.getParameter("DDD")));
						cont.setTelefone(request.getParameter("telefone"));
						
						daoCont.inserir(cont);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						emp.setNome(request.getParameter("nome"));
						emp.setCnpj(request.getParameter("cnpj"));
						
						daoemp.inserir(emp);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						ende.setCep(request.getParameter("cep"));
						ende.setLogradouro(request.getParameter("logradouro"));
						ende.setBairro(request.getParameter("bairro"));
						ende.setNumero(request.getParameter("numero"));
						
						daoEnde.cadastrar(ende);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					request.setAttribute("cliente", cli);
					request.setAttribute("contato", cont);
					request.setAttribute("empresa", emp);
					request.setAttribute("endereco", ende);
			
				destino = "cliente.jsp";
			} 
		
			
		
		if (mensagem.length() == 0) {
			mensagem = "Cliente Cadastrado com sucesso!";
		} else {
			
			destino = "erro.jsp";
		}
 
		// Lista todos os registros existente no Banco de Dados
		lista = dao.listar();
		
		request.setAttribute("listaCliente", lista);
		request.setAttribute("mensagem", mensagem);
 
 
		RequestDispatcher rd = request.getRequestDispatcher(destino);
		rd.forward(request, response);
	}
		
	
	
}
