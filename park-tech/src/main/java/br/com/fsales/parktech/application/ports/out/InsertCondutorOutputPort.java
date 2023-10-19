package br.com.fsales.parktech.application.ports.out;

import br.com.fsales.parktech.application.core.domain.Condutor;

public interface InsertCondutorOutputPort {

	Condutor insert(Condutor condutor);

}
