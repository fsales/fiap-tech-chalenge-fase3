package br.com.fsales.parktech.adapters.in.controller.condutor.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record CondutorRequest(@NotBlank String nome,

		@CPF String cpf,

		@JsonFormat(pattern = "dd/MM/yyyy") @Past @NotNull LocalDate dataNascimento,

		@Size(min = 10, max = 11) @Pattern(regexp = "[0-9]+") String numeroHabilitacao, Contato contato,
		Endereco endereco) {

	public record Contato(@NotBlank String email, @NotBlank String telefone) {
	}

	public record Endereco(

			@NotBlank String rua,

			@NotBlank String logradouro,

			@NotNull Integer numero,

			@NotBlank String complemento,

			@NotBlank String bairro,
			@NotBlank @Pattern(regexp = "[0-9]{8}",
					message = "O CEP deve conter somente número com 8 posições") String cep,

			@Size(min = 2, max = 2) @NotBlank String uf) {
	}

}
