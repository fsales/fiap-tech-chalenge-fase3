package br.com.fsales.parktech.adapters.in.controller.estacionamento.request;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

public record EstacionamentoRequest(EstacionamentoRequest.Condutor condutor, EstacionamentoRequest.Veiculo veiculo,
		LocalDateTime entrada, LocalDateTime saida, EstacionamentoRequest.TipoTempoEnum tipoTempo, Integer duracao) {

	public enum TipoTempoEnum {

		FIXO, VARIAVEL

	}

	public record Condutor(@Schema(name = "id", example = "653fae059451cb68c8572974") String id) {
	}

	public record Veiculo(@Schema(name = "id", example = "653fae059451cb68c8572974") String id) {

	}
}
