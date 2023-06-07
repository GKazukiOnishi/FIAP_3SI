package br.com.fiap.foodflow.dto.factory;

import br.com.fiap.foodflow.dto.DroneDTO;
import br.com.fiap.foodflow.dto.HistoricoVooDTO;
import br.com.fiap.foodflow.dto.LicencaDroneDTO;
import br.com.fiap.foodflow.model.Coordenada;
import br.com.fiap.foodflow.model.Drone;
import br.com.fiap.foodflow.model.HistoricoVoo;
import br.com.fiap.foodflow.model.LicencaDrone;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
        droneDTO.setHistoricos(getDTOsFromHistoricos(drone.getHistoricos()));
        return droneDTO;
    }

    private static List<HistoricoVooDTO> getDTOsFromHistoricos(Set<HistoricoVoo> historicos) {
        return historicos.stream().map(DroneFactory::getDTOFromHistoricoVoo).sorted(Comparator.comparing(HistoricoVooDTO::getIdHistorico)).toList();
    }

    private static HistoricoVooDTO getDTOFromHistoricoVoo(HistoricoVoo historicoVoo) {
        HistoricoVooDTO historicoVooDTO = new HistoricoVooDTO();
        historicoVooDTO.setIdHistorico(historicoVoo.getIdHistorico());
        historicoVooDTO.setAltitudeMedia(historicoVoo.getAltitudeMedia());
        historicoVooDTO.setFim(historicoVoo.getFim());
        historicoVooDTO.setInicio(historicoVoo.getInicio());
        historicoVooDTO.setCoordenadaFim(CoordenadaFactory.getDTOFromCoordenada(historicoVoo.getCoordenadaFim()));
        historicoVooDTO.setCoordenadaInicio(CoordenadaFactory.getDTOFromCoordenada(historicoVoo.getCoordenadaInicio()));
        historicoVooDTO.setVelocidadeMedia(historicoVoo.getVelocidadeMedia());
        return historicoVooDTO;
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
