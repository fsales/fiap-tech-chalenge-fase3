package br.com.fsales.parktech.adapters.out.repository;

import br.com.fsales.parktech.application.core.domain.Condutor;
import br.com.fsales.parktech.application.core.domain.paginacao.Page;

public interface CondutorRepositoryCustom<CondutorEntity> {

    /**
     * @param condutor
     * @param pageNumber
     * @param pageSize
     * @return
     */
    Page<Condutor> consultaPaginada(Condutor condutor, int pageNumber, int pageSize);

}
