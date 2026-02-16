import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        validador val = new validador();
        alumnos[] alumnos = new alumnos[25];
        int opc;

        do {
            System.out.println("\n==== MENU ====");
            System.out.println("1) Alta alumno");
            System.out.println("2) Buscar por ID (solo activos)");
            System.out.println("3) Actualizar promedio por ID (solo activos)");
            System.out.println("4) Baja lógica por ID");
            System.out.println("5) Listar activos");
            System.out.println("6) Reportes");
            System.out.println("0) Salir");
            opc = val.validarMenu(sc);
            switch (opc) {
                case 1: // alta

                    int idAlta = val.leeridpositivo(sc, "Ingresa el id");
                    String nombre = val.leerNameNoVacio(sc, "Ingresa el nombre");
                    double promedio = val.PromedioValido(sc, "Ingresa el promedio (0-10):");

                    boolean repetido = false;

                    for (int i = 0; i < alumnos.length; i++) {
                        if (alumnos[i] != null && alumnos[i].getId() == idAlta) {
                            repetido = true;
                            break;
                        }
                    }

                    if (repetido) {
                        System.out.println("Error id repetido");
                    } else {
                        for (int i = 0; i < alumnos.length; i++) {
                            if (alumnos[i] == null) {

                                alumnos[i] = new alumnos(idAlta, nombre, promedio);

                                System.out.println("Alta realizada");
                                break;
                            }
                        }
                    }

                    break;

                case 2://Buscar id
                    int idBuscar = val.leeridpositivo(sc, "Ingresa el id");
                    boolean encontrada = false;
                    for (int i = 0; i < alumnos.length; i++) {
                        if (alumnos[i] != null && alumnos[i].getId() == idBuscar && alumnos[i].isActive()) {
                            System.out.println(alumnos[i]);
                            encontrada = true;
                            break;
                        }
                    }
                    if (!encontrada) {
                        System.out.println("No encontrada o inactiva");
                    }
                    break;


                case 3://Actualizar promedios
                    int idProemdio = val.leeridpositivo(sc, "Ingresa el id");
                    double nuevoprom = val.PromedioValido(sc, "Ingresa el nuevo promedio");
                    boolean actualizada = false;
                    for (int i = 0; i < alumnos.length; i++) {
                        if (alumnos[i] != null && alumnos[i].getId() == idProemdio && alumnos[i].isActive()) {
                            alumnos[i].setPromedio(nuevoprom);
                            System.out.println("Promedio actualizado");
                            actualizada = true;
                            break;
                        }

                    }
                    if (!actualizada) {
                        System.out.println("No encontramos el id");
                    }
                    break;

                case 4: //Baja logica
                    int idBaja = val.leeridpositivo(sc, "Ingresa el id");
                    boolean BajaHecha = false;
                    for (int i = 0; i < alumnos.length; i++) {
                        if (alumnos[i] != null && alumnos[i].getId() == idBaja && alumnos[i].isActive()) {
                            alumnos[i].setActive(false);
                            System.out.println("Baja logica realizada");
                            BajaHecha = true;
                            break;
                        }
                    }
                    if (!BajaHecha) {
                        System.out.println("No se encontro o ya esta inactiva");
                    }
                    break;

                case 5://Acticidad
                    boolean hayActivadas = false;
                    for (int i = 0; i < alumnos.length; i++) {
                        if (alumnos[i] != null && alumnos[i].isActive()) {
                            System.out.println(alumnos[i]);
                            hayActivadas = true;
                        }
                    }
                    if (!hayActivadas) {
                        System.out.println("No hay activos");
                    }
                    break;

                case 6://Reportes
                    reportes.mostrarReportes(alumnos);
                    break;




                case 0:
                    System.out.println("Saliendo ...");
                    break;

            }

        } while (opc != 0);
    }
}