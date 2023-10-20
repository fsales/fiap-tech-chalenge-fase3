package br.com.fsales.parktech.config.condutor;

import br.com.fsales.parktech.adapters.out.condutor.InsertCondutorAdapter;
import br.com.fsales.parktech.application.core.usecase.condutor.InsertCondutorUseCase;
import br.com.fsales.parktech.application.ports.out.ConsultarEnderecoPorCepOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCondutorConfig {

	/**
	 * @param insertCondutorAdapter
	 * @param consultarEnderecoPorCepOutputPort
	 * @return
	 */
	@Bean
	public InsertCondutorUseCase insertCondutorUseCase(InsertCondutorAdapter insertCondutorAdapter,
			ConsultarEnderecoPorCepOutputPort consultarEnderecoPorCepOutputPort) {
		return new InsertCondutorUseCase(insertCondutorAdapter, consultarEnderecoPorCepOutputPort);
	}

}
