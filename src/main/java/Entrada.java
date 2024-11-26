
import controller.MenuController;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        MenuController menuController = new MenuController();
        do {
            menuController.mostrarMenu();
            salir = menuController.ejecutarOpciones(salir, scanner);
        } while (!salir);
    }
}
