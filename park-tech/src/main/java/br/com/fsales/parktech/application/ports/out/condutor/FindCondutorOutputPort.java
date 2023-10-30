package br.com.fsales.parktech.application.ports.out.condutor;

import br.com.fsales.parktech.application.core.domain.Condutor;
import br.com.fsales.parktech.application.core.domain.paginacao.Page;

public interface FindCondutorOutputPort {

	/**
	 * @param condutor
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	Page<Condutor> consultaPaginada(final Condutor condutor, final int pageNumber, final int pageSize);

}
