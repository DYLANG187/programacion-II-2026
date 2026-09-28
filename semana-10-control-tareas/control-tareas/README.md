# Control de Tareas Personales

## Descripción del problema

Este proyecto consiste en el diseño de una aplicación para administrar tareas personales. Cada tarea contiene un identificador, título, descripción, prioridad y estado de finalización.

El proyecto permite practicar los fundamentos de Maven, Java, HTTP y REST. No se implementa una API real, sino que se prepara su estructura y se diseña la forma en que posteriormente se comunicarían las aplicaciones.

## Tecnologías utilizadas

* Java 17
* Maven
* IntelliJ IDEA
* Git y GitHub
* HTTP
* REST
* JSON

## Datos del proyecto Maven

* **groupId:** `com.estudiante`
* **artifactId:** `control-tareas`
* **version:** `1.0-SNAPSHOT`

### ¿Qué significa cada dato?

* **groupId:** identifica el grupo o paquete al que pertenece el proyecto.
* **artifactId:** identifica el nombre del proyecto.
* **version:** indica la versión actual del proyecto.

## Estructura del proyecto

```text
control-tareas/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com.estudiante
│   │               ├── Main.java
│   │               └── Tarea.java
│   └── test/
│       └── java/
├── evidencias/
├── pom.xml
├── README.md
└── .gitignore
```

## Compilación del proyecto

Para trabajar con Maven se pueden ejecutar los siguientes comandos desde la terminal:

```bash
mvn clean
mvn compile
mvn test
mvn package
```

El comando `clean` elimina archivos generados anteriormente.

El comando `compile` compila el código fuente.

El comando `test` ejecuta las pruebas del proyecto.

El comando `package` genera el archivo `.jar` dentro de la carpeta `target`.

## Endpoints de la API REST

| Operación                       | Método HTTP | Endpoint           | Respuesta esperada |
| ------------------------------- | ----------- | ------------------ | ------------------ |
| Consultar todas las tareas      | `GET`       | `/api/tareas`      | `200 OK`           |
| Consultar una tarea             | `GET`       | `/api/tareas/{id}` | `200 OK`           |
| Registrar una tarea             | `POST`      | `/api/tareas`      | `201 Created`      |
| Modificar una tarea             | `PUT`       | `/api/tareas/{id}` | `200 OK`           |
| Eliminar una tarea              | `DELETE`    | `/api/tareas/{id}` | `204 No Content`   |
| Consultar una tarea inexistente | `GET`       | `/api/tareas/{id}` | `404 Not Found`    |

## Ejemplo de objeto JSON

```json
{
  "id": 1,
  "titulo": "Comprar alimentos",
  "descripcion": "Comprar productos para la semana",
  "prioridad": "ALTA",
  "completada": false
}
```

## Datos del estudiante

**Nombre completo:**
**Dylan Sneyder Garcia Sosa** 

**Número de carné:** 
**9941-25-21652** 
