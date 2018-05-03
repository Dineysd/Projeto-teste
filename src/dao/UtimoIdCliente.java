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
				.prepareStatement("select max(id) as maximo from cliente");
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			if(rs.getInt("maximo") > 0)
			idCliente = rs.getInt("maximo");
			else
				System.out.println("a tabela não possui valor");
		}
		stmt.close();
		return idCliente;
	}

}
