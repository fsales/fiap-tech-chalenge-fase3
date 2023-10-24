package br.com.fsales.parktech.config.veiculo;

import br.com.fsales.parktech.application.core.usecase.condutor.FindCondutorByIdUseCase;
import br.com.fsales.parktech.application.core.usecase.veiculo.FindVeiculoByIdUseCase;
import br.com.fsales.parktech.application.ports.out.condutor.FindCondutorByIdOutputPort;
import br.com.fsales.parktech.application.ports.out.veiculo.FindVeiculoByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindVeiculoByIdConfig {

	/**
	 * @param findVeiculoByIdOutputPort
	 * @return
	 */
	@Bean
	public FindVeiculoByIdUseCase findVeiculoByIdUseCase(FindVeiculoByIdOutputPort findVeiculoByIdOutputPort) {
		return new FindVeiculoByIdUseCase(findVeiculoByIdOutputPort);
	}

}
