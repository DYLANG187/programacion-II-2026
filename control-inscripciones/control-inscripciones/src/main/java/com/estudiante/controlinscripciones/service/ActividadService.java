package com.estudiante.controlinscripciones.service;

import com.estudiante.controlinscripciones.entity.Actividad;
import com.estudiante.controlinscripciones.exception.RecursoNoEncontradoException;
import com.estudiante.controlinscripciones.repository.ActividadRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActividadService {

    private final ActividadRepository actividadRepository;

    public ActividadService(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    public List<Actividad> listarTodas() {
        return actividadRepository.findAll();
    }

    public Actividad buscarPorId(Long id) {
        return actividadRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException(
                                "No se encontró la actividad con ID: " + id));
    }

    public Actividad guardar(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    public Actividad actualizar(Long id, Actividad datos) {
        Actividad actividad = buscarPorId(id);

        actividad.setNombre(datos.getNombre());
        actividad.setDescripcion(datos.getDescripcion());
        actividad.setFecha(datos.getFecha());
        actividad.setCupo(datos.getCupo());
        actividad.setEdadMinima(datos.getEdadMinima());

        return actividadRepository.save(actividad);
    }

    public void eliminar(Long id) {
        Actividad actividad = buscarPorId(id);
        actividadRepository.delete(actividad);
    }

    public List<Actividad> buscarPorFecha(LocalDate fecha) {
        return actividadRepository.findByFecha(fecha);
    }
}
