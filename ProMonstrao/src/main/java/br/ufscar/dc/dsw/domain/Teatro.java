package br.ufscar.dc.dsw.domain;

public class Teatro {

	private Long id, id_usuario;
	private String cnpj;
	private String nome;
	private String cidade;

	public Teatro(Long id) {
		this.id = id;
	}

	public Teatro(String cnpj, String nome, String cidade) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.cidade = cidade;
	}

	public Teatro(Long id, Long id_usuario, String cnpj, String nome, String cidade) {
		super();
		this.id = id;
		this.id_usuario = id_usuario;
		this.cnpj = cnpj;
		this.nome = nome;
		this.cidade = cidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getIdUsuario() {
		return id_usuario;
	}

	public void setIdUsuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}
