package br.com.fsales.parktech.application.core.domain;

import java.time.LocalDate;

public abstract sealed class PessoaFisica extends Pessoa permits Condutor {

	protected String cpf;

	protected LocalDate dataNascimento;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, LocalDate dataNascimento, Contato contato, Endereco endereco, String cpf) {
		super(nome, contato, endereco);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public abstract String getCpf();

	public abstract PessoaFisica setCpf(String cpf);

	public abstract LocalDate getDataNascimento();

	public abstract PessoaFisica setDataNascimento(LocalDate dataNascimento);

}
