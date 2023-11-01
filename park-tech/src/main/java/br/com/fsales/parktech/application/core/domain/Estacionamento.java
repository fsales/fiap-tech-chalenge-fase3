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

	private Integer duracaoEmMinutos;

	private Long excedente;

	private Long totalEmMinutos;

    public Estacionamento() {
    }

	public Estacionamento(String id, Condutor condutor, Veiculo veiculo, LocalDateTime entrada, LocalDateTime saida,
			TipoTempoEnum tipoTempo, Integer duracaoEmMinutos, Long excedente, Long totalEmMinutos) {
        this.id = id;
        this.condutor = condutor;
        this.veiculo = veiculo;
        this.entrada = entrada;
        this.saida = saida;
        this.tipoTempo = tipoTempo;
		this.duracaoEmMinutos = duracaoEmMinutos;
		this.excedente = excedente;
		this.totalEmMinutos = totalEmMinutos;
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

	public Integer getDuracaoEmMinutos() {
		return duracaoEmMinutos;
	}

	public Estacionamento setDuracaoEmMinutos(Integer duracaoEmMinutos) {
		this.duracaoEmMinutos = duracaoEmMinutos;
		return this;
	}

	public Long getExcedente() {
		return excedente;
	}

	public Estacionamento setExcedente(Long excedente) {
		this.excedente = excedente;
		return this;
	}

	public Long getTotalEmMinutos() {
		return totalEmMinutos;
    }

	public Estacionamento setTotalEmMinutos(Long totalEmMinutos) {
		this.totalEmMinutos = totalEmMinutos;
        return this;
    }
}
