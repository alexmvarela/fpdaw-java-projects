package agenda.model;

import com.iesrodeira.utils.Input;

public class Persona {

    private final String nif;
    private final String apellidos;
    private final String nombre;
    
    public Persona(String nif, String apellidos, String nombre) {
        Input.testNif(nif);
        
        this.nif = nif;
        this.apellidos = apellidos;
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }
    
    @Override
    public String toString() {
        return "[" + nif + "] " + apellidos + ", " + nombre;
    }

    @Override
    public boolean equals(Object obj) {
        Persona other = (Persona) obj;
        return this.nif.equalsIgnoreCase(other.nif);
    }
}