package estacionamiento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Estacionamiento {

    private ArrayList<Vehiculo> vehiculos;
    private HashSet<String> placas;

    public Estacionamiento() {
        vehiculos = new ArrayList<>();
        placas = new HashSet<>();
    }

    public boolean registrarVehiculo(Vehiculo vehiculo) {

        if (placas.contains(vehiculo.getPlaca())) {
            return false;
        }

        placas.add(vehiculo.getPlaca());
        vehiculos.add(vehiculo);

        return true;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public Vehiculo buscarPorPlaca(String placa) {

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                return vehiculo;
            }
        }

        return null;
    }

    public Vehiculo obtenerMayorCosto() {

        if (vehiculos.isEmpty()) {
            return null;
        }

        Vehiculo mayor = vehiculos.get(0);

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.calcularCosto() > mayor.calcularCosto()) {
                mayor = vehiculo;
            }
        }

        return mayor;
    }

    public double obtenerTotalGeneral() {

        double total = 0;

        for (Vehiculo vehiculo : vehiculos) {
            total += vehiculo.calcularCosto();
        }

        return total;
    }

    public HashMap<String, Double> obtenerRecaudacionPorTipo() {

        HashMap<String, Double> recaudacion = new HashMap<>();

        for (Vehiculo vehiculo : vehiculos) {

            String tipo;

            if (vehiculo instanceof Automovil) {
                tipo = "Automovil";
            } else {
                tipo = "Motocicleta";
            }

            double costo = vehiculo.calcularCosto();

            recaudacion.put(
                    tipo,
                    recaudacion.getOrDefault(tipo, 0.0) + costo
            );
        }

        return recaudacion;
    }
}