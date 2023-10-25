package br.com.fsales.parktech.adapters.out.repository.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoEntity {

	@NotBlank
	private String email;

	@NotBlank
	private String telefone;

}
