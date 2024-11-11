public class Tablero {

    private int filas;
    private int columnas;
    private String[][] celdas;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.celdas = new String[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                this.celdas[i][j] = "";
            }
        }
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public String[][] getCeldas() {
        return celdas;
    }

    public void colocarPiezaEnTablero(int fila, int columna, String piezaJugadorActual) {
        celdas[fila][columna] = piezaJugadorActual;
    }

    public void dibujarTablero() {
        System.out.println("Tablero actual:");
        for (String[] fila : celdas) {
            for (String celda : fila) {
                System.out.print(celda.equals("") ? "." : celda);
            }
            System.out.println();
        }
        System.out.println();
    }
}
