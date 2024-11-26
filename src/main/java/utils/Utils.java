package utils;

import java.util.Scanner;

public class Utils {
    Scanner scanner = new Scanner(System.in);
    public double validarNumero() {
        boolean esNumero = false;
        double numero = 0;
        do {
            try {
                numero = Double.parseDouble(scanner.nextLine());
                esNumero = true;
            } catch (NumberFormatException e) {
                System.out.println("Introduce un numero");
            }
        } while (!esNumero);
        return numero;
    }
}
