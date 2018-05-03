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
		
		ClienteDao dao = new ClienteDao();
 
		
 
			//Se a ação for DIFERENTE de Listar são lidos os dados da tela
			if (!acao.equalsIgnoreCase("Listar")) {
				
				cli.setNome(request.getParameter("nome"));
				cli.setCpf(request.getParameter("cpf"));

						
						
						try {
							DateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
							cli.setDataNascimento(df2.parse(request.getParameter("datanascimento")));
							
						} catch (ParseException e) {
							e.printStackTrace();
						}
					
					dao.inserir(cli);
					
					request.setAttribute("cliente", cli);
					
			
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
