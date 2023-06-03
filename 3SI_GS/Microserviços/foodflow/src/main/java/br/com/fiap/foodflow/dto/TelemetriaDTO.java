package br.com.fiap.foodflow.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TelemetriaDTO implements Validavel {

    private Integer idTelemetria;
    @NotNull(message = "Uma telemetria deve possuir um drone associado")
    private DroneDTO drone;
    @NotNull(message = "Uma telemetria deve possuir uma coordenada associada")
    private CoordenadaDTO coordenada;
    @NotNull(message = "Uma telemetria deve possuir uma velocidade associada")
    private BigDecimal velocidade;
    @NotNull(message = "Uma telemetria deve possuir uma altitude associada")
    private Integer altitude;
    @NotNull(message = "Uma telemetria deve possuir uma direcao associada")
    private Integer direcao;
    @NotNull(message = "O momento da telemetria deve ser registrada")
    private LocalDateTime tempo;
    private Boolean decolando;
    private Boolean estacionado;

    public Integer getIdTelemetria() {
        return idTelemetria;
    }

    public void setIdTelemetria(Integer idTelemetria) {
        this.idTelemetria = idTelemetria;
    }

    public DroneDTO getDrone() {
        return drone;
    }

    public void setDrone(DroneDTO drone) {
        this.drone = drone;
    }

    public CoordenadaDTO getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(CoordenadaDTO coordenada) {
        this.coordenada = coordenada;
    }

    public BigDecimal getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(BigDecimal velocidade) {
        this.velocidade = velocidade;
    }

    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    public Integer getDirecao() {
        return direcao;
    }

    public void setDirecao(Integer direcao) {
        this.direcao = direcao;
    }

    public LocalDateTime getTempo() {
        return tempo;
    }

    public void setTempo(LocalDateTime tempo) {
        this.tempo = tempo;
    }

    public Boolean getDecolando() {
        return decolando;
    }

    public void setDecolando(Boolean decolando) {
        this.decolando = decolando;
    }

    public Boolean getEstacionado() {
        return estacionado;
    }

    public void setEstacionado(Boolean estacionado) {
        this.estacionado = estacionado;
    }
    
}
