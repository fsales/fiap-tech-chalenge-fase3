package br.com.fsales.parktech.application.core.usecase.estacionamento;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.fsales.parktech.application.core.domain.Condutor;
import br.com.fsales.parktech.application.core.domain.Estacionamento;
import br.com.fsales.parktech.application.core.domain.Veiculo;
import br.com.fsales.parktech.application.core.domain.enumeration.TipoTempoEnum;
import br.com.fsales.parktech.application.ports.in.estacionamento.EstacionamentoInputPort;
import br.com.fsales.parktech.application.ports.out.condutor.FindCondutorByIdOutputPort;
import br.com.fsales.parktech.application.ports.out.estacionamento.EstacionamentoOutputPort;
import br.com.fsales.parktech.application.ports.out.estacionamento.FindEstacionamentoByIdOutPort;
import br.com.fsales.parktech.application.ports.out.veiculo.FindVeiculoByIdOutputPort;

public class EstacionamentoUseCase implements EstacionamentoInputPort {

	private final EstacionamentoOutputPort estacionamentoOutputPort;

	private final FindCondutorByIdOutputPort findCondutorByIdOutputPort;

	private final FindVeiculoByIdOutputPort findVeiculoByIdOutputPort;

	private final FindEstacionamentoByIdOutPort findEstacionamentoByIdOutPort;

	public EstacionamentoUseCase(EstacionamentoOutputPort estacionamentoOutputPort,
			FindCondutorByIdOutputPort findCondutorByIdOutputPort, FindVeiculoByIdOutputPort findVeiculoByIdOutputPort,
			FindEstacionamentoByIdOutPort findEstacionamentoByIdOutPort) {
		this.estacionamentoOutputPort = estacionamentoOutputPort;
		this.findCondutorByIdOutputPort = findCondutorByIdOutputPort;
		this.findVeiculoByIdOutputPort = findVeiculoByIdOutputPort;
		this.findEstacionamentoByIdOutPort = findEstacionamentoByIdOutPort;
	}

	private void validarCampos(Estacionamento estacionamento) {

		if (TipoTempoEnum.VARIAVEL.equals(estacionamento.getTipoTempo()) && estacionamento.getDuracao() != null

		) {
			throw new IllegalArgumentException("No período variável, não é permitido informar a duração.");
		}

		if (TipoTempoEnum.FIXO.equals(estacionamento.getTipoTempo()) && estacionamento.getDuracao() == null

		) {
			throw new IllegalArgumentException("No período fixo, a duração é obrigatória.");
		}
	}

	private Veiculo consultarVeiculoPorID(Estacionamento estacionamento) {
		return findVeiculoByIdOutputPort.find(estacionamento.getVeiculo().getId())
			.orElseThrow(() -> new RuntimeException("Veiculo não existe"));
	}

	private Condutor consultarCondutorPorId(Estacionamento estacionamento) {
		return findCondutorByIdOutputPort.find(estacionamento.getCondutor().getId())
			.orElseThrow(() -> new RuntimeException("Condutor não existe"));
	}

	/**
	 * @param estacionamento
	 * @return
	 */
	@Override
	public Estacionamento iniciarEstacionamento(Estacionamento estacionamento) {

		validarCampos(estacionamento);

		var condutor = consultarCondutorPorId(estacionamento);

		var veiculo = consultarVeiculoPorID(estacionamento);

		estacionamento.setCondutor(condutor)
			.setVeiculo(veiculo)
			.setEntrada(LocalDateTime.now().withSecond(0).withNano(0))
			.setSaida(null);

		return estacionamentoOutputPort.iniciarEstacionamento(estacionamento);
	}

	@Override
	public Estacionamento finalizarEstacionamento(String codigoIdentificador) {

		if (codigoIdentificador == null || codigoIdentificador.isEmpty())
			throw new IllegalArgumentException("O código identificador e obrigatorio");

		var estacionamento = findEstacionamentoByIdOutPort.find(codigoIdentificador)
			.orElseThrow(() -> new IllegalArgumentException("Não existe registro de estaciomento."));

		if (estacionamento.getSaida() != null)
			throw new IllegalArgumentException(String.format("Registro de  estaciomento foi finalizado em %s.",
					estacionamento.getSaida().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))));

		validarCampos(estacionamento);

		// Define a data e hora de saida do estacionamento como o momento atual
		estacionamento.setSaida(LocalDateTime.now().withSecond(0).withNano(0));

		long duracaoEmMinutos = Duration.between(estacionamento.getEntrada(), estacionamento.getSaida()).toMinutes();
		estacionamento.setTempoTotalEstacionado(duracaoEmMinutos);

		if (duracaoEmMinutos < 5)
			throw new IllegalArgumentException(
					"Para finalizar, é necessário aguardar um período de cinco minutos após o início. ");

		// Caso o período seja fixo, verifica-se se não houve excesso no horário
		// estacionado.
		if (TipoTempoEnum.FIXO.equals(estacionamento.getTipoTempo())
				&& duracaoEmMinutos > estacionamento.getDuracao()) {

			estacionamento.setExcedente(Math.subtractExact(estacionamento.getDuracao(), duracaoEmMinutos));
		}

		return estacionamentoOutputPort.sairEstacionamento(estacionamento);
	}

}
