package br.com.fsales.parktech.config.condutor;

import br.com.fsales.parktech.application.core.usecase.condutor.DeleteCondutorUseCase;
import br.com.fsales.parktech.application.ports.out.DeleteCondutorOutputPort;
import br.com.fsales.parktech.application.ports.out.FindCondutorByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCondutorConfig {

	@Bean
	public DeleteCondutorUseCase deleteCondutorUseCase(DeleteCondutorOutputPort deleteCondutorOutputPort,
			FindCondutorByIdOutputPort findCondutorByIdOutputPort) {
		return new DeleteCondutorUseCase(deleteCondutorOutputPort, findCondutorByIdOutputPort);
	}

}
