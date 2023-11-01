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
import org.springframework.data.annotation.Id;
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
	private CondutorEntity condutor;

	@NotNull
	@DBRef
	private VeiculoEntity veiculo;

	@NotNull
	@FutureOrPresent
	private LocalDateTime entrada;

	@FutureOrPresent
	private LocalDateTime saida;

	@NotNull
	private TipoTempoEnumEntity tipoTempo;

	private Integer duracao;

	private Long excedente;

	private Long tempoTotalEstacionado;
}
