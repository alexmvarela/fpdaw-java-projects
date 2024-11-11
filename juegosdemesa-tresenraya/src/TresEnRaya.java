public class TresEnRaya extends Juego {

    private final String PIEZAJ1 = "X";
    private final String PIEZAJ2 = "O";

    public TresEnRaya(int filas, int columnas, String nombreJ1, String nombreJ2) {
        super(filas, columnas, nombreJ1, nombreJ2);
    }
    
    @Override
    protected String getPieza(int turno) {
        return (turno % 2 == 0) ? PIEZAJ2 : PIEZAJ1;
    }

    @Override
    protected boolean esMovimientoValido(int fila, int columna) {
        return (fila >= 0 && fila < tablero.getFilas() && columna >= 0 && columna < tablero.getColumnas() && tablero.getCeldas()[fila][columna].equals(""));
    }

    @Override
    protected boolean esVictoria(String jugadorActual) {
        String simboloJugador = jugador1.getNombre().equals(jugadorActual) ? PIEZAJ1 : PIEZAJ2;

        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                if (j <= tablero.getColumnas() - 3
                        && tablero.getCeldas()[i][j].equals(simboloJugador)
                        && tablero.getCeldas()[i][j + 1].equals(simboloJugador)
                        && tablero.getCeldas()[i][j + 2].equals(simboloJugador)) {
                    return true;
                }

                if (i <= tablero.getFilas() - 3
                        && tablero.getCeldas()[i][j].equals(simboloJugador)
                        && tablero.getCeldas()[i + 1][j].equals(simboloJugador)
                        && tablero.getCeldas()[i + 2][j].equals(simboloJugador)) {
                    return true;
                }

                if (i <= tablero.getFilas() - 3 && j <= tablero.getColumnas() - 3
                        && tablero.getCeldas()[i][j].equals(simboloJugador)
                        && tablero.getCeldas()[i + 1][j + 1].equals(simboloJugador)
                        && tablero.getCeldas()[i + 2][j + 2].equals(simboloJugador)) {
                    return true;
                }

                if (i >= 2 && j <= tablero.getColumnas() - 3
                        && tablero.getCeldas()[i][j].equals(simboloJugador)
                        && tablero.getCeldas()[i - 1][j + 1].equals(simboloJugador)
                        && tablero.getCeldas()[i - 2][j + 2].equals(simboloJugador)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    protected boolean esEmpate() {
        int celdasTotales = tablero.getFilas() * tablero.getColumnas();
        int contadorCeldas = 0;

        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                if (tablero.getCeldas()[i][j].equals(PIEZAJ1) || tablero.getCeldas()[i][j].equals(PIEZAJ2)) {
                    contadorCeldas++;
                } else {
                    break;
                }
            }
        }

        return contadorCeldas == celdasTotales;
    }
}
