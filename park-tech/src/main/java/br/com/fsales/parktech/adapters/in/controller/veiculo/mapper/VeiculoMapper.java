package br.com.fsales.parktech.adapters.in.controller.veiculo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

	VeiculoMapper INSTANCE = Mappers.getMapper(VeiculoMapper.class);

}
