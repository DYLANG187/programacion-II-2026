import java.util.HashSet;
import java.util.Scanner;

public class MainHashSet {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HashSet<String> codigos = new HashSet<>();

        System.out.println("=== REGISTRO DE CÓDIGOS ===");

        for (int i = 1; i <= 3; i++) {

            System.out.print("Ingrese el código " + i + ": ");
            String codigo = scanner.nextLine();

            codigos.add(codigo);
        }

        System.out.println("\nCódigos registrados:");
        for (String codigo : codigos) {
            System.out.println(codigo);
        }

        System.out.print("\nIngrese un código para intentar registrarlo nuevamente: ");
        String codigoRepetido = scanner.nextLine();

        if (codigos.contains(codigoRepetido)) {
            System.out.println("El código ya existe. No se puede registrar.");
        } else {
            codigos.add(codigoRepetido);
            System.out.println("Código registrado correctamente.");
        }

        System.out.println("\n--- CÓDIGOS ALMACENADOS ---");

        for (String codigo : codigos) {
            System.out.println(codigo);
        }

        System.out.print("\nIngrese una opción numérica para continuar: ");
        String entrada = scanner.nextLine();

        try {

            int opcion = Integer.parseInt(entrada);

            System.out.println("Opción ingresada: " + opcion);

        } catch (NumberFormatException e) {

            System.out.println("Debe ingresar una opción numérica.");
        }

        scanner.close();
    }
}