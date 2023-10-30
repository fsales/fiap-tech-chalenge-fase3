package br.com.fsales.parktech.adapters.out.repository.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor

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

	public CondutorEntity(String id, String nome, LocalDate dataNascimento, ContatoEntity contatoEntity,
			EnderecoEntity enderecoEntity, String cpf, String numeroHabilitacao) {
		super(nome, dataNascimento, contatoEntity, enderecoEntity, cpf);
		this.id = id;
		this.numeroHabilitacao = numeroHabilitacao;
	}

	public String getId() {
		return id;
	}

	public CondutorEntity setId(String id) {
		this.id = id;
		return this;
	}

	public String getNumeroHabilitacao() {
		return numeroHabilitacao;
	}

	public CondutorEntity setNumeroHabilitacao(String numeroHabilitacao) {
		this.numeroHabilitacao = numeroHabilitacao;
		return this;
	}

	public List<VeiculoEntity> getVeiculos() {
		return veiculos;
	}

	public CondutorEntity setVeiculos(List<VeiculoEntity> veiculos) {
		this.veiculos = veiculos;
		return this;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public CondutorEntity setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public CondutorEntity setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
		return this;
	}

	/**
	 * @return
	 */
	@Override
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 * @return
	 */
	@Override
	public CondutorEntity setNome(String nome) {
		this.nome = nome;
		return this;
	}

	/**
	 * @return
	 */
	@Override
	public ContatoEntity getContato() {
		return contatoEntity;
	}

	/**
	 * @param contatoEntity
	 * @return
	 */
	@Override
	public CondutorEntity setContato(ContatoEntity contatoEntity) {
		this.contatoEntity = contatoEntity;
		return this;
	}

	/**
	 * @return
	 */
	@Override
	public EnderecoEntity getEndereco() {
		return enderecoEntity;
	}

	/**
	 * @param enderecoEntity
	 * @return
	 */
	@Override
	public CondutorEntity setEndereco(EnderecoEntity enderecoEntity) {
		this.enderecoEntity = enderecoEntity;
		return this;
	}

	/**
	 * @return
	 */
	@Override
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf
	 * @return
	 */
	@Override
	public CondutorEntity setCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	/**
	 * @return
	 */
	@Override
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento
	 * @return
	 */
	@Override
	public CondutorEntity setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}

}
