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

	public void excluir(Cliente cliente) {
		try {

			PreparedStatement pstm = conexao.prepareStatement("Delete from	cliente where id = ? ");
			pstm.setLong(1, cliente.getId());
			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean existe(Cliente cliente) {
		boolean achou = false;
		try {

			PreparedStatement pstm = conexao.prepareStatement("Select * from cliente where nome =	?");
			pstm.setString(1, cliente.getNome());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				achou = true;
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return achou;
	}

	public void inserir(Cliente cliente) {
		try {

			PreparedStatement pstm = conexao
					.prepareStatement("Insert into	cliente (nome, cpf, datanascimento) values (?,?,?)");

			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCpf());

			pstm.setDate(3, new java.sql.Date(cliente.getDataNascimento().getTime()));

			pstm.execute();
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Cliente> listar() {
		List<Cliente> lista = new ArrayList<>();
		try {

			Statement stm = conexao.createStatement();
			ResultSet rs = stm.executeQuery("Select * from cliente");
			while (rs.next()) {
				
				Cliente cli = new Cliente();
				cli.setNome(rs.getString("nome"));
				cli.setCpf(rs.getString("cpf"));
				cli.setDataNascimento(new java.util.Date(rs.getDate("datanascimento").getTime()));
				
				lista.add(cli);
			}
			stm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	public Cliente consultar(Cliente cliente) {
		try {
			PreparedStatement pstm = conexao.prepareStatement("Select * from cliente where DDD =	?");
			pstm.setInt(1, cliente.getId());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {

				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));

				cliente.setDataNascimento(new java.util.Date(rs.getDate("datanascimento").getTime()));
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cliente;
	}

	public List<Cliente> consultarPorDDD(Contato contato) {

		Cliente recuperarDoBanco = null;
		List<Cliente> lista = new ArrayList<>();
		try {
			PreparedStatement pstm = conexao
					.prepareStatement("select e.id,e.nome,e.cpf,c.telefone from cliente e inner join contato c"
							+ "on e.id = id.codigo_cli  where DDD = ?");

			pstm.setInt(1, contato.getDDD());
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {

				recuperarDoBanco.setNome(rs.getString("nome"));
				recuperarDoBanco.setCpf(rs.getString("cpf"));
				recuperarDoBanco.setDataNascimento(new java.util.Date(rs.getDate("datanascimento").getTime()));

				lista.add(recuperarDoBanco);
			}
			pstm.close();
			conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
