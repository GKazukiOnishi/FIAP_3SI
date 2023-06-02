package br.com.fiap.foodflow.dto;

import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;

public class CoordenadaDTO implements Validavel {

    @Digits(integer = 3, fraction = 3, message = "Latitude inválida")
    private BigDecimal latitude;
    @Digits(integer = 3, fraction = 3, message = "Longitude inválida")
    private BigDecimal longitude;

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
