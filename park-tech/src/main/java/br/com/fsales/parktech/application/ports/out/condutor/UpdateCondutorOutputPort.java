package br.com.fsales.parktech.application.ports.out.condutor;

import br.com.fsales.parktech.application.core.domain.Condutor;

public interface UpdateCondutorOutputPort {

	/**
	 * @param condutor
	 * @return
	 */
	Condutor update(Condutor condutor);

}
