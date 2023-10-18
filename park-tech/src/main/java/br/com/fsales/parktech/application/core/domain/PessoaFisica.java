package br.com.fsales.parktech.application.core.domain;

public sealed abstract class PessoaFisica extends Pessoa permits Condutor {

	protected String cpf;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, Contato contato, Endereco endereco, String cpf) {
		super(nome, contato, endereco);
		this.cpf = cpf;
	}

	public String cpf() {
		return cpf;
	}

	public PessoaFisica setCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

}

abstract sealed class Pessoa permits PessoaFisica {

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

	public String nome() {
		return nome;
	}

	public Pessoa setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public Contato contato() {
		return contato;
	}

	public Pessoa setContato(Contato contato) {
		this.contato = contato;
		return this;
	}

	public Endereco endereco() {
		return endereco;
	}

	public Pessoa setEndereco(Endereco endereco) {
		this.endereco = endereco;
		return this;
	}

}
