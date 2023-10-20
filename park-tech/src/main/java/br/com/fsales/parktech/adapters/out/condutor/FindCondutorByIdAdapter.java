package br.com.fsales.parktech.adapters.out.condutor;

import java.util.Optional;

import br.com.fsales.parktech.adapters.out.repository.CondutorRepository;
import br.com.fsales.parktech.adapters.out.repository.mapper.CondutorEntityMapper;
import br.com.fsales.parktech.application.core.domain.Condutor;
import br.com.fsales.parktech.application.ports.out.FindCondutorByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class FindCondutorByIdAdapter implements FindCondutorByIdOutputPort {

	private final CondutorRepository condutorRepository;

	private final CondutorEntityMapper condutorEntityMapper;

	@Override
	public Optional<Condutor> find(String id) {
		var condutorEntity = condutorRepository.findById(id);

		return condutorEntity.map(condutorEntityMapper::toCondutor);
	}

}
