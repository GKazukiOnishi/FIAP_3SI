package br.com.fiap.foodflow.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.math.BigDecimal;

@Embeddable
public class Coordenada {

    @Column(precision = 6, scale = 3)
    private BigDecimal latitude;
    @Column(precision = 6, scale = 3)
    private BigDecimal longitude;

    public Coordenada() {
    }

    public Coordenada(BigDecimal latitude, BigDecimal longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

}
