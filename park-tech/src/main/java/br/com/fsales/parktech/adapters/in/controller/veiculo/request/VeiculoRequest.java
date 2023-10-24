package br.com.fsales.parktech.adapters.in.controller.veiculo.request;

public record VeiculoRequest(String modelo, String marca, String placa, String renavam, Condutor condutor) {
	public record Condutor(String id) {
	}
}
