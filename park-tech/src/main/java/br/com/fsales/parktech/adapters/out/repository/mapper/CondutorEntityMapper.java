package br.com.fsales.parktech.adapters.out.repository.mapper;

import br.com.fsales.parktech.adapters.out.repository.entity.CondutorEntity;
import br.com.fsales.parktech.adapters.out.repository.entity.ContatoEntity;
import br.com.fsales.parktech.adapters.out.repository.entity.EnderecoEntity;
import br.com.fsales.parktech.application.core.domain.Condutor;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CondutorEntityMapper {

	CondutorEntityMapper INSTANCE = Mappers.getMapper(CondutorEntityMapper.class);

	CondutorEntity toCondutorEntity(Condutor condutor);

	@ObjectFactory
	default CondutorEntity createCondutor(Condutor condutor) {

		var contatoEntity = new ContatoEntity(condutor.contato().email(), condutor.contato().telefone());
		var enderecoEntity = new EnderecoEntity(condutor.endereco().rua(), condutor.endereco().logradouro(),
				condutor.endereco().numero(), condutor.endereco().complemento(), condutor.endereco().bairro(),
				condutor.endereco().cidade(), condutor.endereco().cep(), condutor.endereco().uf());

		return new CondutorEntity(condutor.nome(), contatoEntity, enderecoEntity, condutor.cpf(),
				condutor.numeroHabilitacao());
	}

}
