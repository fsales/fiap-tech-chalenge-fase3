package br.com.fsales.parktech.application.ports.in.estacionamento;

import br.com.fsales.parktech.application.core.domain.Estacionamento;

public interface FindEstacionamentoByIdInputPort {

	/**
	 * @param id
	 * @return
	 */
	Estacionamento find(final String id);

}
