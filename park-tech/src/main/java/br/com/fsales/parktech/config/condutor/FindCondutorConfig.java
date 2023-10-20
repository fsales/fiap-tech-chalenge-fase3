package br.com.fsales.parktech.config.condutor;

import br.com.fsales.parktech.adapters.out.condutor.FindCondutorAdapter;
import br.com.fsales.parktech.application.core.usecase.condutor.FindCondutorUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCondutorConfig {

	/**
	 * @param findCondutorAdapter
	 * @return
	 */
	@Bean
	public FindCondutorUseCase findCondutorUseCase(FindCondutorAdapter findCondutorAdapter) {
		return new FindCondutorUseCase(findCondutorAdapter);
	}

}
