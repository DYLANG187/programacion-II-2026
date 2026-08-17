import java.util.Scanner;

public class ControlParqueo {

    public static double obtenerTarifa(int tipoVehiculo) {
        switch (tipoVehiculo) {
            case 1:
                return 5.00;
            case 2:
                return 8.00;
            case 3:
                return 12.00;
            default:
                return 0.00;
        }
    }

    public static String obtenerNombreVehiculo(int tipoVehiculo) {
        switch (tipoVehiculo) {
            case 1:
                return "Motocicleta";
            case 2:
                return "Automóvil";
            case 3:
                return "Pickup o camioneta";
            default:
                return "Desconocido";
        }
    }

    public static double calcularDescuento(double subtotal, int horas) {
        if (horas > 8) {
            return subtotal * 0.15;
        } else {
            return 0.00;
        }
    }

    public static double calcularPago(int horas, double tarifa) {
        return horas * tarifa;
    }

    public static double calcularPago(int horas, double tarifa, double recargo) {
        return (horas * tarifa) + recargo;
    }

    public static void mostrarComprobante(
            String placa,
            String nombreVehiculo,
            int horasExactas,
            int minutosExactos,
            int horasCobradas,
            double tarifa,
            double subtotal,
            double descuento,
            double recargo,
            double total) {

        System.out.println();
        System.out.println("========== COMPROBANTE ==========");
        System.out.println("Placa: " + placa);
        System.out.println("Tipo: " + nombreVehiculo);
        System.out.println("Tiempo estacionado: " + horasExactas
                + " horas y " + minutosExactos + " minutos");
        System.out.println("Horas cobradas: " + horasCobradas);
        System.out.printf("Tarifa por hora: Q%.2f%n", tarifa);
        System.out.printf("Subtotal: Q%.2f%n", subtotal);
        System.out.printf("Descuento: Q%.2f%n", descuento);
        System.out.printf("Recargo por ticket perdido: Q%.2f%n", recargo);
        System.out.printf("TOTAL: Q%.2f%n", total);
        System.out.println("=================================");
    }

    public static int solicitarHora(Scanner scanner, String mensaje) {
        int hora;

        do {
            System.out.print(mensaje);
            hora = scanner.nextInt();

            if (hora < 0 || hora > 23) {
                System.out.println("Error: la hora debe estar entre 0 y 23.");
            }

        } while (hora < 0 || hora > 23);

        return hora;
    }

    public static int solicitarMinuto(Scanner scanner, String mensaje) {
        int minuto;

        do {
            System.out.print(mensaje);
            minuto = scanner.nextInt();

            if (minuto < 0 || minuto > 59) {
                System.out.println("Error: los minutos deben estar entre 0 y 59.");
            }

        } while (minuto < 0 || minuto > 59);

        return minuto;
    }

