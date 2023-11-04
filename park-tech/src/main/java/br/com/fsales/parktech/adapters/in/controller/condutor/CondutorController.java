package br.com.fsales.parktech.adapters.in.controller.condutor;

import br.com.fsales.parktech.adapters.in.controller.ParktechResource;
import br.com.fsales.parktech.adapters.in.controller.condutor.mapper.CondutorMapper;
import br.com.fsales.parktech.adapters.in.controller.condutor.request.CondutorRequest;
import br.com.fsales.parktech.adapters.in.controller.condutor.request.DadosAtualizarCondutorRequest;
import br.com.fsales.parktech.adapters.in.controller.condutor.request.ListarCondutorRequest;
import br.com.fsales.parktech.adapters.in.controller.condutor.response.CondutorResponse;
import br.com.fsales.parktech.adapters.in.controller.exception.response.ViolationResponse;
import br.com.fsales.parktech.application.ports.in.condutor.DeleteCondutorInputPort;
import br.com.fsales.parktech.application.ports.in.condutor.FindCondutorByIdInputPort;
import br.com.fsales.parktech.application.ports.in.condutor.FindCondutorInputPort;
import br.com.fsales.parktech.application.ports.in.condutor.InsertCondutorInputPort;
import br.com.fsales.parktech.application.ports.in.condutor.UpdateCondutorInputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springdoc.core.converters.models.PageableAsQueryParam;
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

@Tag(name = CondutorSwagger.API_CONDUTOR_TAG_NAME, description = CondutorSwagger.API_CONDUTOR_TAG_DESCRIPTION)

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

	@Operation(summary = CondutorSwagger.API_CONDUTOR_OPERATION_SUMMARY_CADASTRAR,
			responses = {
					@ApiResponse(responseCode = "201", description = "Registro criado",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = CondutorResponse.class))),
					@ApiResponse(responseCode = "500", description = "Bad Request",
							content = @Content(mediaType = "*/*",
									schema = @Schema(implementation = ViolationResponse.class))) },
			requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true,
					content = @Content(schema = @Schema(implementation = CondutorRequest.class))))
	@PostMapping
	public ResponseEntity<CondutorResponse> cadastrar(@RequestBody @Valid CondutorRequest condutorRequest,
			UriComponentsBuilder uriComponentsBuilder) {

		log.debug("Salvando dados do condutor: {}", condutorRequest);

		var condutor = condutorMapper.toCondutor(condutorRequest);

		var condutorResponse = condutorMapper.toCondutorResponse(insertCondutorInputPort.insert(condutor));

		var uri = uriComponentsBuilder.path(String.format("%s/{id}", ParktechResource.CONDUTOR))
			.buildAndExpand(condutorResponse.id())
			.toUri();

		return ResponseEntity.created(uri).body(condutorResponse);
	}

	@Operation(summary = CondutorSwagger.API_CONDUTOR_OPERATION_SUMMARY_ATUALIZAR,
			responses = {
					@ApiResponse(responseCode = "200", description = "Registro atualizado",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = CondutorResponse.class))),
					@ApiResponse(responseCode = "500", description = "Bad Request",
							content = @Content(mediaType = "*/*",
									schema = @Schema(implementation = ViolationResponse.class))) },
			requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(required = true,
					content = @Content(schema = @Schema(implementation = DadosAtualizarCondutorRequest.class))))
	@PutMapping
	public ResponseEntity<CondutorResponse> atualizar(
			@Valid @RequestBody DadosAtualizarCondutorRequest condutorRequest) {
		log.debug("Alterando os dados do condutor: {}", condutorRequest);

		var condutor = condutorMapper.toCondutor(condutorRequest);
		var condutorResponse = condutorMapper.toCondutorResponse(updateCondutorInputPort.update(condutor));
		return ResponseEntity.ok(condutorResponse);
	}

	@Operation(summary = CondutorSwagger.API_CONDUTOR_OPERATION_SUMMARY_EXCLUIR,
			responses = {
					@ApiResponse(responseCode = "204", description = "Registro excluído",
							content = @Content(mediaType = "*/*")),
					@ApiResponse(responseCode = "500", description = "Bad Request",
							content = @Content(mediaType = "*/*",
									schema = @Schema(implementation = ViolationResponse.class))) })
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		log.debug("Deletando os dados do condutor: {}", id);

		deleteCondutorInputPort.delete(id);
		return ResponseEntity.noContent().build();
	}

	@Operation(summary = CondutorSwagger.API_CONDUTOR_OPERATION_SUMMARY_DETALHAR,
			responses = {
					@ApiResponse(responseCode = "200", description = "Registro encontrado",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = CondutorResponse.class))),
					@ApiResponse(responseCode = "500", description = "Bad Request",
							content = @Content(mediaType = "*/*",
									schema = @Schema(implementation = ViolationResponse.class))) })
	@GetMapping("/{id}")
	public ResponseEntity<CondutorResponse> detalhar(@PathVariable String id) {
		log.debug("detalhar dados do condutor: {}", id);

		var condutor = findCondutorByIdInputPort.find(id);

		return ResponseEntity.ok(condutorMapper.toCondutorResponse(condutor));
	}

	@Operation(summary = CondutorSwagger.API_CONDUTOR_OPERATION_SUMMARY_LISTAR,
			responses = {
					@ApiResponse(responseCode = "200", description = "Registro encontrado",
							content = @Content(mediaType = "application/json",
									schema = @Schema(implementation = CondutorResponse.class))),
					@ApiResponse(responseCode = "204", description = "Registro não encontrado",
							content = @Content(mediaType = "*/*")),
					@ApiResponse(responseCode = "500", description = "Bad Request",
							content = @Content(mediaType = "*/*",
									schema = @Schema(implementation = ViolationResponse.class))) })
	@PageableAsQueryParam
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
