package entidade;

public class Empresa {

	private Integer id;
	private String nome;
	private String cnpj;
	private int clienteCodigo;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setClienteCodigo(int clienteCodigo) {
		this.clienteCodigo = clienteCodigo;
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
