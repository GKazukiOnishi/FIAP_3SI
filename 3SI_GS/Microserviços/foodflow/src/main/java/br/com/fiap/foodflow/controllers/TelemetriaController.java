package br.com.fiap.foodflow.controllers;

import br.com.fiap.foodflow.dto.TelemetriaDTO;
import br.com.fiap.foodflow.dto.factory.TelemetriaFactory;
import br.com.fiap.foodflow.exception.MapErroBuilder;
import br.com.fiap.foodflow.exception.ValidacaoException;
import br.com.fiap.foodflow.model.Drone;
import br.com.fiap.foodflow.model.Telemetria;
import br.com.fiap.foodflow.repositories.DroneRepository;
import br.com.fiap.foodflow.repositories.TelemetriaRepository;
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
public class TelemetriaController {

    private static final String PATH_PARAM = "telemetriaId";
    private static final String PATH_ID = "{" + PATH_PARAM + "}";


    @Autowired
    private TelemetriaRepository telemetriaRepository;
    @Autowired
    private Validator validator;
    @Autowired
    private DroneRepository droneRepository;

    @RequestMapping("tela/telemetria")
    public ModelAndView telaListaTelemetria() {
        ModelAndView modelView = new ModelAndView("telemetria/lista_telemetrias");

        List<Telemetria> telemetrias = telemetriaRepository.findAll();

        modelView.addObject("telemetrias", TelemetriaFactory.getDTOsFromTelemetrias(telemetrias));

        return modelView;
    }


    @GetMapping("/telemetria")
    public ResponseEntity<List<TelemetriaDTO>> listar() {
        List<Telemetria> telemetrias = telemetriaRepository.findAll();

        return new ResponseEntity<>(TelemetriaFactory.getDTOsFromTelemetrias(telemetrias), HttpStatus.OK);
    }

    @GetMapping("/telemetria/" + PATH_ID)
    public ResponseEntity<TelemetriaDTO> buscar(@PathVariable Integer telemetriaId) {
        Telemetria telemetria = buscaTelemetriaExistente(telemetriaId);

        return new ResponseEntity<>(TelemetriaFactory.getDTOFromTelemetria(telemetria), HttpStatus.OK);
    }

    private Telemetria buscaTelemetriaExistente(Integer telemetriaId) {
        Optional<Telemetria> telemetria = telemetriaRepository.findById(telemetriaId);

        if (telemetria.isPresent()) {
            return telemetria.get();
        }

        throw new ValidacaoException("Telemetria não encontrada");
    }

    @PostMapping("/telemetria")
    public ResponseEntity<TelemetriaDTO> cadastrar(@RequestBody TelemetriaDTO telemetriaDTO) {
        if (telemetriaDTO == null) {
            throw new ValidacaoException("Telemetria a ser cadastrada deve ser informada");
        }

        Telemetria telemetria = validarTelemetria(telemetriaDTO);

        Telemetria telemetriaNova = telemetriaRepository.save(telemetria);

        return new ResponseEntity<>(TelemetriaFactory.getDTOFromTelemetria(telemetriaNova), HttpStatus.CREATED);
    }

    private Telemetria validarTelemetria(TelemetriaDTO telemetriaDTO) {
        Map<String, String> erros = MapErroBuilder.newInstance(validator)
                .validar(telemetriaDTO)
                .validar(telemetriaDTO.getCoordenada(), "coordenada")
                .build();

        if (telemetriaDTO.getDrone().getDroneId() == null) {
            erros.put("drone.droneId", "Código de drone inexistente");
        }

        Optional<Drone> drone = droneRepository.findById(telemetriaDTO.getDrone().getDroneId());

        if (drone.isEmpty()) {
            erros.put("drone.droneId", "Drone não encontrado");
        }

        if (!erros.isEmpty()) {
            throw new ValidacaoException("Existem erros na validação da Telemetria", erros);
        }

        return TelemetriaFactory.getTelemetriaDTO(telemetriaDTO);
    }

    @PutMapping("/telemetria/" + PATH_ID)
    public ResponseEntity<TelemetriaDTO> atualizar(@PathVariable Integer telemetriaId, @RequestBody TelemetriaDTO telemetriaDTO) {
        Telemetria telemetria = buscaTelemetriaExistente(telemetriaId);
        telemetriaDTO.setIdTelemetria(telemetria.getIdTelemetria());

        Telemetria telemetriaValidada = validarTelemetria(telemetriaDTO);
        Telemetria telemetriaAtualizada = telemetriaRepository.save(telemetriaValidada);

        return new ResponseEntity<>(TelemetriaFactory.getDTOFromTelemetria(telemetriaAtualizada), HttpStatus.OK);
    }

}
