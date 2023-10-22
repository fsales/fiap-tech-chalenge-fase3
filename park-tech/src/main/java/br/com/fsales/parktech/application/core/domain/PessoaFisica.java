package br.com.fsales.parktech.application.core.domain;

import java.time.LocalDate;

public sealed abstract class PessoaFisica extends Pessoa permits Condutor {

	protected String cpf;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, LocalDate dataNascimento, Contato contato, Endereco endereco, String cpf) {
		super(nome,dataNascimento , contato, endereco);
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

