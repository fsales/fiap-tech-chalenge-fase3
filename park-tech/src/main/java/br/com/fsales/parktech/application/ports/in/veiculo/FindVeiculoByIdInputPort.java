package br.com.fsales.parktech.application.ports.in.veiculo;

import br.com.fsales.parktech.application.core.domain.Veiculo;

public interface FindVeiculoByIdInputPort {

    /**
     * @param id
     * @return
     */
    Veiculo find(final String id);

}
