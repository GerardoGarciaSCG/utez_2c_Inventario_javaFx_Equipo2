import java.util.Scanner;

public class Validator {


    public static String leerTextoNoVacio(Scanner sc, String msg) {
        String texto;
        do {
            System.out.println(msg);
            texto = sc.nextLine().trim();

        } while (texto.isEmpty());
        return texto;
    }

    public static double leerRangos(Scanner sc, String msg, double min, double max) {
        double valor;

        while (true) {
            System.out.println(msg);

            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();

                if (valor >= min && valor <= max) {
                    sc.nextLine();
                    return valor;
                } else {
                    System.out.println("Error: valor fuera de rango.");
                }
            } else {
                System.out.println("Error: debe ingresar un número.");
                sc.nextLine();
            }
        }
    }


    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int valor;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor >= min && valor <= max) {
                    sc.nextLine();
                    return valor;
                }
            } else {
                sc.nextLine();
            }
            System.out.println("Error: valor fuera de rango.");
        }
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.println(msg);
            if (sc.hasNextBoolean()) {
                boolean valor = sc.nextBoolean();
                sc.nextLine();
                return valor;
            } else {
                sc.nextLine();
                System.out.println("Error: solo true o false.");
            }
        }
    }
}
