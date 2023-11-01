package br.com.fsales.parktech.adapters.in.controller.estacionamento;

import br.com.fsales.parktech.adapters.in.controller.ParktechResource;
import br.com.fsales.parktech.adapters.in.controller.estacionamento.mapper.EstacionamentoMapper;
import br.com.fsales.parktech.adapters.in.controller.estacionamento.request.EstacionamentoRequest;
import br.com.fsales.parktech.adapters.in.controller.estacionamento.response.EstacionamentoResponse;
import br.com.fsales.parktech.adapters.in.controller.exception.response.ViolationResponse;
import br.com.fsales.parktech.application.ports.in.estacionamento.EstacionamentoInputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@Tag(name = EstacionamentoSwagger.API_ESTACIONAMENTO_TAG_NAME,
		description = EstacionamentoSwagger.API_ESTACIONAMENTO_TAG_DESCRIPTION)

@RestController
@RequestMapping(ParktechResource.ESTACIONAMENTO)

@RequiredArgsConstructor
@Log4j2
public class EstacionamentoController {

	private final EstacionamentoInputPort estacionamentoInputPort;

	private final EstacionamentoMapper estacionamentoMapper;

	@Operation(summary = EstacionamentoSwagger.API_ESTACIONAMENTO_OPERATION_SUMMARY_INICIAR,
			responses = {
					@ApiResponse(responseCode = "201", description = "Registro criado",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = EstacionamentoResponse.class))),
					@ApiResponse(responseCode = "500", description = "Bad Request",
							content = @Content(mediaType = "*/*",
									schema = @Schema(implementation = ViolationResponse.class))) },
			requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true,
					content = @Content(schema = @Schema(implementation = EstacionamentoRequest.class))))
	@PostMapping
	public ResponseEntity<EstacionamentoResponse> iniciarEstacionamento(
			@RequestBody @Valid EstacionamentoRequest estacionamentoRequest,
			UriComponentsBuilder uriComponentsBuilder) {
		log.debug("Iniciando peridos de estacionamento: {}", estacionamentoRequest);

		var estacionamento = estacionamentoMapper.toEstacionamento(estacionamentoRequest);

		var estacimentoResponse = estacionamentoMapper
			.toEstacionamentoResponse(estacionamentoInputPort.iniciarEstacionamento(estacionamento));

		var uri = uriComponentsBuilder.path(String.format("%s/{id}", ParktechResource.ESTACIONAMENTO))
			.buildAndExpand(estacimentoResponse.codigoIdentificador())
			.toUri();

		return ResponseEntity.created(uri).body(estacimentoResponse);
	}

	@PutMapping("/{codigoIdentificador}")
	public ResponseEntity<EstacionamentoResponse> finalizarEstacionamento(@PathVariable String codigoIdentificador) {

		var estacimentoResponse = estacionamentoMapper
			.toEstacionamentoResponse(estacionamentoInputPort.finalizarEstacionamento(codigoIdentificador));

		return ResponseEntity.ok(estacimentoResponse);
	}

}
