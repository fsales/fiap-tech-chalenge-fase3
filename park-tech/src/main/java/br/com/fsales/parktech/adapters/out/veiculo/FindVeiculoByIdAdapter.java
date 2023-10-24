package br.com.fsales.parktech.adapters.out.veiculo;

import br.com.fsales.parktech.adapters.out.repository.VeiculoRepository;
import br.com.fsales.parktech.adapters.out.repository.mapper.VeiculoEntityMapper;
import br.com.fsales.parktech.application.core.domain.Veiculo;
import br.com.fsales.parktech.application.ports.out.veiculo.FindVeiculoByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor

@Component
public class FindVeiculoByIdAdapter implements FindVeiculoByIdOutputPort {

	private final VeiculoRepository veiculoRepository;

	private final VeiculoEntityMapper veiculoEntityMapper;

	@Override
	public Optional<Veiculo> find(String id) {
		var veiculoEntity = veiculoRepository.findById(id);

		return veiculoEntity.map(veiculoEntityMapper::toVeiculo);
	}

}
