package br.com.fsales.parktech.application.core.usecase;

import br.com.fsales.parktech.application.core.domain.Condutor;
import br.com.fsales.parktech.application.ports.in.InsertCondutorInputPort;
import br.com.fsales.parktech.application.ports.out.InsertCondutorOutputPort;

public class InsertCondutorUseCase implements InsertCondutorInputPort {

	private final InsertCondutorOutputPort insertCondutorOutputPort;

	public InsertCondutorUseCase(InsertCondutorOutputPort insertCondutorOutputPort) {
		this.insertCondutorOutputPort = insertCondutorOutputPort;
	}

	@Override
	public void insert(Condutor condutor) {
		insertCondutorOutputPort.insert(condutor);
	}

}
