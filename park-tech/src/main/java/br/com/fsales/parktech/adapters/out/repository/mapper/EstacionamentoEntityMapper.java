package br.com.fsales.parktech.adapters.out.repository.mapper;

import br.com.fsales.parktech.adapters.out.repository.entity.EstacionamentoEntity;
import br.com.fsales.parktech.application.core.domain.Estacionamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EstacionamentoEntityMapper {

	EstacionamentoEntity toEstacionamentoEntity(Estacionamento estacionamento);

	Estacionamento toEstacionamento(EstacionamentoEntity save);

	@Mapping(target = "id", ignore = true)
	void updateEstacionamentoEntityFromEstacionamento(Estacionamento estacionamento,
			@MappingTarget EstacionamentoEntity estacionamentoEntity);

}
