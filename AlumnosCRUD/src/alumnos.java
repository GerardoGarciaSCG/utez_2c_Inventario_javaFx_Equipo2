public class alumnos {

    private int id;
    private String nombre;
    private double promedio;
    private boolean active;

    public alumnos(int id, String nombre, double promedio) {
        this.id = id;
        this.nombre = nombre;
        this.promedio = promedio;
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Nombre: " + nombre +
                " | Promedio: " + promedio +
                " | Activo: " + active;
    }
}
