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

        return new CondutorEntity(condutor.id(), condutor.nome(), condutor.getDataNascimento(), new ContatoEntity(condutor.contato().email(), condutor.contato().telefone()),
                new EnderecoEntity(condutor.endereco().rua(), condutor.endereco().logradouro(),
                        condutor.endereco().numero(), condutor.endereco().complemento(), condutor.endereco().bairro(),
                        condutor.endereco().cidade(), condutor.endereco().cep(), condutor.endereco().estado(),
                        condutor.endereco().uf()), condutor.cpf(), condutor.numeroHabilitacao());
    }


    public Condutor createCondutor(CondutorEntity condutorEntity) {

        return new Condutor(condutorEntity.id(), condutorEntity.nome(), condutorEntity.getDataNascimento(), new Contato(condutorEntity.contato().email(), condutorEntity.contato().telefone()),
                new Endereco(condutorEntity.endereco().rua(), condutorEntity.endereco().logradouro(),
                        condutorEntity.endereco().numero(), condutorEntity.endereco().complemento(),
                        condutorEntity.endereco().bairro(), condutorEntity.endereco().cidade(), condutorEntity.endereco().cep(),
                        condutorEntity.endereco().uf()), condutorEntity.cpf(), condutorEntity.numeroHabilitacao());
    }

}
