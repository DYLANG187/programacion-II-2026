# Control de Inscripciones a Actividades Recreativas

## Descripción del proyecto

Este proyecto consiste en desarrollar una aplicación para administrar actividades recreativas y las inscripciones de los participantes.

El sistema permite registrar actividades, consultar su información, inscribir participantes y controlar aspectos como la edad mínima, el cupo disponible y el estado de las inscripciones.

La aplicación cuenta con un backend desarrollado con Spring Boot y PostgreSQL, además de una interfaz web desarrollada con HTML, CSS y JavaScript.

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

- Registro de actividades.
- Consulta de todas las actividades.
- Consulta de actividad por ID.
- Búsqueda de actividades por fecha.
- Actualización de actividades.
- Eliminación de actividades.
- Consulta de actividades con cupos disponibles.
- Cálculo del porcentaje de ocupación.

### Administración de inscripciones

- Registro de participantes en actividades.
- Consulta de inscripciones.
- Consulta de participantes por actividad.
- Cambio de estado entre ACTIVA y CANCELADA.
- Eliminación de inscripciones.

### Validaciones y reglas de negocio

- Validación de edad mínima para participar.
- Control del cupo máximo de cada actividad.
- Restricción para reactivar inscripciones cuando la actividad está llena.
- Restricción para reducir el cupo por debajo de la cantidad de inscripciones activas.
- Restricción para eliminar actividades que todavía tienen inscripciones registradas.

### Manejo de errores

- Uso de DTOs para transferir información.
- Validaciones mediante Spring.
- Manejo global de excepciones.
- Respuestas HTTP según el tipo de error:
  - 400 Bad Request.
  - 404 Not Found.
  - 409 Conflict.

## Interfaz web

Se desarrolló una interfaz web utilizando HTML, CSS y JavaScript que se comunica con la API REST.

La interfaz permite:

- Registrar actividades.
- Consultar actividades.
- Editar actividades.
- Eliminar actividades.
- Consultar ocupación.
- Consultar actividades con cupo disponible.
- Registrar inscripciones.
- Cambiar el estado de las inscripciones.
- Eliminar inscripciones.
- Mostrar mensajes de éxito y error.

## Estructura del proyecto

El proyecto está organizado en los siguientes paquetes:

- `entity`: contiene las entidades Actividad e Inscripcion.
- `repository`: contiene los repositorios para acceder a la base de datos.
- `service`: contiene la lógica del sistema.
- `controller`: contiene los endpoints de la API REST.
- `dto`: contiene las clases para transferencia de datos.
- `exception`: contiene el manejo de excepciones.

La interfaz web se encuentra en la carpeta:

- `frontend`: contiene los archivos HTML, CSS y JavaScript.

También se incluyen:

- `database`: contiene el script SQL con datos de prueba.
- `evidencias`: contiene las capturas, documentos y colección de Postman.

## Base de datos

Se utiliza PostgreSQL con una base de datos llamada `control_inscripciones`.

Las tablas principales son:

- `actividades`
- `inscripciones`

Ambas tablas están relacionadas mediante una clave foránea.

También se incluye un script SQL con datos de prueba ubicado en la carpeta `database`.

## Pruebas realizadas

Se utilizaron solicitudes HTTP en Postman y pruebas desde la interfaz web para comprobar el funcionamiento del sistema.

Entre las pruebas realizadas se encuentran:

- Registro, consulta, actualización y eliminación de actividades.
- Registro y consulta de inscripciones.
- Cambio de estado de las inscripciones.
- Eliminación de inscripciones.
- Validación de edad mínima.
- Validación de cupo máximo.
- Consulta de actividades disponibles.
- Cálculo del porcentaje de ocupación.
- Manejo de errores y excepciones.

Se incluye una colección exportada de Postman y un diagrama entidad-relación dentro de la carpeta `evidencias`.

## Seguridad de configuración

La contraseña de PostgreSQL se obtiene mediante la variable de entorno `DB_PASSWORD`, evitando guardarla directamente en el archivo `application.properties`.

## Estado del proyecto

El proyecto se encuentra funcional y cuenta con:

- Backend desarrollado con Spring Boot.
- Persistencia de datos mediante PostgreSQL y Spring Data JPA.
- API REST con operaciones CRUD.
- DTOs y validaciones.
- Reglas de negocio.
- Manejo global de excepciones.
- Consultas e indicadores.
- Interfaz web con HTML, CSS y JavaScript.
- Integración entre frontend, API REST y PostgreSQL.
- Pruebas realizadas mediante Postman y la interfaz web.