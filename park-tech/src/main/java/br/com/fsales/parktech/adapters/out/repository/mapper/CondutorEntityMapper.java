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
@DecoratedWith(CondutorEntityMapperDecorator.class)
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

        return CondutorEntityMapperDecorator.criarObjetoCondutorEntity(condutor);
    }

    /**
     * @param condutorEntity
     * @return
     */
    @ObjectFactory
    default Condutor createCondutor(CondutorEntity condutorEntity) {

        return CondutorEntityMapperDecorator.criarObjetoConduto(condutorEntity);
    }

}
