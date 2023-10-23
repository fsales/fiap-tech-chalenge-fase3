package br.com.fsales.parktech.application.core.domain;

import java.time.LocalDate;

public final class Condutor extends PessoaFisica {

	private String id;

	private String numeroHabilitacao;

	public Condutor() {
		super();
	}

	public Condutor(String id, String nome, LocalDate dataNascimento, Contato contato, Endereco endereco, String cpf,
			String numeroHabilitacao) {
		super(nome, dataNascimento, contato, endereco, cpf);
		this.id = id;
		this.numeroHabilitacao = numeroHabilitacao;
	}

	public String numeroHabilitacao() {
		return numeroHabilitacao;
	}

	public Condutor setNumeroHabilitacao(String numeroHabilitacao) {
		this.numeroHabilitacao = numeroHabilitacao;
		return this;
	}

	public String id() {
		return id;
	}

	public Condutor setId(String id) {
		this.id = id;
		return this;
	}

}
