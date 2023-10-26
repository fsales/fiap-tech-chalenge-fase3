package br.com.fsales.parktech.adapters.in.controller.veiculo.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record VeiculoFiltroConsultaPaginadaRequest(String placa,
		@Size(min = 10, max = 10) @Pattern(regexp = "^\\d{10}$",
				message = "Formato de Renavam inválido. Utilize XXXXXXXXXX.") String renavam,
		@NotEmpty String modelo, String idCondutor) {
}
