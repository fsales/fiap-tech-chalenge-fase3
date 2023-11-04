package br.com.fsales.parktech.application.core.usecase.veiculo;

import br.com.fsales.parktech.application.core.domain.Veiculo;
import br.com.fsales.parktech.application.ports.in.veiculo.FindVeiculoByIdInputPort;
import br.com.fsales.parktech.application.ports.out.veiculo.FindVeiculoByIdOutputPort;

public class FindVeiculoByIdUseCase implements FindVeiculoByIdInputPort {

	private final FindVeiculoByIdOutputPort findVeiculoByIdOutputPort;

	public FindVeiculoByIdUseCase(FindVeiculoByIdOutputPort findVeiculoByIdOutputPort) {
		this.findVeiculoByIdOutputPort = findVeiculoByIdOutputPort;
	}

	@Override
	public Veiculo find(String id) {
		return findVeiculoByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Veiculo não encontrado."));
	}

}
