package br.com.fsales.parktech.adapters.out.repository.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EnderecoEntity {

	@NotBlank
	private String rua;

	@NotBlank
	private String logradouro;

	@NotNull
	private Integer numero;

	@NotBlank
	private String complemento;

	@NotBlank
	private String bairro;

	@NotBlank
	private String cidade;

	@Pattern(regexp = "[0-9]{8}")
	@NotBlank
	private String cep;

	@NotBlank
	private String estado;

	@Size(min = 2, max = 2)
	@NotBlank
	private String uf;

}
