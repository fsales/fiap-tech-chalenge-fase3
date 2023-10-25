package br.com.fsales.parktech.adapters.in.controller.veiculo.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record VeiculoRequest(@NotEmpty String modelo, @NotEmpty String marca,
		@Pattern(regexp = "^[A-Z0-9]{7}$") @NotEmpty String placa,
		@Size(min = 10, max = 10) @Pattern(regexp = "^\\d{10}$",
				message = "Formato de Renavam inválido. Utilize XXXXXXXXXX.") @NotEmpty String renavam,
		@NotNull Condutor condutor) {
	public record Condutor(@NotEmpty String id) {
	}
}
