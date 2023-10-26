package br.com.fsales.parktech.adapters.in.controller.veiculo.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public record VeiculoResponse(String id, String modelo, String marca, String placa, String renavam, Condutor condutor) {

	public record Condutor(String id, @JsonInclude(JsonInclude.Include.NON_NULL) String nome,
			@JsonInclude(JsonInclude.Include.NON_NULL) String cpf) {
	}
}
