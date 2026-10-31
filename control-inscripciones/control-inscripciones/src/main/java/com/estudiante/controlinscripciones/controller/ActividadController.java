package com.estudiante.controlinscripciones.controller;

import com.estudiante.controlinscripciones.dto.ActividadDTO;
import com.estudiante.controlinscripciones.entity.Actividad;
import com.estudiante.controlinscripciones.service.ActividadService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/actividades")
public class ActividadController {

    private final ActividadService actividadService;

    public ActividadController(ActividadService actividadService) {
        this.actividadService = actividadService;
    }

    @GetMapping
    public List<ActividadDTO> listarTodas() {
        return actividadService.listarTodas()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }
    @GetMapping("/disponibles")
    public List<ActividadDTO> listarConCupoDisponible() {
        return actividadService.listarConCupoDisponible()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }
    @GetMapping("/{id}/ocupacion")
    public double consultarOcupacion(@PathVariable Long id) {
        return actividadService.calcularPorcentajeOcupacion(id);
    }

    @GetMapping("/{id}")
    public ActividadDTO buscarPorId(@PathVariable Long id) {
        return convertirADTO(actividadService.buscarPorId(id));
    }

    @GetMapping("/fecha/{fecha}")
    public List<ActividadDTO> buscarPorFecha(
            @PathVariable
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {

        return actividadService.buscarPorFecha(fecha)
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ActividadDTO crear(@Valid @RequestBody ActividadDTO dto) {
        Actividad actividad = convertirAEntidad(dto);
        return convertirADTO(actividadService.guardar(actividad));
    }

    @PutMapping("/{id}")
    public ActividadDTO actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ActividadDTO dto) {

        Actividad actividad = convertirAEntidad(dto);
        return convertirADTO(actividadService.actualizar(id, actividad));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        actividadService.eliminar(id);
    }

    private ActividadDTO convertirADTO(Actividad actividad) {
        ActividadDTO dto = new ActividadDTO();

        dto.setId(actividad.getId());
        dto.setNombre(actividad.getNombre());
        dto.setDescripcion(actividad.getDescripcion());
        dto.setFecha(actividad.getFecha());
        dto.setCupo(actividad.getCupo());
        dto.setEdadMinima(actividad.getEdadMinima());

        return dto;
    }

    private Actividad convertirAEntidad(ActividadDTO dto) {
        Actividad actividad = new Actividad();

        actividad.setNombre(dto.getNombre());
        actividad.setDescripcion(dto.getDescripcion());
        actividad.setFecha(dto.getFecha());
        actividad.setCupo(dto.getCupo());
        actividad.setEdadMinima(dto.getEdadMinima());

        return actividad;
    }
}
