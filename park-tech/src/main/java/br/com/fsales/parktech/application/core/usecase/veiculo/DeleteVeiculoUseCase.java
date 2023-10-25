package br.com.fsales.parktech.application.core.usecase.veiculo;

import br.com.fsales.parktech.application.ports.in.veiculo.DeleteVeiculoInputPort;
import br.com.fsales.parktech.application.ports.out.veiculo.DeleteVeiculoOutputPort;
import br.com.fsales.parktech.application.ports.out.veiculo.FindVeiculoByIdOutputPort;

public class DeleteVeiculoUseCase implements DeleteVeiculoInputPort {

	private final DeleteVeiculoOutputPort deleteVeiculoOutputPort;

	private final FindVeiculoByIdOutputPort findVeiculoByIdOutputPort;

	public DeleteVeiculoUseCase(DeleteVeiculoOutputPort deleteVeiculoOutputPort,
			FindVeiculoByIdOutputPort findVeiculoByIdOutputPort) {
		this.deleteVeiculoOutputPort = deleteVeiculoOutputPort;
		this.findVeiculoByIdOutputPort = findVeiculoByIdOutputPort;
	}

	/**
	 * @param id
	 */
	@Override
	public void delete(String id) {
		// faz uma consulta por id e caso não exista irá lança uma mensagem de erro
		findVeiculoByIdOutputPort.find(id);
		deleteVeiculoOutputPort.delete(id);
	}

}
