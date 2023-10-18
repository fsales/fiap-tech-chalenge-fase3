package br.com.fsales.parktech.adapters.out.repository.entity;

public sealed abstract class PessoaFisicaEntity extends PessoaEntity permits CondutorEntity {

	protected String cpf;

	public PessoaFisicaEntity() {
		super();
	}

	public PessoaFisicaEntity(String nome, ContatoEntity contatoEntity, EnderecoEntity enderecoEntity, String cpf) {
		super(nome, contatoEntity, enderecoEntity);
		this.cpf = cpf;
	}

	public String cpf() {
		return cpf;
	}

	public PessoaFisicaEntity setCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

}

abstract sealed class PessoaEntity permits PessoaFisicaEntity {

	protected String nome;

	protected ContatoEntity contatoEntity;

	protected EnderecoEntity enderecoEntity;

	public PessoaEntity() {
		super();
	}

	public PessoaEntity(String nome, ContatoEntity contatoEntity, EnderecoEntity enderecoEntity) {
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
