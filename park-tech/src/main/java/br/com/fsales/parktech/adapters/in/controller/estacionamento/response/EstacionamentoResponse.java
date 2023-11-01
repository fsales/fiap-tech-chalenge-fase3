package br.com.fsales.parktech.adapters.in.controller.estacionamento.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

public record EstacionamentoResponse(String codigoIdentificador, EstacionamentoResponse.Condutor condutor,
		EstacionamentoResponse.Veiculo veiculo, @JsonFormat(pattern = "dd/MM/yyyy HH:mm") LocalDateTime entrada,
		@JsonFormat(pattern = "dd/MM/yyyy HH:mm") @JsonInclude(JsonInclude.Include.NON_NULL) LocalDateTime saida,
		EstacionamentoResponse.TipoTempoEnum tipoTempo, @JsonInclude(JsonInclude.Include.NON_NULL) Integer duracao,
		@JsonInclude(JsonInclude.Include.NON_NULL) Long excedente,

		@JsonInclude(JsonInclude.Include.NON_NULL) Long tempoTotalEstacionado) {

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
