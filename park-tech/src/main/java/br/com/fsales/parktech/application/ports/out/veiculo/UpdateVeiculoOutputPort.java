package br.com.fsales.parktech.application.ports.out.veiculo;

import br.com.fsales.parktech.application.core.domain.Veiculo;

public interface UpdateVeiculoOutputPort {

    /**
     * @param veiculo
     * @return
     */
    Veiculo update(final Veiculo veiculo);

}
