package br.com.fsales.parktech.application.ports.out.condutor;

import br.com.fsales.parktech.application.core.domain.Condutor;

import java.util.Optional;

public interface FindCondutorByIdOutputPort {

	/**
	 * @param id
	 * @return
	 */
	Optional<Condutor> find(final String id);

}
