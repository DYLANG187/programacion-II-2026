public class EnvioInternacional extends Envio {

    private String paisDestino;
    private static final double CARGO_INTERNACIONAL = 75.00;

    public EnvioInternacional(String codigo, String destinatario, double peso,
                              String paisDestino) {
        super(codigo, destinatario, peso);
        this.paisDestino = paisDestino;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public double getCargoInternacional() {
        return CARGO_INTERNACIONAL;
    }

    @Override
    public double calcularCostoFinal() {
        double costoBase = calcularCostoBase();
        double recargo = costoBase * 0.12;

        return costoBase + CARGO_INTERNACIONAL + recargo;
    }

    @Override
    public void mostrarResumen(boolean mostrarDesglose) {
        System.out.println("\n--- RESUMEN DEL ENVÍO INTERNACIONAL ---");
        System.out.println("Código: " + getCodigo());
        System.out.println("Destinatario: " + getDestinatario());
        System.out.println("País de destino: " + paisDestino);

        if (mostrarDesglose) {
            double costoBase = calcularCostoBase();
            double recargo = costoBase * 0.12;

            System.out.printf("Peso: %.2f kg%n", getPeso());
            System.out.printf("Costo base: Q%.2f%n", costoBase);
            System.out.printf("Cargo internacional: Q%.2f%n", CARGO_INTERNACIONAL);
            System.out.printf("Recargo del 12%%: Q%.2f%n", recargo);
        }

        System.out.printf("Costo final: Q%.2f%n", calcularCostoFinal());
    }

}