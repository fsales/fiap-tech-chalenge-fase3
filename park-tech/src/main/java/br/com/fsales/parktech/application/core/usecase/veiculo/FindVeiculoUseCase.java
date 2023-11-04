package br.com.fsales.parktech.application.core.usecase.veiculo;

import br.com.fsales.parktech.application.core.domain.Veiculo;
import br.com.fsales.parktech.application.core.domain.VeiculoFiltroConsultaPaginada;
import br.com.fsales.parktech.application.core.domain.paginacao.Page;
import br.com.fsales.parktech.application.ports.in.veiculo.FindVeiculoInputPort;
import br.com.fsales.parktech.application.ports.out.veiculo.FindVeiculoOutputPort;

public class FindVeiculoUseCase implements FindVeiculoInputPort {

	private final FindVeiculoOutputPort findVeiculoOutputPort;

	public FindVeiculoUseCase(FindVeiculoOutputPort findVeiculoOutputPort) {
		this.findVeiculoOutputPort = findVeiculoOutputPort;
	}

	@Override
	public Page<Veiculo> consultaPaginada(VeiculoFiltroConsultaPaginada filtro, int pageNumber, int pageSize) {

		return findVeiculoOutputPort.consultaPaginada(filtro, pageNumber, pageSize);
	}

}
