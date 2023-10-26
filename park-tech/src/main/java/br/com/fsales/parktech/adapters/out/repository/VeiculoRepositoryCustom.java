package br.com.fsales.parktech.adapters.out.repository;

import br.com.fsales.parktech.application.core.domain.Veiculo;
import br.com.fsales.parktech.application.core.domain.VeiculoFiltroConsultaPaginada;
import br.com.fsales.parktech.application.core.domain.paginacao.Page;

public interface VeiculoRepositoryCustom<VeiculoEntity> {

	/**
	 * @param filtro
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	Page<Veiculo> consultaPaginada(VeiculoFiltroConsultaPaginada filtro, int pageNumber, int pageSize);

}
