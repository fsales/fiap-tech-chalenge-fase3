package br.com.fsales.parktech.adapters.in.controller.veiculo.mapper;

import br.com.fsales.parktech.adapters.in.controller.veiculo.request.VeiculoRequest;
import br.com.fsales.parktech.adapters.in.controller.veiculo.response.VeiculoResponse;
import br.com.fsales.parktech.application.core.domain.Veiculo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

	VeiculoMapper INSTANCE = Mappers.getMapper(VeiculoMapper.class);

	Veiculo toVeiculo(VeiculoRequest veiculoRequest);

	VeiculoResponse toVeiculoResponse(Veiculo veiculo);

}
