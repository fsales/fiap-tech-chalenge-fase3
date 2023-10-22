package br.com.fsales.parktech.application.core.domain;

import java.time.LocalDate;

public abstract sealed class Pessoa permits PessoaFisica {

	protected String nome;

	protected LocalDate dataNascimento;

	protected Contato contato;

	protected Endereco endereco;

	public Pessoa() {
		super();
	}

	public Pessoa(String nome, LocalDate dataNascimento, Contato contato, Endereco endereco) {
		this.nome = nome;
		this.contato = contato;
		this.endereco = endereco;
		this.dataNascimento = dataNascimento;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public Pessoa setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}

}
