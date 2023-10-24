package br.com.fsales.parktech.adapters.out.repository.mapper;

import br.com.fsales.parktech.adapters.out.repository.entity.CondutorEntity;
import br.com.fsales.parktech.adapters.out.repository.entity.ContatoEntity;
import br.com.fsales.parktech.adapters.out.repository.entity.EnderecoEntity;
import br.com.fsales.parktech.adapters.out.repository.entity.VeiculoEntity;
import br.com.fsales.parktech.application.core.domain.Condutor;
import br.com.fsales.parktech.application.core.domain.Contato;
import br.com.fsales.parktech.application.core.domain.Endereco;
import br.com.fsales.parktech.application.core.domain.Veiculo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class VeiculoEntityMapperDecorator implements VeiculoEntityMapper {


    public void updateVeiculoEntityFromVeiculo(Veiculo veiculo, VeiculoEntity veiculoEntity) {
        var condutor = veiculoEntity.condutor();
        veiculoEntity.setMarca(veiculo.marca()).setModelo(veiculo.modelo()).setPlaca(veiculo.placa()).setRenavam(veiculo.renavam());
    }

    public CondutorEntity condutorToCondutorEntity(Condutor condutor) {


        return CondutorEntityMapperDecorator.criarObjetoCondutorEntity(condutor);
    }


    public Condutor createCondutor(CondutorEntity condutorEntity) {

        return CondutorEntityMapperDecorator.criarObjetoConduto(condutorEntity);
    }

}
