package br.com.fsales.parktech.application.ports.out.veiculo;

import br.com.fsales.parktech.application.core.domain.Veiculo;
import br.com.fsales.parktech.application.core.domain.paginacao.Page;

public interface FindVeiculoOutputPort {

    /**
     * @param veiculo
     * @param pageNumber
     * @param pageSize
     * @return
     */
    Page<Veiculo> consultaPaginada(final Veiculo veiculo, final int pageNumber, final int pageSize);

}
