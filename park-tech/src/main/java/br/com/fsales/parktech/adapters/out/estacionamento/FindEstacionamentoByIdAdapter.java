package br.com.fsales.parktech.adapters.out.estacionamento;

import java.util.Optional;

import br.com.fsales.parktech.adapters.out.repository.EstacionamentoRepository;
import br.com.fsales.parktech.adapters.out.repository.mapper.EstacionamentoEntityMapper;
import br.com.fsales.parktech.application.core.domain.Estacionamento;
import br.com.fsales.parktech.application.ports.out.estacionamento.FindEstacionamentoByIdOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class FindEstacionamentoByIdAdapter implements FindEstacionamentoByIdOutPort {

	private final EstacionamentoRepository estacionamentoRepository;

	private final EstacionamentoEntityMapper estacionamentoEntityMapper;

	/**
	 * @param id
	 * @return
	 */
	@Override
	public Optional<Estacionamento> find(String id) {
		return estacionamentoRepository.findById(id).map(estacionamentoEntityMapper::toEstacionamento);
	}

}
