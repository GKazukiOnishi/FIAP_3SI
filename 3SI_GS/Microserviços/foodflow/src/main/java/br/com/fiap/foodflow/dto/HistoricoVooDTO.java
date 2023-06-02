package br.com.fiap.foodflow.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HistoricoVooDTO implements Validavel {

    private Integer idHistorico;
    @NotNull(message = "Um histórico de voo deve ter um drone associado")
    private DroneDTO drone;
    @NotNull(message = "A coordenada de início deve ser informada")
    private CoordenadaDTO coordenadaInicio;
    private CoordenadaDTO coordenadaFim;
    @Digits(integer = 6, fraction = 2, message = "A velocidade média do drone deve possuir até 6 dígitos inteiros e 2 decimais")
    private BigDecimal altitudeMedia;
    @Digits(integer = 6, fraction = 2, message = "A velocidade média do drone deve possuir até 6 dígitos inteiros e 2 decimais")
    private BigDecimal velocidadeMedia;
    @NotNull(message = "O momento de início do voo deve ser informado")
    private LocalDateTime inicio;
    private LocalDateTime fim;

    public Integer getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(Integer idHistorico) {
        this.idHistorico = idHistorico;
    }

    public DroneDTO getDrone() {
        return drone;
    }

    public void setDrone(DroneDTO drone) {
        this.drone = drone;
    }

    public CoordenadaDTO getCoordenadaInicio() {
        return coordenadaInicio;
    }

    public void setCoordenadaInicio(CoordenadaDTO coordenadaInicio) {
        this.coordenadaInicio = coordenadaInicio;
    }

    public CoordenadaDTO getCoordenadaFim() {
        return coordenadaFim;
    }

    public void setCoordenadaFim(CoordenadaDTO coordenadaFim) {
        this.coordenadaFim = coordenadaFim;
    }

    public BigDecimal getAltitudeMedia() {
        return altitudeMedia;
    }

    public void setAltitudeMedia(BigDecimal altitudeMedia) {
        this.altitudeMedia = altitudeMedia;
    }

    public BigDecimal getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(BigDecimal velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

}
