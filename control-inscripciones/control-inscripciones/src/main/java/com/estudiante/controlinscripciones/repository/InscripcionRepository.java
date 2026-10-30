package com.estudiante.controlinscripciones.repository;

import com.estudiante.controlinscripciones.entity.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    List<Inscripcion> findByActividadId(Long actividadId);

    List<Inscripcion> findByEstado(String estado);

}
