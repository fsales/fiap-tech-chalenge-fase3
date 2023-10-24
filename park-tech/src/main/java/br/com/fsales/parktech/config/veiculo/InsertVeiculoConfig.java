package br.com.fsales.parktech.config.veiculo;

import br.com.fsales.parktech.application.core.usecase.condutor.InsertCondutorUseCase;
import br.com.fsales.parktech.application.core.usecase.veiculo.InsertVeiculoUseCase;
import br.com.fsales.parktech.application.ports.out.condutor.ConsultarEnderecoPorCepOutputPort;
import br.com.fsales.parktech.application.ports.out.condutor.InsertCondutorOutputPort;
import br.com.fsales.parktech.application.ports.out.veiculo.InsertVeiculoOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertVeiculoConfig {

	/**
	 * @param insertVeiculoOutputPort
	 * @return
	 */
	@Bean
	public InsertVeiculoUseCase insertCondutorUseCase(InsertVeiculoOutputPort insertVeiculoOutputPort) {
		return new InsertVeiculoUseCase(insertVeiculoOutputPort);
	}

}
