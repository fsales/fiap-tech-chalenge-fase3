package br.com.fsales.parktech.config.veiculo;

import br.com.fsales.parktech.application.core.usecase.condutor.FindCondutorUseCase;
import br.com.fsales.parktech.application.core.usecase.veiculo.FindVeiculoUseCase;
import br.com.fsales.parktech.application.ports.in.veiculo.FindVeiculoInputPort;
import br.com.fsales.parktech.application.ports.out.condutor.FindCondutorOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindVeiculoConfig {

	/**
	 * @param findVeiculoInputPort
	 * @return
	 */
	@Bean
	public FindVeiculoUseCase findCondutorUseCase(FindVeiculoInputPort findVeiculoInputPort) {
		return new FindVeiculoUseCase(findVeiculoInputPort);
	}

}
