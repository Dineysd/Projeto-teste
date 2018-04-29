package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConexaoDao;
import entidade.Contato;


public class ContatosDao {
	
	Connection con = ConexaoDao.getConnection();

	public void cadastrar(Contato contato) throws SQLException {
		String sql = "insert into endereco(DDD, telefone, codigo_cliente) values(?, ?, ?)";
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setInt(1, contato.getDDD());
			preparar.setString(2, contato.getTelefone());
			preparar.setInt(3, contato.getCodigo_cli().getId());
			
			preparar.execute();
			preparar.close();
			System.out.println("cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
