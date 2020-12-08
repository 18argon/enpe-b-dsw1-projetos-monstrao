package br.ufscar.dc.dsw.domain;

public class Promocao {
	
	private Long id, id_teatro, id_site;
	private String nome_peca;
	private Float preco_peca;
	private String data_peca;
	
	public Promocao(Long id) {
		this.id = id;
	}

	public Promocao(Long id_teatro, Long id_site, String nome_peca, Float preco_peca, String data_peca) {
		super();
		this.id_teatro = id_teatro;
		this.id_site = id_site;
		this.nome_peca = nome_peca;
		this.preco_peca = preco_peca;
		this.data_peca = data_peca;
	}

	public Promocao(Long id, Long id_teatro, Long id_site, String nome_peca, Float preco_peca, String data_peca) {
		super();
		this.id = id;
		this.id_teatro = id_teatro;
		this.id_site = id_site;
		this.nome_peca = nome_peca;
		this.preco_peca = preco_peca;
		this.data_peca = data_peca;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getIdTeatro() {
		return id_teatro;
	}

	public void setIdTeatro(Long id_teatro) {
		this.id_teatro = id_teatro;
	}
	
	public Long getIdSite() {
		return id_site;
	}

	public void setIdSite(Long id_site) {
		this.id_site = id_site;
	}

	public String getNomePeca() {
		return nome_peca;
	}

	public void setNomePeca(String nome_peca) {
		this.nome_peca = nome_peca;
	}

	public Float getPrecoPeca() {
		return preco_peca;
	}

	public void setPrecoPeca(Float preco_peca) {
		this.preco_peca = preco_peca;
	}
	
	public String getDataPeca() {
		return data_peca;
	}

	public void setDataPeca(String data_peca) {
		this.data_peca = data_peca;
	}

}