package br.com.fsales.parktech.application.core.domain;

import br.com.fsales.parktech.application.core.domain.enumeration.TipoTempoEnum;

import java.time.LocalDateTime;

public class Estacionamento {
    private String id;
    private Condutor condutor;
    private Veiculo veiculo;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private TipoTempoEnum tipoTempo;
    private Integer duracao;

    public Estacionamento() {
    }

    public Estacionamento(String id, Condutor condutor, Veiculo veiculo, LocalDateTime entrada, LocalDateTime saida, TipoTempoEnum tipoTempo, Integer duracao) {
        this.id = id;
        this.condutor = condutor;
        this.veiculo = veiculo;
        this.entrada = entrada;
        this.saida = saida;
        this.tipoTempo = tipoTempo;
        this.duracao = duracao;
    }

    public String getId() {
        return id;
    }

    public Estacionamento setId(String id) {
        this.id = id;
        return this;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public Estacionamento setCondutor(Condutor condutor) {
        this.condutor = condutor;
        return this;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Estacionamento setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
        return this;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public Estacionamento setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
        return this;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public Estacionamento setSaida(LocalDateTime saida) {
        this.saida = saida;
        return this;
    }

    public TipoTempoEnum getTipoTempo() {
        return tipoTempo;
    }

    public Estacionamento setTipoTempo(TipoTempoEnum tipoTempo) {
        this.tipoTempo = tipoTempo;
        return this;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public Estacionamento setDuracao(Integer duracao) {
        this.duracao = duracao;
        return this;
    }
}
