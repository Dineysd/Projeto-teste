package entidade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Cliente {

	private String id;
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private Date dataEmpresa;
	private List<Endereco> enderecos = new ArrayList<>();
	private List<Contato> contatos = new ArrayList<>();
	
	public Cliente() {
		this.id = UUID.randomUUID().toString();
	}
	
	public Cliente(String nome, String cpf, Date dataNascimento, Date dataEmpresa, List<Endereco> enderecos,
			List<Contato> contatos) {
		this();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.dataEmpresa = dataEmpresa;
		this.enderecos = enderecos;
		this.contatos = contatos;
	}
	
	public Cliente(String id, String nome, String cpf, Date dataNascimento, Date dataEmpresa, List<Endereco> enderecos,
			List<Contato> contatos) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.dataEmpresa = dataEmpresa;
		this.enderecos = enderecos;
		this.contatos = contatos;
	}
	

	public String getId() {
		return id;
	}

	public Date getDataEmpresa() {
		return dataEmpresa;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public List<Contato> getContatos() {
		return contatos;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void adicionarContatos(Integer ddd, String telefone){
		this.contatos.add(new Contato(ddd, telefone));
	}
	
	
	public void setEnderecos(String logradouro, Integer numero, String bairro, String cidade, String cep) {
		this.enderecos.add(new Endereco(logradouro, numero, bairro, cidade, cep));
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public void setDataEmpresa(Date dataEmpresa) {
		this.dataEmpresa = dataEmpresa;
	}

	
}
