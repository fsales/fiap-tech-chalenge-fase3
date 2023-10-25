package br.com.fsales.parktech.adapters.out.veiculo;

import br.com.fsales.parktech.adapters.out.repository.VeiculoRepository;
import br.com.fsales.parktech.application.core.domain.Veiculo;
import br.com.fsales.parktech.application.core.domain.paginacao.Page;
import br.com.fsales.parktech.application.ports.out.veiculo.FindVeiculoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class FindVeiculoAdapter implements FindVeiculoOutputPort {

	private final VeiculoRepository veiculoRepository;

	@Override
	public Page<Veiculo> consultaPaginada(Veiculo veiculo, int pageNumber, int pageSize) {

		return veiculoRepository.consultaPaginada(veiculo, pageNumber, pageSize);

	}

}
