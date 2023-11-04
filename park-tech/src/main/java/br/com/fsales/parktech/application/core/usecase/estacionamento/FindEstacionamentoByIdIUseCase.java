package br.com.fsales.parktech.application.core.usecase.estacionamento;

import br.com.fsales.parktech.application.core.domain.Estacionamento;
import br.com.fsales.parktech.application.ports.in.estacionamento.FindEstacionamentoByIdInputPort;
import br.com.fsales.parktech.application.ports.out.estacionamento.FindEstacionamentoByIdOutPort;

public class FindEstacionamentoByIdIUseCase implements FindEstacionamentoByIdInputPort {

	private final FindEstacionamentoByIdOutPort findEstacionamentoByIdOutPort;

	public FindEstacionamentoByIdIUseCase(FindEstacionamentoByIdOutPort findEstacionamentoByIdOutPort) {
		this.findEstacionamentoByIdOutPort = findEstacionamentoByIdOutPort;
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public Estacionamento find(String id) {
		return findEstacionamentoByIdOutPort.find(id)
			.orElseThrow(() -> new RuntimeException("Não existe registro de estaciomento."));
	}

}
