import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class MainControlCompras {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Producto> productos = new ArrayList<>();
        HashSet<String> categorias = new HashSet<>();
        HashMap<String, Double> totalesPorCategoria = new HashMap<>();

        for (int i = 0; i < 5; i++) {

            System.out.println("\n===== REGISTRO DEL PRODUCTO " + (i + 1) + " =====");

            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine();

            System.out.print("Categoría: ");
            String categoria = scanner.nextLine();

            System.out.print("Precio unitario: Q");
            double precioUnitario = scanner.nextDouble();

            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            if (nombre.trim().isEmpty()) {
                System.out.println("Producto no registrado: el nombre no puede estar vacío.");
            } else if (categoria.trim().isEmpty()) {
                System.out.println("Producto no registrado: la categoría no puede estar vacía.");
            } else if (precioUnitario <= 0) {
                System.out.println("Producto no registrado: el precio debe ser mayor que cero.");
            } else if (cantidad <= 0) {
                System.out.println("Producto no registrado: la cantidad debe ser mayor que cero.");
            } else {

                Producto producto = new Producto(nombre, categoria, precioUnitario, cantidad);

                productos.add(producto);
                categorias.add(categoria);

                double subtotal = producto.calcularSubtotal();

                if (totalesPorCategoria.containsKey(categoria)) {
                    totalesPorCategoria.put(
                            categoria,
                            totalesPorCategoria.get(categoria) + subtotal
                    );
                } else {
                    totalesPorCategoria.put(categoria, subtotal);
                }

                System.out.println("Producto registrado correctamente.");
            }
        }

        System.out.println("\n===== RESUMEN DE COMPRAS =====");

        double totalGeneral = 0;
        Producto productoMayor = productos.get(0);
        Producto productoMenor = productos.get(0);

        for (Producto producto : productos) {

            double subtotal = producto.calcularSubtotal();

            System.out.printf(
                    "%s | %s | Q%.2f x %d | Subtotal: Q%.2f%n",
                    producto.getNombre(),
                    producto.getCategoria(),
                    producto.getPrecioUnitario(),
                    producto.getCantidad(),
                    subtotal
            );

            totalGeneral += subtotal;

            if (subtotal > productoMayor.calcularSubtotal()) {
                productoMayor = producto;
            }

            if (subtotal < productoMenor.calcularSubtotal()) {
                productoMenor = producto;
            }
        }

        System.out.println("\nCategorías registradas:");
        System.out.println(categorias);

        System.out.println("\nTotal por categoría:");

        for (String categoria : totalesPorCategoria.keySet()) {
            System.out.printf(
                    "%s: Q%.2f%n",
                    categoria,
                    totalesPorCategoria.get(categoria)
            );
        }

        String categoriaMayor = "";
        double mayorTotalCategoria = 0;

        for (String categoria : totalesPorCategoria.keySet()) {

            double totalCategoria = totalesPorCategoria.get(categoria);

            if (totalCategoria > mayorTotalCategoria) {
                mayorTotalCategoria = totalCategoria;
                categoriaMayor = categoria;
            }
        }

        System.out.println("\nProductos registrados: " + productos.size());

        System.out.printf("Total general: Q%.2f%n", totalGeneral);

        System.out.println("\nProducto con mayor gasto:");
        System.out.printf(
                "%s - Q%.2f%n",
                productoMayor.getNombre(),
                productoMayor.calcularSubtotal()
        );

        System.out.println("\nProducto con menor gasto:");
        System.out.printf(
                "%s - Q%.2f%n",
                productoMenor.getNombre(),
                productoMenor.calcularSubtotal()
        );

        System.out.println("\nCategoría con mayor gasto:");
        System.out.printf(
                "%s - Q%.2f%n",
                categoriaMayor,
                mayorTotalCategoria
        );

        System.out.print("\nIngrese una categoría para consultar: ");
        String categoriaConsulta = scanner.nextLine();

        if (totalesPorCategoria.containsKey(categoriaConsulta)) {
            System.out.printf(
                    "Total gastado en %s: Q%.2f%n",
                    categoriaConsulta,
                    totalesPorCategoria.get(categoriaConsulta)
            );
        } else {
            System.out.println("La categoría ingresada no se encuentra registrada.");
        }

        scanner.close();
    }
}