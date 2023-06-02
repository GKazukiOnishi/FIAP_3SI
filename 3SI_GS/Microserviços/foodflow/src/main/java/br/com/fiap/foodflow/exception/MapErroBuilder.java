package br.com.fiap.foodflow.exception;

import br.com.fiap.foodflow.dto.Validavel;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapErroBuilder {

    private static final String PATH_CONCAT_STRING = ".";

    private Validator validator;
    private Map<String, String> mapErros;

    private MapErroBuilder() {
        mapErros = new HashMap<>();
    }

    public static MapErroBuilder newInstance(Validator validator) {
        MapErroBuilder mapErroBuilder = new MapErroBuilder();
        mapErroBuilder.validator = validator;
        return mapErroBuilder;
    }

    private static <T> Map<String, String> convertConstraintViolationsToMap(Set<ConstraintViolation<T>> constraintViolations) {
        Map<String, String> mapDeErros = new HashMap<>();
        for (ConstraintViolation<T> c : constraintViolations) {
            mapDeErros.put(c.getPropertyPath().toString(), c.getMessage());
        }
        return mapDeErros;
    }

    public MapErroBuilder validar(Validavel validavel, String originPath) {
        Set<ConstraintViolation<Validavel>> erros = validator.validate(validavel);
        Map<String, String> mapErros = convertConstraintViolationsToMap(erros);

        if (originPath != null) {
            Map<String, String> mapaComOrigem = new HashMap<>();
            mapErros.forEach((k, v) -> {
                mapaComOrigem.put(originPath + PATH_CONCAT_STRING + k, v);
            });
            this.mapErros.putAll(mapaComOrigem);
        } else {
            this.mapErros.putAll(mapErros);
        }

        return this;
    }

    public MapErroBuilder validar(Validavel validavel) {
        return validar(validavel, null);
    }

    public Map<String, String> build() {
        return mapErros;
    }

}
