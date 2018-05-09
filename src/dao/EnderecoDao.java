package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConexaoDao;
import entidade.Endereco;

public class EnderecoDao {

	Connection con = ConexaoDao.getConnection();
	private UtimoIdCliente cliente;

	public void cadastrar(Endereco endereco) throws SQLException {

		try {
			String sql = "INSERT INTO endereco(logradouro, numero, bairro, cep, codigo_cliente) "
					+ "VALUES (?, ?, ?, ?, ?)";

			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setString(1, endereco.getLogradouro());
			preparar.setString(2, endereco.getNumero());
			preparar.setString(3, endereco.getBairro());
			preparar.setString(4, endereco.getCep());
			preparar.setLong(5, cliente.utimoidCliente().getId());

			preparar.execute();
			preparar.close();
			System.out.println("cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
