package br.com.fsales.parktech.adapters.out.condutor;

import br.com.fsales.parktech.adapters.out.repository.CondutorRepository;
import br.com.fsales.parktech.application.core.domain.Condutor;
import br.com.fsales.parktech.application.core.domain.paginacao.Page;
import br.com.fsales.parktech.application.ports.out.condutor.FindCondutorOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class FindCondutorAdapter implements FindCondutorOutputPort {

	private final CondutorRepository condutorRepository;

	@Override
	public Page<Condutor> consultaPaginada(Condutor condutor, int pageNumber, int pageSize) {

		return condutorRepository.consultaPaginada(condutor, pageNumber, pageSize);

	}

}
