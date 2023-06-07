package br.com.fiap.foodflow.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Drone {

    @Id
    @SequenceGenerator(name = "droneSeq", sequenceName = "drone_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "droneSeq")
    @Column(length = 5)
    private Integer droneId;

    @Column(nullable = false, length = 50)
    private String modelo;

    @Column(unique = true, nullable = false, length = 8)
    private String serie;

    @OneToOne(cascade = CascadeType.ALL)
    private LicencaDrone licenca;

    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "drone")
    private Set<HistoricoVoo> historicos = new HashSet<>();

    @Column(nullable = false, length = 3)
    private Integer horasVoo;

    @Column(nullable = false, precision = 4, scale = 2)
    private BigDecimal capacidadeCarga;

    @Column(nullable = false, precision = 4, scale = 2)
    private BigDecimal capacidadeBateria;

    @Column(nullable = false)
    private LocalDate dataCompra;

    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "drone")
    private Set<Telemetria> telemetrias;

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

    public LicencaDrone getLicenca() {
        return licenca;
    }

    public void setLicenca(LicencaDrone licenca) {
        this.licenca = licenca;
    }

    public Set<HistoricoVoo> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(Set<HistoricoVoo> historicos) {
        this.historicos = historicos;
    }

    public Integer getHorasVoo() {
        return horasVoo;
    }

    public void setHorasVoo(Integer horasVoo) {
        this.horasVoo = Objects.requireNonNullElse(horasVoo, 0);
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

    public Set<Telemetria> getTelemetrias() {
        return telemetrias;
    }

    public void setTelemetrias(Set<Telemetria> telemetrias) {
        this.telemetrias = telemetrias;
    }
}
