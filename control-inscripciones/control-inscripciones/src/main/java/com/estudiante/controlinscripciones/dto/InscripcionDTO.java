package com.estudiante.controlinscripciones.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class InscripcionDTO {

    private Long id;

    @NotBlank(message = "El nombre del participante es obligatorio")
    @Size(max = 100, message = "El nombre no debe superar 100 caracteres")
    private String nombreParticipante;

    @NotNull(message = "La edad del participante es obligatoria")
    @Min(value = 0, message = "La edad no puede ser negativa")
    private Integer edadParticipante;

    private String estado;

    @NotNull(message = "Debe seleccionar una actividad")
    private Long actividadId;

    public InscripcionDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreParticipante() {
        return nombreParticipante;
    }

    public void setNombreParticipante(String nombreParticipante) {
        this.nombreParticipante = nombreParticipante;
    }

    public Integer getEdadParticipante() {
        return edadParticipante;
    }

    public void setEdadParticipante(Integer edadParticipante) {
        this.edadParticipante = edadParticipante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getActividadId() {
        return actividadId;
    }

    public void setActividadId(Long actividadId) {
        this.actividadId = actividadId;
    }
}
