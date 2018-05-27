package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dao.ClienteDao;
import dao.ContatosDao;
import dao.UtimoIdCliente;
import entidade.Cliente;
import entidade.Contato;

public class Teste_conexao {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
	
		Connection con = ConexaoDao.getConnection();
		//ClienteDao dao = new ClienteDao(con);
		//ContatosDao dao = new ContatosDao();
		
		//UtimoIdCliente cli = new UtimoIdCliente();
		//String s = cli.utimoidCliente().getId();
		Contato cont = new Contato();
		
		cont.setDDD(44);
		
		
		ClienteDao c = new ClienteDao();
		List<Cliente> lista = c.consultarPorDDD(cont);
		
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		
		
		for(Cliente cli : lista){
			
			System.out.println(cli.getNome() );
			System.out.println(cli.getCpf() );
			System.out.println(formatador.format(cli.getDataNascimento()));
			System.out.println(formatador.format(cli.getDataEmpresa()));
			
		};
		

	}

}
