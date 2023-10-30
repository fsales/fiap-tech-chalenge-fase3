package br.com.fsales.parktech.adapters.in.controller.veiculo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

public record VeiculoResponse(String id, @Schema(name = "modelo", example = "Virtus Higline") String modelo,
		@Schema(name = "marca", example = "Volkswagen") String marca,
		@Schema(name = "placa", example = "VAP8V99") String placa,
		@Schema(name = "renavam", example = "1132266690") String renavam,
		@Schema(name = "condutor", implementation = Condutor.class) VeiculoResponse.Condutor condutor) {

	public record Condutor(@Schema(name = "id", example = "653fae059451cb68c8572974") String id,
			@Schema(name = "nome", example = "Marcos Andre") @JsonInclude(JsonInclude.Include.NON_NULL) String nome,
			@Schema(name = "cpf", example = "50297831054") @JsonInclude(JsonInclude.Include.NON_NULL) String cpf) {
	}
}
