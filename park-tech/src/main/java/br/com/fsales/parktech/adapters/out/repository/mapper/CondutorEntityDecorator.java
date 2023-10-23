package br.com.fsales.parktech.adapters.out.repository.mapper;

import br.com.fsales.parktech.adapters.out.repository.entity.CondutorEntity;
import br.com.fsales.parktech.application.core.domain.Condutor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class CondutorEntityDecorator implements CondutorEntityMapper {

	@Override
	public void updateCondutorEntityFromCondutor(Condutor condutor, @MappingTarget CondutorEntity condutorEntity) {
		var endereco = condutor.endereco();
		var contato = condutor.contato();

		condutorEntity.endereco()
			.setCep(endereco.cep())
			.setRua(endereco.rua())
			.setLogradouro(endereco.logradouro())
			.setNumero(endereco.numero())
			.setComplemento(endereco.complemento())
			.setBairro(endereco.bairro())
			.setCidade(endereco.cidade())
			.setUf(endereco.uf());

		condutorEntity.contato().setEmail(contato.email()).setTelefone(contato.telefone());
	}

}
