package br.com.fsales.parktech.config.condutor;

import br.com.fsales.parktech.application.core.usecase.condutor.FindCondutorUseCase;
import br.com.fsales.parktech.application.ports.out.FindCondutorOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCondutorConfig {

	/**
	 * @param findCondutorOutputPort
	 * @return
	 */
	@Bean
	public FindCondutorUseCase findCondutorUseCase(FindCondutorOutputPort findCondutorOutputPort) {
		return new FindCondutorUseCase(findCondutorOutputPort);
	}

}
