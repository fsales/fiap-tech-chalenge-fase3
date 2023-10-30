package br.com.fsales.parktech.application.core.usecase.veiculo;

import br.com.fsales.parktech.application.core.domain.Veiculo;
import br.com.fsales.parktech.application.ports.in.veiculo.InsertVeiculoInputPort;
import br.com.fsales.parktech.application.ports.out.veiculo.InsertVeiculoOutputPort;

public class InsertVeiculoUseCase implements InsertVeiculoInputPort {

	private final InsertVeiculoOutputPort insertVeiculoOutputPort;

	public InsertVeiculoUseCase(InsertVeiculoOutputPort insertVeiculoOutputPort) {
		this.insertVeiculoOutputPort = insertVeiculoOutputPort;

	}

	@Override
	public Veiculo insert(final Veiculo veiculo) {

		return insertVeiculoOutputPort.insert(veiculo);
	}

}
