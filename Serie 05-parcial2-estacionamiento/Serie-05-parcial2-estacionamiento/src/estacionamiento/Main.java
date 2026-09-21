package estacionamiento;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Estacionamiento estacionamiento = new Estacionamiento();

        int opcion = 0;

        do {
            try {
                System.out.println("\n===== ESTACIONAMIENTO =====");
                System.out.println("1. Registrar vehículo");
                System.out.println("2. Mostrar todos los vehículos");
                System.out.println("3. Buscar vehículo por placa");
                System.out.println("4. Mostrar vehículo de mayor costo");
                System.out.println("5. Mostrar total general recaudado");
                System.out.println("6. Mostrar total recaudado por tipo");
                System.out.println("7. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {

                    case 1:
                        registrarVehiculo(scanner, estacionamiento);
                        break;

                    case 2:
                        System.out.println("\n===== VEHÍCULOS REGISTRADOS =====");

                        if (estacionamiento.getVehiculos().isEmpty()) {
                            System.out.println("No hay vehículos registrados.");
                        } else {
                            for (Vehiculo vehiculo : estacionamiento.getVehiculos()) {

                                String tipo;

                                if (vehiculo instanceof Automovil) {
                                    tipo = "Automóvil";
                                } else {
                                    tipo = "Motocicleta";
                                }

                                System.out.println("----------------------------");
                                System.out.println("Placa: " + vehiculo.getPlaca());
                                System.out.println("Propietario: " + vehiculo.getPropietario());
                                System.out.println("Tipo: " + tipo);
                                System.out.println("Horas utilizadas: "
                                        + vehiculo.getHorasUtilizadas());
                                System.out.println("Costo: Q"
                                        + String.format("%.2f",
                                        vehiculo.calcularCosto()));
                            }
                        }
                        break;

                    case 3:
                        System.out.println("\n===== BUSCAR VEHÍCULO =====");
                        System.out.print("Ingrese la placa: ");

                        String placaBuscar = scanner.nextLine().trim();

                        Vehiculo encontrado =
                                estacionamiento.buscarPorPlaca(placaBuscar);

                        if (encontrado != null) {
                            encontrado.mostrarInformacion();
                        } else {
                            System.out.println(
                                    "No se encontró ningún vehículo con esa placa.");
                        }
                        break;

                    case 4:
                        System.out.println("\n===== VEHÍCULO DE MAYOR COSTO =====");

                        Vehiculo mayorCosto =
                                estacionamiento.obtenerMayorCosto();

                        if (mayorCosto == null) {
                            System.out.println("No hay vehículos registrados.");
                        } else {

                            String tipo;

                            if (mayorCosto instanceof Automovil) {
                                tipo = "Automóvil";
                            } else {
                                tipo = "Motocicleta";
                            }

                            System.out.println("Placa: "
                                    + mayorCosto.getPlaca());
                            System.out.println("Propietario: "
                                    + mayorCosto.getPropietario());
                            System.out.println("Tipo: " + tipo);
                            System.out.println("Horas utilizadas: "
                                    + mayorCosto.getHorasUtilizadas());
                            System.out.println("Costo: Q"
                                    + String.format("%.2f",
                                    mayorCosto.calcularCosto()));
                        }
                        break;

                    case 5:
                        System.out.println("\n===== TOTAL GENERAL RECAUDADO =====");

                        double totalGeneral =
                                estacionamiento.obtenerTotalGeneral();

                        System.out.println("Total recaudado: Q"
                                + String.format("%.2f", totalGeneral));
                        break;

                    case 6:
                        System.out.println("\n===== TOTAL RECAUDADO POR TIPO =====");

                        System.out.println(
                                estacionamiento.obtenerRecaudacionPorTipo());
                        break;

                    case 7:
                        System.out.println("\nSaliendo del sistema...");
                        break;

                    default:
                        System.out.println("\nOpción inválida.");
                }

            } catch (NumberFormatException e) {
                System.out.println(
                        "\nError: debe ingresar un número válido.");
            } finally {
                System.out.println("Operación procesada.");
            }

        } while (opcion != 7);

        scanner.close();
    }

    public static void registrarVehiculo(
            Scanner scanner,
            Estacionamiento estacionamiento) {

        System.out.println("\n===== REGISTRAR VEHÍCULO =====");

        System.out.print("Placa: ");
        String placa = scanner.nextLine().trim();

        if (placa.isEmpty()) {
            System.out.println("La placa no puede estar vacía.");
            return;
        }

        if (estacionamiento.buscarPorPlaca(placa) != null) {
            System.out.println("La placa ya está registrada.");
            return;
        }

        System.out.print("Nombre del propietario: ");
        String propietario = scanner.nextLine().trim();

        if (propietario.isEmpty()) {
            System.out.println("El propietario no puede estar vacío.");
            return;
        }

        System.out.print("Hora de ingreso: ");
        String horaIngreso = scanner.nextLine().trim();

        if (horaIngreso.isEmpty()) {
            System.out.println("La hora de ingreso no puede estar vacía.");
            return;
        }

        int horasUtilizadas;

        while (true) {
            try {
                System.out.print("Horas utilizadas: ");
                horasUtilizadas = Integer.parseInt(scanner.nextLine());

                if (horasUtilizadas <= 0) {
                    System.out.println(
                            "Las horas utilizadas deben ser mayores que cero.");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println(
                        "Debe ingresar un número entero válido.");
            } finally {
                System.out.println("Validación de horas realizada.");
            }
        }

        int tipo;

        while (true) {
            try {
                System.out.println("\nTipo de vehículo:");
                System.out.println("1. Automóvil");
                System.out.println("2. Motocicleta");
                System.out.print("Seleccione el tipo: ");

                tipo = Integer.parseInt(scanner.nextLine());

                if (tipo == 1 || tipo == 2) {
                    break;
                }

                System.out.println("Tipo de vehículo inválido.");

            } catch (NumberFormatException e) {
                System.out.println(
                        "Debe ingresar una opción numérica.");
            } finally {
                System.out.println("Validación de tipo realizada.");
            }
        }

        Vehiculo vehiculo;

        if (tipo == 1) {
            vehiculo = new Automovil(
                    placa,
                    propietario,
                    horaIngreso,
                    horasUtilizadas
            );
        } else {
            vehiculo = new Motocicleta(
                    placa,
                    propietario,
                    horaIngreso,
                    horasUtilizadas
            );
        }

        if (estacionamiento.registrarVehiculo(vehiculo)) {
            System.out.println("\nVehículo registrado correctamente.");
            System.out.println(
                    "Costo calculado: Q"
                            + String.format("%.2f", vehiculo.calcularCosto()));
        } else {
            System.out.println("La placa ya está registrada.");
        }
    }
}