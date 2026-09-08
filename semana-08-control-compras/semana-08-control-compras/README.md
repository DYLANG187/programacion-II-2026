# Semana 08 - Control de Compras

## Descripción

Este proyecto consiste en una aplicación de consola desarrollada en Java para registrar y analizar las compras realizadas durante una semana.

El programa permite registrar productos, calcular sus subtotales, obtener el gasto total y conocer cuánto se gastó en cada categoría.

## Funcionalidades

* Registrar productos con nombre, categoría, precio y cantidad.
* Validar que los datos ingresados sean correctos.
* Calcular el subtotal de cada producto.
* Mostrar todos los productos registrados.
* Mostrar las categorías sin repetir.
* Calcular el total general de las compras.
* Calcular el total gastado por cada categoría.
* Identificar el producto con mayor y menor gasto.
* Identificar la categoría con mayor gasto.
* Consultar el total gastado en una categoría específica.

## Colecciones utilizadas

El programa utiliza tres colecciones de Java:

* `ArrayList<Producto>`: almacena todos los productos registrados.
* `HashSet<String>`: almacena las categorías sin repetir.
* `HashMap<String, Double>`: relaciona cada categoría con el total gastado en ella.

## Estructura del proyecto

```text
semana-08-control-compras/
├── src/
│   ├── Producto.java
│   └── MainControlCompras.java
├── evidencias/
│   └── Evidencias_Control_Compras_NombreApellido.docx
├── README.md
└── .gitignore
```

## Requisitos

* Java JDK
* IntelliJ IDEA o cualquier IDE compatible con Java.

## Ejecución

1. Abrir el proyecto en IntelliJ IDEA.
2. Ejecutar la clase `MainControlCompras`.
3. Ingresar los datos solicitados por el programa.
4. Revisar los resultados mostrados en la consola.

## Nombre y Carné

**Nombre:** Dylan Sneyder Garcia Sosa

**Carné:** 9941-25-21652
