public class GradeService {
    public double caalcularPromedio(double Promedio1, double Promedio2, double Promedio3) {
        return (Promedio1 + Promedio2 + Promedio3) / 3;

    }

    public double calcularFinal(double Promedio, int asistencia) {
        return (Promedio * 0.70) + (asistencia * 0.3);
    }

    public String Estado(double Promedio, int asistencia, boolean entregarProyecto) {
        if (asistencia < 80) {
            return "Reprobado por asistencia";
        }
        if (!entregarProyecto) {
            return "Reprobado por falta de entregar proyecto";
        }
        if ((Promedio >= 70)) {
            return "Alumno aprobado";
        } else {
            return "Alumno reprobado por calificacion";
        }

    }
}
