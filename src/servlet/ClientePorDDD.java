package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;

@WebServlet("/ClientePorDDD")
public class ClientePorDDD extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer n = Integer.parseInt(request.getParameter("DDD"));

		ClienteDao c = new ClienteDao();

		try {

			RequestDispatcher rd = request.getRequestDispatcher("/listarPorDDD.jsp");
			request.setAttribute("listaPorDDD", c.consultarPorDDD(n));
			rd.forward(request, response);
		} catch (Exception e) {
			e.getMessage();
		}

	}

}