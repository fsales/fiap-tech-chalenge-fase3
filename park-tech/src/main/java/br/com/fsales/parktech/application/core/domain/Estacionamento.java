package br.com.fsales.parktech.application.core.domain;

import java.time.LocalDateTime;

import br.com.fsales.parktech.application.core.domain.enumeration.TipoTempoEnum;

public class Estacionamento {
    private String id;
    private Condutor condutor;
    private Veiculo veiculo;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private TipoTempoEnum tipoTempo;

	private Integer duracao;

	private Long excedente;

	private Long tempoTotalEstacionado;

    public Estacionamento() {
    }

	public Estacionamento(String id, Condutor condutor, Veiculo veiculo, LocalDateTime entrada, LocalDateTime saida,
			TipoTempoEnum tipoTempo, Integer duracao, Long excedente, Long tempoTotalEstacionado) {
        this.id = id;
        this.condutor = condutor;
        this.veiculo = veiculo;
        this.entrada = entrada;
        this.saida = saida;
        this.tipoTempo = tipoTempo;
		this.duracao = duracao;
		this.excedente = excedente;
		this.tempoTotalEstacionado = tempoTotalEstacionado;
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

	public Long getExcedente() {
		return excedente;
	}

	public Estacionamento setExcedente(Long excedente) {
		this.excedente = excedente;
		return this;
	}

	public Long getTempoTotalEstacionado() {
		return tempoTotalEstacionado;
    }

	public Estacionamento setTempoTotalEstacionado(Long tempoTotalEstacionado) {
		this.tempoTotalEstacionado = tempoTotalEstacionado;
        return this;
    }
}
