package br.com.fsales.parktech.config.estacionamento;

import br.com.fsales.parktech.application.core.usecase.estacionamento.FindEstacionamentoByIdIUseCase;
import br.com.fsales.parktech.application.ports.out.estacionamento.FindEstacionamentoByIdOutPort;
import org.springframework.context.annotation.Bean;

public class FindEstacionamentoByIdIConfig {

	@Bean
	public FindEstacionamentoByIdIUseCase findEstacionamentoByIdIUseCase(
			FindEstacionamentoByIdOutPort findEstacionamentoByIdOutPort) {
		return new FindEstacionamentoByIdIUseCase(findEstacionamentoByIdOutPort);
	}

}
