package br.com.fsales.parktech.adapters.in.controller.condutor.request;

import io.swagger.v3.oas.annotations.media.Schema;
import org.hibernate.validator.constraints.br.CPF;

public record ListarCondutorRequest(@Schema(name = "nome", example = "Marcos Andre") String nome,
		@Schema(name = "cpf", example = "50297831054") @CPF String cpf,
		@Schema(name = "numeroHabilitacao", example = "02888820071") String numeroHabilitacao) {
}
