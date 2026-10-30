package com.estudiante.controlinscripciones.controller;

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
    public List<Actividad> listarTodas() {
        return actividadService.listarTodas();
    }

    @GetMapping("/{id}")
    public Actividad buscarPorId(@PathVariable Long id) {
        return actividadService.buscarPorId(id);
    }

    @GetMapping("/fecha/{fecha}")
    public List<Actividad> buscarPorFecha(
            @PathVariable
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return actividadService.buscarPorFecha(fecha);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Actividad crear(@Valid @RequestBody Actividad actividad) {
        return actividadService.guardar(actividad);
    }

    @PutMapping("/{id}")
    public Actividad actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Actividad actividad) {
        return actividadService.actualizar(id, actividad);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        actividadService.eliminar(id);
    }
}
