package br.com.fiap.foodflow.repositories;

import br.com.fiap.foodflow.model.Telemetria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelemetriaRepository extends JpaRepository<Telemetria, Integer> {

}
