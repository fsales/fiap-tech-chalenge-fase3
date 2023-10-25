package br.com.fsales.parktech.application.ports.in.veiculo;

import br.com.fsales.parktech.application.core.domain.Veiculo;

public interface InsertVeiculoInputPort {

	/**
	 * @param veiculo
	 * @return
	 */
	Veiculo insert(final Veiculo veiculo);

}
