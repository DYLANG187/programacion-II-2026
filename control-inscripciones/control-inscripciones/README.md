# Control de Inscripciones a Actividades Recreativas

## Descripción del proyecto

Este proyecto consiste en desarrollar una aplicación para administrar actividades recreativas y las inscripciones de los participantes.

El sistema permite registrar actividades, consultar su información, inscribir participantes y controlar aspectos como la edad mínima, el cupo disponible y el estado de las inscripciones.

## Herramientas utilizadas

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- IntelliJ IDEA
- Postman
- HTML
- CSS
- JavaScript

## Funcionalidades implementadas

### Administración de actividades

- Registro y consulta de actividades.
- Actualización y eliminación de actividades.
- Búsqueda de actividades por ID y fecha.
- Consulta de actividades con cupos disponibles.
- Cálculo del porcentaje de ocupación de cada actividad.

### Administración de inscripciones

- Registro y consulta de inscripciones.
- Consulta de participantes por actividad.
- Cambio de estado de las inscripciones.
- Eliminación de inscripciones.

### Validaciones y reglas de negocio

- Validación de edad mínima para participar.
- Control del cupo máximo de cada actividad.
- Restricción para reactivar inscripciones cuando la actividad está llena.
- Restricción para reducir el cupo por debajo de la cantidad de inscripciones activas.
- Restricción para eliminar actividades que todavía tienen inscripciones registradas.

### Manejo de errores

- Uso de DTOs para transferir información.
- Manejo global de excepciones.
- Respuestas HTTP según el tipo de error:
    - 400 Bad Request.
    - 404 Not Found.
    - 409 Conflict.

## Estructura del proyecto

El proyecto está organizado en los siguientes paquetes:

- `entity`: contiene las entidades Actividad e Inscripcion.
- `repository`: contiene los repositorios para acceder a la base de datos.
- `service`: contiene la lógica del sistema.
- `controller`: contiene los endpoints de la API REST.
- `dto`: contiene las clases para transferencia de datos.
- `exception`: contiene el manejo de excepciones.

## Base de datos

Se utiliza PostgreSQL con una base de datos llamada `control_inscripciones`.

Las tablas principales son:

- `actividades`
- `inscripciones`

Ambas tablas están relacionadas mediante una clave foránea.

También se incluye un script SQL con datos de prueba, ubicado en la carpeta `database`.

## Pruebas realizadas

Se utilizaron solicitudes HTTP en Postman para comprobar el funcionamiento de la API, incluyendo:

- Registro y consulta de actividades.
- Registro y consulta de inscripciones.
- Actualización y eliminación de registros.
