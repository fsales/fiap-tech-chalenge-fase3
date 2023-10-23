package br.com.fsales.parktech.adapters.out.condutor;

import br.com.fsales.parktech.adapters.out.repository.CondutorRepository;
import br.com.fsales.parktech.adapters.out.repository.mapper.CondutorEntityMapper;
import br.com.fsales.parktech.application.core.domain.Condutor;
import br.com.fsales.parktech.application.ports.out.UpdateCondutorOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public Condutor update(Condutor condutor) {
		Condutor condutorRetorno = new Condutor();
		var condutorEntityOptional = condutorRepository.findById(condutor.id());

		if (condutorEntityOptional.isPresent()) {
			var condutorEntity = condutorEntityOptional.get();
			condutorEntityMapper.updateCondutorEntityFromCondutor(condutor, condutorEntity);
			condutorRepository.save(condutorEntity);
			condutorRetorno = condutorEntityMapper.toCondutor(condutorEntity);
		}

		return condutorRetorno;
	}

}
