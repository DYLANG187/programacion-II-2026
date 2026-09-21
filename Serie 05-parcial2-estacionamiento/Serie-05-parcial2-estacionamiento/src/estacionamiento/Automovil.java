package estacionamiento;

public class Automovil extends Vehiculo {

    public Automovil(String placa, String propietario, String horaIngreso, int horasUtilizadas) {
        super(placa, propietario, horaIngreso, horasUtilizadas);
    }

    @Override
    public double calcularCosto() {
        double costo = getHorasUtilizadas() * 10.0;

        if (getHorasUtilizadas() > 5) {
            costo = costo * 0.90;
        }

        return costo;
    }
}