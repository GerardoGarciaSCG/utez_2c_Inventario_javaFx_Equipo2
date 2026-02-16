import java.util.Scanner;

public class validador {

    public int leeridpositivo(Scanner sc, String msg) {
        int num;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                sc.nextLine();
                if (num > 0) {
                    return num;
                } else {
                    System.out.println("EL numero debe de ser mayor a 0");
                }

            } else {
                System.out.println("Ingresa un digito valido ");
                sc.nextLine();
            }
        }
    }

    public String leerNameNoVacio(Scanner sc, String msg) {
        String name;
        while (true) {
            System.out.println(msg);
            name = sc.nextLine();
            if (!name.trim().isEmpty()) {
                return name;
            } else {
                System.out.println("El nombre no puede estar vacio");
            }

        }
    }

    public double PromedioValido(Scanner sc, String msg) {
        double prom;

        while (true) {
            System.out.println(msg);

            if (sc.hasNextDouble()) {
                prom = sc.nextDouble();
                sc.nextLine(); // limpiar buffer

                if (prom >= 0 && prom <= 10) {
                    return prom;
                } else {
                    System.out.println("Error: El promedio debe estar entre 0 y 10.");
                }

            } else {
                System.out.println("Error: Ingresa un número válido.");
                sc.nextLine(); // limpiar entrada inválida
            }
        }
    }

    public int validarMenu(Scanner sc) {
        int opc;

        while (true) {
            System.out.println("Selecciona una opcion:");

            if (sc.hasNextInt()) {
                opc = sc.nextInt();
                sc.nextLine();

                if (opc >= 1 && opc <= 6) {
                    return opc;
                } else {
                    System.out.println("Ingresa un numero del rango");
                }
            } else {
                System.out.println("Ingresa un valor numerico");
                sc.nextLine();
            }
        }
    }
}