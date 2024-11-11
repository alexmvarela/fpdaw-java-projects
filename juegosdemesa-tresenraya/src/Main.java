import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("EMPIEZA EL JUEGO: TRES EN RAYA");
        int filas = inputTablero(sc, "Introduce el número de FILAS:");
        int columnas = inputTablero(sc, "Introduce el número de COLUMNAS:");
        String nombreJ1 = inputJugador(sc, "Introduce el nombre del JUGADOR 1:");
        String nombreJ2 = inputJugador(sc, "Introduce el nombre del JUGADOR 2:");

        TresEnRaya tresEnRaya = new TresEnRaya(filas, columnas, nombreJ1, nombreJ2);
        tresEnRaya.iniciarJuego();
    }

    private static int inputTablero(Scanner sc, String message) {
        System.out.println(message);
        int input = 0;
        boolean esInputValido = false;
        
        while(!esInputValido) {
            try {
                input = sc.nextInt();
                sc.nextLine();
                if (input > 0) {
                    esInputValido = true;
                } else {
                    System.out.println("El input no es válido. Introduce un número mayor que 0:");
                }
            } catch(InputMismatchException e) {
                System.out.println("El input no es válido. Introduce un número entero:");
                sc.nextLine();
            }
        }
        return input;
    }

    private static String inputJugador(Scanner sc, String message) {
        System.out.println(message);
        String input = sc.nextLine();
        return input;
    }
}
