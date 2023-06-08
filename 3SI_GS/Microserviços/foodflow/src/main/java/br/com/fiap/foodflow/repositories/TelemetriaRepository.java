package br.com.fiap.foodflow.repositories;

import br.com.fiap.foodflow.model.Drone;
import br.com.fiap.foodflow.model.Telemetria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TelemetriaRepository extends JpaRepository<Telemetria, Integer> {

    List<Telemetria> (Drone drone, LocalDateTime inicio, LocalDateTime fim);
    findByDroneAndTempoBetween
}
