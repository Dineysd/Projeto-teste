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
	private Cliente cliente;
	

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	
	public Cliente getCliente() {
		return cliente;
	}

	
	
	
	
	

}
