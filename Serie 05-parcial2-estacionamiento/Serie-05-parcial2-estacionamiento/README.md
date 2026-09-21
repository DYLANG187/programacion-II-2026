# Parcial II - Sistema de Estacionamiento

## Descripción

Aplicación de consola desarrollada en Java para administrar el ingreso de vehículos a un estacionamiento.

El proyecto permite registrar automóviles y motocicletas, calcular el costo de estacionamiento, buscar vehículos, mostrar información y consultar la recaudación.

También se incluye una base de datos PostgreSQL con las operaciones solicitadas en el examen.

## Tecnologías utilizadas

* Java
* Programación Orientada a Objetos (POO)
* IntelliJ IDEA
* PostgreSQL
* pgAdmin 4
* GitHub

## Estructura del proyecto

```text
parcial2_estacionamiento/
│
├── src/
│   └── estacionamiento/
│       ├── Vehiculo.java
│       ├── Automovil.java
│       ├── Motocicleta.java
│       ├── Estacionamiento.java
│       └── Main.java
│
├── database/
│   └── estacionamiento.sql
│
├── evidencias/
│   └── capturas del funcionamiento del proyecto
│
├── README.md
└── .gitignore
```

## Funcionalidades

El programa permite:

1. Registrar vehículos.
2. Mostrar todos los vehículos registrados.
3. Buscar un vehículo por placa.
4. Mostrar el vehículo con mayor costo.
5. Mostrar el total general recaudado.
6. Mostrar el total recaudado por tipo de vehículo.
7. Salir del sistema.

## Tipos de vehículos

### Automóvil

* Tarifa: Q10 por hora.
* Si utiliza más de 5 horas, se aplica un descuento del 10%.

### Motocicleta

* Tarifa: Q6 por hora.
* Si utiliza más de 5 horas, se aplica un descuento del 10%.

## Validaciones

El sistema valida:

* Que la placa no esté vacía.
* Que el propietario no esté vacío.
* Que la hora de ingreso no esté vacía.
* Que las horas utilizadas sean mayores que cero.
* Que no existan placas duplicadas.
* Que el tipo de vehículo sea válido.
* Que las opciones del menú sean numéricas.

También se utilizan `try`, `catch` y `finally` para manejar entradas incompatibles.

## Programación Orientada a Objetos

El proyecto utiliza:

* Clase abstracta `Vehiculo`.
* Herencia mediante `Automovil` y `Motocicleta`.
* Encapsulamiento de atributos.
* Sobrescritura del método `calcularCosto()`.
* Polimorfismo utilizando referencias de tipo `Vehiculo`.

## Colecciones utilizadas

* `ArrayList<Vehiculo>` para almacenar los vehículos registrados.
* `HashSet<String>` para controlar las placas y evitar duplicados.
* `HashMap<String, Double>` para almacenar la recaudación por tipo de vehículo.

## Base de datos

La base de datos utilizada es:

`parcial2_estacionamiento`

La tabla principal es:

`vehiculo`

La tabla contiene los campos:

* `id`
* `placa`
* `propietario`
* `tipo`
* `hora_ingreso`
* `horas_utilizadas`
* `costo`
* `activo`

Se utilizan restricciones como `PRIMARY KEY`, `NOT NULL`, `UNIQUE`, `CHECK` y `DEFAULT`.

El archivo con las instrucciones SQL se encuentra en:

`database/estacionamiento.sql`

## Evidencias

La carpeta `evidencias` contiene capturas del funcionamiento del programa en Java, las pruebas realizadas en PostgreSQL y los resultados de las operaciones solicitadas.

## Estudiante

Nombre: Dylan Garcia

Carné: 9941-25-21652

Curso: Programación II

Evaluación: Examen Parcial 2
