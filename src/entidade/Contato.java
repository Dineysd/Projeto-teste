package entidade;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Contato {
	
	private Integer id;
	private Integer ddd;
	private String telefone;
	private Cliente codigo_cli;


	public void setId(Integer id) {
		this.id = id;
	}


	public void setDDD(Integer ddd) {
		this.ddd = ddd;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public Integer getDDD() {
		return ddd;
	}


	public String getTelefone() {
		return telefone;
	}


	public Integer getId() {
		return id;
	}
	
	public Cliente getCodigo_cli() {
		return codigo_cli;
	}

	
	
	

}
