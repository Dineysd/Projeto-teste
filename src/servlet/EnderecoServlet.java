package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EnderecoDao;
import entidade.Endereco;


@WebServlet("/enderecoServlet")
public class EnderecoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		EnderecoDao dao = new EnderecoDao();
		
		Endereco end = new Endereco(request.getParameter("logradouro"), Integer.parseInt(request.getParameter("numero")), 
				request.getParameter("bairro"), request.getParameter("cidade"), request.getParameter("cep"));

		
		try {
			dao.cadastrar(end);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("endereco", end);
		RequestDispatcher rd = request.getRequestDispatcher("/sucesso.jsp");
		rd.forward(request, response);
	}

}
