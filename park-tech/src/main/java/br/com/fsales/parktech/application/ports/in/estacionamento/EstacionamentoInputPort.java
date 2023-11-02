package br.com.fsales.parktech.application.ports.in.estacionamento;

import br.com.fsales.parktech.application.core.domain.Estacionamento;

public interface EstacionamentoInputPort {

	/**
	 * @param estacionamento
	 * @return
	 */
	Estacionamento iniciarEstacionamento(final Estacionamento estacionamento);

	/**
	 * @param codigoIdentificador
	 * @return
	 */
	Estacionamento finalizarEstacionamento(final String codigoIdentificador);
}
