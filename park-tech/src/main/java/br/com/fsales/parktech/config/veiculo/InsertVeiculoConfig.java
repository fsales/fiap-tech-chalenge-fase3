package br.com.fsales.parktech.config.veiculo;

import br.com.fsales.parktech.application.core.usecase.veiculo.InsertVeiculoUseCase;
import br.com.fsales.parktech.application.ports.out.condutor.FindCondutorByIdOutputPort;
import br.com.fsales.parktech.application.ports.out.veiculo.InsertVeiculoOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertVeiculoConfig {

	/**
	 * @param insertVeiculoOutputPort
	 * @param findCondutorByIdOutputPort
	 * @return
	 */
	@Bean
	public InsertVeiculoUseCase insertVeiculoUseCase(InsertVeiculoOutputPort insertVeiculoOutputPort,
			FindCondutorByIdOutputPort findCondutorByIdOutputPort) {
		return new InsertVeiculoUseCase(insertVeiculoOutputPort, findCondutorByIdOutputPort);
	}

}
