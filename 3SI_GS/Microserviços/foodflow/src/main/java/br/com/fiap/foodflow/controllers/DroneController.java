package br.com.fiap.foodflow.controllers;

import br.com.fiap.foodflow.dto.DroneDTO;
import br.com.fiap.foodflow.dto.factory.DroneFactory;
import br.com.fiap.foodflow.exception.MapErroBuilder;
import br.com.fiap.foodflow.exception.ValidacaoException;
import br.com.fiap.foodflow.model.Drone;
import br.com.fiap.foodflow.repositories.DroneRepository;
import br.com.fiap.foodflow.repositories.LicencaDroneRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Controller
public class DroneController {

    private static final String PATH_PARAM = "droneId";
    private static final String PATH_ID = "{" + PATH_PARAM + "}";

    @Autowired
    private DroneRepository droneRepository;
    @Autowired
    private LicencaDroneRepository licencaDroneRepository;
    @Autowired
    private Validator validator;

    @RequestMapping("tela/drone")
    public ModelAndView telaDrone() {
        ModelAndView modelView = new ModelAndView("drone/index");

        List<Drone> drones = droneRepository.findAll(Sort.by("droneId"));

        modelView.addObject("drones", DroneFactory.getDTOsFromDrones(drones));

        return modelView;
    }

    @RequestMapping("tela/drone/detalhe/" + PATH_ID)
    public ModelAndView telaDroneDetalhe(@PathVariable Integer droneId) {
        ModelAndView modelView = new ModelAndView("drone/detalhe");

        configuraTelaComDroneExistente(droneId, modelView);

        return modelView;
    }

    private void configuraTelaComDroneExistente(Integer droneId, ModelAndView modelView) {
        Drone drone = buscaDroneExistente(droneId);

        modelView.addObject("drone", DroneFactory.getDTOFromDrone(drone));
    }

    @RequestMapping("tela/drone/edicao/" + PATH_ID)
    public ModelAndView telaDroneEdicao(@PathVariable Integer droneId) {
        ModelAndView modelView = new ModelAndView("drone/edicao");

        configuraTelaComDroneExistente(droneId, modelView);
        modelView.addObject("novo", false);

        return modelView;
    }

    @RequestMapping("tela/drone/novo")
    public ModelAndView telaDroneNovo() {
        ModelAndView modelView = new ModelAndView("drone/edicao");

        modelView.addObject("novo", true);

        return modelView;
    }

    @GetMapping("/drone")
    public ResponseEntity<List<DroneDTO>> listar() {
        List<Drone> drones = droneRepository.findAll(Sort.by("droneId"));

        return new ResponseEntity<>(DroneFactory.getDTOsFromDrones(drones), HttpStatus.OK);
    }

    @GetMapping("/drone/" + PATH_ID)
    public ResponseEntity<DroneDTO> buscar(@PathVariable Integer droneId) {
        Drone drone = buscaDroneExistente(droneId);

        return new ResponseEntity<>(DroneFactory.getDTOFromDrone(drone), HttpStatus.OK);
    }

    private Drone buscaDroneExistente(Integer droneId) {
        Optional<Drone> drone = droneRepository.findById(droneId);

        if (drone.isPresent()) {
            return drone.get();
        }
        throw new ValidacaoException("Drone não encontrado");
    }

    @PostMapping("/drone")
    public ResponseEntity<DroneDTO> cadastrar(@RequestBody DroneDTO droneDTO) {
        if (droneDTO == null) {
            throw new ValidacaoException("Drone a ser cadastrado deve ser informado");
        }

        droneDTO.setDroneId(null);

        Drone drone = validarDrone(droneDTO, null);

        Drone droneNovo = droneRepository.save(drone);

        return new ResponseEntity<>(DroneFactory.getDTOFromDrone(droneNovo), HttpStatus.CREATED);
    }

    private Drone validarDrone(DroneDTO droneDTO, Drone droneExistente) {
        Map<String, String> erros = MapErroBuilder.newInstance(validator)
                .validar(droneDTO)
                .validar(droneDTO.licencaNotNull(), "licenca")
                .build();

        Integer droneIdExistente = -1;
        if (droneExistente != null) {
            droneIdExistente = droneExistente.getDroneId();
        }
        if (droneRepository.existsBySerieAndDroneIdNot(droneDTO.getSerie(), droneIdExistente)) {
            erros.put("serie", "Serie já cadastrada");
        }

        Integer numLicenca = droneDTO.licencaNotNull().getNumLicenca();
        Integer numLicencaAtual = -1;
        if (droneExistente != null) {
            numLicencaAtual = droneExistente.getLicenca().getNumLicenca();
        }
        if (!Objects.equals(numLicenca, numLicencaAtual) && licencaDroneRepository.existsByNumLicenca(numLicenca)) {
            erros.put("licenca.numLicenca", "Número de licenca já cadastrada");
        }

        if (!erros.isEmpty()) {
            throw new ValidacaoException("Existem erros na validação do drone", erros);
        }

        return DroneFactory.getDroneFromDTO(droneDTO);
    }

    @PutMapping("/drone/" + PATH_ID)
    public ResponseEntity<DroneDTO> atualizar(@PathVariable Integer droneId, @RequestBody DroneDTO droneDTO) {
        Drone drone = buscaDroneExistente(droneId);
        droneDTO.setDroneId(drone.getDroneId());

        Drone droneValidado = validarDrone(droneDTO, drone);

        Drone droneAtualizado = droneRepository.save(droneValidado);

        return new ResponseEntity<>(DroneFactory.getDTOFromDrone(droneAtualizado), HttpStatus.OK);
    }

}
