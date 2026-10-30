# Control de Inscripciones a Actividades Recreativas

## Descripción del proyecto

Este proyecto consiste en desarrollar una aplicación para administrar actividades recreativas y las inscripciones de los participantes.

El sistema permite registrar actividades, consultar su información, inscribir participantes y controlar aspectos como la edad mínima y el cupo disponible.

## Herramientas utilizadas

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven
- IntelliJ IDEA
- Postman

## Funcionalidades implementadas

- Operaciones CRUD de actividades.
- Búsqueda de actividades por ID y fecha.
- Actualización y eliminación de actividades.
- Registro y consulta de inscripciones.
- Consulta de participantes por actividad.
- Validación de edad mínima.
- Validación del cupo máximo.
- Cambio de estado de las inscripciones.
- Almacenamiento de información en PostgreSQL.

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

## Pruebas realizadas

Se utilizaron solicitudes HTTP en Postman para comprobar el funcionamiento de la API, incluyendo registros, consultas, actualizaciones, eliminaciones y validaciones de las reglas de negocio.

## Estado del proyecto

Actualmente se cuenta con una primera versión funcional del backend, con conexión a PostgreSQL y operaciones para administrar actividades e inscripciones.

El proyecto continuará desarrollándose con nuevas funcionalidades y la implementación de la interfaz gráfica, es decir, frontend.