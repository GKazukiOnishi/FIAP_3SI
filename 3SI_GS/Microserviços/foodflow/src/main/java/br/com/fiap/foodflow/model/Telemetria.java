package br.com.fiap.foodflow.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Telemetria {

	@Id
	@SequenceGenerator(name = "telemetriaSeq", sequenceName = "telemetria_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "telemetriaSeq")
	@Column(length = 10)
	private Integer idTelemetria;

	@ManyToOne(optional = false)
    private Drone drone;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "latitude", column = @Column(nullable = false)),
			@AttributeOverride(name = "longitude", column = @Column(nullable = false))
	})
	private Coordenada coordenada;

	@Column(precision = 8, scale = 2, nullable = false)
	private BigDecimal velocidade;

	@Column(precision = 8, scale = 2, nullable = false)
	private Integer altitude;

	@Column(length = 3, nullable = false)
	private Integer direcao;

	@Column(nullable = false)
	private LocalDateTime tempo;

	public Integer getIdTelemetria() {
		return idTelemetria;
	}

	public void setIdTelemetria(Integer idTelemetria) {
		this.idTelemetria = idTelemetria;
	}

	public Drone getDrone() {
		return drone;
	}

	public void setDrone(Drone drone) {
		this.drone = drone;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
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

}
