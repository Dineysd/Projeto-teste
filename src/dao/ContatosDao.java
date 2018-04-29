package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConexaoDao;
import entidade.Contato;


public class ContatosDao {
	
	Connection con = ConexaoDao.getConnection();

	public void cadastrar(Contato contato) throws SQLException {
		String sql = "insert into endereco(id,DDD,telefone,codigo_cliente) values(?,?,?,?,?)";
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setInt(1, contato.getId());
			preparar.setInt(2, contato.getDDD());
			preparar.setString(3, contato.getTelefone());
			preparar.setInt(5, contato.getCodigo_cli());
			
			preparar.execute();
			preparar.close();
			System.out.println("cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
