package br.com.fsales.parktech.adapters.out.repository.impl;

import br.com.fsales.parktech.adapters.out.repository.VeiculoRepositoryCustom;
import br.com.fsales.parktech.adapters.out.repository.entity.VeiculoEntity;
import br.com.fsales.parktech.application.core.domain.Veiculo;
import br.com.fsales.parktech.application.core.domain.paginacao.Page;

public class VeiculoRepositoryCustomImpl implements VeiculoRepositoryCustom<VeiculoEntity> {

	/**
	 * @param veiculo
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@Override
	public Page<Veiculo> consultaPaginada(Veiculo veiculo, int pageNumber, int pageSize) {
		return null;
	}

}
