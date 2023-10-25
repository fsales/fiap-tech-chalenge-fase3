package br.com.fsales.parktech.application.core.domain;

import java.time.LocalDate;

public final class Condutor extends PessoaFisica {

	private String id;

	private String numeroHabilitacao;

	public Condutor() {
		super();
	}

	public Condutor(String id, String nome, LocalDate dataNascimento, Contato contato, Endereco endereco, String cpf,
			String numeroHabilitacao) {
		super(nome, dataNascimento, contato, endereco, cpf);
		this.id = id;
		this.numeroHabilitacao = numeroHabilitacao;
	}

	public String getId() {
		return id;
	}

	public Condutor setId(String id) {
		this.id = id;
		return this;
	}

	public String getNumeroHabilitacao() {
		return numeroHabilitacao;
	}

	public Condutor setNumeroHabilitacao(String numeroHabilitacao) {
		this.numeroHabilitacao = numeroHabilitacao;
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
	public Condutor setCpf(String cpf) {
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
	public Condutor setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
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
	public Pessoa setNome(String nome) {
		this.nome = nome;
		return this;
	}

	/**
	 * @return
	 */
	@Override
	public Contato getContato() {
		return contato;
	}

	/**
	 * @param contato
	 * @return
	 */
	@Override
	public Condutor setContato(Contato contato) {
		this.contato = contato;
		return this;
	}

	/**
	 * @return
	 */
	@Override
	public Endereco getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco
	 * @return
	 */
	@Override
	public Condutor setEndereco(Endereco endereco) {
		this.endereco = endereco;
		return this;
	}

}
