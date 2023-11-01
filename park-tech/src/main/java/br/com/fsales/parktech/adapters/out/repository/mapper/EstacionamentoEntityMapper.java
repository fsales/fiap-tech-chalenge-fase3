package br.com.fsales.parktech.adapters.out.repository.mapper;

import br.com.fsales.parktech.adapters.out.repository.entity.EstacionamentoEntity;
import br.com.fsales.parktech.application.core.domain.Estacionamento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstacionamentoEntityMapper {

	EstacionamentoEntity toEstacionamentoEntity(Estacionamento estacionamento);

	Estacionamento toEstacionamento(EstacionamentoEntity save);

}
