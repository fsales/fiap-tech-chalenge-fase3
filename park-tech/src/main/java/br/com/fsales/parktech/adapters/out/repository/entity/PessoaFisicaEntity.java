package br.com.fsales.parktech.adapters.out.repository.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;

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

abstract sealed class PessoaEntity permits PessoaFisicaEntity {

	@NotBlank
	@TextIndexed(weight = 5)
	protected String nome;

	@NotNull
	protected ContatoEntity contatoEntity;

	@NotNull
	protected EnderecoEntity enderecoEntity;

	public PessoaEntity() {
		super();
		this.contatoEntity = new ContatoEntity();
		this.enderecoEntity = new EnderecoEntity();
	}

	public PessoaEntity(String nome, ContatoEntity contatoEntity, EnderecoEntity enderecoEntity) {
		this();
		this.nome = nome;
		this.contatoEntity = contatoEntity;
		this.enderecoEntity = enderecoEntity;
	}

	public String nome() {
		return nome;
	}

	public PessoaEntity setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public ContatoEntity contato() {
		return contatoEntity;
	}

	public PessoaEntity setContato(ContatoEntity contatoEntity) {
		this.contatoEntity = contatoEntity;
		return this;
	}

	public EnderecoEntity endereco() {
		return enderecoEntity;
	}

	public PessoaEntity setEndereco(EnderecoEntity enderecoEntity) {
		this.enderecoEntity = enderecoEntity;
		return this;
	}

}
