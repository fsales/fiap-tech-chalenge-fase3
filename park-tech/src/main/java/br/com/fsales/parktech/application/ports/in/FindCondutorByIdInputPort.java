package br.com.fsales.parktech.application.ports.in;

import br.com.fsales.parktech.application.core.domain.Condutor;

public interface FindCondutorByIdInputPort {

	/**
	 * @param id
	 * @return
	 */
	Condutor find(final String id);

}
