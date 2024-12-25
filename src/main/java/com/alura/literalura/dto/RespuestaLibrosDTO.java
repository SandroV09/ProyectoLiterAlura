package com.alura.literalura.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class RespuestaLibrosDTO {


    @JsonProperty("results")
    private List<LibroDTO> libros;


    public List<LibroDTO> getLibros() {
        return libros;
    }

    /**
     * Establece la lista de libros.
     *
     * @param libros La nueva lista de libros.
     */
    public void setLibros(List<LibroDTO> libros) {
        this.libros = libros;
    }
}