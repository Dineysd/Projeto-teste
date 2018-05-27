package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConexaoDao;
import dao.ClienteDao;
import dao.ContatosDao;
import entidade.Cliente;
import entidade.Contato;

@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection conexao = ConexaoDao.getConnection();

		Contato cont = new Contato();
		Cliente cli = new Cliente();

		// ----CONTATO
		Integer ddd = Integer.parseInt(request.getParameter("ddd"));
		String fone = request.getParameter("telefone");

		// ----ENDEREÇO
		String loga = request.getParameter("logradouro");
		Integer numero = Integer.parseInt(request.getParameter("numero"));
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String cep = request.getParameter("cep");

		// ----CLIENTE
		String nome = request.getParameter("nome");
		String cpfCnpj = request.getParameter("cpf");
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat df3 = new SimpleDateFormat("dd/MM/yyyy");
		cli.adicionarContatos(ddd, fone);
		cli.setEnderecos(loga, numero, bairro, cidade, cep);

		try {
			ClienteDao dao = new ClienteDao(conexao);

			Cliente clientes = new Cliente(nome, cpfCnpj, df.parse(request.getParameter("datanascimento")),
					df3.parse(request.getParameter("dataemp")), cli.getEnderecos(), cli.getContatos());

			dao.save(clientes);

			request.setAttribute("cliente", clientes);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		


		RequestDispatcher rd = request.getRequestDispatcher("/mensagem.jsp");
		rd.forward(request, response);
	}

}
