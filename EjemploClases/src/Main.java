import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Ticket ticket= new Ticket(); // declaracion de un objeto
        InputValidator inputvalidator = new InputValidator();
        Scanner sc = new Scanner(System.in);
        // I-P-O
        // Input


        int cantidad = inputvalidator.getvalidInt("Ingresar la cantidad de articulos ",sc );
        //Process
        ticket.process(cantidad);

        //Output
        ticket.imprimirTocket(cantidad);
    }
}