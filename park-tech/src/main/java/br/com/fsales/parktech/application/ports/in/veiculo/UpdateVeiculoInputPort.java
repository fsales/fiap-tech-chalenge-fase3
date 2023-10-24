package br.com.fsales.parktech.application.ports.in.veiculo;

import br.com.fsales.parktech.application.core.domain.Veiculo;

public interface UpdateVeiculoInputPort {

    /**
     * @param veiculo
     * @return
     */
    Veiculo update(final Veiculo veiculo);

}
