package servlet;

import java.io.IOException;
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

import dao.ClienteDao;

import entidade.Cliente;

@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String destino = "sucesso.jsp";
		String mensagem = "";

		Cliente cli = new Cliente();

		ClienteDao dao = new ClienteDao();

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

		if (mensagem.length() == 0) {
			mensagem = "Cliente Cadastrado com sucesso!";
		} else {

			destino = "erro.jsp";
		}

		request.setAttribute("mensagem", mensagem);

		RequestDispatcher rd = request.getRequestDispatcher("/contatos.jsp");
		rd.forward(request, response);
	}

}
