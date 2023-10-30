package br.com.fsales.parktech.config.veiculo;

import br.com.fsales.parktech.application.core.usecase.veiculo.FindVeiculoUseCase;
import br.com.fsales.parktech.application.ports.out.veiculo.FindVeiculoOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindVeiculoConfig {

	/**
	 * @param findVeiculoOutputPort
	 * @return
	 */
	@Bean
	public FindVeiculoUseCase findVeiculoUseCase(FindVeiculoOutputPort findVeiculoOutputPort) {
		return new FindVeiculoUseCase(findVeiculoOutputPort);
	}

}
