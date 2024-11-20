package PROG05_Exerc1_util;

import java.time.LocalDate;

/**
 * Clase que contiene métodos estáticos para validar datos.
 * Realiza validaciones de kilómetros, fecha de matriculación y DNI.
 * 
 * @author Alex Martínez
 */
public class Validar {
    /**
     * Valida que los kilómetros sean mayores que 0.
     * @param kilometros Kilometros a validar.
     * @return true si son válidos, false en caso contrario.
     */
    public static boolean validarKilometros(int kilometros) {
        return kilometros > 0;
    }
    
    /**
     * Valida que la fecha de matriculación sea anterior a la actual.
     * @param fecha Fecha a validar.
     * @return true si es válida, false en caso contrario.
     */
    public static boolean validarFechaMatriculacion(LocalDate fecha) {
        return fecha.isBefore(LocalDate.now());
    }
    
    /**
     * Valida que el DNI tenga un formato correcto.
     * @param dni DNI a validar.
     * @throws IllegalArgumentException Si el DNI no cumple con los requisitos de formato.
     */
    public static void validarDni(String dni) { 
        // Validar que la longitud sea de 9 caracteres    
        if (dni.length() != 9) {
            throw new IllegalArgumentException("Error: El DNI debe tener 9 caracteres.");
        }
        
        // Validar que la última posición sea una letra
        char letra = dni.charAt(8);
        if (!Character.isLetter(letra)) {
            throw new IllegalArgumentException("Error: El último carácter del DNI debe ser una letra.");
        }
        
        // Validar que los 8 primeros caracteres sean números
        String numeros = dni.substring(0, 8);
        boolean esValido = true;
        int i = 0;
        while (esValido && i < numeros.length()) {
            char numero = numeros.charAt(i);
            if (!Character.isDigit(numero)) {
                esValido = false;
            }
            i++;
        }
        if (!esValido) {
            throw new IllegalArgumentException("Error: Los primeros 8 caracteres del DNI deben ser números.");
        }
    }
}
