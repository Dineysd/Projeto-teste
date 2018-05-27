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
				.prepareStatement("select max(id) as maximo from cliente");
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			
			idCliente.setId(rs.getString("maximo"));

		}
		stmt.close();
		
		return idCliente;
		
	}

}
