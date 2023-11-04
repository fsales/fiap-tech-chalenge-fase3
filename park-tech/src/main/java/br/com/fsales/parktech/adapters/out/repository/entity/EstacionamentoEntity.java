package br.com.fsales.parktech.adapters.out.repository.entity;

import java.time.LocalDateTime;

import br.com.fsales.parktech.adapters.out.repository.enumeration.TipoTempoEnumEntity;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "estacionamentos")
public class EstacionamentoEntity {

	@Id
	private String id;

	@NotNull
	@DBRef
	@Indexed
	private CondutorEntity condutor;

	@NotNull
	@DBRef
	@Indexed
	private VeiculoEntity veiculo;

	@NotNull
	@FutureOrPresent
	@Indexed
	private LocalDateTime entrada;

	@FutureOrPresent
	@Indexed
	private LocalDateTime saida;

	@NotNull
	@Indexed
	private TipoTempoEnumEntity tipoTempo;

	@Indexed
	private Integer duracao;

	private Long excedente;

	private Long tempoTotalEstacionado;

	@CreatedDate
	private LocalDateTime createdDate;

	@LastModifiedDate
	private LocalDateTime lastModifiedDate;
}
