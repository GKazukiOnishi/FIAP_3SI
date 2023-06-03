package br.com.fiap.foodflow.repositories;

import br.com.fiap.foodflow.model.Drone;
import br.com.fiap.foodflow.model.HistoricoVoo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricoVooRepository extends JpaRepository<HistoricoVoo, Integer> {

    List<HistoricoVoo> findByDroneAndFimNull(Drone drone);

}
