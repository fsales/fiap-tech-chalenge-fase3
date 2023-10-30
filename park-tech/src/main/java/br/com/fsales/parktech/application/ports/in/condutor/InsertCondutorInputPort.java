package br.com.fsales.parktech.application.ports.in.condutor;

import br.com.fsales.parktech.application.core.domain.Condutor;

public interface InsertCondutorInputPort {

	/**
	 * @param condutor
	 * @return
	 */
	Condutor insert(final Condutor condutor);

}
