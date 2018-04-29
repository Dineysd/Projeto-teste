package entidade;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Contato {
	
	private Integer id;
	private int ddd;
	private String telefone;
	private Integer codigo_cli;

	
	
	public Contato(Integer id,int ddd, String numero, Integer codigoCli) {
		
		this.id = id;
		this.ddd = ddd;
		this.telefone = numero;
		codigo_cli = codigoCli;
		
	}


	public int getDDD() {
		return ddd;
	}


	public String getTelefone() {
		return telefone;
	}


	public Integer getId() {
		return id;
	}
	
	public Integer getCodigo_cli() {
		return codigo_cli;
	}

	
	
	

}
