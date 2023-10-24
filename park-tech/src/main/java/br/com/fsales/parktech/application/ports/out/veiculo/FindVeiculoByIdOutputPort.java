package br.com.fsales.parktech.application.ports.out.veiculo;

import br.com.fsales.parktech.application.core.domain.Veiculo;

import java.util.Optional;

public interface FindVeiculoByIdOutputPort {

    /**
     * @param id
     * @return
     */
    Optional<Veiculo> find(final String id);

}
