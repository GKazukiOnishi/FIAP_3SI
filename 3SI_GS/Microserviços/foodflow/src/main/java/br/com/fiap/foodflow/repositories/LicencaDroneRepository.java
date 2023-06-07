package br.com.fiap.foodflow.repositories;

import br.com.fiap.foodflow.model.Drone;
import br.com.fiap.foodflow.model.LicencaDrone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicencaDroneRepository extends JpaRepository<LicencaDrone, Integer> {

    boolean existsByNumLicenca(Integer numLicenca);

}
