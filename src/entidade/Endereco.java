package entidade;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Endereco {
	
	private Integer id;
	private String logradouro;
	private String numero;
	private String bairro;
	private String cep;
	private Integer cliente;
	
	
	
	public Endereco(Integer id,String logradouro, String numero, String bairro, String cep) {
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
	}


	public Endereco() {

	}


	public Integer getId() {
		return id;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public String getNumero() {
		return numero;
	}


	public String getBairro() {
		return bairro;
	}


	public String getCep() {
		return cep;
	}
	
	public Integer getCliente() {
		return cliente;
	}

	
	
	
	
	

}
