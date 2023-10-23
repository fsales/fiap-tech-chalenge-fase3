package br.com.fsales.parktech.adapters.in.controller.condutor.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizarCondutorRequest(@NotBlank String id, Contato contato, Endereco endereco) {

	public record Contato(@NotBlank String email, @NotBlank String telefone) {
	}

	public record Endereco(

			@NotBlank String rua,

			@NotBlank String logradouro,

			@NotNull Integer numero,

			@NotBlank String complemento,

			@NotBlank String bairro,
			@NotBlank @Pattern(regexp = "[0-9]{8}",
					message = "O CEP deve conter somente número com 8 posições") String cep) {
	}

}
