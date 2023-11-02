package br.com.fsales.parktech.adapters.out.repository;

import br.com.fsales.parktech.adapters.out.repository.entity.EstacionamentoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstacionamentoRepository extends MongoRepository<EstacionamentoEntity, String> {

}
