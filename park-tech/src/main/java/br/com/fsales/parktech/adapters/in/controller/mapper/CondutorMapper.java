package br.com.fsales.parktech.adapters.in.controller.mapper;

import br.com.fsales.parktech.adapters.in.controller.request.CondutorRequest;
import br.com.fsales.parktech.application.core.domain.Condutor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CondutorMapper {

	CondutorMapper INSTANCE = Mappers.getMapper(CondutorMapper.class);

	Condutor toCondutor(CondutorRequest condutorRequest);

}
