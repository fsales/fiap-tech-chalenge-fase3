package br.com.fsales.parktech.adapters.in.controller.condutor.mapper;

import br.com.fsales.parktech.adapters.in.controller.condutor.request.CondutorRequest;
import br.com.fsales.parktech.adapters.in.controller.condutor.request.DadosAtualizarCondutorRequest;
import br.com.fsales.parktech.adapters.in.controller.condutor.request.ListarCondutorRequest;
import br.com.fsales.parktech.adapters.in.controller.condutor.response.CondutorResponse;
import br.com.fsales.parktech.application.core.domain.Condutor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CondutorMapper {

	CondutorMapper INSTANCE = Mappers.getMapper(CondutorMapper.class);

	/**
	 * @param condutorRequest
	 * @return
	 */
	Condutor toCondutor(CondutorRequest condutorRequest);

	Condutor toCondutor(DadosAtualizarCondutorRequest condutorRequest);

	/**
	 * @param condutor
	 * @return
	 */
	CondutorResponse toCondutorResponse(Condutor condutor);

	/**
	 * @param listarCondutorRequest
	 * @return
	 */
	Condutor toCondutor(ListarCondutorRequest listarCondutorRequest);
}
