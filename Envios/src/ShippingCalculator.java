import java.security.PublicKey;

public class ShippingCalculator {
    private static final double IVA = 0.16;
    public static final double pesokg = 12;

    public double calcularSubotal(double pesokg, double distancia, int tipoServicio, boolean zonaRemota) {
        double subtotal = 0;
        if (tipoServicio == 1) {
            subtotal = +50;
        } else if (tipoServicio == 2) {
            subtotal = +90;

        }

        subtotal = subtotal * pesokg;

        if (distancia <= 50) {
            subtotal += 20;

        } else if (distancia >= 200) {
            subtotal += 60;
        } else {
            subtotal += 120;
        }


        if (zonaRemota) {
            subtotal += subtotal * 0.10;
        }

        return subtotal;
    }

    public double calcularIva(double subtotal) {
        return subtotal * IVA;
    }

    public double calcularTotal(double subtotal, double IVA) {
        return subtotal + IVA;
    }
}


