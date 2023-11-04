package br.com.fsales.parktech.adapters.out.repository.impl;

import br.com.fsales.parktech.adapters.out.repository.PageRepositoryCustom;
import br.com.fsales.parktech.adapters.out.repository.VeiculoRepositoryCustom;
import br.com.fsales.parktech.adapters.out.repository.entity.VeiculoEntity;
import br.com.fsales.parktech.adapters.out.repository.mapper.VeiculoEntityMapper;
import br.com.fsales.parktech.application.core.domain.Veiculo;
import br.com.fsales.parktech.application.core.domain.VeiculoFiltroConsultaPaginada;
import br.com.fsales.parktech.application.core.domain.paginacao.Page;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;

@RequiredArgsConstructor
public class VeiculoRepositoryCustomImpl
		implements VeiculoRepositoryCustom<VeiculoEntity>, PageRepositoryCustom<VeiculoEntity> {

	private final MongoTemplate mongoTemplate;

	private final VeiculoEntityMapper veiculoEntityMapper;

	/**
	 * @param filtro
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@Override
	public Page<Veiculo> consultaPaginada(VeiculoFiltroConsultaPaginada filtro, int pageNumber, int pageSize) {
		var criteria = new Criteria();
		var query = new Query(criteria);

		if (StringUtils.isNotBlank(filtro.modelo())) {
			TextCriteria textCriteria = TextCriteria.forDefaultLanguage().matchingPhrase(filtro.modelo());

			query.addCriteria(textCriteria);
		}

		if (StringUtils.isNotBlank(filtro.placa()))
			criteria.and("placa").is(filtro.placa());

		if (StringUtils.isNotBlank(filtro.renavam()))
			criteria.and("renavam").is(filtro.renavam());

		if (StringUtils.isNotBlank(filtro.idCondutor()))
			criteria.and("condutor").is(filtro.idCondutor());

		var page = consultaDocumentosPaginado(query, PageRequest.of(pageNumber, pageSize), mongoTemplate,
				VeiculoEntity.class);
		return page.map(veiculoEntityMapper::toVeiculo);
	}

}
