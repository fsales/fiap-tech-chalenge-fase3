package br.com.fsales.parktech.application.ports.out.condutor;

import java.util.Optional;

import br.com.fsales.parktech.application.core.domain.Condutor;

public interface FindCondutorByIdOutputPort {

	/**
	 * @param id
	 * @return
	 */
	Optional<Condutor> find(final String id);

}
