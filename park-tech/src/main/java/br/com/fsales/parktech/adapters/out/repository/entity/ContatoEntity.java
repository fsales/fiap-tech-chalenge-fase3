package br.com.fsales.parktech.adapters.out.repository.entity;

public class ContatoEntity {

	private String email;

	private String telefone;

	public ContatoEntity() {
		super();
	}

	public ContatoEntity(String email, String telefone) {
		this.email = email;
		this.telefone = telefone;
	}

	public String email() {
		return email;
	}

	public ContatoEntity setEmail(String email) {
		this.email = email;
		return this;
	}

	public String telefone() {
		return telefone;
	}

	public ContatoEntity setTelefone(String telefone) {
		this.telefone = telefone;
		return this;
	}

}
