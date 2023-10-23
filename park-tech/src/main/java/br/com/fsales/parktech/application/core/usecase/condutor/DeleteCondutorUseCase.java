package br.com.fsales.parktech.application.core.usecase.condutor;

import br.com.fsales.parktech.application.ports.in.DeleteCondutorInputPort;
import br.com.fsales.parktech.application.ports.out.DeleteCondutorOutputPort;
import br.com.fsales.parktech.application.ports.out.FindCondutorByIdOutputPort;

public class DeleteCondutorUseCase implements DeleteCondutorInputPort {

	private final DeleteCondutorOutputPort deleteCondutorOutputPort;

	private FindCondutorByIdOutputPort findCondutorByIdOutputPort;

	public DeleteCondutorUseCase(DeleteCondutorOutputPort deleteCondutorOutputPort,
			FindCondutorByIdOutputPort findCondutorByIdOutputPort) {
		this.deleteCondutorOutputPort = deleteCondutorOutputPort;
		this.findCondutorByIdOutputPort = findCondutorByIdOutputPort;
	}

	/**
	 * @param id
	 */
	@Override
	public void delete(String id) {
		// faz uma consulta por id e caso não exista irá lança uma mensagem de erro
		findCondutorByIdOutputPort.find(id);
		deleteCondutorOutputPort.delete(id);
	}

}
