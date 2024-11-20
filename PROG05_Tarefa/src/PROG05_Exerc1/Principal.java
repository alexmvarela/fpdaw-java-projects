package PROG05_Exerc1;

import PROG05_Exerc1_util.Validar;
import java.util.Scanner;
import java.time.LocalDate;

/**
 * Clase principal de la aplicación.
 * Contiene un menú para gestionar un vehículo.
 * Funcionalidades principales:
 * - Crear un nuevo vehículo.
 * - Consultar atributos específicos (matrícula, kilómetros, antigüedad, propietario, precio).
 * - Actualizar los kilómetros del vehículo.
 * - Mostrar información detallada del vehículo.
 * - Salir de la aplicación.
 * 
 * @author Alex Martínez
 */
public class Principal {
    /**
    * Vehículo gestionado por la aplicación.
    * Este objeto almacena toda la información del vehículo creado.
    * Si no se ha creado ningún vehículo, su valor será `null`.
    */
    private static Vehiculo vehiculo;
    
    /**
    * Método principal que ejecuta la aplicación.
    * Gestiona el flujo principal mediante un menú interactivo para realizar
    * diversas acciones sobre el vehículo.
    * 
    * @param args Argumentos de la línea de comandos.
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            mostrarMenu();
            opcion = inputOpcion(sc);
            
            switch (opcion) {
                case 1:
                    crearVehiculo(sc);
                    break;
                case 2:
                    if (vehiculo == null) {
                        System.out.println("No hay vehículo creado.");
                    } else {
                        System.out.println("Matrícula: " + vehiculo.getMatricula());
                    }
                    break;
                case 3:
                    if (vehiculo == null) {
                        System.out.println("No hay vehículo creado.");
                    } else {
                        System.out.println("Kilómetros: " + vehiculo.getKilometros());
                    }
                    break;
                case 4:
                    if (vehiculo == null) {
                        System.out.println("No hay vehículo creado.");
                    } else {
                        actualizarKilometros(sc);
                    }
                    break;
                case 5:
                    if (vehiculo == null) {
                        System.out.println("No hay vehículo creado.");
                    } else {
                        System.out.println("Años de antigüedad: " + vehiculo.getAnios());
                    }
                    break;
                case 6:
                    if (vehiculo == null) {
                        System.out.println("No hay vehículo creado.");
                    } else {
                        System.out.println("Propietario: " + vehiculo.getNombrePropietario());
                        System.out.println("DNI: " + vehiculo.getDniPropietario());
                    }
                    break;
                case 7:
                    if (vehiculo == null) {
                        System.out.println("No hay vehículo creado.");
                    } else {
                       System.out.println("Descripción: " + vehiculo.getDescripcion());
                       System.out.println("Matrícula: " + vehiculo.getMatricula());
                       System.out.println("Kilómetros: " + vehiculo.getKilometros());
                    }
                    break;
                case 8:
                    if (vehiculo == null) {
                        System.out.println("No hay vehículo creado.");
                    } else {
                        System.out.println("Precio: " + vehiculo.getPrecio() + " euros");
                    }
                    break;
                case 9:
                    System.out.println("Saliendo de la aplicación...");
                    break;
            }
        } while (opcion != 9);
    }
    
    /**
    * Muestra el menú principal con las opciones disponibles en la aplicación.
    */
    private static void mostrarMenu() {
        System.out.println("\n______MENÚ PRINCIPAL______");
        System.out.println("1. Nuevo vehículo");
        System.out.println("2. Ver matrícula");
        System.out.println("3. Ver número de kilómetros");
        System.out.println("4. Actualizar kilómetros");
        System.out.println("5. Ver años de antigüedad");
        System.out.println("6. Mostrar propietario");
        System.out.println("7. Mostrar descripción");
        System.out.println("8. Mostrar precio");
        System.out.println("9. Salir\n");
    }
    
    /**
    * Solicita al usuario que introduzca una opción válida del menú.
    * Repite la solicitud hasta que el usuario ingrese un valor en el rango permitido.
    * 
    * @param sc Objeto `Scanner` para leer la entrada del usuario.
    * @return Un entero que representa la opción seleccionada por el usuario.
    */
    private static int inputOpcion(Scanner sc) {
        int opcion;
        boolean esInputValido = false;
        
        do {
            System.out.println("Selecciona una opción [1 - 9]:");
            opcion = sc.nextInt();
            sc.nextLine();
            if (opcion >= 1 && opcion <= 9) {
                esInputValido = true;
            } else {
                System.out.println("Opción no válida.");
            }
        } while (!esInputValido);
        
        return opcion;
    }
    
    /**
    * Solicita al usuario los datos necesarios para crear un nuevo vehículo.
    * Valida los datos ingresados antes de crear el objeto Vehículo.
    * En caso de error en la validación, se muestra un mensaje de error y no se crea el vehículo.
    * 
    * @param sc Objeto `Scanner` para leer la entrada del usuario.
    */
    private static void crearVehiculo(Scanner sc) {
        System.out.print("Introduce la marca: ");
        String marca = sc.nextLine();

        System.out.print("Introduce la matrícula: ");
        String matricula = sc.nextLine();

        System.out.print("Introduce el número de kilómetros: ");
        int kilometros = sc.nextInt();
        sc.nextLine();
        if (!Validar.validarKilometros(kilometros)) {
            System.out.println("Error: Los kilómetros deben ser mayores que 0.");
            return;
        }

        System.out.print("Introduce la fecha de matriculación (AAAA-MM-DD): ");
        LocalDate fechaMatriculacion = LocalDate.parse(sc.nextLine());
        if (!Validar.validarFechaMatriculacion(fechaMatriculacion)) {
            System.out.println("Error: La fecha de matriculación debe ser anterior a la actual.");
            return;
        }

        System.out.print("Introduce la descripción: ");
        String descripcion = sc.nextLine();

        System.out.print("Introduce el precio: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        System.out.print("Introduce el nombre del propietario: ");
        String nombrePropietario = sc.nextLine();

        System.out.print("Introduce el DNI del propietario: ");
        String dniPropietario = sc.nextLine();
        try {
            Validar.validarDni(dniPropietario);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        vehiculo = new Vehiculo(marca, matricula, kilometros, fechaMatriculacion, descripcion, 
                                precio, nombrePropietario, dniPropietario);
        System.out.println("Vehículo creado correctamente."); 
    }
    
    /**
    * Solicita al usuario que ingrese un nuevo valor para los kilómetros del vehículo.
    * Si el valor es mayor que los kilómetros actuales, se actualiza el atributo correspondiente.
    * En caso contrario, se muestra un mensaje de error.
    * 
    * @param sc Objeto `Scanner` para leer la entrada del usuario.
    */
    private static void actualizarKilometros(Scanner sc) {
        System.out.print("Introduce los kilómetros actuales: ");
        int nuevosKilometros = sc.nextInt();
        sc.nextLine();

        if (nuevosKilometros > vehiculo.getKilometros()) {
            vehiculo.setKilometros(nuevosKilometros);
            System.out.println("Kilómetros actualizados correctamente.");
        } else {
            System.out.println("Error: No se pueden restar kilómetros.");
        }
    }
}
