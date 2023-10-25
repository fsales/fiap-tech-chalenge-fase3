package br.com.fsales.parktech.config.veiculo;

import br.com.fsales.parktech.application.core.usecase.veiculo.InsertVeiculoUseCase;
import br.com.fsales.parktech.application.ports.out.veiculo.InsertVeiculoOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertVeiculoConfig {

	/**
	 * @param insertVeiculoOutputPort
	 * @return
	 */
	@Bean
	public InsertVeiculoUseCase insertVeiculoUseCase(InsertVeiculoOutputPort insertVeiculoOutputPort) {
		return new InsertVeiculoUseCase(insertVeiculoOutputPort);
	}

}
