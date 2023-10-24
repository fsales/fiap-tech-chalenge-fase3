package br.com.fsales.parktech.adapters.out.repository.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "condutores")
@CompoundIndexes({ @CompoundIndex(name = "nome_cpf", def = "{'nome': 1, 'cpf': 1}") })
public final class CondutorEntity extends PessoaFisicaEntity {

	@Id
	private String id;

	@Size(min = 10, max = 11)
	@Pattern(regexp = "[0-9]+")
	@Indexed(unique = true)
	private String numeroHabilitacao;

	@DBRef
	private List<VeiculoEntity> veiculos;

	@CreatedDate
	private LocalDateTime createdDate;

	@LastModifiedDate
	private LocalDateTime lastModifiedDate;

	public CondutorEntity() {
		super();
		this.veiculos = new ArrayList<>();
	}

	public CondutorEntity(String id, String nome, LocalDate dataNascimento, ContatoEntity contatoEntity,
			EnderecoEntity enderecoEntity, String cpf, String numeroHabilitacao) {
		super(nome, dataNascimento, contatoEntity, enderecoEntity, cpf);
		this.id = id;
		this.numeroHabilitacao = numeroHabilitacao;
		this.veiculos = new ArrayList<>();

	}

	public CondutorEntity(String nome, LocalDate dataNascimento, ContatoEntity contatoEntity,
			EnderecoEntity enderecoEntity, String cpf, String numeroHabilitacao) {
		super(nome, dataNascimento, contatoEntity, enderecoEntity, cpf);
		this.numeroHabilitacao = numeroHabilitacao;
		this.veiculos = new ArrayList<>();
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

	@Override
	public String nome() {
		return nome;
	}

	@Override
	public CondutorEntity setNome(String nome) {
		this.nome = nome;
		return this;
	}

	@Override
	public ContatoEntity contato() {
		return contatoEntity;
	}

	@Override
	public CondutorEntity setContato(ContatoEntity contatoEntity) {
		this.contatoEntity = contatoEntity;
		return this;
	}

	@Override
	public EnderecoEntity endereco() {
		return enderecoEntity;
	}

	@Override
	public CondutorEntity setEndereco(EnderecoEntity enderecoEntity) {
		this.enderecoEntity = enderecoEntity;
		return this;
	}

	@Override
	public String cpf() {
		return cpf;
	}

	@Override
	public CondutorEntity setCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public List<VeiculoEntity> veiculos() {

		return veiculos;
	}

	@Override
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	@Override
	public CondutorEntity setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}

}
