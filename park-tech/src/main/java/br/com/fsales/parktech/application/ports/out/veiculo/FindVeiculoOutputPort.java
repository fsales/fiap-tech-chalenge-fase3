package br.com.fsales.parktech.application.ports.out.veiculo;

import br.com.fsales.parktech.application.core.domain.Veiculo;
import br.com.fsales.parktech.application.core.domain.VeiculoFiltroConsultaPaginada;
import br.com.fsales.parktech.application.core.domain.paginacao.Page;

public interface FindVeiculoOutputPort {

	/**
	 * @param filtro
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	Page<Veiculo> consultaPaginada(final VeiculoFiltroConsultaPaginada filtro, final int pageNumber,
			final int pageSize);

}
