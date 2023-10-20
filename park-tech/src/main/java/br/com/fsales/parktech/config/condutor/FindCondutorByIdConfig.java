package br.com.fsales.parktech.config.condutor;

import br.com.fsales.parktech.adapters.out.condutor.FindCondutorByIdAdapter;
import br.com.fsales.parktech.application.core.usecase.condutor.FindCondutorByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCondutorByIdConfig {

	@Bean
	public FindCondutorByIdUseCase findCondutorByIdUseCase(FindCondutorByIdAdapter findCondutorByIdAdapter) {
		return new FindCondutorByIdUseCase(findCondutorByIdAdapter);
	}

}
