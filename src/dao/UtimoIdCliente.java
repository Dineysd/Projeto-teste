package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.ConexaoDao;
import entidade.Cliente;

public class UtimoIdCliente {
	Cliente idCliente = new Cliente();
	
	public Cliente utimoidCliente() throws Exception {
		Connection con = ConexaoDao.getConnection();
		
		PreparedStatement stmt = con
				.prepareStatement("select max(id) from cliente");
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			
			idCliente.setId(Long.parseLong(rs.getString("id")));

		}
		stmt.close();
		return idCliente;
		
	}

}
