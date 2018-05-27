package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConexaoDao;
import dao.ClienteDao;
import entidade.Cliente;
import entidade.Contato;

@WebServlet("/ClientePorDDD")
public class ClientePorDDD extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Contato cont = new Contato();
		cont.setDDD(Integer.parseInt(request.getParameter("ddd")));

		ClienteDao c = new ClienteDao();
		List<Cliente> lista = c.consultarPorDDD(cont);
		request.setAttribute("listas", lista);
		
		request.setAttribute("contatos", cont);

		RequestDispatcher rd = request.getRequestDispatcher("/listarPorDDD.jsp");
		rd.forward(request, response);

	}

}
