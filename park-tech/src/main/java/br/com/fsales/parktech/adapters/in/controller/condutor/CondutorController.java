package br.com.fsales.parktech.adapters.in.controller.condutor;

import br.com.fsales.parktech.adapters.in.controller.ParktechResource;
import br.com.fsales.parktech.adapters.in.controller.condutor.mapper.CondutorMapper;
import br.com.fsales.parktech.adapters.in.controller.condutor.request.CondutorRequest;
import br.com.fsales.parktech.adapters.in.controller.condutor.request.DadosAtualizarCondutorRequest;
import br.com.fsales.parktech.adapters.in.controller.condutor.request.ListarCondutorRequest;
import br.com.fsales.parktech.adapters.in.controller.condutor.response.CondutorResponse;
import br.com.fsales.parktech.application.ports.in.DeleteCondutorInputPort;
import br.com.fsales.parktech.application.ports.in.FindCondutorByIdInputPort;
import br.com.fsales.parktech.application.ports.in.FindCondutorInputPort;
import br.com.fsales.parktech.application.ports.in.InsertCondutorInputPort;
import br.com.fsales.parktech.application.ports.in.UpdateCondutorInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(ParktechResource.CONDUTOR)

@RequiredArgsConstructor
@Log4j2
public class CondutorController {

	private final InsertCondutorInputPort insertCondutorInputPort;

	private final UpdateCondutorInputPort updateCondutorInputPort;

	private final FindCondutorByIdInputPort findCondutorByIdInputPort;

	private final FindCondutorInputPort findCondutorInputPort;

	private final DeleteCondutorInputPort deleteCondutorInputPort;

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

	@PutMapping
	public ResponseEntity<CondutorResponse> atualizar(
			@Valid @RequestBody DadosAtualizarCondutorRequest condutorRequest) {
		log.debug("Alterando os dados do condutor: {}", condutorRequest);

		var condutor = condutorMapper.toCondutor(condutorRequest);
		var condutorResponse = condutorMapper.toCondutorResponse(updateCondutorInputPort.update(condutor));
		return ResponseEntity.ok(condutorResponse);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		log.debug("Deletando os dados do condutor: {}", id);

		deleteCondutorInputPort.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CondutorResponse> detalhar(@PathVariable String id) {
		log.debug("detalhar dados do condutor: {}", id);

		var condutor = findCondutorByIdInputPort.find(id);

		return ResponseEntity.ok(condutorMapper.toCondutorResponse(condutor));
	}

	@GetMapping
	public ResponseEntity<Page<CondutorResponse>> listarTodos(ListarCondutorRequest condutorRequest,
			@PageableDefault(sort = { "nome" }) Pageable pageable) {
		log.debug("litar dados do condutor: {}", condutorRequest);

		var condutor = condutorMapper.toCondutor(condutorRequest);

		var page = findCondutorInputPort.consultaPaginada(condutor, pageable.getPageNumber(), pageable.getPageSize())
			.map(condutorMapper::toCondutorResponse);

		var total = page.totalElements();
		var pageSize = pageable.getPageSize();
		var pageNumber = pageable.getPageNumber();

		return ResponseEntity.ok(new PageImpl<>(page.list(), PageRequest.of(pageNumber, pageSize), total));
	}

}
