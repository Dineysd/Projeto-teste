package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConexaoDao;
import entidade.Contato;

public class ContatosDao {

	Connection con = ConexaoDao.getConnection();
	

	public void inserir(Contato contato) throws SQLException {

		try {
			UtimoIdCliente cliente = new UtimoIdCliente();
			
			String sql = "insert into contato(id, ddd, telefone, cliente_id) values(?, ?, ?, ?)";

			PreparedStatement preparar = con.prepareStatement(sql);
            preparar.setString(1, contato.getId());
			preparar.setLong(2, contato.getDDD());
			preparar.setString(3, contato.getTelefone());
			preparar.setString(4, cliente.utimoidCliente().getId());

			preparar.execute();
			preparar.close();
			System.out.println("cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
