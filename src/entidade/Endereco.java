package entidade;

import java.util.UUID;

public class Endereco {
	
	private String id;
	private String logradouro;
	private int numero;
	private String bairro;
	private String cidade;
	private String cep;
	private Cliente cliente;


	public Endereco() {

		this.id = UUID.randomUUID().toString();
	}
	public Endereco(String logradouro, int numero, String bairro,String cidade, String cep) {
		this();
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
	}


	public String getId() {
		return id;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public int getNumero() {
		return numero;
	}


	public String getBairro() {
		return bairro;
	}
	
	public String getCidade() {
		return cidade;
	}


	public String getCep() {
		return cep;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	
	
	
	
	

}
