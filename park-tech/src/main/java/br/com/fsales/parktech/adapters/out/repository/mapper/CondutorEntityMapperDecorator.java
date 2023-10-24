package br.com.fsales.parktech.adapters.out.repository.mapper;

import br.com.fsales.parktech.adapters.out.repository.entity.CondutorEntity;
import br.com.fsales.parktech.adapters.out.repository.entity.ContatoEntity;
import br.com.fsales.parktech.adapters.out.repository.entity.EnderecoEntity;
import br.com.fsales.parktech.application.core.domain.Condutor;
import br.com.fsales.parktech.application.core.domain.Contato;
import br.com.fsales.parktech.application.core.domain.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class CondutorEntityMapperDecorator implements CondutorEntityMapper {

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

    public static CondutorEntity criarObjetoCondutorEntity(Condutor condutor) {
        var contatoEntity = new ContatoEntity(condutor.contato().email(), condutor.contato().telefone());
        var enderecoEntity = new EnderecoEntity(condutor.endereco().rua(), condutor.endereco().logradouro(),
                condutor.endereco().numero(), condutor.endereco().complemento(), condutor.endereco().bairro(),
                condutor.endereco().cidade(), condutor.endereco().cep(), condutor.endereco().estado(),
                condutor.endereco().uf());

        return new CondutorEntity(condutor.id(), condutor.nome(), condutor.getDataNascimento(), contatoEntity,
                enderecoEntity, condutor.cpf(), condutor.numeroHabilitacao());
    }

    public static Condutor criarObjetoConduto(CondutorEntity condutorEntity) {
        var contato = new Contato(condutorEntity.contato().email(), condutorEntity.contato().telefone());
        var endereco = new Endereco(condutorEntity.endereco().rua(), condutorEntity.endereco().logradouro(),
                condutorEntity.endereco().numero(), condutorEntity.endereco().complemento(),
                condutorEntity.endereco().bairro(), condutorEntity.endereco().cidade(), condutorEntity.endereco().cep(),
                condutorEntity.endereco().uf());

        return new Condutor(condutorEntity.id(), condutorEntity.nome(), condutorEntity.getDataNascimento(), contato,
                endereco, condutorEntity.cpf(), condutorEntity.numeroHabilitacao());
    }
}
