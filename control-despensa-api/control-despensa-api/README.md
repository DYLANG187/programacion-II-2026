# API REST - Control de Despensa

## Nombre de la actividad

Desarrollo de una API REST básica para consultar y analizar los productos almacenados en la despensa de un hogar.

**Nombre:** Dylan Sneyder Garcia Sosa

**Carné:** 9941-25-21652

## Descripción del problema

El proyecto consiste en desarrollar una API REST para administrar y consultar información de productos almacenados en una despensa.

Los productos se mantienen en memoria mediante una colección `List<Producto>`. La API permite consultar todos los productos, buscar por identificador, filtrar por categoría, consultar productos con stock bajo, encontrar el producto de mayor valor y obtener un resumen general del inventario.

No se utiliza una base de datos. Los datos se pierden cuando la aplicación se detiene.

## Tecnologías utilizadas

* Java 17
* Spring Boot
* Spring Web
* Maven
* IntelliJ IDEA
* JSON
* Git y GitHub

## Requisitos para ejecutar el proyecto

* Java 17 o superior.
* Maven incluido mediante el Maven Wrapper del proyecto.
* IntelliJ IDEA u otro IDE compatible con proyectos Maven.
* Git para trabajar con el repositorio.

## Estructura principal

```text
control-despensa-api/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/estudiante/despensa/
│   │   │       ├── ControlDespensaApiApplication.java
│   │   │       ├── controller/
│   │   │       │   └── ProductoController.java
│   │   │       └── model/
│   │   │           ├── Producto.java
│   │   │           └── ResumenInventario.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── evidencias/
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## Explicación de las clases

### Producto

Representa cada producto de la despensa. Contiene los atributos:

* ID
* Nombre
* Categoría
* Cantidad
* Precio unitario

También contiene el método `calcularSubtotal()`, que multiplica la cantidad por el precio unitario.

### ResumenInventario

Representa el resumen general de la despensa. Contiene:

* Cantidad de productos.
* Total de unidades.
* Valor total del inventario.

### ProductoController

Es el controlador REST de la aplicación. Utiliza la ruta base `/api/productos` y contiene los endpoints para consultar y analizar los productos almacenados en memoria.

## Endpoints

| Operación                         | Método | Ruta                                   | Estado esperado |
| --------------------------------- | ------ | -------------------------------------- | --------------- |
| Listar productos                  | GET    | `/api/productos`                       | 200             |
| Buscar por identificador          | GET    | `/api/productos/{id}`                  | 200 o 404       |
| Buscar por categoría              | GET    | `/api/productos/categoria/{categoria}` | 200             |
| Consultar stock bajo              | GET    | `/api/productos/stock-bajo`            | 200             |
| Consultar producto de mayor valor | GET    | `/api/productos/mayor-valor`           | 200             |
| Obtener resumen                   | GET    | `/api/productos/resumen`               | 200             |

## Instrucciones para ejecutar la aplicación

1. Abrir el proyecto en IntelliJ IDEA.
2. Esperar a que Maven cargue las dependencias.
3. Abrir la clase `ControlDespensaApiApplication`.
4. Ejecutar el método `main`.
5. Esperar a que Spring Boot indique que la aplicación inició correctamente.
6. Realizar las consultas utilizando las rutas de los endpoints.

La aplicación se ejecuta normalmente en:

```text
http://localhost:8080
```

## Ejemplos de respuestas JSON

### Buscar un producto

Ruta:

```text
GET /api/productos/3
```

Respuesta:

```json
{
  "id": 3,
  "nombre": "Frijoles",
  "categoria": "Granos",
  "cantidad": 5,
  "precioUnitario": 7.0
}
```

### Producto de mayor valor

Ruta:

```text
GET /api/productos/mayor-valor
```

Respuesta:

```json
{
  "id": 5,
  "nombre": "Gaseosa",
  "categoria": "Bebidas",
  "cantidad": 6,
  "precioUnitario": 9.5
}
```

### Resumen del inventario

Ruta:

```text
GET /api/productos/resumen
```

Respuesta:

```json
{
  "cantidadProductos": 6,
  "totalUnidades": 21,
  "valorTotal": 217.0
}
```

## Datos de prueba

La aplicación contiene seis productos almacenados en memoria:

| ID | Producto | Categoría | Cantidad | Precio unitario |
| -: | -------- | --------- | -------: | --------------: |
|  1 | Arroz    | Granos    |        4 |           Q8.50 |
|  2 | Leche    | Lacteos   |        2 |          Q10.00 |
|  3 | Frijoles | Granos    |        5 |           Q7.00 |
|  4 | Jabon    | Limpieza  |        3 |          Q12.00 |
|  5 | Gaseosa  | Bebidas   |        6 |           Q9.50 |
|  6 | Cafe     | Bebidas   |        1 |          Q35.00 |

## Repositorio

El enlace al repositorio de GitHub se agregará al finalizar la actividad.

## Evidencias

El documento de evidencias se encuentra dentro de la carpeta:

```text
evidencias/
```

Nombre del documento:

```text
Evidencias_API_Despensa_NombreApellido.docx
```
