import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a la paquetria ");
        double pesokg = validarValores.validarrangodouble(sc, "Ingresa el peso", 0.1, 50);
        int distancia = validarValores.validarRangoEnteros(sc, "Ingresa la distancia en km ", 1, 2000);
        int tipoServicio = validarValores.validarRangoEnteros(sc, "Ingresa el tipo de envio 1) Estandar, 2) Express", 1, 2);
        boolean zonaRemota = validarValores.validarRangoBoleano(sc, "Ingrea si es zona remota (true or false)");
        ShippingCalculator cal = new ShippingCalculator();

        double subtotal = cal.calcularSubotal(distancia, pesokg, tipoServicio, zonaRemota);
        double iva = cal.calcularIva(subtotal);
        double total = cal.calcularTotal(subtotal, iva);
        Ticket.imprimirTicket(tipoServicio,
                pesokg,
                distancia,
                zonaRemota,
                subtotal,
                iva,
                total);


    }


}