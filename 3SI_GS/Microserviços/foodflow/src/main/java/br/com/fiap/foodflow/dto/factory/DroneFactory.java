package br.com.fiap.foodflow.dto.factory;

import br.com.fiap.foodflow.dto.DroneDTO;
import br.com.fiap.foodflow.model.Drone;

public class DroneFactory {

    public static Drone getDroneFromDTO(DroneDTO droneDTO) {
        Drone drone = new Drone();
        drone.setModelo(droneDTO.getModelo());
        drone.setSerie(droneDTO.getSerie());
        drone.setCapacidadeCarga(droneDTO.getCapacidadeCarga());
        return drone;
    }

}
