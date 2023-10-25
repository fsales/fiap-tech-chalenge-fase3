package br.com.fsales.parktech.adapters.out.repository.mapper;

import br.com.fsales.parktech.adapters.out.repository.entity.CondutorEntity;
import br.com.fsales.parktech.application.core.domain.Condutor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CondutorEntityMapper {

	CondutorEntityMapper INSTANCE = Mappers.getMapper(CondutorEntityMapper.class);

	/**
	 * @param condutor
	 * @return
	 */
	CondutorEntity toCondutorEntity(Condutor condutor);

	/**
	 * @param condutorEntity
	 * @return
	 */
	Condutor toCondutor(CondutorEntity condutorEntity);

	/**
	 * @param condutor
	 * @param condutorEntity
	 */
	@Mapping(target = "id", ignore = true)
	void updateCondutorEntityFromCondutor(Condutor condutor, @MappingTarget CondutorEntity condutorEntity);
}
