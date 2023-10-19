package br.com.fsales.parktech.application.ports.in;

import br.com.fsales.parktech.application.core.domain.Condutor;

public interface InsertCondutorInputPort {

	Condutor insert(Condutor condutor);

}
