package br.com.fsales.parktech.application.core.usecase.condutor;

import br.com.fsales.parktech.application.core.domain.Condutor;
import br.com.fsales.parktech.application.ports.in.FindCondutorByIdInputPort;
import br.com.fsales.parktech.application.ports.out.FindCondutorByIdOutputPort;

public class FindCondutorByIdUseCase implements FindCondutorByIdInputPort {

	private final FindCondutorByIdOutputPort findCondutorByIdOutputPort;

	public FindCondutorByIdUseCase(FindCondutorByIdOutputPort findCondutorByIdOutputPort) {
		this.findCondutorByIdOutputPort = findCondutorByIdOutputPort;
	}

	@Override
	public Condutor find(String id) {
		return findCondutorByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Condutor não encontrado."));
	}

}
