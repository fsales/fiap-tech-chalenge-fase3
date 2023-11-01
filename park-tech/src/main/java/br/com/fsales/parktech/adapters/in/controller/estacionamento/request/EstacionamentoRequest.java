package br.com.fsales.parktech.adapters.in.controller.estacionamento.request;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record EstacionamentoRequest(
		@Schema(name = "condutor",
				implementation = EstacionamentoRequest.Condutor.class) @NotNull EstacionamentoRequest.Condutor condutor,

		@Schema(name = "veiculo",
				implementation = EstacionamentoRequest.Veiculo.class) @NotNull EstacionamentoRequest.Veiculo veiculo,
		@Schema(name = "entrada", example = "31/10/2023 21:02", format = "dd/MM/yyyy HH:mm") @JsonFormat(
				pattern = "dd/MM/yyyy HH:mm") @FutureOrPresent @NotNull LocalDateTime entrada,
		@Schema(name = "tipoTempo",
				implementation = EstacionamentoRequest.TipoTempoEnum.class) @NotNull EstacionamentoRequest.TipoTempoEnum tipoTempo,
		@Schema(name = "duracaoEmMinutos", example = "1",
				description = "representação do tempo estacinando em minutos. Exemplo: 60, 90,120...") Integer duracaoEmMinutos) {

	public enum TipoTempoEnum {

		FIXO, VARIAVEL

	}

	public record Condutor(@NotEmpty @Schema(name = "id", example = "6536d7609826445f718f38eb") String id) {
	}

	public record Veiculo(@NotEmpty @Schema(name = "id", example = "653876ea4bb3a15f1239046c") String id) {

	}
}
