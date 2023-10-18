package br.com.fsales.parktech.application.core.domain;

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

	public String rua() {
		return rua;
	}

	public Endereco setRua(String rua) {
		this.rua = rua;
		return this;
	}

	public String logradouro() {
		return logradouro;
	}

	public Endereco setLogradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}

	public Integer numero() {
		return numero;
	}

	public Endereco setNumero(Integer numero) {
		this.numero = numero;
		return this;
	}

	public String complemento() {
		return complemento;
	}

	public Endereco setComplemento(String complemento) {
		this.complemento = complemento;
		return this;
	}

	public String bairro() {
		return bairro;
	}

	public Endereco setBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	public String cidade() {
		return cidade;
	}

	public Endereco setCidade(String cidade) {
		this.cidade = cidade;
		return this;
	}

	public String cep() {
		return cep;
	}

	public Endereco setCep(String cep) {
		this.cep = cep;
		return this;
	}

	public String uf() {
		return uf;
	}

	public Endereco setUf(String uf) {
		this.uf = uf;
		return this;
	}

}
