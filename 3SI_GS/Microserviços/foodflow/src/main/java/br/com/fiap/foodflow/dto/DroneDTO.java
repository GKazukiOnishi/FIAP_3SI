package br.com.fiap.foodflow.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class DroneDTO implements Validavel {

    private static final String DRONE_ID_FORMAT = "Drone%s";

    private Integer droneId;

    @NotBlank(message = "Modelo obrigatório")
    private String modelo;
    @NotNull(message = "Número de série obrigatório")
    @Pattern(regexp = "^[0-9]{8}$", message = "O número de série é composto por 8 dígitos")
    private String serie;
    @NotNull(message = "Licença obrigatória")
    private LicencaDroneDTO licenca;
    @PositiveOrZero(message = "O valor de horas de voo deve ser zero ou positivo")
    private Integer horasVoo;
    @NotNull(message = "Capacidade de carga obrigatória")
    @PositiveOrZero(message = "A capacidade de carga deve ser zero ou positivo")
    @Digits(integer = 2, fraction = 2, message = "A capacidade de carga deve ser um número com até 2 dígitos inteiros e 2 decimais")
    private BigDecimal capacidadeCarga;
    @NotNull(message = "Capacidade de bateria obrigatória")
    @PositiveOrZero(message = "A capacidade de carga deve ser zero ou positivo")
    @Digits(integer = 2, fraction = 2, message = "A capacidade de bateria deve ser um número com até 2 dígitos inteiros e 2 decimais")
    private BigDecimal capacidadeBateria;
    @NotNull(message = "Data de compra obrigatória")
    private LocalDate dataCompra;

    public Integer getDroneId() {
        return droneId;
    }

    public void setDroneId(Integer droneId) {
        this.droneId = droneId;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public LicencaDroneDTO getLicenca() {
        return licenca;
    }

    public LicencaDroneDTO getLicencaNotNull() {
        return licenca == null ? new LicencaDroneDTO() : licenca;
    }

    public void setLicenca(LicencaDroneDTO licenca) {
        this.licenca = licenca;
    }

    public Integer getHorasVoo() {
        return horasVoo;
    }

    public void setHorasVoo(Integer horasVoo) {
        this.horasVoo = horasVoo;
    }

    public BigDecimal getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(BigDecimal capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public BigDecimal getCapacidadeBateria() {
        return capacidadeBateria;
    }

    public void setCapacidadeBateria(BigDecimal capacidadeBateria) {
        this.capacidadeBateria = capacidadeBateria;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

}
