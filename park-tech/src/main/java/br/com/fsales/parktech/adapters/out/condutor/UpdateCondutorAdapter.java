package br.com.fsales.parktech.adapters.out.condutor;

import br.com.fsales.parktech.adapters.out.repository.CondutorRepository;
import br.com.fsales.parktech.adapters.out.repository.mapper.CondutorEntityMapper;
import br.com.fsales.parktech.application.core.domain.Condutor;
import br.com.fsales.parktech.application.ports.out.UpdateCondutorOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class UpdateCondutorAdapter implements UpdateCondutorOutputPort {

	private final CondutorRepository condutorRepository;

	private final CondutorEntityMapper condutorEntityMapper;

	/**
	 * @param condutor
	 * @return
	 */
	@Override
	public Condutor update(Condutor condutor) {

		var condutorEntity = condutorRepository.findById(condutor.id()).get();

		// condutorEntityMapper.updateCondutorEntityFromCondutor(condutor,
		// condutorEntity);

		// var condutorEntity =
		// condutorRepository.save(condutorEntityMapper.toCondutorEntity(condutor));

		return condutorEntityMapper.toCondutor(condutorEntity);
	}

}
