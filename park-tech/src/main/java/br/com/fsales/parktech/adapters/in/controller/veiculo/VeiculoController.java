package br.com.fsales.parktech.adapters.in.controller.veiculo;

import br.com.fsales.parktech.adapters.in.controller.ParktechResource;
import br.com.fsales.parktech.adapters.in.controller.veiculo.mapper.VeiculoMapper;
import br.com.fsales.parktech.adapters.in.controller.veiculo.request.VeiculoRequest;
import br.com.fsales.parktech.adapters.in.controller.veiculo.response.VeiculoResponse;
import br.com.fsales.parktech.application.ports.in.veiculo.InsertVeiculoInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(ParktechResource.VEICULO)

@RequiredArgsConstructor
@Log4j2
public class VeiculoController {

	private final InsertVeiculoInputPort insertVeiculoInputPort;

	private final VeiculoMapper veiculoMapper;

	@PostMapping
	public ResponseEntity<VeiculoResponse> cadastrar(@RequestBody @Valid VeiculoRequest veiculoRequest,
			UriComponentsBuilder uriComponentsBuilder) {
		log.debug("Salvando dados do veiculo: {}", veiculoRequest);

		var veiculo = veiculoMapper.toVeiculo(veiculoRequest);
		var veiculoResponse = veiculoMapper.toVeiculoResponse(insertVeiculoInputPort.insert(veiculo));

		var uri = uriComponentsBuilder.path(String.format("%s/{id}", ParktechResource.VEICULO))
			.buildAndExpand(veiculoResponse.id())
			.toUri();

		return ResponseEntity.created(uri).body(veiculoResponse);
	}

	@GetMapping
	public ResponseEntity<String> teste() {

		return ResponseEntity.ok("teste");
	}

}
