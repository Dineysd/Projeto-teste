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

		try {
			String sql = "insert into contato(ddd, telefone, codigo_cli) values(?, ?, ?)";

			PreparedStatement preparar = con.prepareStatement(sql);

			preparar.setLong(1, contato.getDDD());
			preparar.setString(2, contato.getTelefone());
			preparar.setLong(3, cliente.utimoidCliente().getId());

			preparar.execute();
			preparar.close();
			System.out.println("cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
