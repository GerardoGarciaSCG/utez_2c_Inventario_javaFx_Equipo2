public class reportes {

    public static void mostrarReportes(alumnos[] alumnos) {

        int totalActivos = 0;
        double sumaPromedio = 0;
        alumnos menor = null;
        alumnos mayor = null;

        for (int i = 0; i < alumnos.length; i++) {

            if (alumnos[i] != null && alumnos[i].isActive()) {

                totalActivos++;
                sumaPromedio += alumnos[i].getPromedio();

                if (mayor == null || alumnos[i].getPromedio() > mayor.getPromedio()) {
                    mayor = alumnos[i];
                }

                if (menor == null || alumnos[i].getPromedio() < menor.getPromedio()) {
                    menor = alumnos[i];
                }
            }
        }

        System.out.println("==== REPORTES ====");

        if (totalActivos == 0) {
            System.out.println("No hay alumnos activos.");
            return;
        }

        System.out.println("Total activos: " + totalActivos);
        System.out.println("Promedio general: " + (sumaPromedio / totalActivos));
        System.out.println("Mayor promedio: " + mayor.getName() + " - " + mayor.getPromedio());
        System.out.println("Menor promedio: " + menor.getName() + " - " + menor.getPromedio());
    }
}
