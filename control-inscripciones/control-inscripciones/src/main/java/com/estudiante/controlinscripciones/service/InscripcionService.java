package com.estudiante.controlinscripciones.service;

import com.estudiante.controlinscripciones.entity.Actividad;
import com.estudiante.controlinscripciones.entity.Inscripcion;
import com.estudiante.controlinscripciones.exception.RecursoNoEncontradoException;
import com.estudiante.controlinscripciones.repository.ActividadRepository;
import com.estudiante.controlinscripciones.repository.InscripcionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.estudiante.controlinscripciones.exception.ReglaNegocioException;

import java.util.List;

@Service
public class InscripcionService {

    private final InscripcionRepository inscripcionRepository;
    private final ActividadRepository actividadRepository;

    public InscripcionService(
            InscripcionRepository inscripcionRepository,
            ActividadRepository actividadRepository) {
        this.inscripcionRepository = inscripcionRepository;
        this.actividadRepository = actividadRepository;
    }

    public List<Inscripcion> listarTodas() {
        return inscripcionRepository.findAll();
    }

    public Inscripcion buscarPorId(Long id) {
        return inscripcionRepository.findById(id)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException(
                                "No se encontró la inscripción con ID: " + id));
    }

    @Transactional
    public Inscripcion inscribir(Inscripcion inscripcion, Long actividadId) {
        Actividad actividad = actividadRepository.findById(actividadId)
                .orElseThrow(() ->
                        new RecursoNoEncontradoException(
                                "No se encontró la actividad con ID: " + actividadId));

        if (inscripcion.getEdadParticipante() < actividad.getEdadMinima()) {
            throw new ReglaNegocioException(
                    "El participante no cumple con la edad mínima de la actividad");
        }

        long ocupadas = inscripcionRepository
                .findByActividadId(actividadId)
                .stream()
                .filter(i -> "ACTIVA".equalsIgnoreCase(i.getEstado()))
                .count();

        if (ocupadas >= actividad.getCupo()) {
            throw new ReglaNegocioException(
                    "La actividad ya alcanzó su cupo máximo");
        }

        inscripcion.setActividad(actividad);
        inscripcion.setEstado("ACTIVA");

        return inscripcionRepository.save(inscripcion);
    }

    @Transactional
    public Inscripcion cambiarEstado(Long id, String nuevoEstado) {
        if (nuevoEstado == null
                || (!"ACTIVA".equalsIgnoreCase(nuevoEstado)
                && !"CANCELADA".equalsIgnoreCase(nuevoEstado))) {
            throw new ReglaNegocioException(
                    "El estado debe ser ACTIVA o CANCELADA");
        }

        Inscripcion inscripcion = buscarPorId(id);

        if ("ACTIVA".equalsIgnoreCase(nuevoEstado)
                && "CANCELADA".equalsIgnoreCase(inscripcion.getEstado())) {

            Long actividadId = inscripcion.getActividad().getId();

            long ocupadas = inscripcionRepository
                    .findByActividadId(actividadId)
                    .stream()
                    .filter(i -> "ACTIVA".equalsIgnoreCase(i.getEstado()))
                    .count();

            if (ocupadas >= inscripcion.getActividad().getCupo()) {
                throw new ReglaNegocioException(
                        "No se puede reactivar la inscripción porque la actividad ya alcanzó su cupo máximo");
            }
        }

        inscripcion.setEstado(nuevoEstado.toUpperCase());

        return inscripcionRepository.save(inscripcion);
    }

    public List<Inscripcion> listarPorActividad(Long actividadId) {
        if (!actividadRepository.existsById(actividadId)) {
            throw new RecursoNoEncontradoException(
                    "No se encontró la actividad con ID: " + actividadId);
        }

        return inscripcionRepository.findByActividadId(actividadId);
    }

    public void eliminar(Long id) {
        Inscripcion inscripcion = buscarPorId(id);
        inscripcionRepository.delete(inscripcion);
    }
}
