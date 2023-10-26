package br.com.fsales.parktech.adapters.in.controller.veiculo;

import br.com.fsales.parktech.adapters.in.controller.ParktechResource;
import br.com.fsales.parktech.adapters.in.controller.veiculo.mapper.VeiculoMapper;
import br.com.fsales.parktech.adapters.in.controller.veiculo.request.DadosAtualizarVeiculoRequest;
import br.com.fsales.parktech.adapters.in.controller.veiculo.request.VeiculoFiltroConsultaPaginadaRequest;
import br.com.fsales.parktech.adapters.in.controller.veiculo.request.VeiculoRequest;
import br.com.fsales.parktech.adapters.in.controller.veiculo.response.VeiculoResponse;
import br.com.fsales.parktech.application.ports.in.veiculo.DeleteVeiculoInputPort;
import br.com.fsales.parktech.application.ports.in.veiculo.FindVeiculoByIdInputPort;
import br.com.fsales.parktech.application.ports.in.veiculo.FindVeiculoInputPort;
import br.com.fsales.parktech.application.ports.in.veiculo.InsertVeiculoInputPort;
import br.com.fsales.parktech.application.ports.in.veiculo.UpdateVeiculoInputPort;
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
@RequestMapping(ParktechResource.VEICULO)

@RequiredArgsConstructor
@Log4j2
public class VeiculoController {

	private final InsertVeiculoInputPort insertVeiculoInputPort;

	private final UpdateVeiculoInputPort updateVeiculoInputPort;

	private final DeleteVeiculoInputPort deleteVeiculoInputPort;

	private final FindVeiculoByIdInputPort findVeiculoByIdInputPort;

	private final FindVeiculoInputPort findVeiculoInputPort;

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

	@PutMapping
	public ResponseEntity<VeiculoResponse> atualizar(@RequestBody @Valid DadosAtualizarVeiculoRequest veiculoRequest) {
		log.debug("Alterando dados do veiculo: {}", veiculoRequest);

		var veiculo = veiculoMapper.toVeiculo(veiculoRequest);

		var veiculoResponse = veiculoMapper.toVeiculoResponse(updateVeiculoInputPort.update(veiculo));

		return ResponseEntity.ok(veiculoResponse);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		log.debug("Deletando os dados do veiculo: {}", id);

		deleteVeiculoInputPort.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<VeiculoResponse> detalhar(@PathVariable String id) {
		log.debug("detalhar dados do veiculo: {}", id);

		var veiculoResponse = findVeiculoByIdInputPort.find(id);

		return ResponseEntity.ok(veiculoMapper.toVeiculoResponse(veiculoResponse));
	}

	@GetMapping
	public ResponseEntity<Page<VeiculoResponse>> listarTodos(VeiculoFiltroConsultaPaginadaRequest veiculoRequest,
			@PageableDefault Pageable pageable) {
		log.debug("litar dados do veiculo: {}", veiculoRequest);

		var veiculoFiltro = veiculoMapper.toVeiculoFiltroConsultaPaginada(veiculoRequest);

		var page = findVeiculoInputPort
			.consultaPaginada(veiculoFiltro, pageable.getPageNumber(), pageable.getPageSize())
			.map(veiculoMapper::toVeiculoResponse);

		var total = page.totalElements();
		var pageSize = pageable.getPageSize();
		var pageNumber = pageable.getPageNumber();

		return ResponseEntity.ok(new PageImpl<>(page.list(), PageRequest.of(pageNumber, pageSize), total));
	}

}
