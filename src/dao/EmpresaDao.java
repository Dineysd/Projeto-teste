package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConexaoDao;
import entidade.Empresa;


public class EmpresaDao {
	
	Connection con = ConexaoDao.getConnection();
	private UtimoIdCliente cliente;

	public void inserir(Empresa empresa) throws SQLException {
		String sql = "insert into endereco(cnpj, nome, codigo_cliente) values(?, ?, ?)";
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
		
			preparar.setString(1, empresa.getCnpj());
			preparar.setString(2, empresa.getNome());
			preparar.setInt(3, cliente.utimoidCliente());
			
			preparar.execute();
			preparar.close();
			System.out.println("cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
