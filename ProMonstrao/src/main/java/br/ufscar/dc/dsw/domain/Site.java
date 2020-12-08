package br.ufscar.dc.dsw.domain;

public class Site {

	private Long id, id_usuario;
	private String nome;
	private String telefone;
	
	public Site(Long id) {
		this.id = id;
	}

	public Site(String nome, String telefone) {
		super();		
		this.nome = nome;
		this.telefone = telefone;
	}

	public Site(Long id, Long id_usuario, String nome, String telefone) {
		super();
		this.id = id;
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.telefone = telefone;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


}
