import java.util.Scanner;
import java.util.InputMismatchException;

public abstract class Juego {

    protected Tablero tablero;
    protected Jugador jugador1;
    protected Jugador jugador2;

    public Juego(int filas, int columnas, String nombreJ1, String nombreJ2) {
        this.tablero = new Tablero(filas, columnas);
        this.jugador1 = new Jugador(nombreJ1);
        this.jugador2 = new Jugador(nombreJ2);
    }

    public void iniciarJuego() {
        Scanner sc = new Scanner(System.in);
        tablero.dibujarTablero();
        int turno = 1;
        boolean finPartida = false;

        while (!finPartida) {
            Jugador jugadorActual = (turno % 2 == 0) ? jugador2 : jugador1;
            System.out.println("Turno de " + jugadorActual.getNombre());

            //System.out.println("Elige una fila:");
            int fila = inputCoordenadas(sc, "Elige una FILA:");  //sc.nextInt() - 1;
            //System.out.println("Elige una columna:");
            int columna = inputCoordenadas(sc, "Elige una COLUMNA:");   //sc.nextInt() - 1;

            if (esMovimientoValido(fila, columna)) {
                String pieza = getPieza(turno);
                tablero.colocarPiezaEnTablero(fila, columna, pieza);
                if (esVictoria(jugadorActual.getNombre())) {
                    finPartida = true;
                    System.out.println("FIN DEL JUEGO: " + jugadorActual.getNombre() + " GANA LA PARTIDA!!");
                } else if (esEmpate()) {
                    finPartida = true;
                    System.out.println("FIN DEL JUEGO: el resultado es EMPATE");
                } else {
                    turno++;
                }
            } else {
                System.out.println("Movimiento no válido. Casilla ocupada o fuera de los límites.");
            }
            tablero.dibujarTablero();
        }
    }
    
    private int inputCoordenadas(Scanner sc, String message) {
        int input = 0;
        boolean esValido = false;
        
        while(!esValido) {
            System.out.println(message);
            try {
                input = sc.nextInt() - 1;
                sc.nextLine();
                esValido = true;
            } catch(InputMismatchException e) {
                System.out.println("El input no es válido. No es un número entero.");
                sc.nextLine();
            }
        }
        
        return input;
    }

    protected abstract String getPieza(int turno);

    protected abstract boolean esMovimientoValido(int fila, int columna);

    protected abstract boolean esVictoria(String nombreJugador);

    protected abstract boolean esEmpate();
}
