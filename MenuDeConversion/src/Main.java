import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opc;
        int CAF = 0;
        int FAC = 0;
        int kmAM = 0;
        int mAKm = 0;
        int totalConversiones = 0;
        int totalNoNumerico = 0;
        int totalFueraRango = 0;

        do {
            System.out.println("Bienvenido este es el menu de conversiones");
            System.out.println("1) °C a °F");
            System.out.println("2) °F a °C");
            System.out.println("3) Km a Millas");
            System.out.println("4) Millas a Km");
            System.out.println("5) Salir");
            System.out.println("Elige una opcion");

            if (!sc.hasNextInt()) {
                System.out.println("Coloque un dato numerico");
                sc.next();
                totalNoNumerico ++ ;
                continue;
            }

            opc = sc.nextInt();

            if (opc < 1 || opc > 5) {
                System.out.println("Ingresa un numero del 1 al 5");
                totalFueraRango++;
                continue;
            }

            if (opc == 5) {
                break;
            }

            System.out.println("Ingresa el valor a convertir");

            if (!sc.hasNextDouble()) {
                System.out.println("Dato no numerico");
                sc.next();
                continue;
            }

            double valor = sc.nextDouble();
            double resultado;

            switch (opc) {
                case 1:
                    resultado = (valor * 9 / 5) + 32;
                    System.out.println(valor + " °C = " + resultado + " °F");
                    CAF++;
                    break;

                case 2:
                    resultado = (valor - 32) * 5 / 9;
                    System.out.println(valor + " °F = " + resultado + " °C");
                    FAC++;
                    break;

                case 3:
                    resultado = valor * 0.621371;
                    System.out.println(valor + " Km = " + resultado + " Millas");
                    kmAM++;
                    break;

                case 4:
                    resultado = valor / 0.621371;
                    System.out.println(valor + " Millas = " + resultado + " Km");
                    mAKm++;
                    break;
            }

            totalConversiones++;

        } while (true);

        System.out.println("Total de conversiones: " + totalConversiones);
        System.out.println("Total de intentos fuera del rango: "+totalFueraRango );
        System.out.println("Total de valores no numericos " +totalNoNumerico);
        System.out.println("°C a °F: " + CAF);
        System.out.println("°F a °C: " + FAC);
        System.out.println("Km a Millas: " + kmAM);
        System.out.println("Millas a Km: " + mAKm);
        System.out.println("Programa terminado");
    }
}
