package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatosDao;
import entidade.Contato;

@WebServlet("/contatoServlet")
public class ContatoServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		Contato cont = new Contato();
		
		ContatosDao cdao = new ContatosDao();
		
		cont.setDDD(Long.parseLong(request.getParameter("DDD")));
		cont.setTelefone(request.getParameter("telefone"));
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/endereco.jsp");
		rd.forward(request, response);
	}

}
