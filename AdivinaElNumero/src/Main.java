import java.util.Random;
import java.util.Scanner;

public class Main {
    static int contadorfurarango = 0;
    static int contadorNoNumerico = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int intentos = 0;
        int limitesintentos = 7;
        boolean gano = false;
        int secreto = random.nextInt(100) + 1;


        System.out.println("Adivina el numero (1-100)" + "tienes :" + limitesintentos + "Para lograrlo");
        while (intentos < limitesintentos) {
            int numero = obtenernumerovalido("Intento:" + (intentos + 1), sc, min, max);
            intentos++;
            if (numero == secreto) {
                System.out.println("Felicidades ganaste en el intento " + intentos);
                gano = true;
                System.out.println("Los datos que registraste fuera del rango fueron " + contadorfurarango);
                System.out.println("Los intentos que no fueron numericos fueron " + contadorNoNumerico);
                break;
            } else if (numero > secreto) {
                System.out.println("El numero s3ecreto es menor a " + numero);
            } else {
                System.out.println("El numero secreto es mayor a " + numero);
            }

        }
        if (!gano) {
            System.out.println("Perdiste el numero secreto era " + secreto);
            System.out.println("Los datos que registraste fuera del rango fueron " + contadorfurarango);
            System.out.println("Los intentos que no fueron numericos fueron " + contadorNoNumerico);
        }

    }

    public static int obtenernumerovalido(String mensaje, Scanner sc, int min, int max) {
        int entrada;
        while (true) {
            System.out.println(mensaje);
            if (sc.hasNextInt()) {
                entrada = sc.nextInt();
                if (entrada >= min && entrada <= max) {

                    return entrada;

                }
                System.out.println("El numero ingresasdo esra fuera de rango (1-100)");
                contadorfurarango++;
            } else {
                System.out.println("El dato ingresado no es numerico");
                sc.next();
                contadorNoNumerico++;


            }


        }
    }
}
