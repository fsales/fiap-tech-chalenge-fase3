package br.com.fsales.parktech.adapters.out.repository.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "veiculos")

@CompoundIndexes({@CompoundIndex(name = "placa_renavam", def = "{'placa': 1, 'renavam': 1}"),
        @CompoundIndex(name = "modelo_marca", def = "{'modelo': 1, 'marca': 1}")})
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

    public VeiculoEntity() {
        super();
    }

    public VeiculoEntity(String id, String modelo, String marca, String placa, String renavam,
                         CondutorEntity condutor) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.renavam = renavam;
        this.condutor = condutor;
    }

    public String id() {
        return id;
    }

    public VeiculoEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String modelo() {
        return modelo;
    }

    public VeiculoEntity setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public String marca() {
        return marca;
    }

    public VeiculoEntity setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public String placa() {
        return placa;
    }

    public VeiculoEntity setPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public String renavam() {
        return renavam;
    }

    public VeiculoEntity setRenavam(String renavam) {
        this.renavam = renavam;
        return this;
    }

    public CondutorEntity condutor() {
        return condutor;
    }

    public VeiculoEntity setCondutor(CondutorEntity condutor) {
        this.condutor = condutor;
        return this;
    }

    public LocalDateTime createdDate() {
        return createdDate;
    }

    public LocalDateTime lastModifiedDate() {
        return lastModifiedDate;
    }

}
