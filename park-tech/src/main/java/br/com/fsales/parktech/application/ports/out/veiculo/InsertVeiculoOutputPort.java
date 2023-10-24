package br.com.fsales.parktech.application.ports.out.veiculo;

import br.com.fsales.parktech.application.core.domain.Veiculo;

public interface InsertVeiculoOutputPort {

    /**
     * @param veiculo
     * @return
     */
    Veiculo insert(final Veiculo veiculo);

}
