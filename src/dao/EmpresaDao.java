package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConexaoDao;
import entidade.Empresa;


public class EmpresaDao {
	
	Connection con = ConexaoDao.getConnection();

	public void cadastrar(Empresa empresa) throws SQLException {
		String sql = "insert into endereco(id,cnpj,nome,codigo_cliente) values(?,?,?,?,?)";
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setInt(1, empresa.getId());
			preparar.setString(2, empresa.getCnpj());
			preparar.setString(3, empresa.getNome());
			preparar.setInt(4, empresa.getClienteCodigo());
			
			preparar.execute();
			preparar.close();
			System.out.println("cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
