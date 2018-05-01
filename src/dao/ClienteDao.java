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

			PreparedStatement pstm = conexao.prepareStatement("Delete from	cliente where nome = ? ");
			pstm.setString(1, cliente.getNome());
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
			ResultSet rs = stm.executeQuery("select * from cliente");
			while (rs.next()) {
				Cliente cli = new Cliente();
				cli.setNome(rs.getString("nome"));
				cli.setCpf(rs.getString("cpf"));
				cli.setDataNascimento(new java.sql.Date(rs.getDate("datanascimento").getTime()));
				
				lista.add(cli);
			}
			stm.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

	

	public List<Cliente> consultarPorDDD(Integer ddd) {

		Contato cont = new Contato();
		cont.setDDD(ddd);
		
		List<Cliente> lista = new ArrayList<>();
		try {
			PreparedStatement pstm = conexao
					.prepareStatement("select * from cliente e inner join contato c"
							+ "on e.id = id.codigo_cli  where c.DDD = ?");

			pstm.setInt(1, cont.getDDD());
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				
				Cliente recuperarDoBanco = new Cliente();

				recuperarDoBanco.setNome(rs.getString("nome"));
				recuperarDoBanco.setCpf(rs.getString("cpf"));
				recuperarDoBanco.setDataNascimento(new java.sql.Date(rs.getDate("datanascimento").getTime()));

				lista.add(recuperarDoBanco);
			}
			pstm.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
