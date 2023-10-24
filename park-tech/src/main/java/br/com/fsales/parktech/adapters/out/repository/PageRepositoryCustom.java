package br.com.fsales.parktech.adapters.out.repository;

import br.com.fsales.parktech.application.core.domain.paginacao.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

public interface PageRepositoryCustom<T> {

    int LIMIT = -1;

    int SKIP = -1;

    /**
     * @param query
     * @param pageable
     * @param mongoTemplate
     * @param entityClass
     * @return
     */
    default Page<T> consultaDocumentosPaginado(Query query, Pageable pageable, MongoTemplate mongoTemplate,
                                               Class<T> entityClass) {
        // defindindo a paginaçcao
        query.with(pageable)
                .skip((long) pageable.getPageSize() * pageable.getPageNumber())
                .limit(pageable.getPageSize());

        var list = mongoTemplate.find(query, entityClass);
        var totalElements = mongoTemplate.count(query.skip(SKIP).limit(LIMIT), entityClass);

        return new Page<T>(list, totalElements);
    }

}