    public static int calcularMinutosEstacionado(
            int horaEntrada,
            int minutoEntrada,
            int horaSalida,
            int minutoSalida) {

        int entrada = horaEntrada * 60 + minutoEntrada;
        int salida = horaSalida * 60 + minutoSalida;

        if (salida < entrada) {
            salida += 24 * 60;
        }

        return salida - entrada;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("          CONTROL DE PARQUEO");
        System.out.println("==========================================");
        System.out.println("Nombre: Dylan Sneyder Garcia Sosa");
        System.out.println("Carné: 9941-25-21652");
        System.out.println();

        int cantidadVehiculos;

        do {
            System.out.print("Ingrese la cantidad de vehículos: ");
            cantidadVehiculos = scanner.nextInt();

            if (cantidadVehiculos <= 0) {
                System.out.println("Error: la cantidad debe ser mayor que cero.");
            }

        } while (cantidadVehiculos <= 0);

        int cantidadMotocicletas = 0;
        int cantidadAutomoviles = 0;
        int cantidadPickups = 0;
        int cantidadTicketsPerdidos = 0;

        double totalRecaudado = 0.00;
        double pagoMasAlto = 0.00;
        String placaPagoMasAlto = "";

        for (int i = 1; i <= cantidadVehiculos; i++) {

            System.out.println();
            System.out.println("---------- VEHÍCULO " + i + " ----------");

            scanner.nextLine();

            System.out.print("Ingrese el número de placa: ");
            String placa = scanner.nextLine();

            int tipoVehiculo;

            do {
                System.out.println("Tipo de vehículo:");
                System.out.println("1. Motocicleta");
                System.out.println("2. Automóvil");
                System.out.println("3. Pickup o camioneta");
                System.out.print("Seleccione una opción: ");

                tipoVehiculo = scanner.nextInt();

                if (tipoVehiculo < 1 || tipoVehiculo > 3) {
                    System.out.println("Error: debe ingresar un tipo entre 1 y 3.");
                }

            } while (tipoVehiculo < 1 || tipoVehiculo > 3);

            int horaEntrada = solicitarHora(
                    scanner,
                    "Hora de entrada (0-23): "
            );

            int minutoEntrada = solicitarMinuto(
                    scanner,
                    "Minuto de entrada (0-59): "
            );

            int horaSalida = solicitarHora(
                    scanner,
                    "Hora de salida (0-23): "
            );

            int minutoSalida = solicitarMinuto(
                    scanner,
                    "Minuto de salida (0-59): "
            );

            int minutosEstacionado = calcularMinutosEstacionado(
                    horaEntrada,
                    minutoEntrada,
                    horaSalida,
                    minutoSalida
            );

            int horasExactas = minutosEstacionado / 60;
            int minutosExactos = minutosEstacionado % 60;

            int horasCobradas = minutosEstacionado / 60;

            if (minutosEstacionado % 60 != 0) {
                horasCobradas++;
            }

            char ticketPerdido;

            do {
                System.out.print("¿Perdió el ticket? (S/N): ");
                ticketPerdido = scanner.next().toUpperCase().charAt(0);

                if (ticketPerdido != 'S' && ticketPerdido != 'N') {
                    System.out.println("Error: debe ingresar únicamente S o N.");
                }

            } while (ticketPerdido != 'S' && ticketPerdido != 'N');

            double tarifa = obtenerTarifa(tipoVehiculo);
            String nombreVehiculo = obtenerNombreVehiculo(tipoVehiculo);

            double subtotal = calcularPago(horasCobradas, tarifa);

            double descuento = calcularDescuento(
                    subtotal,
                    horasCobradas
            );

            double recargo;

            if (ticketPerdido == 'S') {
                recargo = 50.00;
                cantidadTicketsPerdidos++;
            } else {
                recargo = 0.00;
            }

            double total;

            if (ticketPerdido == 'S') {
                calcularPago(horasCobradas, tarifa, recargo);
                total = subtotal - descuento + recargo;
            } else {
                total = subtotal - descuento;
            }

            switch (tipoVehiculo) {
                case 1:
                    cantidadMotocicletas++;
                    break;

                case 2:
                    cantidadAutomoviles++;
                    break;

                case 3:
                    cantidadPickups++;
                    break;
            }

            totalRecaudado += total;

            if (total > pagoMasAlto) {
                pagoMasAlto = total;
                placaPagoMasAlto = placa;
            }

            mostrarComprobante(
                    placa,
                    nombreVehiculo,
                    horasExactas,
                    minutosExactos,
                    horasCobradas,
                    tarifa,
                    subtotal,
                    descuento,
                    recargo,
                    total
            );
        }

        System.out.println();
        System.out.println("==========================================");
        System.out.println("          RESUMEN DE LA JORNADA");
        System.out.println("==========================================");
        System.out.println("Cantidad de motocicletas: "
                + cantidadMotocicletas);
        System.out.println("Cantidad de automóviles: "
                + cantidadAutomoviles);
        System.out.println("Cantidad de pickups/camionetas: "
                + cantidadPickups);
        System.out.println("Cantidad de tickets perdidos: "
                + cantidadTicketsPerdidos);
        System.out.printf("Total de dinero recaudado: Q%.2f%n",
                totalRecaudado);
        System.out.printf("Pago más alto: Q%.2f - Placa: %s%n",
                pagoMasAlto,
                placaPagoMasAlto);
        System.out.println("==========================================");

        scanner.close();
    }
}