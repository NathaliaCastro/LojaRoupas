package com.nathaliacastro.nathsstore.business.bean;

public class PecaBean {
	
	private Integer codigo;
	private String nome;
	private Integer codigoTipo;
	private String tipo;
	private Float preco;
	private String nomeImagem;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public String getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(String nomeImagem) {
		this.nomeImagem = nomeImagem;
	}

	public Integer getCodigoTipo() {
		return codigoTipo;
	}

	public void setCodigoTipo(Integer codigoTipo) {
		this.codigoTipo = codigoTipo;
	}
}
