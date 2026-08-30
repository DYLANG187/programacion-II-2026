public class Envio {

    private String codigo;
    private String destinatario;
    private double peso;

    public Envio(String codigo, String destinatario, double peso) {
        this.codigo = codigo;
        this.destinatario = destinatario;
        this.peso = peso;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public double getPeso() {
        return peso;
    }

    public double calcularCostoBase() {
        return peso * 10.00;
    }

    public double calcularCostoFinal() {
        return calcularCostoBase();
    }

    public void mostrarResumen() {
        System.out.println("\n--- RESUMEN DEL ENVÍO ---");
        System.out.println("Código: " + codigo);
        System.out.println("Destinatario: " + destinatario);
        System.out.printf("Costo final: Q%.2f%n", calcularCostoFinal());
    }

    public void mostrarResumen(boolean mostrarDesglose) {
        mostrarResumen();

        if (mostrarDesglose) {
            System.out.printf("Peso: %.2f kg%n", peso);
            System.out.printf("Costo base: Q%.2f%n", calcularCostoBase());
            System.out.printf("Costo final: Q%.2f%n", calcularCostoFinal());
        }
    }

}