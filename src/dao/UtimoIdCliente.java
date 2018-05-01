package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.ConexaoDao;

public class UtimoIdCliente {
	
	public Integer utimoidCliente() throws Exception {
		Connection con = ConexaoDao.getConnection();
		
		Integer idCliente = null;
		PreparedStatement stmt = con
				.prepareStatement("select max(idContrato) as maximo from cliente");
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			idCliente = rs.getInt("maximo");
		}
		stmt.close();
		return idCliente;
	}

}
