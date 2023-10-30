package br.com.fsales.parktech.adapters.in.controller.veiculo.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record VeiculoFiltroConsultaPaginadaRequest(@Schema(name = "placa", example = "VAP8V99") String placa,
		@Schema(name = "renavam", example = "1132266690") @Size(min = 10, max = 10) @Pattern(regexp = "^\\d{10}$",
				message = "Formato de Renavam inválido. Utilize XXXXXXXXXX.") String renavam,
		@Schema(name = "modelo", example = "Virtus Higline") @NotEmpty String modelo,
		@Schema(name = "idCondutor", example = "653fae059451cb68c8572974") String idCondutor) {
}
