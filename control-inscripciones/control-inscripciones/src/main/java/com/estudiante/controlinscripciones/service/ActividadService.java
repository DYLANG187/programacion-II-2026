package com.estudiante.controlinscripciones.service;

import com.estudiante.controlinscripciones.entity.Actividad;
import com.estudiante.controlinscripciones.exception.RecursoNoEncontradoException;
import com.estudiante.controlinscripciones.repository.ActividadRepository;
import com.estudiante.controlinscripciones.repository.InscripcionRepository;
import com.estudiante.controlinscripciones.exception.ReglaNegocioException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActividadService {

    private final ActividadRepository actividadRepository;
    private final InscripcionRepository inscripcionRepository;

    public ActividadService(
            ActividadRepository actividadRepository,
            InscripcionRepository inscripcionRepository) {
        this.actividadRepository = actividadRepository;
        this.inscripcionRepository = inscripcionRepository;
    }

    public List<Actividad> listarTodas() {
        return actividadRepository.findAll();
    }
    public List<Actividad> listarConCupoDisponible() {
        return actividadRepository.findAll()
                .stream()
                .filter(actividad -> {
                    long ocupadas = inscripcionRepository
                            .findByActividadId(actividad.getId())
                            .stream()
                            .filter(i -> "ACTIVA".equalsIgnoreCase(i.getEstado()))
                            .count();

                    return ocupadas < actividad.getCupo();
                })
                .toList();
    }
    public double calcularPorcentajeOcupacion(Long actividadId) {
        Actividad actividad = buscarPorId(actividadId);

        long ocupadas = inscripcionRepository
                .findByActividadId(actividadId)
                .stream()
                .filter(i -> "ACTIVA".equalsIgnoreCase(i.getEstado()))
                .count();

        return (ocupadas * 100.0) / actividad.getCupo();
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

        long ocupadas = inscripcionRepository
                .findByActividadId(id)
                .stream()
                .filter(i -> "ACTIVA".equalsIgnoreCase(i.getEstado()))
                .count();

        if (datos.getCupo() < ocupadas) {
            throw new ReglaNegocioException(
                    "No se puede reducir el cupo por debajo de las inscripciones activas");
        }

        actividad.setNombre(datos.getNombre());
        actividad.setDescripcion(datos.getDescripcion());
        actividad.setFecha(datos.getFecha());
        actividad.setCupo(datos.getCupo());
        actividad.setEdadMinima(datos.getEdadMinima());

        return actividadRepository.save(actividad);
    }

    public void eliminar(Long id) {
        Actividad actividad = buscarPorId(id);

        boolean tieneInscripciones = !inscripcionRepository
                .findByActividadId(id).isEmpty();

        if (tieneInscripciones) {
            throw new ReglaNegocioException(
                    "No se puede eliminar la actividad porque tiene inscripciones registradas");
        }

        actividadRepository.delete(actividad);
    }

    public List<Actividad> buscarPorFecha(LocalDate fecha) {
        return actividadRepository.findByFecha(fecha);
    }
}
