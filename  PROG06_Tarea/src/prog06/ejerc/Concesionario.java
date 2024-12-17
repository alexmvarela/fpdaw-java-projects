package prog06.ejerc;

import java.time.LocalDate;

/**
 * Clase que representa un concesionario de venta de coches de segunda mano.
 * Los vehículos se almacenan en un array de objetos Vehículo.
 * El atributo indexVehiculo permite saber el número de vehículos existentes en el concesionario
 * y, por lo tanto, conocer la posición de inserción de un nuevo vehículo.
 * Dispone de métodos para gestionar el concesionario.
 * 
 * @author alex
 */
public class Concesionario {
    private Vehiculo[] vehiculos;
    private static int indexVehiculo = 0;
    
    public Concesionario(int capacidad) {
        vehiculos = new Vehiculo[capacidad];
    }
    
    /**
     * Este método recibe todos los datos de un vehículo y trata de insertarlo en el concesionario.
     * Si se realiza con éxito actualiza el valor del atributo estático indexVehiculo.
     * 
     * @param marca
     * @param matricula
     * @param precio
     * @param kms
     * @param descripcion
     * @param fechaMatriculacion
     * @param nombrePropietario
     * @param dniPropietario
     * @return 0 si se hizo con éxito, -1 si el concesionario está lleno, -2 si la matrícula ya existe.
     */
    public int insertarVehiculo(String marca, String matricula, double precio, int kms, String descripcion, LocalDate fechaMatriculacion, String nombrePropietario, String dniPropietario) {
        int resultado;
        
        if (indexVehiculo == vehiculos.length) {
            resultado = -1;
        } else if (buscarVehiculo(matricula) != null) {
            resultado = -2;
        } else {
            vehiculos[indexVehiculo] = new Vehiculo(marca, matricula, precio, kms, descripcion, fechaMatriculacion, nombrePropietario, dniPropietario);
            indexVehiculo++;
            resultado = 0;
        }
        
        return resultado;
    }
    
    /**
     * Este método lista por pantalla los datos de todos los vehículos del concesionario
     * o, en su caso, el mensaje "No hay vehículos en el concesionario".
     */
    public void listarVehiculos() {
        System.out.println("______LISTA DE VEHÍCULOS______");
        
        if (vehiculos[0] == null) {
            System.out.println("No hay vehículos en el concesionario");
        } else {
            System.out.println("Número de vehículos en el concesionario: " + indexVehiculo);
            for (int i = 0; i < indexVehiculo; i++) {
                System.out.println("----- " + (i + 1) + " -----");
                System.out.println("Marca: " + vehiculos[i].getMarca());
                System.out.println("Matrícula " + vehiculos[i].getMatricula());
                System.out.println("Precio: " + vehiculos[i].getPrecio() + "€");
                System.out.println("Kilómetros: " + vehiculos[i].getKms() + "km");
                System.out.println("Descripción: " + vehiculos[i].getDescripcion());
                System.out.println("Fecha matriculación: " + vehiculos[i].getFechaMatriculacion());
                System.out.println("Propietario: " + vehiculos[i].getNombrePropietario() + "(" + vehiculos[i].getDniPropietario() + ")" );
            }
        }
    }
    
    /**
     * Método para buscar un vehículo en el concesionario.
     * La búsqueda se hace por matrícula.
     * 
     * @param matricula
     * @return string con los datos del vehículo, null si el vehículo no existe.
     */
    public String buscarVehiculo(String matricula) {
        String datosVehiculoEncontrado = "";
        boolean vehiculoEncontrado = false;
        
        int i = 0;
        while (indexVehiculo > 0 && i < indexVehiculo && !vehiculoEncontrado) {
            if (vehiculos[i].getMatricula().equals(matricula)) {
                vehiculoEncontrado = true;
                datosVehiculoEncontrado = "Marca: " + vehiculos[i].getMarca() + "\nMatrícula: " + vehiculos[i].getMatricula() + "\nPrecio: " + vehiculos[i].getPrecio() + "€";
            } else {
                i++;
            }
        }
        
        return vehiculoEncontrado ? datosVehiculoEncontrado : null;
    }
    
    /**
     * Este método busca el vehículo con la matrícula introducida y si lo encuentra
     * actualiza el valor de los kilómetros.
     * 
     * @param matricula
     * @param kms
     * @return true si se hizo con éxito, false en caso contrario.
     */
    public boolean actualizarKms(String matricula, int kms) {
        boolean vehiculoEncontrado = false;
            
        int i = 0;
        while (indexVehiculo > 0 && i < indexVehiculo && !vehiculoEncontrado) {
            if (vehiculos[i].getMatricula().equals(matricula)) {
                vehiculoEncontrado = true;
                vehiculos[i].setKms(kms);
            } else {
                i++;
            }
        }
        
        return vehiculoEncontrado;
    }
    
    /**
     * Este método busca el vehículo con la matrícula introducida y si lo encuentra
     * elimina el vehículo del concesionario.
     * Si se realiza con éxito desplazará todos los vehículos del array que estaban
     * después del vehículo eliminado a una posición anterior, de modo que
     * no queden posiciones intermedias vacías. Además actualizará el valor del atributo
     * estático indexVehiculo.
     * 
     * @param matricula
     * @return true si se hizo con éxito, false en caso contrario.
     */
    public boolean eliminarVehiculo(String matricula) {
        boolean vehiculoEncontrado = false;
            
        int i = 0;
        while (indexVehiculo > 0 && i < indexVehiculo && !vehiculoEncontrado) {
            if (vehiculos[i].getMatricula().equals(matricula)) {
                vehiculoEncontrado = true;
                vehiculos[i] = null;
                for (int j = i; j < indexVehiculo - 1; j++) {
                    vehiculos[j] = vehiculos[j + 1];
                }
                indexVehiculo--;
            } else {
                i++;
            }
        }
        
        return vehiculoEncontrado;
    }
}
