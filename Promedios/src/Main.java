import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeService service = new GradeService();
        Validator validator = new Validator();


        String nombre = Validator.leerTextoNoVacio(sc, "Ingresa tu nombre");
        double p1 = Validator.leerRangos(sc, "Ingresa tu primer promedio", 0, 100);
        double p2 = Validator.leerRangos(sc, "Ingresa tu segundo promedio", 0, 100);
        double p3 = Validator.leerRangos(sc, "Ingresa tu tercer promedio", 0, 100);
        int asistencia = Validator.leerIntEnRango(sc, "Ingresa el porcentaje de asistencia", 0, 100);
        boolean proyecto = Validator.leerBoolean(sc, "Ingreda si entregaste el proyecto ( True  False)");
        double promedio = service.caalcularPromedio(p1, p1, p1);
        double promediofinal = service.calcularFinal(promedio, asistencia);
        String estado = service.Estado(promediofinal, asistencia, proyecto);

        imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, proyecto, promediofinal, estado);
    }

    public static void imprimirReporte(String nombre,
                                       double p1, double p2, double p3,
                                       double promedio,
                                       int asistencia,
                                       boolean entregoProyecto,
                                       double finalCalificacion,
                                       String estado) {

        System.out.println("REPORTE FINAL");
        System.out.println("Alumno: " + nombre);
        System.out.println("Parciales: " + p1 + ", " + p2 + ", " + p3);
        System.out.println("Promedio: " + promedio);
        System.out.println("Asistencia: " + asistencia + "%");
        System.out.println("Entregó proyecto: " + entregoProyecto);
        System.out.println("Calificación final: " + finalCalificacion);
        System.out.println("Estado: " + estado);

    }


}

