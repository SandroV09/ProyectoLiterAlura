package com.alura.literalura.service;

import com.alura.literalura.model.Autor;
import com.alura.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {


    @Autowired
    private AutorRepository autorRepository;

    /**
     * Lista todos los autores junto con sus libros asociados.
     *
     * @return Una lista de todos los autores con sus libros asociados.
     */
    public List<Autor> listarAutores() {
        return autorRepository.findAllConLibros();
    }

    /**
     * Lista autores que estuvieran vivos en un año específico.
     *
     * @param ano El año en el que se desea buscar autores vivos.
     * @return Una lista de autores vivos en el año especificado.
     */
    public List<Autor> listarAutoresVivosEnAno(int ano) {
        return autorRepository.findAutoresVivosEnAnoConLibros(ano);
    }


    public Autor crearAutor(Autor autor) {
        return autorRepository.save(autor);
    }


    public Optional<Autor> obtenerAutorPorId(Long id) {
        return autorRepository.findById(id);
    }


    public Optional<Autor> obtenerAutorPorNombre(String nombre) {
        return autorRepository.findByNombre(nombre);
    }


    public Autor actualizarAutor(Long id, Autor autorDetalles) {
        Autor autor = autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor no encontrado"));
        autor.setNombre(autorDetalles.getNombre());
        autor.setAnoNacimiento(autorDetalles.getAnoNacimiento());
        autor.setAnoFallecimiento(autorDetalles.getAnoFallecimiento());
        return autorRepository.save(autor);
    }

    /**
     * Elimina un autor por su identificador único.
     *
     * @param id El identificador único del autor a eliminar.
     */
    public void eliminarAutor(Long id) {
        autorRepository.deleteById(id);
    }
}