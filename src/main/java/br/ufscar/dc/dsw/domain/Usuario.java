package br.ufscar.dc.dsw.domain;

public class Usuario {

	private Long id;
	private String login;
	private String senha;
	private String papel;

	public Usuario(Long id) {
		this.id = id;
	}

	public Usuario(String login, String senha, String papel) {
		super();
		this.login = login;
		this.senha = senha;
		this.papel = papel;
	}

	public Usuario(Long id, String login, String senha, String papel) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.papel = papel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String password) {
		this.senha = password;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}
}