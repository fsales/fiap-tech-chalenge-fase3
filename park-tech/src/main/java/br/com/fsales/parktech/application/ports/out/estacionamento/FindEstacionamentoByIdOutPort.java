package br.com.fsales.parktech.application.ports.out.estacionamento;

import java.util.Optional;

import br.com.fsales.parktech.application.core.domain.Estacionamento;

public interface FindEstacionamentoByIdOutPort {

	/**
	 * @param id
	 * @return
	 */
	Optional<Estacionamento> find(final String id);

}
