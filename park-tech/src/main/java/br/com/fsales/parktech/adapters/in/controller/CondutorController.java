package br.com.fsales.parktech.adapters.in.controller;

import br.com.fsales.parktech.adapters.in.controller.mapper.CondutorMapper;
import br.com.fsales.parktech.adapters.in.controller.request.CondutorRequest;
import br.com.fsales.parktech.application.ports.in.InsertCondutorInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/condutores")

@RequiredArgsConstructor
@Log4j2
public class CondutorController {

	private final InsertCondutorInputPort insertCondutorInputPort;

	private final CondutorMapper condutorMapper;

	@PostMapping
	public void cadastrar(@RequestBody @Valid CondutorRequest condutorRequest) {
		log.debug("Salvando dados do condutor: {}", condutorRequest);

		var condutor = condutorMapper.toCondutor(condutorRequest);
		insertCondutorInputPort.insert(condutor);
	}

}
