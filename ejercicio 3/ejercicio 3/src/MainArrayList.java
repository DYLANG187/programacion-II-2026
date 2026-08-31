import java.util.ArrayList;
import java.util.Scanner;

public class MainArrayList {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Mascota> mascotas = new ArrayList<>();

        System.out.println("=== REGISTRO DE MASCOTAS ===");

        // Registrar tres mascotas
        for (int i = 1; i <= 3; i++) {

            System.out.println("\nMascota " + i);

            System.out.print("Ingrese el nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Ingrese la especie: ");
            String especie = scanner.nextLine();

            mascotas.add(new Mascota(nombre, especie));
        }

        // Mostrar cantidad
        System.out.println("\nCantidad de mascotas: " + mascotas.size());

        // Recorrer la lista
        System.out.println("\n--- MASCOTAS REGISTRADAS ---");

        for (Mascota mascota : mascotas) {
            System.out.println(mascota);
        }

        // Eliminar una mascota
        System.out.print("\nIngrese el número de la mascota que desea eliminar (1-3): ");
        String entrada = scanner.nextLine();

        try {

            int opcion = Integer.parseInt(entrada);

            if (opcion >= 1 && opcion <= mascotas.size()) {

                mascotas.remove(opcion - 1);

                System.out.println("Mascota eliminada correctamente.");

            } else {

                System.out.println("Debe ingresar un número válido.");
            }

        } catch (NumberFormatException e) {

            System.out.println("Debe ingresar una opción numérica.");
        }

        // Mostrar nuevamente
        System.out.println("\n--- LISTA ACTUALIZADA ---");

        System.out.println("Cantidad de mascotas: " + mascotas.size());

        for (Mascota mascota : mascotas) {
            System.out.println(mascota);
        }

        scanner.close();
    }
}