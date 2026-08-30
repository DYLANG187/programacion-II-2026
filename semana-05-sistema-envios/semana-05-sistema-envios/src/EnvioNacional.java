public class EnvioNacional extends Envio {

    private String departamentoDestino;
    private double distancia;

    public EnvioNacional(String codigo, String destinatario, double peso,
                         String departamentoDestino, double distancia) {
        super(codigo, destinatario, peso);
        this.departamentoDestino = departamentoDestino;
        this.distancia = distancia;
    }

    public String getDepartamentoDestino() {
        return departamentoDestino;
    }

    public double getDistancia() {
        return distancia;
    }

    @Override
    public double calcularCostoFinal() {
        return calcularCostoBase() + (distancia * 0.50);
    }

    @Override
    public void mostrarResumen(boolean mostrarDesglose) {
        System.out.println("\n--- RESUMEN DEL ENVÍO NACIONAL ---");
        System.out.println("Código: " + getCodigo());
        System.out.println("Destinatario: " + getDestinatario());
        System.out.println("Departamento de destino: " + departamentoDestino);

        if (mostrarDesglose) {
            double costoBase = calcularCostoBase();
            double cargoDistancia = distancia * 0.50;

            System.out.printf("Peso: %.2f kg%n", getPeso());
            System.out.printf("Costo base: Q%.2f%n", costoBase);
            System.out.printf("Distancia: %.2f km%n", distancia);
            System.out.printf("Cargo por distancia: Q%.2f%n", cargoDistancia);
        }

        System.out.printf("Costo final: Q%.2f%n", calcularCostoFinal());
    }

}