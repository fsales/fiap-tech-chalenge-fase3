package br.com.fsales.parktech.adapters.out.repository.mapper;

import br.com.fsales.parktech.adapters.out.repository.entity.CondutorEntity;
import br.com.fsales.parktech.adapters.out.repository.entity.ContatoEntity;
import br.com.fsales.parktech.adapters.out.repository.entity.EnderecoEntity;
import br.com.fsales.parktech.application.core.domain.Condutor;
import br.com.fsales.parktech.application.core.domain.Contato;
import br.com.fsales.parktech.application.core.domain.Endereco;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ObjectFactory;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
@DecoratedWith(CondutorEntityDecorator.class)
public interface CondutorEntityMapper {

	CondutorEntityMapper INSTANCE = Mappers.getMapper(CondutorEntityMapper.class);

	/**
	 * @param condutor
	 * @return
	 */
	CondutorEntity toCondutorEntity(Condutor condutor);

	/**
	 * @param condutorEntity
	 * @return
	 */
	Condutor toCondutor(CondutorEntity condutorEntity);

	/**
	 * @param condutor
	 * @param condutorEntity
	 */
	void updateCondutorEntityFromCondutor(Condutor condutor, @MappingTarget CondutorEntity condutorEntity);

	/**
	 * @param condutor
	 * @return
	 */
	@ObjectFactory
	default CondutorEntity createCondutorEntity(Condutor condutor) {

		var contatoEntity = new ContatoEntity(condutor.contato().email(), condutor.contato().telefone());
		var enderecoEntity = new EnderecoEntity(condutor.endereco().rua(), condutor.endereco().logradouro(),
				condutor.endereco().numero(), condutor.endereco().complemento(), condutor.endereco().bairro(),
				condutor.endereco().cidade(), condutor.endereco().cep(), condutor.endereco().estado(),
				condutor.endereco().uf());

		return new CondutorEntity(condutor.id(), condutor.nome(), condutor.getDataNascimento(), contatoEntity,
				enderecoEntity, condutor.cpf(), condutor.numeroHabilitacao());
	}

	/**
	 * @param condutorEntity
	 * @return
	 */
	@ObjectFactory
	default Condutor createCondutor(CondutorEntity condutorEntity) {

		var contato = new Contato(condutorEntity.contato().email(), condutorEntity.contato().telefone());
		var endereco = new Endereco(condutorEntity.endereco().rua(), condutorEntity.endereco().logradouro(),
				condutorEntity.endereco().numero(), condutorEntity.endereco().complemento(),
				condutorEntity.endereco().bairro(), condutorEntity.endereco().cidade(), condutorEntity.endereco().cep(),
				condutorEntity.endereco().uf());

		return new Condutor(condutorEntity.id(), condutorEntity.nome(), condutorEntity.getDataNascimento(), contato,
				endereco, condutorEntity.cpf(), condutorEntity.numeroHabilitacao());
	}

}
