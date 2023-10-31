package br.com.fsales.parktech.adapters.in.controller.estacionamento;

import br.com.fsales.parktech.adapters.in.controller.ParktechResource;
import br.com.fsales.parktech.adapters.in.controller.estacionamento.mapper.EstacionamentoMapper;
import br.com.fsales.parktech.adapters.in.controller.estacionamento.request.EstacionamentoRequest;
import br.com.fsales.parktech.application.ports.in.estacionamento.EstacionamentoInputPort;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@Tag(name = EstacionamentoSwagger.API_ESTACIONAMENTO_TAG_NAME, description = EstacionamentoSwagger.API_ESTACIONAMENTO_TAG_DESCRIPTION)

@RestController
@RequestMapping(ParktechResource.ESTACIONAMENTO)

@RequiredArgsConstructor
@Log4j2
public class EstacionamentoController {

	private final EstacionamentoInputPort estacionamentoInputPort;

	private final EstacionamentoMapper estacionamentoMapper;

	@PostMapping
	public ResponseEntity<String> iniciarEstacionamento(@RequestBody @Valid EstacionamentoRequest estacionamentoRequest,
			UriComponentsBuilder uriComponentsBuilder) {
		log.debug("Iniciando peridos de estacionamento: {}", estacionamentoRequest);

		var estacionamento = estacionamentoMapper.toEstacionamento(estacionamentoRequest);

		var estacimentoResponse = estacionamentoMapper
			.toEstacionamentoResponse(estacionamentoInputPort.iniciarEstacionamento(estacionamento));

		var uri = uriComponentsBuilder.path(String.format("%s/{id}", ParktechResource.ESTACIONAMENTO))
			.buildAndExpand(estacimentoResponse.id())
			.toUri();

		return ResponseEntity.ok("Estacionamento iniciado com sucesso.");
	}
}
