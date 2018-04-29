package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoDao;
import entidade.Cliente;
import entidade.Contato;

public class ClienteDao {

	Connection con = ConexaoDao.getConnection();

	public void cadastrar(Cliente cliente) throws SQLException {
		String sql = "insert into cliente(nome, cpf, datanascimento) values(?, ?, ?)";
		try {
			PreparedStatement preparar = con.prepareStatement(sql);
			preparar.setString(1, cliente.getNome());
			preparar.setString(2, cliente.getCpf());
			preparar.setString(3, cliente.getDataNacimento());
			preparar.execute();
			preparar.close();
			System.out.println("cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> findBysDDD(Contato contato) throws SQLException {
		Cliente recuperarDoBanco = null;
		List<Cliente> lista = new ArrayList<>();
		try {
			PreparedStatement selecionarOsclientes = con
					.prepareStatement("select id,nome,cpf from cliente e inner join contato c"
							+ "on e.id = id.codigo_cli  where DDD = " + contato.getDDD());

			ResultSet result = selecionarOsclientes.executeQuery();

			if (result.next()) {
				recuperarDoBanco = new Cliente(result.getString("nome"), result.getString("cpf"),
						result.getString("dataNascimento"));
				lista.add(recuperarDoBanco);
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar Cliente " + e.getMessage());
		}
		
		return lista;
	}

}
