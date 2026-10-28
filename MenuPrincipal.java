import java.util.Scanner;

public class MenuPrincipal {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1:
                    opcionFactorial();
                    break;
                case 2:
                    opcionIMC();
                    break;
                case 3:
                    pausa();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            System.out.println();
        } while (opcion != 4);
        sc.close();
    }

    // ===== PROCEDIMIENTOS (no retornan valor) =====

    static void mostrarMenu() {
        System.out.println("========== MENÚ ==========");
        System.out.println("1. Calcular factorial");
        System.out.println("2. Calcular IMC");
        System.out.println("3. Pausa de 5 segundos");
        System.out.println("4. Salir");
        System.out.println("==========================");
    }

    static void opcionFactorial() {
        int n = leerEntero("Ingrese un número entero (>= 0): ");
        if (n < 0) {
            System.out.println("No existe el factorial de un número negativo.");
        } else if (n > 20) {
            System.out.println("El número es demasiado grande (máximo 20).");
        } else {
            System.out.println("El factorial de " + n + " es: " + factorial(n));
        }
    }

    static void opcionIMC() {
        double estaturaCm = leerDouble("Ingrese su estatura en centímetros: ");
        double pesoKg = leerDouble("Ingrese su peso en Kg: ");
        if (estaturaCm <= 0 || pesoKg <= 0) {
            System.out.println("La estatura y el peso deben ser mayores que cero.");
            return;
        }
        double imc = calcularIMC(pesoKg, estaturaCm);
        System.out.printf("Su IMC es: %.2f%n", imc);
        mostrarMensajeIMC(imc);
    }

    static void mostrarMensajeIMC(double imc) {
        if (imc <= 18) {
            System.out.println("IMC con valor bajo");
        } else {
            System.out.println("Mantenga su peso controlado");
        }
    }

    static void pausa() {
        System.out.println("Haga una pausa de 5 segundos...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("¡Pausa terminada!");
    }

    // ===== FUNCIONES (retornan un valor) =====

    static long factorial(int n) {
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    static double calcularIMC(double peso, double estaturaCm) {
        double estaturaM = estaturaCm / 100.0; // convertir cm a metros
        return peso / (estaturaM * estaturaM);
    }

    static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.print("Valor inválido. " + mensaje);
            sc.next();
        }
        return sc.nextInt();
    }

    static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextDouble()) {
            System.out.print("Valor inválido. " + mensaje);
            sc.next();
        }
        return sc.nextDouble();
    }
}
