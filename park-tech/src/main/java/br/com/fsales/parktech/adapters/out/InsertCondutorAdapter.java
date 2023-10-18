package br.com.fsales.parktech.adapters.out;

import br.com.fsales.parktech.adapters.out.repository.CondutorRepository;
import br.com.fsales.parktech.adapters.out.repository.mapper.CondutorEntityMapper;
import br.com.fsales.parktech.application.core.domain.Condutor;
import br.com.fsales.parktech.application.ports.out.InsertCondutorOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class InsertCondutorAdapter implements InsertCondutorOutputPort {

	private final CondutorRepository condutorRepository;

	private final CondutorEntityMapper condutorEntityMapper;

	@Override
	public void insert(Condutor condutor) {

		var condutorEntity = condutorEntityMapper.toCondutorEntity(condutor);

		condutorRepository.save(condutorEntity);
	}

}
