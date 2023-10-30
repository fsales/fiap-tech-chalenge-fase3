package br.com.fsales.parktech.config.veiculo;

import br.com.fsales.parktech.application.core.usecase.veiculo.UpdateVeiculoUseCase;
import br.com.fsales.parktech.application.ports.out.veiculo.FindVeiculoByIdOutputPort;
import br.com.fsales.parktech.application.ports.out.veiculo.UpdateVeiculoOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateVeiculoConfig {

	@Bean
	public UpdateVeiculoUseCase updateVeiculoUseCase(UpdateVeiculoOutputPort updateVeiculoOutputPort,
			FindVeiculoByIdOutputPort findVeiculoByIdOutputPort) {
		return new UpdateVeiculoUseCase(updateVeiculoOutputPort, findVeiculoByIdOutputPort);
	}

}
