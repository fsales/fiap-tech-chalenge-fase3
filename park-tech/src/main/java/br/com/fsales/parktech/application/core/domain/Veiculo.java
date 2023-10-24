package br.com.fsales.parktech.application.core.domain;

import java.time.LocalDateTime;

public class Veiculo {

    private String id;
    private String modelo;
    private String marca;
    private  String placa;
    private String renavam;

    private Condutor condutor;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    public Veiculo() {
        super();
    }

    public Veiculo(String id, String modelo, String marca, String placa, String renavam, Condutor condutor, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.renavam = renavam;
        this.condutor = condutor;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public String id() {
        return id;
    }

    public Veiculo setId(String id) {
        this.id = id;
        return this;
    }

    public String modelo() {
        return modelo;
    }

    public Veiculo setModelo(String modelo) {
        this.modelo = modelo;
        return this;
    }

    public String marca() {
        return marca;
    }

    public Veiculo setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public String placa() {
        return placa;
    }

    public Veiculo setPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public String renavam() {
        return renavam;
    }

    public Veiculo setRenavam(String renavam) {
        this.renavam = renavam;
        return this;
    }

    public Condutor condutor() {
        return condutor;
    }

    public Veiculo setCondutor(Condutor condutor) {
        this.condutor = condutor;
        return this;
    }

    public LocalDateTime createdDate() {
        return createdDate;
    }

    public Veiculo setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public LocalDateTime lastModifiedDate() {
        return lastModifiedDate;
    }

    public Veiculo setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
        return this;
    }
}
