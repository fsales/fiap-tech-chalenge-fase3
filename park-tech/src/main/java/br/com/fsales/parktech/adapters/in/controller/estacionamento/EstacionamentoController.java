package br.com.fsales.parktech.adapters.in.controller.estacionamento;

import br.com.fsales.parktech.adapters.in.controller.ParktechResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = EstacionamentoSwagger.API_ESTACIONAMENTO_TAG_NAME, description = EstacionamentoSwagger.API_ESTACIONAMENTO_TAG_DESCRIPTION)

@RestController
@RequestMapping(ParktechResource.ESTACIONAMENTO)

@RequiredArgsConstructor
@Log4j2
public class EstacionamentoController {
}
