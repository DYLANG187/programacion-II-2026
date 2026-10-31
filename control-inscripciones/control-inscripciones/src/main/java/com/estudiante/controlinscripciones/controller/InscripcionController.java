package com.estudiante.controlinscripciones.controller;

import com.estudiante.controlinscripciones.dto.InscripcionDTO;
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
    public List<InscripcionDTO> listarTodas() {
        return inscripcionService.listarTodas()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    @GetMapping("/{id}")
    public InscripcionDTO buscarPorId(@PathVariable Long id) {
        return convertirADTO(inscripcionService.buscarPorId(id));
    }

    @GetMapping("/actividad/{actividadId}")
    public List<InscripcionDTO> listarPorActividad(
            @PathVariable Long actividadId) {

        return inscripcionService.listarPorActividad(actividadId)
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    @PostMapping("/actividad/{actividadId}")
    @ResponseStatus(HttpStatus.CREATED)
    public InscripcionDTO crear(
            @PathVariable Long actividadId,
            @Valid @RequestBody InscripcionDTO dto) {

        Inscripcion inscripcion = convertirAEntidad(dto);

        return convertirADTO(
                inscripcionService.inscribir(inscripcion, actividadId)
        );
    }

    @PatchMapping("/{id}/estado")
    public InscripcionDTO cambiarEstado(
            @PathVariable Long id,
            @RequestParam String estado) {

        return convertirADTO(
                inscripcionService.cambiarEstado(id, estado)
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        inscripcionService.eliminar(id);
    }

    private InscripcionDTO convertirADTO(Inscripcion inscripcion) {
        InscripcionDTO dto = new InscripcionDTO();

        dto.setId(inscripcion.getId());
        dto.setNombreParticipante(inscripcion.getNombreParticipante());
        dto.setEdadParticipante(inscripcion.getEdadParticipante());
        dto.setEstado(inscripcion.getEstado());
        dto.setActividadId(inscripcion.getActividad().getId());

        return dto;
    }

    private Inscripcion convertirAEntidad(InscripcionDTO dto) {
        Inscripcion inscripcion = new Inscripcion();

        inscripcion.setNombreParticipante(dto.getNombreParticipante());
        inscripcion.setEdadParticipante(dto.getEdadParticipante());

        return inscripcion;
    }
}
