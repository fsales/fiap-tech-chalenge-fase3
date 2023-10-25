package br.com.fsales.parktech.application.core.domain;

public class Contato {

	private String email;

	private String telefone;

	public Contato() {
		super();
	}

	public Contato(String email, String telefone) {
		this.email = email;
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public Contato setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getTelefone() {
		return telefone;
	}

	public Contato setTelefone(String telefone) {
		this.telefone = telefone;
		return this;
	}
}
