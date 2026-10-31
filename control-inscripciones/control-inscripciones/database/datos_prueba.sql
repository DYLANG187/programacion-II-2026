-- Datos de ejemplo para Control de Inscripciones

-- Actividades
INSERT INTO actividades (nombre, descripcion, fecha, cupo, edad_minima)
VALUES
    ('Natacion recreativa', 'Actividad de natacion para principiantes',
     '2026-11-10', 15, 12),
    ('Taller de dibujo', 'Taller de dibujo y pintura',
     '2026-11-12', 10, 8);

-- Inscripciones
INSERT INTO inscripciones
(nombre_participante, edad_participante, estado, actividad_id)
VALUES
    ('Maria Lopez', 20, 'ACTIVA',
     (SELECT id FROM actividades WHERE nombre = 'Natacion recreativa'
      ORDER BY id DESC LIMIT 1)),
('Carlos Perez', 18, 'ACTIVA',
 (SELECT id FROM actividades WHERE nombre = 'Natacion recreativa'
  ORDER BY id DESC LIMIT 1)),
('Ana Garcia', 15, 'ACTIVA',
 (SELECT id FROM actividades WHERE nombre = 'Taller de dibujo'
  ORDER BY id DESC LIMIT 1));