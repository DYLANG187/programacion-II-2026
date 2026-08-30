import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE ENVÍOS =====");
            System.out.println("1. Registrar envío nacional");
            System.out.println("2. Registrar envío internacional");
            System.out.println("3. Salir");

            opcion = leerOpcion(scanner);

            switch (opcion) {
                case 1:
                    registrarEnvioNacional(scanner);
                    break;

                case 2:
                    registrarEnvioInternacional(scanner);
                    break;

                case 3:
                    System.out.println("\nPrograma finalizado.");
                    break;

                default:
                    System.out.println("\nOpción inválida. Seleccione 1, 2 o 3.");
            }

        } while (opcion != 3);

        scanner.close();
    }

    public static void registrarEnvioNacional(Scanner scanner) {

        System.out.println("\n--- REGISTRO DE ENVÍO NACIONAL ---");

        String codigo = leerTexto(scanner, "Ingrese el código del envío: ");
        String destinatario = leerTexto(scanner, "Ingrese el nombre del destinatario: ");
        double peso = leerNumeroMayorQueCero(scanner, "Ingrese el peso del paquete en kg: ");
        String departamento = leerTexto(scanner, "Ingrese el departamento de destino: ");
        double distancia = leerNumeroMayorQueCero(scanner, "Ingrese la distancia en km: ");

        Envio envio = new EnvioNacional(
                codigo,
                destinatario,
                peso,
                departamento,
                distancia
        );

        envio.mostrarResumen(true);

        preguntarOtroEnvio(scanner);
    }

    public static void registrarEnvioInternacional(Scanner scanner) {

        System.out.println("\n--- REGISTRO DE ENVÍO INTERNACIONAL ---");

        String codigo = leerTexto(scanner, "Ingrese el código del envío: ");
        String destinatario = leerTexto(scanner, "Ingrese el nombre del destinatario: ");
        double peso = leerNumeroMayorQueCero(scanner, "Ingrese el peso del paquete en kg: ");
        String pais = leerTexto(scanner, "Ingrese el país de destino: ");

        Envio envio = new EnvioInternacional(
                codigo,
                destinatario,
                peso,
                pais
        );

        envio.mostrarResumen(true);

        preguntarOtroEnvio(scanner);
    }

    public static int leerOpcion(Scanner scanner) {

        while (true) {
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = Integer.parseInt(scanner.nextLine());

                if (opcion >= 1 && opcion <= 3) {
                    return opcion;
                }

                System.out.println("Error: debe seleccionar una opción entre 1 y 3.");

            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número válido.");
            }
        }
    }

    public static String leerTexto(Scanner scanner, String mensaje) {

        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine().trim();

            if (!texto.isEmpty()) {
                return texto;
            }

            System.out.println("Error: este campo no puede estar vacío.");
        }
    }

    public static double leerNumeroMayorQueCero(Scanner scanner, String mensaje) {

        while (true) {
            System.out.print(mensaje);

            try {
                double numero = Double.parseDouble(scanner.nextLine());

                if (numero > 0) {
                    return numero;
                }

                System.out.println("Error: el valor debe ser mayor que cero.");

            } catch (NumberFormatException e) {
                System.out.println("Error: ingrese un número válido.");
            }
        }
    }

    public static void preguntarOtroEnvio(Scanner scanner) {

        while (true) {
            System.out.print("\n¿Desea registrar otro envío? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();

            if (respuesta.equals("s")) {
                return;
            }

            if (respuesta.equals("n")) {
                System.out.println("\nRegresando al menú principal...");
                return;
            }

            System.out.println("Error: responda únicamente con 's' o 'n'.");
        }
    }

}