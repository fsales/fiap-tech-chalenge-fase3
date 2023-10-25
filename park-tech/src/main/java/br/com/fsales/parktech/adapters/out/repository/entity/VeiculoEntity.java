package br.com.fsales.parktech.adapters.out.repository.entity;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "veiculos")
@CompoundIndexes({ @CompoundIndex(name = "placa_renavam", def = "{'placa': 1, 'renavam': 1}"),
		@CompoundIndex(name = "modelo_marca", def = "{'modelo': 1, 'marca': 1}") })
public class VeiculoEntity {

	@Id
	private String id;

	@NotEmpty
	private String modelo;

	@NotEmpty
	private String marca;

	@NotEmpty
	@Pattern(regexp = "^[A-Z0-9]{7}$")
	private String placa;

	@NotEmpty
	@Size(min = 10, max = 10)
	@Pattern(regexp = "^\\d{10}$", message = "Formato de Renavam inválido. Utilize XXXXXXXXXX.")
	private String renavam;

	@NotNull
	@DBRef
	private CondutorEntity condutor;

	@CreatedDate
	private LocalDateTime createdDate;

	@LastModifiedDate
	private LocalDateTime lastModifiedDate;

}
