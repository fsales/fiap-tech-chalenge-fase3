package br.com.fsales.parktech.adapters.out.repository;

import br.com.fsales.parktech.adapters.out.repository.entity.CondutorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondutorRepository
        extends MongoRepository<CondutorEntity, String>, CondutorRepositoryCustom<CondutorEntity> {

}
