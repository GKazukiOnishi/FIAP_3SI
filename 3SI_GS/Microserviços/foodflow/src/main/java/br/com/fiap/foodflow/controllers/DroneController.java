package br.com.fiap.foodflow.controllers;

import br.com.fiap.foodflow.dto.DroneDTO;
import br.com.fiap.foodflow.dto.factory.DroneFactory;
import br.com.fiap.foodflow.exception.MapErroBuilder;
import br.com.fiap.foodflow.exception.ValidacaoException;
import br.com.fiap.foodflow.model.Drone;
import br.com.fiap.foodflow.repositories.DroneRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("tela/drone")
    public ModelAndView telaDrone() {
        ModelAndView modelView = new ModelAndView("drone/index");

        List<Drone> drones = droneRepository.findAll();

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
        List<Drone> drones = droneRepository.findAll();

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

        Drone drone = validarDrone(droneDTO);

        Drone droneNovo = droneRepository.save(drone);

        return new ResponseEntity<>(DroneFactory.getDTOFromDrone(droneNovo), HttpStatus.CREATED);
    }

    private Drone validarDrone(DroneDTO droneDTO) {
        Map<String, String> erros = MapErroBuilder.newInstance(validator)
                .validar(droneDTO)
                .validar(droneDTO.getLicencaNotNull(), "licenca")
                .build();
        if (!erros.isEmpty()) {
            throw new ValidacaoException("Existem erros na validação do drone", erros);
        }

        return DroneFactory.getDroneFromDTO(droneDTO);
    }

    @PutMapping("/drone/" + PATH_ID)
    public ResponseEntity<DroneDTO> atualizar(@PathVariable Integer droneId, @RequestBody DroneDTO droneDTO) {
        Drone drone = buscaDroneExistente(droneId);
        droneDTO.setDroneId(drone.getDroneId());

        Drone droneValidado = validarDrone(droneDTO);

        Drone droneAtualizado = droneRepository.save(droneValidado);

        return new ResponseEntity<>(DroneFactory.getDTOFromDrone(droneAtualizado), HttpStatus.OK);
    }

}
