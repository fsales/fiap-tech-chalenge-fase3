package br.com.fsales.parktech.application.ports.out;

import java.util.Optional;

import br.com.fsales.parktech.application.core.domain.Condutor;

public interface FindCondutorByIdOutputPort {

	Optional<Condutor> find(final String id);

}