package br.com.fsales.parktech.config.estacionamento;

import br.com.fsales.parktech.application.core.usecase.estacionamento.EstacionamentoUseCase;
import br.com.fsales.parktech.application.ports.out.estacionamento.EstacionamentoOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EstacionamentoConfig {

	@Bean
	public EstacionamentoUseCase estacionamentoUseCase(EstacionamentoOutputPort estacionamentoOutputPort) {
		return new EstacionamentoUseCase(estacionamentoOutputPort);
	}

}
