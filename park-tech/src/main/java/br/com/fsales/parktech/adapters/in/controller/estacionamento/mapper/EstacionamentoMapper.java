package br.com.fsales.parktech.adapters.in.controller.estacionamento.mapper;

import br.com.fsales.parktech.adapters.in.controller.estacionamento.request.EstacionamentoRequest;
import br.com.fsales.parktech.adapters.in.controller.estacionamento.response.EstacionamentoResponse;
import br.com.fsales.parktech.application.core.domain.Estacionamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EstacionamentoMapper {

	EstacionamentoMapper INSTANCE = Mappers.getMapper(EstacionamentoMapper.class);

	Estacionamento toEstacionamento(EstacionamentoRequest estacionamentoRequest);

	@Mapping(target = "codigoIdentificador", source = "id")
	EstacionamentoResponse toEstacionamentoResponse(Estacionamento estacionamento);

}
