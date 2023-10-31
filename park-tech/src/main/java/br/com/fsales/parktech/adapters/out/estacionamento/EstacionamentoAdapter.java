package br.com.fsales.parktech.adapters.out.estacionamento;

import br.com.fsales.parktech.application.core.domain.Estacionamento;
import br.com.fsales.parktech.application.ports.out.estacionamento.EstacionamentoOutputPort;
import org.springframework.stereotype.Component;

@Component
public class EstacionamentoAdapter implements EstacionamentoOutputPort {

	/**
	 * @param estacionamento
	 * @return
	 */
	@Override
	public Estacionamento iniciarEstacionamento(Estacionamento estacionamento) {
		return null;
	}

}
