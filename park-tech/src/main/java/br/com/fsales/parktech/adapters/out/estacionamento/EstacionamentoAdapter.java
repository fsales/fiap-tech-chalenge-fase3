package br.com.fsales.parktech.adapters.out.estacionamento;

import br.com.fsales.parktech.adapters.out.repository.EstacionamentoRepository;
import br.com.fsales.parktech.adapters.out.repository.mapper.EstacionamentoEntityMapper;
import br.com.fsales.parktech.application.core.domain.Estacionamento;
import br.com.fsales.parktech.application.ports.out.estacionamento.EstacionamentoOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class EstacionamentoAdapter implements EstacionamentoOutputPort {

	private final EstacionamentoRepository estacionamentoRepository;

	private final EstacionamentoEntityMapper estacionamentoEntityMapper;

	/**
	 * @param estacionamento
	 * @return
	 */
	@Override
	public Estacionamento iniciarEstacionamento(Estacionamento estacionamento) {

		var estacionamentoEntity = estacionamentoEntityMapper.toEstacionamentoEntity(estacionamento);

		estacionamentoEntity = estacionamentoRepository.save(estacionamentoEntity);

		return estacionamentoEntityMapper.toEstacionamento(estacionamentoEntity);
	}

	/**
	 * @param estacionamento
	 * @return
	 */
	@Override
	public Estacionamento sairEstacionamento(Estacionamento estacionamento) {

		var estacionamentoEntity = estacionamentoRepository.findById(estacionamento.getId()).orElseThrow();

		estacionamentoEntityMapper.updateEstacionamentoEntityFromEstacionamento(estacionamento, estacionamentoEntity);
		estacionamentoRepository.save(estacionamentoEntity);

		return estacionamentoEntityMapper.toEstacionamento(estacionamentoEntity);
	}

}
