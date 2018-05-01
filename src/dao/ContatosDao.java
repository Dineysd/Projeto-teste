package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConexaoDao;
import entidade.Contato;


public class ContatosDao {
	
	Connection con = ConexaoDao.getConnection();
	private UtimoIdCliente cliente;

	public void inserir(Contato contato) throws SQLException {
		String sql = "insert into endereco(DDD, telefone, codigo_cli) values(?, ?, ?)";
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setLong(1, contato.getDDD());
			preparar.setString(2, contato.getTelefone());
			preparar.setInt(3, cliente.utimoidCliente());
			
			preparar.execute();
			preparar.close();
			System.out.println("cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
