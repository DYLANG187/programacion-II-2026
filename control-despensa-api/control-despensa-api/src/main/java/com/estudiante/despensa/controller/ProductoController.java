package com.estudiante.despensa.controller;

import com.estudiante.despensa.model.Producto;
import com.estudiante.despensa.model.ResumenInventario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final List<Producto> productos = new ArrayList<>();

    public ProductoController() {

        agregarProducto(new Producto(1L, "Arroz", "Granos", 4, 8.50));
        agregarProducto(new Producto(2L, "Leche", "Lacteos", 2, 10.00));
        agregarProducto(new Producto(3L, "Frijoles", "Granos", 5, 7.00));
        agregarProducto(new Producto(4L, "Jabon", "Limpieza", 3, 12.00));
        agregarProducto(new Producto(5L, "Gaseosa", "Bebidas", 6, 9.50));
        agregarProducto(new Producto(6L, "Cafe", "Bebidas", 1, 35.00));
    }

    private void agregarProducto(Producto producto) {
        if (producto.getId() == null || producto.getId() <= 0) {
            throw new IllegalArgumentException("El identificador debe ser mayor que cero.");
        }

        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        if (producto.getCategoria() == null || producto.getCategoria().trim().isEmpty()) {
            throw new IllegalArgumentException("La categoría no puede estar vacía.");
        }

        if (producto.getCantidad() < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }

        if (producto.getPrecioUnitario() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero.");
        }

        for (Producto existente : productos) {
            if (existente.getId().equals(producto.getId())) {
                throw new IllegalArgumentException("El identificador está duplicado.");
            }
        }

        productos.add(producto);
    }

    // 1. Listar todos los productos
    @GetMapping
    public List<Producto> obtenerProductos() {
        return productos;
    }

    // 2. Buscar producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerPorId(@PathVariable Long id) {

        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                return ResponseEntity.ok(producto);
            }
        }

        return ResponseEntity.notFound().build();
    }

    // 3. Buscar productos por categoría
    @GetMapping("/categoria/{categoria}")
    public List<Producto> obtenerPorCategoria(@PathVariable String categoria) {

        List<Producto> resultado = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.add(producto);
            }
        }

        return resultado;
    }

    // 4. Productos con stock bajo
    @GetMapping("/stock-bajo")
    public List<Producto> obtenerStockBajo() {

        List<Producto> resultado = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getCantidad() <= 3) {
                resultado.add(producto);
            }
        }

        return resultado;
    }

    // 5. Producto de mayor valor
    @GetMapping("/mayor-valor")
    public ResponseEntity<Producto> obtenerMayorValor() {

        if (productos.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Producto mayor = productos.get(0);

        for (Producto producto : productos) {
            if (producto.calcularSubtotal() > mayor.calcularSubtotal()) {
                mayor = producto;
            }
        }

        return ResponseEntity.ok(mayor);
    }

    // 6. Resumen del inventario
    @GetMapping("/resumen")
    public ResumenInventario obtenerResumen() {

        int cantidadProductos = productos.size();
        int totalUnidades = 0;
        double valorTotal = 0;

        for (Producto producto : productos) {
            totalUnidades += producto.getCantidad();
            valorTotal += producto.calcularSubtotal();
        }

        return new ResumenInventario(
                cantidadProductos,
                totalUnidades,
                valorTotal
        );
    }
}