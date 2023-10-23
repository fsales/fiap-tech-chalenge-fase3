package br.com.fsales.parktech.adapters.out.condutor;

import br.com.fsales.parktech.adapters.out.repository.CondutorRepository;
import br.com.fsales.parktech.application.ports.out.DeleteCondutorOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class DeleteCondutorAdapter implements DeleteCondutorOutputPort {

	private final CondutorRepository condutorRepository;

	/**
	 * @param id
	 */
	@Override
	public void delete(String id) {

		condutorRepository.deleteById(id);
	}

}
