package entidade;

public class Empresa {
	
	private Integer id;
	private String nome;
	private String cnpj;
	private int clienteCodigo;
	
	
	public Empresa(Integer id, String nome, String cnpj, int clienteCodigo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
	}
	
	
	public String getCnpj() {
		return cnpj;
	}
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}


	public int getClienteCodigo() {
		return clienteCodigo;
	}
	

}
