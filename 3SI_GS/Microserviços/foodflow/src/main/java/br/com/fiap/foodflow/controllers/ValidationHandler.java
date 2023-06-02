package br.com.fiap.foodflow.controllers;

import br.com.fiap.foodflow.dto.ErroDTO;
import br.com.fiap.foodflow.exception.ValidacaoException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@ControllerAdvice
public class ValidationHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ErroDTO> handle(RuntimeException e) {
        Map<String, String> mapDeErros = new HashMap<>();

        if (e instanceof ConstraintViolationException) {
            ConstraintViolationException ce = (ConstraintViolationException) e;
            Set<ConstraintViolation<?>> constraintViolations = ce.getConstraintViolations();
            for (ConstraintViolation<?> c : constraintViolations) {
                mapDeErros.put(c.getPropertyPath().toString(), c.getMessage());
            }
        } else if (e instanceof ValidacaoException) {
            ValidacaoException ve = (ValidacaoException) e;
            mapDeErros = ve.getErroPorCampos();
        }

        ErroDTO retorno = new ErroDTO(e.getMessage(), mapDeErros);
        return new ResponseEntity<>(retorno, HttpStatus.BAD_REQUEST);
    }

}
