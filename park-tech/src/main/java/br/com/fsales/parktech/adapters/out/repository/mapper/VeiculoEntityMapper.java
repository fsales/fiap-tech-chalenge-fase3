package br.com.fsales.parktech.adapters.out.repository.mapper;

import br.com.fsales.parktech.adapters.out.repository.entity.CondutorEntity;
import br.com.fsales.parktech.adapters.out.repository.entity.VeiculoEntity;
import br.com.fsales.parktech.application.core.domain.Condutor;
import br.com.fsales.parktech.application.core.domain.Veiculo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
// @DecoratedWith(VeiculoEntityMapperDecorator.class)
public interface VeiculoEntityMapper {

	VeiculoEntityMapper INSTANCE = Mappers.getMapper(VeiculoEntityMapper.class);

	Veiculo toVeiculo(VeiculoEntity veiculoEntity);

	VeiculoEntity toVeiculoEntity(Veiculo veiculo);

	void updateVeiculoEntityFromVeiculo(Veiculo veiculo, @MappingTarget VeiculoEntity veiculoEntity);

	CondutorEntity condutorToCondutorEntity(Condutor condutor);

	/**
	 * @param condutorEntity
	 * @return
	 */
	Condutor condutorEntityToCondutor(CondutorEntity condutorEntity);

}
