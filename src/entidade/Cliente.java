package entidade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Cliente {

	private Long id;
	private String nome;
	private String cpf;
	private Date dataNascimento;
	private Date dataEmpresa;
	private List<Endereco> enderecos = new ArrayList<>();
	private List<Contato> contatos = new ArrayList<>();

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
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
	
	public List<Contato> getContatos() {
		return contatos;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void addEnderco(Endereco end) {
		enderecos.add(end);
	}

	public void addContato(Contato cont) {
		contatos.add(cont);
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataEmpresa(Date dataEmpresa) {
		this.dataEmpresa = dataEmpresa;
	}

}
