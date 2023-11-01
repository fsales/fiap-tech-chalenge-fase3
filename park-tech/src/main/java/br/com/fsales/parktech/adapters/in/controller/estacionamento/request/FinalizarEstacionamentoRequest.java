package br.com.fsales.parktech.adapters.in.controller.estacionamento.request;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record FinalizarEstacionamentoRequest(@Schema(name = "condutor",
		implementation = FinalizarEstacionamentoRequest.Condutor.class) @NotNull FinalizarEstacionamentoRequest.Condutor condutor,

		@Schema(name = "veiculo",
				implementation = FinalizarEstacionamentoRequest.Veiculo.class) @NotNull FinalizarEstacionamentoRequest.Veiculo veiculo,
		@Schema(name = "entrada", example = "31/10/2023 21:02:45") @JsonFormat(
				pattern = "dd/MM/yyyy HH:mm:ss") @FutureOrPresent @NotNull LocalDateTime entrada,
		@Schema(name = "saida", example = "31/10/2023 22:32:55") @JsonFormat(
				pattern = "dd/MM/yyyy HH:mm:ss") @FutureOrPresent LocalDateTime saida,
		@Schema(name = "tipoTempo",
				implementation = FinalizarEstacionamentoRequest.TipoTempoEnum.class) @NotNull FinalizarEstacionamentoRequest.TipoTempoEnum tipoTempo,
		@Schema(name = "duracaoEmMinutos", example = "1",
				description = "representação do tempo estacinando em horas. Exemplo: 1, 2,3...") Integer duracaoEmMinutos) {

	public enum TipoTempoEnum {

		FIXO, VARIAVEL

	}

	public record Condutor(@NotEmpty @Schema(name = "id", example = "6536d7609826445f718f38eb") String id) {
	}

	public record Veiculo(@NotEmpty @Schema(name = "id", example = "653876ea4bb3a15f1239046c") String id) {

	}
}
