package br.com.fsales.parktech.config;

import br.com.fsales.parktech.adapters.out.InsertCondutorAdapter;
import br.com.fsales.parktech.application.core.usecase.InsertCondutorUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCondutorConfig {

	@Bean
	public InsertCondutorUseCase insertCondutorUseCase(InsertCondutorAdapter insertCondutorAdapter) {
		return new InsertCondutorUseCase(insertCondutorAdapter);
	}

}
