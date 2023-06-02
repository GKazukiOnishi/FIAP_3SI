package br.com.fiap.foodflow.controllers;

import br.com.fiap.foodflow.dto.DroneDTO;
import br.com.fiap.foodflow.dto.LicencaDroneDTO;
import br.com.fiap.foodflow.dto.factory.DroneFactory;
import br.com.fiap.foodflow.exception.MapErroBuilder;
import br.com.fiap.foodflow.exception.ValidacaoException;
import br.com.fiap.foodflow.model.Drone;
import br.com.fiap.foodflow.repositories.DroneRepository;
import jakarta.validation.Validator;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class DroneController {

    private static final String PATH_PARAM = "droneId";
    private static final String PATH_ID = "{" + PATH_PARAM + "}";

    @Autowired
    private DroneRepository droneRepository;
    @Autowired
    private Validator validator;

    @GetMapping("/drone")
    public ResponseEntity<List<DroneDTO>> listar() {
        List<Drone> drones = droneRepository.findAll();

        List<DroneDTO> dronesDTO = new ArrayList<>();

        return new ResponseEntity<>(dronesDTO, HttpStatus.OK);
    }

    @GetMapping("/drone/" + PATH_ID)
    public ResponseEntity<DroneDTO> buscar(@PathParam(PATH_PARAM) Integer droneId) {
        Optional<Drone> drone = droneRepository.findById(droneId);

        return null;
    }

    @PostMapping("/drone")
    public ResponseEntity<DroneDTO> cadastrar(@RequestBody DroneDTO droneDTO) {
        if (droneDTO == null) {
            throw new ValidacaoException("Drone a ser cadastrado deve ser informado");
        }

        Map<String, String> erros = MapErroBuilder.newInstance(validator)
                .validar(droneDTO)
                .validar(Optional.ofNullable(droneDTO).map(d -> d.getLicenca()).orElse(new LicencaDroneDTO()), "licenca")
                .build();
        if (!erros.isEmpty()) {
            throw new ValidacaoException("Existem erros na validação do drone", erros);
        }

        Drone drone = DroneFactory.getDroneFromDTO(droneDTO);

        Drone droneNovo = droneRepository.save(drone);

        droneDTO.setDroneId(droneNovo.getDroneId());

        return new ResponseEntity<>(droneDTO, HttpStatus.CREATED);
    }

}
