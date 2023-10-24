package br.com.fsales.parktech.adapters.out.repository;

import br.com.fsales.parktech.adapters.out.repository.entity.VeiculoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository
        extends MongoRepository<VeiculoEntity, String>, VeiculoRepositoryCustom<VeiculoEntity> {

}
