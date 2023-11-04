package br.com.fsales.parktech.application.core.usecase.veiculo;

import br.com.fsales.parktech.application.core.domain.Veiculo;
import br.com.fsales.parktech.application.ports.in.veiculo.InsertVeiculoInputPort;
import br.com.fsales.parktech.application.ports.out.condutor.FindCondutorByIdOutputPort;
import br.com.fsales.parktech.application.ports.out.veiculo.InsertVeiculoOutputPort;

public class InsertVeiculoUseCase implements InsertVeiculoInputPort {

	private final InsertVeiculoOutputPort insertVeiculoOutputPort;

	private final FindCondutorByIdOutputPort findCondutorByIdOutputPort;

	public InsertVeiculoUseCase(InsertVeiculoOutputPort insertVeiculoOutputPort,
			FindCondutorByIdOutputPort findCondutorByIdOutputPort) {
		this.insertVeiculoOutputPort = insertVeiculoOutputPort;
		this.findCondutorByIdOutputPort = findCondutorByIdOutputPort;

	}

	@Override
	public Veiculo insert(final Veiculo veiculo) {
		findCondutorByIdOutputPort.find(veiculo.getCondutor().getId())
			.orElseThrow(() -> new RuntimeException("Condutor não existe"));
		return insertVeiculoOutputPort.insert(veiculo);
	}

}
