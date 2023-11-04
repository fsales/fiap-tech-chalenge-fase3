package br.com.fsales.parktech.application.ports.out.veiculo;

import java.util.Optional;

import br.com.fsales.parktech.application.core.domain.Veiculo;

public interface FindVeiculoByIdOutputPort {

	/**
	 * @param id
	 * @return
	 */
	Optional<Veiculo> find(final String id);

}
