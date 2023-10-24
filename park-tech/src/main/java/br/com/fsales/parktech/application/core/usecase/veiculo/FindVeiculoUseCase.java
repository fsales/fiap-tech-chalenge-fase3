package br.com.fsales.parktech.application.core.usecase.veiculo;

import br.com.fsales.parktech.application.core.domain.Veiculo;
import br.com.fsales.parktech.application.core.domain.paginacao.Page;
import br.com.fsales.parktech.application.ports.in.veiculo.FindVeiculoInputPort;

public class FindVeiculoUseCase implements FindVeiculoInputPort {

    private final FindVeiculoInputPort findVeiculoInputPort;

    public FindVeiculoUseCase(FindVeiculoInputPort findVeiculoInputPort) {
        this.findVeiculoInputPort = findVeiculoInputPort;
    }

    @Override
    public Page<Veiculo> consultaPaginada(Veiculo veiculo, int pageNumber, int pageSize) {

        return findVeiculoInputPort.consultaPaginada(veiculo, pageNumber, pageSize);
    }

}
