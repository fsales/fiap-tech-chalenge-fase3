package br.com.fsales.parktech.adapters.out.repository.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

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

    public EnderecoEntity() {
        super();
    }

    public EnderecoEntity(String rua, String logradouro, Integer numero, String complemento, String bairro,
                          String cidade, String cep, String estado, String uf) {
        this.rua = rua;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
        this.uf = uf;
    }

    public String rua() {
        return rua;
    }

    public EnderecoEntity setRua(String rua) {
        this.rua = rua;
        return this;
    }

    public String logradouro() {
        return logradouro;
    }

    public EnderecoEntity setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public Integer numero() {
        return numero;
    }

    public EnderecoEntity setNumero(Integer numero) {
        this.numero = numero;
        return this;
    }

    public String complemento() {
        return complemento;
    }

    public EnderecoEntity setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public String bairro() {
        return bairro;
    }

    public EnderecoEntity setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String cidade() {
        return cidade;
    }

    public EnderecoEntity setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String cep() {
        return cep;
    }

    public EnderecoEntity setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String estado() {
        return estado;
    }

    public EnderecoEntity setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public String uf() {
        return uf;
    }

    public EnderecoEntity setUf(String uf) {
        this.uf = uf;
        return this;
    }

}
