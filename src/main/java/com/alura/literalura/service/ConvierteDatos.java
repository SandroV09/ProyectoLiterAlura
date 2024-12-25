package com.alura.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;


@Component
public class ConvierteDatos implements IConvierteDatos {


    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            // Deserializa el JSON en un objeto de la clase especificada
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            // Lanza una RuntimeException si ocurre un error de procesamiento de JSON
            throw new RuntimeException("Error al deserializar el JSON", e);
        }
    }
}