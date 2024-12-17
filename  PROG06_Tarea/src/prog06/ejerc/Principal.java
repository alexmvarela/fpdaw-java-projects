package prog06.ejerc;

import java.util.Scanner;
import java.time.LocalDate;
import prog06.util.Validar;

/**
 * La clase Principal se encarga de:
 * - instanciar un objeto Concesionario, que será capaz de gestionar un máximo de 50 coches
 * - pintar el menú y solicitar datos por teclado al usuario
 * - realizar las validaciones de datos de entrada
 * - mostrar datos por pantalla, excepto listar los vehículos
 * 
 * @author alex
 */
public class Principal {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Concesionario concesionario = new Concesionario(50);
        int opcion;
        
        do {
            mostrarMenu();
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch(opcion) {
                case 1:
                    registrarVehiculo(sc, concesionario);
                    break;
                case 2:
                    concesionario.listarVehiculos();
                    break;
                case 3:
                    buscarVehiculo(sc, concesionario);
                    break;
                case 4:
                    modificarKms(sc, concesionario);
                    break;
                case 5:
                    eliminarVehiculo(sc, concesionario);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 6);   
    }
    
    /**
     * Método para mostrar el menú con las distintas opciones del programa.
     */
    public static void mostrarMenu() {
        System.out.println("___________MENU__________");
        System.out.println("1. Nuevo vehículo");
        System.out.println("2. Listar vehículos");
        System.out.println("3. Buscar vehículos");
        System.out.println("4. Modificar kms vehículo");
        System.out.println("5. Eliminar vehículo");
        System.out.println("6. Salir");
        System.out.println("_________________________");
    }
    
    /**
     * Este método solicitará al usuario los datos por teclado de un nuevo vehículo.
     * Los datos correspondientes a la matrícula, nombre y dni se validan, de modo que
     * si el formato no es válido se vuelven a solicitar hasta introducir un valor correcto.
     * Al final se mostrará un mensaje que indica si el vehículo se registró correctamente o no.
     * 
     * @param sc 
     * @param concesionario 
     */
    public static void registrarVehiculo(Scanner sc, Concesionario concesionario) {
        System.out.println("______NUEVO VEHÍCULO_____");
        
        System.out.print("Marca: ");
        String marca = sc.nextLine();
        
        String matricula = "";
        boolean esMatriculaValida = false;
        while (!esMatriculaValida) {
            System.out.print("Matrícula (NNNNLLL): ");
            matricula = sc.nextLine();
            if (Validar.validarMatricula(matricula)) {
                esMatriculaValida = true;
            } else {
                System.out.println("La matrícula introducida no tiene el formato correcto");
            }
        }
        
        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        System.out.print("Número de kilómetros: ");
        int kms = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();

        System.out.print("Fecha de matriculación (AAAA-MM-DD): ");
        LocalDate fechaMatriculacion = LocalDate.parse(sc.nextLine());    

        String nombrePropietario = "";
        boolean esNombreValido = false;
        while (!esNombreValido) {
            System.out.print("Nombre y apellidos del propietario: ");
            nombrePropietario = sc.nextLine();
            if (Validar.validarNombre(nombrePropietario)) {
                esNombreValido = true;
            } else {
                System.out.println("El nombre introducido no tiene el formato correcto");
            }
        }
        
        String dniPropietario = "";
        boolean esDniValido = false;
        while (!esDniValido) {
            System.out.print("DNI del propietario: ");
            dniPropietario = sc.nextLine();
            if (Validar.validarDni(dniPropietario)) {
                esDniValido = true;
            } else {
                System.out.println("EL DNI introducido no tiene el formato correcto");
            }
        }
        
        int resultado = concesionario.insertarVehiculo(marca, matricula, precio, kms, descripcion, fechaMatriculacion, nombrePropietario, dniPropietario);
        switch(resultado) {
            case 0:
                System.out.println("Nuevo vehículo registrado correctamente");
                break;
            case -1:
                System.out.println("No se puede registrar: concesionario lleno");
                break;
            case -2:
                System.out.println("No se puede registrar: la matrícula ya existe");
        }
    }
    
    /**
     * Este método solicitará al usuario una matrícula por teclado (no será necesario validarla)
     * y se buscará en el concesionario un vehículo cuya matrícula coincida con la introducida.
     * Si existe se mostrarán su marca, matrícula y precio por pantalla y
     * en caso contrario el mensaje "No existe vehículo con la matrícula introducida".
     * 
     * @param sc
     * @param concesionario 
     */
    public static void buscarVehiculo(Scanner sc, Concesionario concesionario) {
        System.out.println("____BUSCAR VEHÍCULO____");
        System.out.print("Introduce la matrícula: ");
        String matricula = sc.nextLine();
        String vehiculoEncontrado = concesionario.buscarVehiculo(matricula);
        
        if (vehiculoEncontrado == null) {
            System.out.println("No existe vehículo con la matrícula introducida");
        } else {
            System.out.println(vehiculoEncontrado);
        }
    }
    
    /**
     * Este método solicitará al usuario una matrícula por teclado (no será necesario validarla)
     * y se buscará en el concesionario un vehículo cuya matrícula coincida con la introducida.
     * Si existe se actualizará su número de kilómetros al valor introducido y
     * en caso contrario el mensaje "No existe vehículo con la matrícula introducida".
     * 
     * @param sc
     * @param concesionario 
     */
    public static void modificarKms(Scanner sc, Concesionario concesionario) {
        System.out.println("____MODIFICAR KMS____");
        System.out.print("Introduce la matrícula: ");
        String matricula = sc.nextLine();
        System.out.print("Introduce el número de kilómetros: ");
        int kms = sc.nextInt();
        sc.nextLine();
        boolean kmsActualizados = concesionario.actualizarKms(matricula, kms);
        
        if (kmsActualizados) {
            System.out.println("Kilómetros actualizados correctamente");
        } else {
            System.out.println("No existe vehículo con la matrícula introducida");
        }
    }
    
    /**
     * Este método solicitará al usuario una matrícula por teclado (no será necesario validarla)
     * y se buscará en el concesionario un vehículo cuya matrícula coincida con la introducida.
     * Si existe se eliminará el vehículo y en caso contrario el
     * mensaje "No existe vehículo con la matrícula introducida".
     * 
     * @param sc
     * @param concesionario 
     */
    public static void eliminarVehiculo(Scanner sc, Concesionario concesionario) {
        System.out.println("____ELIMINAR VEHÍCULO____");
        System.out.print("Introduce la matrícula: ");
        String matricula = sc.nextLine();
        boolean vehiculoEliminado = concesionario.eliminarVehiculo(matricula);
        
        if (vehiculoEliminado) {
            System.out.println("Vehículo eliminado correctamente");
        } else {
            System.out.println("No existe vehículo con la matrícula introducida");
        }
    }
}
