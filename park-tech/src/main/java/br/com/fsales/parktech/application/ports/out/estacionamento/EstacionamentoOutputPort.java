package br.com.fsales.parktech.application.ports.out.estacionamento;

import br.com.fsales.parktech.application.core.domain.Estacionamento;

public interface EstacionamentoOutputPort {

	/**
	 * @param estacionamento
	 * @return
	 */
	Estacionamento iniciarEstacionamento(Estacionamento estacionamento);

}
