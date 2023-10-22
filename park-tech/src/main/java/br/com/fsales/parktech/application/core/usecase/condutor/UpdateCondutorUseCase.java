package br.com.fsales.parktech.application.core.usecase.condutor;

import br.com.fsales.parktech.application.core.domain.Condutor;
import br.com.fsales.parktech.application.ports.in.UpdateCondutorInputPort;
import br.com.fsales.parktech.application.ports.out.FindCondutorByIdOutputPort;
import br.com.fsales.parktech.application.ports.out.UpdateCondutorOutputPort;

public class UpdateCondutorUseCase implements UpdateCondutorInputPort {

	private final UpdateCondutorOutputPort updateCondutorOutputPort;

	private final FindCondutorByIdOutputPort findCondutorByIdOutputPort;

	public UpdateCondutorUseCase(UpdateCondutorOutputPort updateCondutorOutputPort,
			FindCondutorByIdOutputPort findCondutorByIdOutputPort) {
		this.updateCondutorOutputPort = updateCondutorOutputPort;
		this.findCondutorByIdOutputPort = findCondutorByIdOutputPort;
	}

	@Override
	public Condutor update(Condutor condutor) {
		findCondutorByIdOutputPort.find(condutor.id())
			.orElseThrow(() -> new RuntimeException("Condutor não encontrado."));
		return updateCondutorOutputPort.update(condutor);
	}

}
