package br.com.fsales.parktech.adapters.in.controller.condutor;

import br.com.fsales.parktech.adapters.in.controller.condutor.mapper.CondutorMapper;
import br.com.fsales.parktech.adapters.in.controller.condutor.request.CondutorRequest;
import br.com.fsales.parktech.adapters.in.controller.condutor.response.CondutorResponse;
import br.com.fsales.parktech.application.ports.in.InsertCondutorInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/condutores")

@RequiredArgsConstructor
@Log4j2
public class CondutorController {

	private final InsertCondutorInputPort insertCondutorInputPort;

	private final CondutorMapper condutorMapper;

	@PostMapping
	public ResponseEntity<CondutorResponse> cadastrar(@RequestBody @Valid CondutorRequest condutorRequest,
			UriComponentsBuilder uriComponentsBuilder) {
		log.debug("Salvando dados do condutor: {}", condutorRequest);

		var condutor = condutorMapper.toCondutor(condutorRequest);

		var condutorResponse = condutorMapper.toCondutorResponse(insertCondutorInputPort.insert(condutor));

		var uri = uriComponentsBuilder.path("/condutores/{id}").buildAndExpand(condutorResponse.id()).toUri();

		return ResponseEntity.created(uri).body(condutorResponse);
	}

}
