package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoDao;
import entidade.Cliente;
import entidade.Contato;
import entidade.Endereco;

public class ClienteDao {
	Connection conexao = ConexaoDao.getConnection();
	
	public ClienteDao() {
	}

	public ClienteDao(Connection conexão) throws SQLException{
		
		this.conexao.createStatement().execute(
				"create table if not exists cliente ("
						+ "id varchar(46) not null,"
						+ "nome varchar(50) not null,"
						+ "datanacimento date not null,"
						+ "dataempresa date not null,"
						+ "cpf varchar(20) not null unique,"
						+ "primary key(id)"
						+ ")");
		this.conexao.createStatement().execute(
				"create table if not exists contato ("
						+ "id varchar(46) not null,"
						+ "ddd integer not null,"
						+ "telefone varchar(36) not null,"
						+ "cliente_id varchar(36) not null,"
						+ "foreign key (cliente_id) references cliente (id),"
						+ "primary key(id)"
						+ ")");
		this.conexao.createStatement().execute(
				"create table if not exists endereco ("
						+ "id varchar(46) not null,"
						+ "logradouro varchar(50) not null,"
						+ "numero integer not null,"
						+ "bairro varchar(50) not null,"
						+ "cidade varchar(50) not null,"
						+ "cep varchar(20) not null,"
						+ "cliente_end_id varchar(36) not null,"
						+ "foreign key (cliente_end_id) references cliente (id),"
						+ "primary key(id)"
						+ ")");
	}
	
	public void save(Cliente cliente) throws SQLException {
		String sql = "insert into cliente( id, nome, datanacimento, dataempresa, cpf) "
				+ "values (?, ?, ?, ?, ?) ";
		PreparedStatement insertPedido = conexao.prepareStatement(sql);
		insertPedido.setString(1, cliente.getId());
		insertPedido.setString(2, cliente.getNome());
		insertPedido.setDate(3,new java.sql.Date(cliente.getDataNascimento().getTime()));
		insertPedido.setDate(4,new java.sql.Date(cliente.getDataEmpresa().getTime()));
		insertPedido.setString(5, cliente.getCpf());
		
		insertPedido.execute();
		
		
		for (Contato contatos : cliente.getContatos()) {
			sql = "insert into contato ( id, ddd, telefone,"
					+ " cliente_id) values(?, ?, ?, ? )";
			PreparedStatement insertCont = conexao.prepareStatement(sql);
			insertCont.setString(1, contatos.getId());
			insertCont.setInt(2, contatos.getDDD());
			insertCont.setString(3, contatos.getTelefone());
			insertCont.setString(4, cliente.getId());
			
			
			insertCont.execute();
			
		}
		
		for (Endereco ende : cliente.getEnderecos()) {
			sql = "insert into endereco (id, logradouro, numero,"
					+ "bairro, cidade, cep, cliente_end_id) values(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement inserirEnd = conexao.prepareStatement(sql);
			inserirEnd.setString(1, ende.getId());
			inserirEnd.setString(2, ende.getLogradouro());
			inserirEnd.setInt(3, ende.getNumero());
			inserirEnd.setString(4, ende.getBairro());
			inserirEnd.setString(5, ende.getCidade());
			inserirEnd.setString(6, ende.getCep());
			inserirEnd.setString(7, cliente.getId());
			
			
			inserirEnd.execute();
			inserirEnd.close();
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
				cli.setDataNascimento(new java.util.Date(rs.getDate("datanacimento").getTime()));
				cli.setDataEmpresa(new java.util.Date(rs.getDate("dataempresa").getTime()));

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
					"SELECT * FROM cliente c inner join contato e on  c.id = e.cliente_id where ddd = ?");

			pstm.setInt(1, contato.getDDD());
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {

				Cliente recuperarDoBanco = new Cliente();

				recuperarDoBanco.setNome(rs.getString("nome"));
				recuperarDoBanco.setCpf(rs.getString("cpf"));
				recuperarDoBanco.setDataNascimento(new java.util.Date(rs.getDate("datanacimento").getTime()));
				recuperarDoBanco.setDataEmpresa(new java.util.Date(rs.getDate("dataempresa").getTime()));
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
