package br.com.fsales.parktech.config.condutor;

import br.com.fsales.parktech.application.core.usecase.condutor.UpdateCondutorUseCase;
import br.com.fsales.parktech.application.ports.out.FindCondutorByIdOutputPort;
import br.com.fsales.parktech.application.ports.out.UpdateCondutorOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCondutorConfig {

	@Bean
	public UpdateCondutorUseCase updateCondutorUseCase(UpdateCondutorOutputPort updateCondutorOutputPort,
			FindCondutorByIdOutputPort findCondutorByIdOutputPort) {
		return new UpdateCondutorUseCase(updateCondutorOutputPort, findCondutorByIdOutputPort);
	}

}
