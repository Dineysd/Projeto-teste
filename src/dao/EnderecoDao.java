package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConexaoDao;
import entidade.Endereco;

public class EnderecoDao {

	Connection con = ConexaoDao.getConnection();
	

	public void cadastrar(Endereco endereco) throws SQLException {

		try {
			UtimoIdCliente cliente = new UtimoIdCliente();
			
			String sql = "insert into endereco (id, logradouro, numero,"
					+ "bairro, cidade, cep, cliente_end_id) values(?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setString(1, endereco.getId());
			preparar.setString(2, endereco.getLogradouro());
			preparar.setInt(3, endereco.getNumero());
			preparar.setString(4, endereco.getBairro());
			preparar.setString(5, endereco.getCidade());
			preparar.setString(6, endereco.getCep());
			preparar.setString(7, cliente.utimoidCliente().getId());

			preparar.execute();
			preparar.close();
			System.out.println("Endereço cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
