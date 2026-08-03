import java.util.Scanner;

public class CondicionesyCiclos {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Estudiante: Dylan Sneyder Garcia Sosa");
        System.out.println("Carné: 9941-25-21652");
        System.out.println("Semana 3 — Condiciones y ciclos");
        System.out.println();

        int opcion;

        do {
            System.out.println("========= DESAFÍOS LÓGICOS =========");
            System.out.println();
            System.out.println("1. Generar una secuencia");
            System.out.println("2. Realizar un conteo regresivo");
            System.out.println("3. Analizar números");
            System.out.println("4. Dibujar una pirámide");
            System.out.println("5. Validar palabra secreta");
            System.out.println("6. Salir");
            System.out.println();

            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    // Opción 1: Generar una secuencia
                    System.out.print("Número inicial: ");
                    int inicial = scanner.nextInt();

                    System.out.print("Número final: ");
                    int finalNumero = scanner.nextInt();

                    System.out.print("Incremento: ");
                    int incremento = scanner.nextInt();

                    if (incremento <= 0) {
                        System.out.println("El incremento debe ser mayor que cero.");
                    } else if (finalNumero <= inicial) {
                        System.out.println("El número final debe ser mayor que el inicial.");
                    } else {
                        System.out.println("Resultado:");

                        for (int numero = inicial; numero <= finalNumero; numero += incremento) {
                            System.out.print(numero + " ");
                        }

                        System.out.println();
                    }
                    break;

                case 2:
                    // Opción 2: Realizar un conteo regresivo
                    int numeroRegresivo;

                    System.out.print("Ingrese el número inicial (10-50): ");
                    numeroRegresivo = scanner.nextInt();

                    while (numeroRegresivo < 10 || numeroRegresivo > 50) {
                        System.out.println("Número inválido. Debe estar entre 10 y 50.");
                        System.out.print("Ingrese nuevamente el número: ");
                        numeroRegresivo = scanner.nextInt();
                    }

                    System.out.println("Resultado:");

                    while (numeroRegresivo >= 0) {
                        System.out.print(numeroRegresivo + " ");
                        numeroRegresivo--;
                    }

                    System.out.println();
                    System.out.println("¡Despegue!");
                    break;

                case 3:
                    // Opción 3: Analizar números
                    int numero;
                    int positivos = 0;
                    int negativos = 0;
                    int suma = 0;
                    int ignorados = 0;

                    while (true) {
                        System.out.print("Ingrese un número: ");
                        numero = scanner.nextInt();

                        if (numero == 0) {
                            break;
                        }

                        if (numero % 5 == 0) {
                            System.out.println("El número " + numero + " fue ignorado.");
                            ignorados++;
                            continue;
                        }

                        if (numero > 0) {
                            positivos++;
                        } else if (numero < 0) {
                            negativos++;
                        } else {
                            System.out.println("Número no válido.");
                        }

                        suma += numero;
                    }

                    System.out.println();
                    System.out.println("Resultado:");
                    System.out.println("Positivos: " + positivos);
                    System.out.println("Negativos: " + negativos);
                    System.out.println("Suma válida: " + suma);
                    System.out.println("Números ignorados: " + ignorados);
                    break;

                case 4:
                    // Opción 4: Dibujar una pirámide
                    int altura;

                    System.out.print("Ingrese la altura (3-10): ");
                    altura = scanner.nextInt();

                    while (altura < 3 || altura > 10) {
                        System.out.println("Altura inválida. Debe estar entre 3 y 10.");
                        System.out.print("Ingrese nuevamente la altura: ");
                        altura = scanner.nextInt();
                    }

                    for (int fila = 1; fila <= altura; fila++) {

                        for (int espacios = 1; espacios <= altura - fila; espacios++) {
                            System.out.print(" ");
                        }

                        for (int asteriscos = 1; asteriscos <= (2 * fila - 1); asteriscos++) {
                            System.out.print("*");
                        }

                        System.out.println();
                    }
                    break;

                case 5:
                    // Opción 5: Validar palabra secreta
                    scanner.nextLine();

                    String palabra;

                    do {
                        System.out.print("Ingrese la palabra secreta: ");
                        palabra = scanner.nextLine();

                        if (palabra.trim().equalsIgnoreCase("Guatemala")) {
                            System.out.println("Palabra correcta.");
                        } else {
                            System.out.println("Palabra incorrecta. Intente nuevamente.");
                        }

                    } while (!palabra.trim().equalsIgnoreCase("Guatemala"));

                    break;

                case 6:
                    System.out.println("Programa finalizado correctamente.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

            System.out.println();

        } while (opcion != 6);

        scanner.close();
    }
}