package com.estudiante.controlinscripciones.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "inscripciones")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del participante es obligatorio")
    @Size(max = 100, message = "El nombre no debe superar 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nombreParticipante;

    @NotNull(message = "La edad del participante es obligatoria")
    @Min(value = 0, message = "La edad no puede ser negativa")
    @Column(nullable = false)
    private Integer edadParticipante;

    @NotBlank(message = "El estado es obligatorio")
    @Column(nullable = false, length = 20)
    private String estado = "ACTIVA";

    @NotNull(message = "Debe seleccionar una actividad")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actividad_id", nullable = false)
    private Actividad actividad;

    public Inscripcion() {
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

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
}
