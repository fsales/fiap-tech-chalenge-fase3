package br.com.fsales.parktech.application.core.usecase.veiculo;

import br.com.fsales.parktech.application.core.domain.Veiculo;
import br.com.fsales.parktech.application.ports.in.veiculo.UpdateVeiculoInputPort;
import br.com.fsales.parktech.application.ports.out.condutor.FindCondutorByIdOutputPort;
import br.com.fsales.parktech.application.ports.out.veiculo.FindVeiculoByIdOutputPort;
import br.com.fsales.parktech.application.ports.out.veiculo.UpdateVeiculoOutputPort;

public class UpdateVeiculoUseCase implements UpdateVeiculoInputPort {

	private final UpdateVeiculoOutputPort updateVeiculoOutputPort;

	private final FindVeiculoByIdOutputPort findVeiculoByIdOutputPort;

	private final FindCondutorByIdOutputPort findCondutorByIdOutputPort;

	public UpdateVeiculoUseCase(UpdateVeiculoOutputPort updateVeiculoOutputPort,
			FindVeiculoByIdOutputPort findVeiculoByIdOutputPort,
			FindCondutorByIdOutputPort findCondutorByIdOutputPort) {
		this.updateVeiculoOutputPort = updateVeiculoOutputPort;
		this.findVeiculoByIdOutputPort = findVeiculoByIdOutputPort;
		this.findCondutorByIdOutputPort = findCondutorByIdOutputPort;
	}

	@Override
	public Veiculo update(Veiculo veiculo) {
		findVeiculoByIdOutputPort.find(veiculo.getId())
			.orElseThrow(() -> new RuntimeException("Veiculo não encontrado."));

		findCondutorByIdOutputPort.find(veiculo.getCondutor().getId())
			.orElseThrow(() -> new RuntimeException("Condutor não existe"));


		return updateVeiculoOutputPort.update(veiculo);
	}

}
