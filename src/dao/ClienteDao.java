package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoDao;
import entidade.Cliente;
import entidade.Contato;

public class ClienteDao {
	Connection conexao = ConexaoDao.getConnection();

	public void inserir(Cliente cliente) {
		try {

			String sql ="Insert into cliente (nome, cpf, datanascimento, dataemp) values (?, ?, ?, ?)";
			PreparedStatement pstm = conexao
					.prepareStatement(sql);

			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCpf());
			pstm.setDate(3, new java.sql.Date(cliente.getDataNascimento().getTime()));
			pstm.setDate(4, new java.sql.Date(cliente.getDataEmpresa().getTime()));

			pstm.execute();

			for (Contato contatos : cliente.getContatos()) {
				sql = "insert into contato (ddd, telefone, cliente_id) values(?, ?, ?);";
				
				PreparedStatement cli_contato = conexao.prepareStatement(sql);

				cli_contato.setInt(1, contatos.getDDD());
				cli_contato.setString(2, contatos.getTelefone());
				cli_contato.setLong(3, cliente.getId());

				cli_contato.execute();
				pstm.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> listar() {

		List<Cliente> lista = new ArrayList<>();
		try {

			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("select * from cliente");
			while (rs.next()) {
				Cliente cli = new Cliente();
				cli.setNome(rs.getString("nome"));
				cli.setCpf(rs.getString("cpf"));
				cli.setDataNascimento(new java.util.Date(rs.getDate("datanascimento").getTime()));

				lista.add(cli);
			}
			stm.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public List<Cliente> consultarPorDDD(Contato contato) {

		List<Cliente> lista = new ArrayList<>();
		try {
			PreparedStatement pstm = conexao.prepareStatement(
					"SELECT * FROM cliente c inner join contato e on  c.id = e.codigo_cli where DDD = ?");

			pstm.setLong(1, contato.getDDD());
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {

				Cliente recuperarDoBanco = new Cliente();

				recuperarDoBanco.setNome(rs.getString("nome"));
				recuperarDoBanco.setCpf(rs.getString("cpf"));
				recuperarDoBanco.setDataNascimento(new java.util.Date(rs.getDate("datanascimento").getTime()));
				// recuperarDoBanco.setDataEmpresa(new
				// java.util.Date(rs.getDate("dataemp").getTime()));
				System.out.println();
				lista.add(recuperarDoBanco);
			}
			pstm.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
