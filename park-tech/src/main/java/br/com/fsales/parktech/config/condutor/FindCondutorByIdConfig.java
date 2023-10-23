package br.com.fsales.parktech.config.condutor;

import br.com.fsales.parktech.application.core.usecase.condutor.FindCondutorByIdUseCase;
import br.com.fsales.parktech.application.ports.out.FindCondutorByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCondutorByIdConfig {

	/**
	 * @param findCondutorByIdOutputPort
	 * @return
	 */
	@Bean
	public FindCondutorByIdUseCase findCondutorByIdUseCase(FindCondutorByIdOutputPort findCondutorByIdOutputPort) {
		return new FindCondutorByIdUseCase(findCondutorByIdOutputPort);
	}

}
