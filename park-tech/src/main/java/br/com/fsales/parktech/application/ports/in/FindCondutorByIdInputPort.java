package br.com.fsales.parktech.application.ports.in;

import br.com.fsales.parktech.application.core.domain.Condutor;

public interface FindCondutorByIdInputPort {

	Condutor find(final String id);

}
