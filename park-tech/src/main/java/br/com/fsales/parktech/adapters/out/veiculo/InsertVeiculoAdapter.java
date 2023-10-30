package br.com.fsales.parktech.adapters.out.veiculo;

import br.com.fsales.parktech.adapters.out.repository.VeiculoRepository;
import br.com.fsales.parktech.adapters.out.repository.mapper.VeiculoEntityMapper;
import br.com.fsales.parktech.application.core.domain.Veiculo;
import br.com.fsales.parktech.application.ports.out.veiculo.InsertVeiculoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class InsertVeiculoAdapter implements InsertVeiculoOutputPort {

	private final VeiculoRepository veiculoiRepository;

	private final VeiculoEntityMapper veiculoEntityMapper;

	@Override
	public Veiculo insert(Veiculo veiculo) {

		var veiculoEntity = veiculoEntityMapper.toVeiculoEntity(veiculo);

		veiculoEntity = veiculoiRepository.save(veiculoEntity);

		return veiculoEntityMapper.toVeiculo(veiculoEntity);
	}

}
