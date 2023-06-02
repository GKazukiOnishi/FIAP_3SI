package br.com.fiap.foodflow.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class HistoricoVoo {

    @Id
    @SequenceGenerator(name = "historicoSeq", sequenceName = "historico_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historicoSeq")
    private Integer idHistorico;

    @ManyToOne(optional = false)
    private Drone drone;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "latitude_inicio", nullable = false)),
            @AttributeOverride(name = "longitude", column = @Column(name = "longitude_inicio", nullable = false))
    })
    private Coordenada coordenadaInicio;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "latitude_fim")),
            @AttributeOverride(name = "longitude", column = @Column(name = "longitude_fim"))
    })
    private Coordenada coordenadaFim;

    @Column(precision = 8, scale = 2)
    private BigDecimal altitudeMedia;

    @Column(precision = 8, scale = 2)
    private BigDecimal velocidadeMedia;

    @Column(nullable = false)
    private LocalDateTime inicio;

    private LocalDateTime fim;

    public Integer getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(Integer idHistorico) {
        this.idHistorico = idHistorico;
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    public Coordenada getCoordenadaInicio() {
        return coordenadaInicio;
    }

    public void setCoordenadaInicio(Coordenada coordenadaInicio) {
        this.coordenadaInicio = coordenadaInicio;
    }

    public Coordenada getCoordenadaFim() {
        return coordenadaFim;
    }

    public void setCoordenadaFim(Coordenada coordenadaFim) {
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
