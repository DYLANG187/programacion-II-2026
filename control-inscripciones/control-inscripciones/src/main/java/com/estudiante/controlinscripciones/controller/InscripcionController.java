package com.estudiante.controlinscripciones.controller;

import com.estudiante.controlinscripciones.entity.Inscripcion;
import com.estudiante.controlinscripciones.service.InscripcionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    private final InscripcionService inscripcionService;

    public InscripcionController(InscripcionService inscripcionService) {
        this.inscripcionService = inscripcionService;
    }

    @GetMapping
    public List<Inscripcion> listarTodas() {
        return inscripcionService.listarTodas();
    }

    @GetMapping("/{id}")
    public Inscripcion buscarPorId(@PathVariable Long id) {
        return inscripcionService.buscarPorId(id);
    }

    @GetMapping("/actividad/{actividadId}")
    public List<Inscripcion> listarPorActividad(@PathVariable Long actividadId) {
        return inscripcionService.listarPorActividad(actividadId);
    }

    @PostMapping("/actividad/{actividadId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Inscripcion crear(
            @PathVariable Long actividadId,
            @Valid @RequestBody Inscripcion inscripcion) {
        return inscripcionService.inscribir(inscripcion, actividadId);
    }

    @PatchMapping("/{id}/estado")
    public Inscripcion cambiarEstado(
            @PathVariable Long id,
            @RequestParam String estado) {
        return inscripcionService.cambiarEstado(id, estado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        inscripcionService.eliminar(id);
    }
}
