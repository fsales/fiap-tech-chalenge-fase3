package br.com.fsales.parktech.adapters.in.controller.veiculo.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DadosAtualizarVeiculoRequest(@NotEmpty String id,
		@Schema(name = "modelo", example = "Virtus Higline") @NotEmpty String modelo,
		@Schema(name = "marca", example = "Volkswagen") @NotEmpty String marca,
		@Schema(name = "placa", example = "VAP8V99") @Pattern(regexp = "^[A-Z0-9]{7}$") @NotEmpty String placa,
		@Schema(name = "renavam", example = "1132266690") @Size(min = 10, max = 10) @Pattern(regexp = "^\\d{10}$",
				message = "Formato de Renavam inválido. Utilize XXXXXXXXXX.") @NotEmpty String renavam,
		@Schema(name = "condutor",
				implementation = Condutor.class) @NotNull DadosAtualizarVeiculoRequest.Condutor condutor) {
	public record Condutor(@Schema(name = "id", example = "653fae059451cb68c8572974") @NotEmpty String id) {
	}
}
