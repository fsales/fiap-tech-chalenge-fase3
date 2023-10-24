package br.com.fsales.parktech.adapters.in.controller.veiculo;

import br.com.fsales.parktech.adapters.in.controller.ParktechResource;
import br.com.fsales.parktech.adapters.in.controller.veiculo.mapper.VeiculoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ParktechResource.VEICULO)

@RequiredArgsConstructor
@Log4j2
public class VeiculoController {

	private final VeiculoMapper veiculoMapper;

	@GetMapping
	public ResponseEntity<String> teste() {

		return ResponseEntity.ok("teste");
	}
}
