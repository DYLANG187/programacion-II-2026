package com.estudiante.controlinscripciones.repository;

import com.estudiante.controlinscripciones.entity.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {

    List<Actividad> findByFecha(LocalDate fecha);

}
