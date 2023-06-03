package br.com.fiap.foodflow.dto.factory;

import br.com.fiap.foodflow.dto.CoordenadaDTO;
import br.com.fiap.foodflow.dto.DroneDTO;
import br.com.fiap.foodflow.dto.LicencaDroneDTO;
import br.com.fiap.foodflow.dto.TelemetriaDTO;
import br.com.fiap.foodflow.model.Coordenada;
import br.com.fiap.foodflow.model.Drone;
import br.com.fiap.foodflow.model.LicencaDrone;
import br.com.fiap.foodflow.model.Telemetria;

import java.util.List;

public class TelemetriaFactory {


    public static List<TelemetriaDTO> getDTOsFromTelemetrias(List<Telemetria> telemetrias) {
        return telemetrias.stream().map(TelemetriaFactory::getDTOFromTelemetria).toList();
    }


    public static TelemetriaDTO getDTOFromTelemetria(Telemetria telemetria) {
        TelemetriaDTO telemetriaDTO = new TelemetriaDTO();
        telemetriaDTO.setIdTelemetria(telemetria.getIdTelemetria());
        telemetriaDTO.setDrone(getDTOFromDrone(telemetria.getDrone()));
        telemetriaDTO.setCoordenada(getDTOFromCoordenada(telemetria.getCoordenada()));
        telemetriaDTO.setVelocidade(telemetria.getVelocidade());
        telemetriaDTO.setAltitude(telemetria.getAltitude());
        telemetriaDTO.setDirecao(telemetria.getDirecao());
        telemetriaDTO.setTempo(telemetria.getTempo());

        return telemetriaDTO;
    }

    private static CoordenadaDTO getDTOFromCoordenada(Coordenada coordenada) {
        CoordenadaDTO coordenadaDTO = new CoordenadaDTO();
        coordenadaDTO.setLatitude(coordenada.getLatitude());
        coordenadaDTO.setLongitude(coordenada.getLongitude());
        return coordenadaDTO;
    }

    private static DroneDTO getDTOFromDrone(Drone drone) {
        DroneDTO droneDTO = new DroneDTO();
        droneDTO.setDroneId(drone.getDroneId());
        return droneDTO;
    }

    public static Telemetria getTelemetriaDTO(TelemetriaDTO telemetriaDTO) {
        Telemetria telemetria = new Telemetria();
        telemetria.setIdTelemetria(telemetriaDTO.getIdTelemetria());
        telemetria.setDrone(getDroneFromDTO(telemetriaDTO.getDrone()));
        telemetria.setCoordenada(getCoordenadaFromDTO(telemetriaDTO.getCoordenada()));
        telemetria.setVelocidade(telemetriaDTO.getVelocidade());
        telemetria.setAltitude(telemetriaDTO.getAltitude());
        telemetria.setDirecao(telemetriaDTO.getDirecao());
        telemetria.setTempo(telemetriaDTO.getTempo());

        return telemetria;
    }

    private static Coordenada getCoordenadaFromDTO(CoordenadaDTO coordenadaDTO) {
        Coordenada coordenada = new Coordenada();
        coordenada.setLatitude(coordenadaDTO.getLatitude());
        coordenada.setLongitude(coordenadaDTO.getLongitude());
        return coordenada;
    }

    private static Drone getDroneFromDTO(DroneDTO droneDTO) {
        Drone drone = new Drone();
        drone.setDroneId(droneDTO.getDroneId());
        return drone;
    }

}
