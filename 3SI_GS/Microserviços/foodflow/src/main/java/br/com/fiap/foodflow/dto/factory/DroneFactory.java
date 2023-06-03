package br.com.fiap.foodflow.dto.factory;

import br.com.fiap.foodflow.dto.DroneDTO;
import br.com.fiap.foodflow.dto.LicencaDroneDTO;
import br.com.fiap.foodflow.model.Drone;
import br.com.fiap.foodflow.model.LicencaDrone;

import java.util.List;

public class DroneFactory {

    public static Drone getDroneFromDTO(DroneDTO droneDTO) {
        Drone drone = new Drone();
        drone.setDroneId(droneDTO.getDroneId());
        drone.setModelo(droneDTO.getModelo());
        drone.setSerie(droneDTO.getSerie());
        drone.setLicenca(getLicencaFromDTO(droneDTO.getLicenca()));
        drone.setHorasVoo(droneDTO.getHorasVoo());
        drone.setCapacidadeCarga(droneDTO.getCapacidadeCarga());
        drone.setCapacidadeBateria(droneDTO.getCapacidadeBateria());
        drone.setDataCompra(droneDTO.getDataCompra());
        return drone;
    }

    private static LicencaDrone getLicencaFromDTO(LicencaDroneDTO licencaDTO) {
        LicencaDrone licencaDrone = new LicencaDrone();
        licencaDrone.setNumLicenca(licencaDTO.getNumLicenca());
        licencaDrone.setTitular(licencaDTO.getTitular());
        licencaDrone.setDataEmissao(licencaDTO.getDataEmissao());
        licencaDrone.setDataValidade(licencaDTO.getDataValidade());
        return licencaDrone;
    }

    public static List<DroneDTO> getDTOsFromDrones(List<Drone> drones) {
        return drones.stream().map(DroneFactory::getDTOFromDrone).toList();
    }

    public static DroneDTO getDTOFromDrone(Drone drone) {
        DroneDTO droneDTO = new DroneDTO();
        droneDTO.setDroneId(drone.getDroneId());
        droneDTO.setModelo(drone.getModelo());
        droneDTO.setSerie(drone.getSerie());
        droneDTO.setLicenca(getDTOFromLicenca(drone.getLicenca()));
        droneDTO.setHorasVoo(drone.getHorasVoo());
        droneDTO.setCapacidadeCarga(drone.getCapacidadeCarga());
        droneDTO.setCapacidadeBateria(drone.getCapacidadeBateria());
        droneDTO.setDataCompra(drone.getDataCompra());
        return droneDTO;
    }

    private static LicencaDroneDTO getDTOFromLicenca(LicencaDrone licenca) {
        LicencaDroneDTO licencaDTO = new LicencaDroneDTO();
        licencaDTO.setNumLicenca(licenca.getNumLicenca());
        licencaDTO.setTitular(licenca.getTitular());
        licencaDTO.setDataEmissao(licenca.getDataEmissao());
        licencaDTO.setDataValidade(licenca.getDataValidade());
        return licencaDTO;
    }

}
