package br.com.fsales.parktech.application.core.domain;

import java.time.LocalDate;

public final class Condutor extends PessoaFisica {

	private String numeroHabilitacao;

	public Condutor() {
		super();
	}

	public Condutor(String nome, LocalDate dataNascimento, Contato contato, Endereco endereco, String cpf, String numeroHabilitacao) {
		super(nome, dataNascimento, contato, endereco, cpf);
		this.numeroHabilitacao = numeroHabilitacao;
	}

	public String numeroHabilitacao() {
		return numeroHabilitacao;
	}

	public Condutor setNumeroHabilitacao(String numeroHabilitacao) {
		this.numeroHabilitacao = numeroHabilitacao;
		return this;
	}

}
