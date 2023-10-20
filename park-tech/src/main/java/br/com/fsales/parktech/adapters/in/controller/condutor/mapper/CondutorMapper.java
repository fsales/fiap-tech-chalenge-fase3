package br.com.fsales.parktech.adapters.in.controller.condutor.mapper;

import br.com.fsales.parktech.adapters.in.controller.condutor.request.CondutorRequest;
import br.com.fsales.parktech.adapters.in.controller.condutor.request.ListarCondutorRequest;
import br.com.fsales.parktech.adapters.in.controller.condutor.response.CondutorResponse;
import br.com.fsales.parktech.application.core.domain.Condutor;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CondutorMapper {

	CondutorMapper INSTANCE = Mappers.getMapper(CondutorMapper.class);

	/**
	 * @param condutorRequest
	 * @return
	 */
	Condutor toCondutor(CondutorRequest condutorRequest);

	/**
	 * @param condutor
	 * @return
	 */
	CondutorResponse toCondutorResponse(Condutor condutor);

	/**
	 * @param listarCondutorRequest
	 * @return
	 */
	Condutor toCondutor(ListarCondutorRequest listarCondutorRequest);

	/**
	 * @param condutor
	 * @return
	 */
	@ObjectFactory
	default CondutorResponse createCondutorResponse(Condutor condutor) {

		var contato = new CondutorResponse.Contato(condutor.contato().email(), condutor.contato().telefone());
		var endereco = new CondutorResponse.Endereco(condutor.endereco().rua(), condutor.endereco().logradouro(),
				condutor.endereco().numero(), condutor.endereco().complemento(), condutor.endereco().bairro(),
				condutor.endereco().cidade(), condutor.endereco().cep(), condutor.endereco().uf());

		return new CondutorResponse(condutor.id(), condutor.nome(), condutor.cpf(), condutor.getDataNascimento(),
				condutor.numeroHabilitacao(), contato, endereco);
	}

}
