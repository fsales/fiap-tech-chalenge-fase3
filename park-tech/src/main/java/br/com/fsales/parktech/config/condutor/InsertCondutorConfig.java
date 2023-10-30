package br.com.fsales.parktech.config.condutor;

import br.com.fsales.parktech.application.core.usecase.condutor.InsertCondutorUseCase;
import br.com.fsales.parktech.application.ports.out.condutor.ConsultarEnderecoPorCepOutputPort;
import br.com.fsales.parktech.application.ports.out.condutor.InsertCondutorOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCondutorConfig {

	/**
	 * @param insertCondutorOutputPort
	 * @param consultarEnderecoPorCepOutputPort
	 * @return
	 */
	@Bean
	public InsertCondutorUseCase insertCondutorUseCase(InsertCondutorOutputPort insertCondutorOutputPort,
			ConsultarEnderecoPorCepOutputPort consultarEnderecoPorCepOutputPort) {
		return new InsertCondutorUseCase(insertCondutorOutputPort, consultarEnderecoPorCepOutputPort);
	}

}
