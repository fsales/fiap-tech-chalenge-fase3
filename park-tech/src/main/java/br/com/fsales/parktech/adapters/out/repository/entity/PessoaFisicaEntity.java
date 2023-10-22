package br.com.fsales.parktech.adapters.out.repository.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.mongodb.core.index.Indexed;

public sealed abstract class PessoaFisicaEntity extends PessoaEntity permits CondutorEntity {

	@Indexed(unique = true)
	@NotBlank
	protected String cpf;

	@NotBlank
	protected LocalDate dataNascimento;

	public PessoaFisicaEntity() {
		super();
	}

	public PessoaFisicaEntity(String nome, LocalDate dataNascimento, ContatoEntity contatoEntity, EnderecoEntity enderecoEntity, String cpf) {
		super(nome, contatoEntity, enderecoEntity);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public String cpf() {
		return cpf;
	}

	public PessoaFisicaEntity setCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public PessoaFisicaEntity setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}
}


