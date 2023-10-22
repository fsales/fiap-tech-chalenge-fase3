package br.com.fsales.parktech.application.ports.in;

import br.com.fsales.parktech.application.core.domain.Condutor;

public interface UpdateCondutorInputPort {

	/**
	 * @param condutor
	 * @return
	 */
	Condutor update(final Condutor condutor);

}
