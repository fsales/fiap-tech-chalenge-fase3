package br.com.fsales.parktech.adapters.in.controller.request;

public record CondutorRequest(String nome, String cpf, String numeroHabilitacao, Contato contato, Endereco endereco) {

	public record Contato(String email, String telefone) {
	}

	public record Endereco(String rua, String logradouro,

			Integer numero,

			String complemento,

			String bairro,

			String cidade,

			String cep,

			String uf) {
	}

}
