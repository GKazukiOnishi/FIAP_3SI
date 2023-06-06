package br.com.fiap.foodflow.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class HistoricoVooDTO implements Validavel {

    private Integer idHistorico;
    private CoordenadaDTO coordenadaInicio;
    private CoordenadaDTO coordenadaFim;
    private BigDecimal altitudeMedia;
    private BigDecimal velocidadeMedia;
    private LocalDateTime inicio;
    private LocalDateTime fim;

    public Integer getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(Integer idHistorico) {
        this.idHistorico = idHistorico;
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
