package br.com.fsales.parktech.application.core.usecase.condutor;

import br.com.fsales.parktech.application.core.domain.Condutor;
import br.com.fsales.parktech.application.core.domain.paginacao.Page;
import br.com.fsales.parktech.application.ports.in.FindCondutorInputPort;
import br.com.fsales.parktech.application.ports.out.FindCondutorOutputPort;

public class FindCondutorUseCase implements FindCondutorInputPort {

	private final FindCondutorOutputPort findCondutorOutputPort;

	public FindCondutorUseCase(FindCondutorOutputPort findCondutorOutputPort) {
		this.findCondutorOutputPort = findCondutorOutputPort;
	}

	@Override
	public Page<Condutor> consultaPaginada(Condutor condutor, int pageNumber, int pageSize) {

		return findCondutorOutputPort.consultaPaginada(condutor, pageNumber, pageSize);
	}

}
