package entidade;

import java.util.UUID;

public class Contato {
	
	private String id;
	private Integer ddd;
	private String telefone;
	private Cliente cliente_id;

	public Contato() {
		this.id = UUID.randomUUID().toString();
	}
	
	public Contato(Integer ddd, String telefone) {
		this();
		this.ddd = ddd;
		this.telefone = telefone;

	}


	public void setDDD(Integer ddd) {
		this.ddd = ddd;
	}

	public Integer getDDD() {
		return ddd;
	}


	public String getTelefone() {
		return telefone;
	}


	public String getId() {
		return id;
	}
	
	public Cliente getCliente_id() {
		return cliente_id;
	}
	

	
	
	

}
