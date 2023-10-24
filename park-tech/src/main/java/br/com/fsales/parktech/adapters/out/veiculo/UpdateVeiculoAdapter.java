package br.com.fsales.parktech.adapters.out.veiculo;

import br.com.fsales.parktech.adapters.out.repository.VeiculoRepository;
import br.com.fsales.parktech.adapters.out.repository.mapper.VeiculoEntityMapper;
import br.com.fsales.parktech.application.core.domain.Veiculo;
import br.com.fsales.parktech.application.ports.out.veiculo.UpdateVeiculoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor

@Component
public class UpdateVeiculoAdapter implements UpdateVeiculoOutputPort {

	private final VeiculoRepository veiculoRepository;

	private final VeiculoEntityMapper veiculoEntityMapper;

	/**
	 * @param veiculo
	 * @return
	 */
	@Override
	@Transactional
	public Veiculo update(Veiculo veiculo) {
		Veiculo veiculoRetorno = null;
		var veiculoEntityOptional = veiculoRepository.findById(veiculo.id());

		if (veiculoEntityOptional.isPresent()) {
			var condutorEntity = veiculoEntityOptional.get();
			veiculoEntityMapper.updateVeiculoEntityFromVeiculo(veiculo, condutorEntity);
			veiculoRepository.save(condutorEntity);
			veiculoRetorno = veiculoEntityMapper.toVeiculo(condutorEntity);
		}

		return veiculoRetorno;
	}

}
