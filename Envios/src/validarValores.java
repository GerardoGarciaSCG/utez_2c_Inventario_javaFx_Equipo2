import java.util.Scanner;


public class validarValores {
    public static double validarrangodouble(Scanner sc, String msg, double min, double max) {
        double valor;
        do {
            System.out.println(msg);
            while (!sc.hasNextDouble()) {
                System.out.println("El valor que colocasre es invalido");
                sc.next();
            }
            valor = sc.nextDouble();


        } while (valor < min || valor > max);
        return valor;
    }

    public static int validarRangoEnteros(Scanner sc, String msg, int min, int max) {
        int valor;
        do {
            System.out.println(msg);
            while (!sc.hasNextInt()) {
                System.out.println("El valor que registraste no es valido");
                valor = sc.nextInt();

            }
            valor = sc.nextInt();
        } while (valor < min || valor > max);
        return valor;
    }

    public static boolean validarRangoBoleano(Scanner sc, String msg) {
        System.out.println(msg);
        while (!sc.hasNextBoolean()) {
            System.out.println("El dato que inserto es erroneo solo acepta false o true");
            sc.nextLine();

        }
        return sc.hasNextBoolean();
    }

}
