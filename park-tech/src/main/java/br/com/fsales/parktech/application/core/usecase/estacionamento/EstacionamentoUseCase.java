package br.com.fsales.parktech.application.core.usecase.estacionamento;

import br.com.fsales.parktech.application.core.domain.Estacionamento;
import br.com.fsales.parktech.application.ports.in.estacionamento.EstacionamentoInputPort;
import br.com.fsales.parktech.application.ports.out.estacionamento.EstacionamentoOutputPort;

public class EstacionamentoUseCase implements EstacionamentoInputPort {

	private final EstacionamentoOutputPort estacionamentoOutputPort;

	public EstacionamentoUseCase(EstacionamentoOutputPort estacionamentoOutputPort) {
		this.estacionamentoOutputPort = estacionamentoOutputPort;
	}

	/**
	 * @param estacionamento
	 * @return
	 */
	@Override
	public Estacionamento iniciarEstacionamento(Estacionamento estacionamento) {

		return estacionamentoOutputPort.iniciarEstacionamento(estacionamento);
	}

}
