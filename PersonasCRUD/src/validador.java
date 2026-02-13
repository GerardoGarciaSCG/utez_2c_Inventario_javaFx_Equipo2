import java.util.Scanner;

public class validador {

    public int leerIdPositivo(Scanner sc, String msg) {
        int num;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                sc.nextLine();
                if (num > 0) {
                    return num;
                } else {
                    System.out.println("El ID debe ser mayor a 0.");
                }
            } else {
                System.out.println("Ingrese un número válido.");
                sc.nextLine();
            }
        }
    }

    public String leerTextoNoVacio(Scanner sc, String msg) {
        String texto;
        while (true) {
            System.out.println(msg);
            texto = sc.nextLine();
            if (!texto.trim().isEmpty()) {
                return texto;
            } else {
                System.out.println("El nombre no puede estar vacío.");
            }
        }
    }

    public int leerOpcionMenu(Scanner sc) {
        int opc;
        while (true) {
            System.out.println("Seleccione una opción:");
            if (sc.hasNextInt()) {
                opc = sc.nextInt();
                sc.nextLine();
                if (opc >= 0 && opc <= 5) {
                    return opc;
                } else {
                    System.out.println("Opción inválida. Intente nuevamente.");
                }
            } else {
                System.out.println("Ingrese un número entero.");
                sc.nextLine();
            }
        }
    }
}
