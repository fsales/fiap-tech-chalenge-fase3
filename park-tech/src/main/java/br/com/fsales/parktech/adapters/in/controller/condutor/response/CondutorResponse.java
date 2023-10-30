package br.com.fsales.parktech.adapters.in.controller.condutor.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

public record CondutorResponse(

		String id, @Schema(name = "nome", example = "Marcos Andre") String nome,
		@Schema(name = "cpf", example = "50297831054") String cpf,
		@Schema(name = "dataNascimento", pattern = "dd/MM/yyyy", example = "17/02/1995",
				type = "string") @JsonFormat(pattern = "dd/MM/yyyy") LocalDate dataNascimento,
		@Schema(name = "numeroHabilitacao", example = "02888820071") String numeroHabilitacao,

		@Schema(name = "contato", implementation = Contato.class) Contato contato,

		@Schema(name = "endereco", implementation = Endereco.class) Endereco endereco) {

	public record Contato(

			@Schema(name = "email", example = "email@email.com")
			String email,

			@Schema(name = "telefone", example = "(99)9999-9999")
			String telefone) {
	}

	public record Endereco(

			@Schema(name = "rua", example = "villa nova")
			String rua,

			@Schema(name = "logradouro", example = "Praça da Sé")
			String logradouro,

			@Schema(name = "numero", example = "1024")
			Integer numero,

			@Schema(name = "complemento", example = "lado ímpar")
			String complemento,

			@Schema(name = "bairro", example = "Sé")
			String bairro,

			@Schema(name = "cidade", example = "São Paulo")
			String cidade,

			@Schema(name = "cep", example = "01001000")
			String cep,

			@Schema(name = "siglaEstado", example = "SP")
			String uf) {
	}

}
