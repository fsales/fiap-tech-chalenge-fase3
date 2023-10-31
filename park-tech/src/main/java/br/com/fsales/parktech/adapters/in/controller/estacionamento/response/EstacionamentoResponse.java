package br.com.fsales.parktech.adapters.in.controller.estacionamento.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

public record EstacionamentoResponse(String id, EstacionamentoResponse.Condutor condutor,
		EstacionamentoResponse.Veiculo veiculo, LocalDateTime entrada, LocalDateTime saida,
		EstacionamentoResponse.TipoTempoEnum tipoTempo, Integer duracao) {

	public enum TipoTempoEnum {

		FIXO, VARIAVEL

	}

	public record Condutor(@Schema(name = "id", example = "653fae059451cb68c8572974") String id,
			@Schema(name = "nome", example = "Marcos Andre") @JsonInclude(JsonInclude.Include.NON_NULL) String nome,
			@Schema(name = "cpf", example = "50297831054") @JsonInclude(JsonInclude.Include.NON_NULL) String cpf) {
	}

	public record Veiculo(String id,
			@JsonInclude(JsonInclude.Include.NON_NULL) @Schema(name = "modelo",
					example = "Virtus Higline") String modelo,
			@JsonInclude(JsonInclude.Include.NON_NULL) @Schema(name = "marca", example = "Volkswagen") String marca,
			@JsonInclude(JsonInclude.Include.NON_NULL) @Schema(name = "placa", example = "VAP8V99") String placa) {

	}

}
