import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        validador val = new validador();

        Personas[] personas = new Personas[20];

        int opcion;

        do {
            System.out.println("\n==== MENU ====");
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID (solo activas)");
            System.out.println("3) Baja lógica por ID");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar nombre por ID");
            System.out.println("0) Salir");

            opcion = val.leerOpcionMenu(sc);

            switch (opcion) {

                case 1: // Alta
                    int idAlta = val.leerIdPositivo(sc, "Ingrese ID:");
                    String nombreAlta = val.leerTextoNoVacio(sc, "Ingrese nombre:");

                    boolean repetido = false;

                    for (int i = 0; i < personas.length; i++) {
                        if (personas[i] != null && personas[i].getId() == idAlta) {
                            repetido = true;
                            break;
                        }
                    }

                    if (repetido) {
                        System.out.println("Error: ID repetido.");
                    } else {
                        for (int i = 0; i < personas.length; i++) {
                            if (personas[i] == null) {
                                personas[i] = new Personas(idAlta, nombreAlta);
                                System.out.println("Alta realizada.");
                                break;
                            }
                        }
                    }
                    break;

                case 2: // Buscar activa
                    int idBuscar = val.leerIdPositivo(sc, "Ingrese ID:");
                    boolean encontrada = false;

                    for (int i = 0; i < personas.length; i++) {
                        if (personas[i] != null &&
                                personas[i].getId() == idBuscar &&
                                personas[i].isActive()) {

                            System.out.println(personas[i]);
                            encontrada = true;
                            break;
                        }
                    }

                    if (!encontrada) {
                        System.out.println("No encontrada o inactiva.");
                    }
                    break;

                case 3: // Baja lógica
                    int idBaja = val.leerIdPositivo(sc, "Ingrese ID:");
                    boolean bajaHecha = false;

                    for (int i = 0; i < personas.length; i++) {
                        if (personas[i] != null &&
                                personas[i].getId() == idBaja &&
                                personas[i].isActive()) {

                            personas[i].setActive(false);
                            System.out.println("Baja lógica realizada.");
                            bajaHecha = true;
                            break;
                        }
                    }

                    if (!bajaHecha) {
                        System.out.println("No encontrada o ya inactiva.");
                    }
                    break;

                case 4: // Listar activas
                    boolean hayActivas = false;

                    for (int i = 0; i < personas.length; i++) {
                        if (personas[i] != null && personas[i].isActive()) {
                            System.out.println(personas[i]);
                            hayActivas = true;
                        }
                    }

                    if (!hayActivas) {
                        System.out.println("No hay registros activos.");
                    }
                    break;

                case 5: // Actualizar nombre
                    int idActualizar = val.leerIdPositivo(sc, "Ingrese ID:");
                    String nuevoNombre = val.leerTextoNoVacio(sc, "Nuevo nombre:");

                    boolean actualizada = false;

                    for (int i = 0; i < personas.length; i++) {
                        if (personas[i] != null &&
                                personas[i].getId() == idActualizar &&
                                personas[i].isActive()) {

                            personas[i].setName(nuevoNombre);
                            System.out.println("Nombre actualizado.");
                            actualizada = true;
                            break;
                        }
                    }

                    if (!actualizada) {
                        System.out.println("No encontrada o inactiva.");
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}
