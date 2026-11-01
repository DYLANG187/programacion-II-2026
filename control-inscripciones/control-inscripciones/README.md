# Control de Inscripciones a Actividades Recreativas

## Información del proyecto

- **Nombre del proyecto:** Control de Inscripciones a Actividades Recreativas.
- **Estudiante:** Dylan Garcia.
- **Número de carné:** 9941-25-21652.

## Descripción del problema

El proyecto busca solucionar la necesidad de administrar actividades recreativas y controlar las inscripciones de los participantes. Permite llevar un registro de las actividades, consultar los espacios disponibles y verificar que los participantes cumplan con los requisitos establecidos.

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

## Estructura general del sistema

El proyecto está organizado de la siguiente manera:

- `entity`: contiene las entidades Actividad e Inscripcion.
- `repository`: contiene los repositorios para acceder a la base de datos.
- `service`: contiene la lógica del sistema.
- `controller`: contiene los endpoints de la API REST.
- `dto`: contiene las clases para transferencia de datos.
- `exception`: contiene el manejo de excepciones.
- `frontend`: contiene los archivos HTML, CSS y JavaScript.
- `database`: contiene el script SQL con datos de prueba.
- `evidencias`: contiene las capturas, documentos y colección de Postman.

También se incluye `CorsConfig.java` para permitir la comunicación entre el frontend y el backend.

## Requisitos para ejecutar el proyecto

- Java JDK 17 o superior.
- PostgreSQL.
- IntelliJ IDEA o un entorno compatible con Maven.
- Navegador web.
- Git (opcional, para clonar el repositorio).

## Configuración de PostgreSQL

1. Abrir PostgreSQL mediante pgAdmin.
2. Crear una base de datos llamada `control_inscripciones`.
3. Verificar que PostgreSQL esté funcionando en el puerto `5432`.
4. Configurar la variable de entorno `DB_PASSWORD` con la contraseña del usuario de PostgreSQL.

El archivo `application.properties` utiliza esta variable para conectarse a la base de datos sin guardar la contraseña directamente.

## Instrucciones para iniciar el backend

1. Abrir el proyecto en IntelliJ IDEA.
2. Verificar que la variable de entorno `DB_PASSWORD` esté configurada en la ejecución de Spring Boot.
3. Esperar a que Maven cargue las dependencias.
4. Ejecutar la clase `ControlInscripcionesApplication`.
5. Verificar que la aplicación inicie correctamente en el puerto `8080`.

La API estará disponible en:

`http://localhost:8080/api`

## Instrucciones para abrir el frontend

1. Abrir la carpeta `frontend` del proyecto.
2. Ejecutar el archivo `index.html` en un navegador web.
3. Verificar que el backend esté iniciado antes de utilizar la interfaz.

La interfaz se comunica con la API REST para consultar y administrar las actividades e inscripciones.

## Descripción de los endpoints

### Actividades

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/actividades` | Consulta todas las actividades. |
| GET | `/api/actividades/{id}` | Consulta una actividad por ID. |
| GET | `/api/actividades/fecha/{fecha}` | Busca actividades por fecha. |
| GET | `/api/actividades/disponibles` | Consulta actividades con cupo disponible. |
| GET | `/api/actividades/{id}/ocupacion` | Consulta el porcentaje de ocupación. |
| POST | `/api/actividades` | Registra una actividad. |
| PUT | `/api/actividades/{id}` | Actualiza una actividad. |
| DELETE | `/api/actividades/{id}` | Elimina una actividad. |

### Inscripciones

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/inscripciones` | Consulta todas las inscripciones. |
| GET | `/api/inscripciones/{id}` | Consulta una inscripción por ID. |
| GET | `/api/inscripciones/actividad/{actividadId}` | Consulta inscripciones por actividad. |
| POST | `/api/inscripciones/actividad/{actividadId}` | Registra un participante en una actividad. |
| PATCH | `/api/inscripciones/{id}/estado?estado=ACTIVA` | Cambia el estado de una inscripción. |
| DELETE | `/api/inscripciones/{id}` | Elimina una inscripción. |

## Reglas principales del negocio

- Los participantes deben cumplir con la edad mínima de la actividad.
- No se permite superar el cupo máximo.
- No se permite reactivar una inscripción si la actividad está llena.
- No se permite reducir el cupo por debajo de la cantidad de inscripciones activas.
- No se permite eliminar una actividad que todavía tenga inscripciones registradas.
- El porcentaje de ocupación se calcula tomando en cuenta las inscripciones activas.

## Validaciones y manejo de errores

- Uso de DTOs para transferir información.
- Validaciones mediante Spring.
- Manejo global de excepciones.
- Respuestas HTTP según el tipo de error:
  - 400 Bad Request.
  - 404 Not Found.
  - 409 Conflict.
  - 500 Internal Server Error.

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