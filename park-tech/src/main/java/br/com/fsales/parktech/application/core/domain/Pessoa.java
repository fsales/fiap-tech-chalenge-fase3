package br.com.fsales.parktech.application.core.domain;

public abstract sealed class Pessoa permits PessoaFisica {

	protected String nome;

	protected Contato contato;

	protected Endereco endereco;

	public Pessoa() {
		super();
	}

	public Pessoa(String nome, Contato contato, Endereco endereco) {
		this.nome = nome;
		this.contato = contato;
		this.endereco = endereco;
	}

	public abstract String getNome();

	public abstract Pessoa setNome(String nome);

	public abstract Contato getContato();

	public abstract Pessoa setContato(Contato contato);

	public abstract Endereco getEndereco();

	public abstract Pessoa setEndereco(Endereco endereco);

}
