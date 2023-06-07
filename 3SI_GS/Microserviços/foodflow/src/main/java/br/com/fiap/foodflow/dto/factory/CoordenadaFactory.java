package br.com.fiap.foodflow.dto.factory;

import br.com.fiap.foodflow.dto.CoordenadaDTO;
import br.com.fiap.foodflow.model.Coordenada;

public class CoordenadaFactory {

    public static Coordenada getCoordenadaFromDTO(CoordenadaDTO coordenadaDTO) {
        Coordenada coordenada = new Coordenada();
        coordenada.setLatitude(coordenadaDTO.getLatitude());
        coordenada.setLongitude(coordenadaDTO.getLongitude());
        return coordenada;
    }

    public static CoordenadaDTO getDTOFromCoordenada(Coordenada coordenada) {
        if (coordenada == null) {
            return null;
        }
        CoordenadaDTO coordenadaDTO = new CoordenadaDTO();
        coordenadaDTO.setLatitude(coordenada.getLatitude());
        coordenadaDTO.setLongitude(coordenada.getLongitude());
        return coordenadaDTO;
    }

}
