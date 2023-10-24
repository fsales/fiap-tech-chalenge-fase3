package br.com.fsales.parktech.adapters.in.controller.condutor.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record CondutorResponse(

		String id, String nome, String cpf, @JsonFormat(pattern = "dd/MM/yyyy") LocalDate dataNascimento,
		String numeroHabilitacao, Contato contato, Endereco endereco) {

	public record Contato(

			String email,

			String telefone) {
	}

	public record Endereco(

			String rua,

			String logradouro,

			Integer numero,

			String complemento,

			String bairro,

			String cidade,

			String cep,

			String uf) {
	}

}
