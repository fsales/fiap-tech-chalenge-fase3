package br.com.fsales.parktech.application.core.usecase.veiculo;

import br.com.fsales.parktech.application.core.domain.Veiculo;
import br.com.fsales.parktech.application.ports.in.veiculo.UpdateVeiculoInputPort;
import br.com.fsales.parktech.application.ports.out.veiculo.FindVeiculoByIdOutputPort;
import br.com.fsales.parktech.application.ports.out.veiculo.UpdateVeiculoOutputPort;

public class UpdateVeiculoUseCase implements UpdateVeiculoInputPort {

	private final UpdateVeiculoOutputPort updateVeiculoOutputPort;

	private final FindVeiculoByIdOutputPort findVeiculoByIdOutputPort;

	public UpdateVeiculoUseCase(UpdateVeiculoOutputPort updateVeiculoOutputPort, FindVeiculoByIdOutputPort findVeiculoByIdOutputPort) {
		this.updateVeiculoOutputPort = updateVeiculoOutputPort;
		this.findVeiculoByIdOutputPort = findVeiculoByIdOutputPort;
	}

	@Override
	public Veiculo update(Veiculo veiculo) {
		findVeiculoByIdOutputPort.find(veiculo.id())
			.orElseThrow(() -> new RuntimeException("Condutor não encontrado."));

		return updateVeiculoOutputPort.update(veiculo);
	}

}
