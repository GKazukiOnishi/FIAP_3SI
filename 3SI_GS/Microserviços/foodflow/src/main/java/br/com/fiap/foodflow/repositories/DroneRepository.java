package br.com.fiap.foodflow.repositories;

import br.com.fiap.foodflow.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<Drone, Integer> {

    boolean existsBySerieAndDroneIdNot(String serie, Integer droneId);

}
