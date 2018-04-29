package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConexaoDao;
import entidade.Endereco;

public class EnderecoDao {
	
	Connection con = ConexaoDao.getConnection();

	public void cadastrar(Endereco endereco) throws SQLException {
		String sql = "insert into endereco(logradouro,numero,bairro,cep,codigo_cliente) values(?,?,?,?,?)";
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setString(1, endereco.getLogradouro());
			preparar.setString(2, endereco.getNumero());
			preparar.setString(3, endereco.getBairro());
			preparar.setString(4, endereco.getCep());
			preparar.setInt(5, endereco.getCliente());
			
			preparar.execute();
			preparar.close();
			System.out.println("cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
