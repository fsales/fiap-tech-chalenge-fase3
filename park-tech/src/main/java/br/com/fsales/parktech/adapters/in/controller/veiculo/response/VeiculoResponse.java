package br.com.fsales.parktech.adapters.in.controller.veiculo.response;

public record VeiculoResponse(String id, String modelo, String marca, String placa, String renavam, Condutor condutor) {

	public record Condutor(String id, String nome, String cpf) {
	}
}
