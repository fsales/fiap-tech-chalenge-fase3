package br.com.fsales.parktech.config.estacionamento;

import br.com.fsales.parktech.application.core.usecase.estacionamento.EstacionamentoUseCase;
import br.com.fsales.parktech.application.ports.out.condutor.FindCondutorByIdOutputPort;
import br.com.fsales.parktech.application.ports.out.estacionamento.EstacionamentoOutputPort;
import br.com.fsales.parktech.application.ports.out.estacionamento.FindEstacionamentoByIdOutPort;
import br.com.fsales.parktech.application.ports.out.veiculo.FindVeiculoByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EstacionamentoConfig {

	@Bean
	public EstacionamentoUseCase estacionamentoUseCase(EstacionamentoOutputPort estacionamentoOutputPort,
			FindCondutorByIdOutputPort findCondutorByIdOutputPort, FindVeiculoByIdOutputPort findVeiculoByIdOutputPort,
			FindEstacionamentoByIdOutPort findEstacionamentoByIdOutPort) {
		return new EstacionamentoUseCase(estacionamentoOutputPort, findCondutorByIdOutputPort,
				findVeiculoByIdOutputPort, findEstacionamentoByIdOutPort);
	}

}
