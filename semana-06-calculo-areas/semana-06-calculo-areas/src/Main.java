public class Main {

    public static void main(String[] args) {

        Figura[] figuras = {
                new Circulo("Círculo", 5),
                new Rectangulo("Rectángulo", 8, 4),
                new Triangulo("Triángulo", 6, 3)
        };

        for (Figura figura : figuras) {
            figura.mostrarInformacion();
            System.out.printf("Área: %.2f%n", figura.calcularArea());
            System.out.println();
        }
    }

}
