package br.com.fsales.parktech.adapters.out.repository.mapper;

import br.com.fsales.parktech.adapters.out.client.response.EnderecoResponse;
import br.com.fsales.parktech.application.core.domain.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EnderecoResponseMapper {

    EnderecoResponseMapper INSTANCE = Mappers.getMapper(EnderecoResponseMapper.class);

    @Mapping(target = "cidade", source = "localidade")
    Endereco toEndereco(EnderecoResponse enderecoResponse);

}
