package br.com.fsales.parktech.adapters.out.repository.impl;

import br.com.fsales.parktech.adapters.out.repository.CondutorRepositoryCustom;
import br.com.fsales.parktech.adapters.out.repository.PageRepositoryCustom;
import br.com.fsales.parktech.adapters.out.repository.entity.CondutorEntity;
import br.com.fsales.parktech.adapters.out.repository.mapper.CondutorEntityMapper;
import br.com.fsales.parktech.application.core.domain.Condutor;
import br.com.fsales.parktech.application.core.domain.paginacao.Page;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;

@RequiredArgsConstructor
public class CondutorRepositoryCustomImpl
        implements CondutorRepositoryCustom<CondutorEntity>, PageRepositoryCustom<CondutorEntity> {

    // https://docs.spring.io/spring-data/mongodb/reference/repositories/custom-implementations.html
    // https://mhewedy.github.io/spring-data-jpa-mongodb-expressions/

    private final MongoTemplate mongoTemplate;

    private final CondutorEntityMapper condutorEntityMapper;

    private static void montarFiltroConsultaPaginada(Condutor condutor, Query query, Criteria criteria) {
        if (StringUtils.isNotBlank(condutor.nome())) {
            TextCriteria textCriteria = TextCriteria.forDefaultLanguage().matchingPhrase(condutor.nome());

            query.addCriteria(textCriteria);
        }

        if (StringUtils.isNotBlank(condutor.cpf()))
            criteria.and("cpf").is(condutor.cpf());

        if (StringUtils.isNotBlank(condutor.numeroHabilitacao()))
            criteria.and("numeroHabilitacao").is(condutor.numeroHabilitacao());
    }

    @Override
    public Page<Condutor> consultaPaginada(Condutor condutor, int pageNumber, int pageSize) {
        var pageable = PageRequest.of(pageNumber, pageSize);
        var criteria = new Criteria();
        var query = new Query(criteria);

        montarFiltroConsultaPaginada(condutor, query, criteria);

        var dados = consultaDocumentosPaginado(query, pageable, mongoTemplate, CondutorEntity.class);

        return dados.map(condutorEntityMapper::toCondutor);
    }

}
