package br.com.fsales.parktech.adapters.in.controller.condutor.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record CondutorRequest(@Schema(name = "nome", example = "Marcos Andre") @NotBlank String nome,

		@Schema(name = "cpf", example = "50297831054")
		@CPF String cpf,

		@Schema(name = "dataNascimento", pattern = "dd/MM/yyyy", example = "17/02/1995", type = "string")
		@JsonFormat(pattern = "dd/MM/yyyy") @Past @NotNull LocalDate dataNascimento,

		@Schema(name = "numeroHabilitacao", example = "02888820071") @Size(min = 10,
				max = 11) @Pattern(regexp = "[0-9]+") String numeroHabilitacao,

		@Schema(name = "contato", implementation = Contato.class) Contato contato,

		@Schema(name = "endereco", implementation = Endereco.class)
		Endereco endereco) {

	public record Contato(@Schema(name = "email", example = "email@email.com") @NotBlank String email,
			@Schema(name = "telefone", example = "(99)9999-9999") @NotBlank String telefone) {
	}

	public record Endereco(

			@Schema(name = "rua", example = "villa nova")
			@NotBlank String rua,

			@Schema(name = "logradouro", example = "Praça da Sé")
			@NotBlank String logradouro,

			@Schema(name = "numero", example = "1024")
			@NotNull Integer numero,

			@Schema(name = "complemento", example = "lado ímpar")
			@NotBlank String complemento,

			@Schema(name = "bairro", example = "Sé") @NotBlank String bairro,

			@Schema(name = "cep", example = "01001000") @NotBlank @Pattern(regexp = "[0-9]{8}",
					message = "O CEP deve conter somente número com 8 posições") String cep) {
	}

}
