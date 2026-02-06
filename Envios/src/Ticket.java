public class Ticket {

    public static void imprimirTicket(int tipoServicio, double pesokg, int distanciaKm,
                                      boolean zonaRemota, double subtotal, double iva, double total) {

        String servicio = (tipoServicio == 1) ? "Estándar" : "Express";

        System.out.println("TICKET DE ENVÍO");
        System.out.println("Servicio: " + servicio);
        System.out.println("Peso: " + pesokg + " kg");
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Zona remota: " + (zonaRemota ? "Sí" : "No"));
        System.out.println("----------------------------------");
        System.out.printf("Subtotal: $%.2f%n", subtotal);
        System.out.printf("IVA (16%%): $%.2f%n", iva);
        System.out.printf("TOTAL: $%.2f%n", total);
    }
}

