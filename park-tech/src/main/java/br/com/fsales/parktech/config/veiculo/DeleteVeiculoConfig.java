package br.com.fsales.parktech.config.veiculo;

import br.com.fsales.parktech.application.core.usecase.condutor.DeleteCondutorUseCase;
import br.com.fsales.parktech.application.core.usecase.veiculo.DeleteVeiculoUseCase;
import br.com.fsales.parktech.application.ports.out.condutor.DeleteCondutorOutputPort;
import br.com.fsales.parktech.application.ports.out.condutor.FindCondutorByIdOutputPort;
import br.com.fsales.parktech.application.ports.out.veiculo.DeleteVeiculoOutputPort;
import br.com.fsales.parktech.application.ports.out.veiculo.FindVeiculoByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteVeiculoConfig {

	/**
	 * @param deleteVeiculoOutputPort
	 * @param findVeiculoByIdOutputPort
	 * @return
	 */
	@Bean
	public DeleteVeiculoUseCase deleteVeiculoUseCase(DeleteVeiculoOutputPort deleteVeiculoOutputPort, FindVeiculoByIdOutputPort findVeiculoByIdOutputPort) {
		return new DeleteVeiculoUseCase(deleteVeiculoOutputPort, findVeiculoByIdOutputPort);
	}
}
