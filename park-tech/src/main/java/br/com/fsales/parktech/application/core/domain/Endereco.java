package br.com.fsales.parktech.application.core.domain;

import br.com.fsales.parktech.application.core.domain.enumeration.EstadoEnum;

public class Endereco {

	private String rua;

	private String logradouro;

	private Integer numero;

	private String complemento;

	private String bairro;

	private String cidade;

	private String cep;

	private String uf;

	public Endereco() {
		super();
	}

	public Endereco(String rua, String logradouro, Integer numero, String complemento, String bairro, String cidade,
			String cep, String uf) {
		this.rua = rua;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.uf = uf;
	}

	public String getRua() {
		return rua;
	}

	public Endereco setRua(String rua) {
		this.rua = rua;
		return this;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public Endereco setLogradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}

	public Integer getNumero() {
		return numero;
	}

	public Endereco setNumero(Integer numero) {
		this.numero = numero;
		return this;
	}

	public String getComplemento() {
		return complemento;
	}

	public Endereco setComplemento(String complemento) {
		this.complemento = complemento;
		return this;
	}

	public String getBairro() {
		return bairro;
	}

	public Endereco setBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public String getCidade() {
		return cidade;
	}

	public Endereco setCidade(String cidade) {
		this.cidade = cidade;
		return this;
	}

	public String getCep() {
		return cep;
	}

	public Endereco setCep(String cep) {
		this.cep = cep;
		return this;
	}

	public String getUf() {
		return uf;
	}

	public Endereco setUf(String uf) {
		this.uf = uf;
		return this;
	}

	/**
	 * Retorna o nome do estado
	 * @return
	 */
	public String getEstado() {
		var estadoEnum = EstadoEnum.getEnum(uf);
		return estadoEnum == null ? "" : estadoEnum.nome();
	}


}
