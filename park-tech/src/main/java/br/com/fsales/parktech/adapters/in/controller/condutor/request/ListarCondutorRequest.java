package br.com.fsales.parktech.adapters.in.controller.condutor.request;

import org.hibernate.validator.constraints.br.CPF;

public record ListarCondutorRequest(String nome, @CPF String cpf, String numeroHabilitacao) {
}
