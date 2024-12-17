package prog06.util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Clase que contiene métodos para validar los datos introducidos por el usuario
 * correspondientes a la matrícula del vehículo y al nombre y DNI del propietario.
 * 
 * @author alex
 */
public class Validar {
    
    /**
     * Este método valida mediante una expresión regular que la matrícula introducida
     * tiene el formato NNNNLLL, siendo NNNN un número entre 0000 y 9999,
     * y LLL letras mayúsculas del abecedario.
     * 
     * @param matricula
     * @return true si la matrícula tiene el formato correcto, false en caso contrario.
     */
    public static boolean validarMatricula(String matricula) {
        Pattern p = Pattern.compile("^[0-9]{4}[A-Z]{3}$");
        Matcher m = p.matcher(matricula);
        return m.matches();
    }
    
    /**
     * Este método valida mediante una expresión regular que el DNI introducido
     * tiene el formato NNNNNNNNL, siendo NNNNNNNN un número entre 00000000 y 99999999,
     * y L un letra mayúscula o minúscula del abecedario. 
     * 
     * @param dni
     * @return true si el DNI tiene el formato correcto, false en caso contrario.
     */
    public static boolean validarDni(String dni) {
        Pattern p = Pattern.compile("^[0-9]{8}[A-Za-z]$");
        Matcher m = p.matcher(dni);
        return m.matches();
    }
    
    /**
     * Este método valida (sin usar expresiones regulares) que:
     * - el nombre y apellidos no execede de 40 caracteres
     * - no hay espacios en blanco al principio y/o al final de la cadena
     * - no hay dos o más espacios consecutivos intermedios
     * - contiene al menos un nombre y dos apellidos
     * 
     * @param nombreCompleto
     * @return true si el nombre y apellidos tiene el formato correcto, false en caso contrario.
     */
    public static boolean validarNombre(String nombreCompleto) {
        return !(nombreCompleto.length() > 40 ||
                !nombreCompleto.equals(nombreCompleto.trim()) ||
                nombreCompleto.contains("  ") ||
                nombreCompleto.split(" ").length < 3); 
    }
}
