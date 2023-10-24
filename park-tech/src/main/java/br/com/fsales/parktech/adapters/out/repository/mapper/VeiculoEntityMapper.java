package br.com.fsales.parktech.adapters.out.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VeiculoEntityMapper {

	VeiculoEntityMapper INSTANCE = Mappers.getMapper(VeiculoEntityMapper.class);

}
