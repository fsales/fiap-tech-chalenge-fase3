package br.com.fsales.parktech.adapters.out.repository.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.mongodb.core.index.TextIndexed;

public abstract sealed class PessoaEntity permits PessoaFisicaEntity {

	@NotBlank
	@TextIndexed(weight = 5)
	protected String nome;

	@NotNull
	protected ContatoEntity contatoEntity;

	@NotNull
	protected EnderecoEntity enderecoEntity;

	public PessoaEntity() {
		super();
	}

	public PessoaEntity(String nome, ContatoEntity contatoEntity, EnderecoEntity enderecoEntity) {
		this();
		this.nome = nome;
		this.contatoEntity = contatoEntity;
		this.enderecoEntity = enderecoEntity;
	}

	public abstract String getNome();

	public abstract PessoaEntity setNome(String nome);

	public abstract ContatoEntity getContato();

	public abstract PessoaEntity setContato(ContatoEntity contatoEntity);

	public abstract EnderecoEntity getEndereco();

	public abstract PessoaEntity setEndereco(EnderecoEntity enderecoEntity);

}