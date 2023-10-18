package br.com.fsales.parktech.adapters.out.repository.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "condutores")
public final class CondutorEntity extends PessoaFisicaEntity {

	@Id
	private String id;

	private String numeroHabilitacao;

	@CreatedDate
	private LocalDateTime createdDate;

	@LastModifiedDate
	private LocalDateTime lastModifiedDate;

	public CondutorEntity() {
		super();
	}

	public CondutorEntity(String nome, ContatoEntity contatoEntity, EnderecoEntity enderecoEntity, String cpf,
			String id, String numeroHabilitacao) {
		super(nome, contatoEntity, enderecoEntity, cpf);
		this.id = id;
		this.numeroHabilitacao = numeroHabilitacao;
	}

	public CondutorEntity(String nome, ContatoEntity contatoEntity, EnderecoEntity enderecoEntity, String cpf,
			String numeroHabilitacao) {
		super(nome, contatoEntity, enderecoEntity, cpf);
		this.numeroHabilitacao = numeroHabilitacao;
	}

	public String id() {
		return id;
	}

	public CondutorEntity setId(String id) {
		this.id = id;
		return this;
	}

	public String numeroHabilitacao() {
		return numeroHabilitacao;
	}

	public CondutorEntity setNumeroHabilitacao(String numeroHabilitacao) {
		this.numeroHabilitacao = numeroHabilitacao;
		return this;
	}

	public LocalDateTime createdDate() {
		return createdDate;
	}

	public CondutorEntity setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public LocalDateTime lastModifiedDate() {
		return lastModifiedDate;
	}

	public CondutorEntity setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
		return this;
	}

}
