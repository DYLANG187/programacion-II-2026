import java.util.Scanner;

public class CalculadoraEdad {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Solicita los datos necesarios para realizar el cálculo
        System.out.print("Ingrese su nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su carné: ");
        String carne = scanner.nextLine();

        System.out.print("Ingrese su año de nacimiento: ");
        int anioNacimiento = scanner.nextInt();

        System.out.print("Ingrese el año actual: ");
        int anioActual = scanner.nextInt();

        // Calcula la edad aproximada utilizando los años ingresados
        int edad = anioActual - anioNacimiento;
        int edadMeses = edad * 12;

        boolean esMayorDeEdad = edad >= 18;

        System.out.println("\n----- RESULTADO -----");
        System.out.println("Nombre: " + nombre);
        System.out.println("Carné: " + carne);
        System.out.println("Edad aproximada: " + edad + " años");
        System.out.println("Edad aproximada en meses: " + edadMeses + " meses");
        System.out.println("¿Es mayor de edad?: " + esMayorDeEdad);

        scanner.close();
    }
}