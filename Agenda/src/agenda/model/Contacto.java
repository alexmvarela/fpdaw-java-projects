package agenda.model;

import com.iesrodeira.utils.Input;

public class Contacto {
    
    private int numero = -1;
    private String descripcion;
    private final Persona persona;
    private String direccion;
    private String telefono;
    private String email;
    
    public Contacto(Persona persona, String telefono, String email, String descripcion, String direccion) {
        Input.testPhone(telefono);
        Input.testEmail(email);
        
        this.persona = persona;
        this.telefono = telefono;
        this.email = email;
        this.descripcion = descripcion;
        this.direccion = direccion;
    }

    public Contacto(Persona persona, String telefono, String email, String descripcion) {
        Input.testPhone(telefono);
        Input.testEmail(email);
        
        this.persona = persona;
        this.telefono = telefono;
        this.email = email;
        this.descripcion = descripcion;
        this.direccion = "";
    }
    
    public Contacto(Persona persona, String telefono, String email) {
        Input.testPhone(telefono);
        Input.testEmail(email);
        
        this.persona = persona;
        this.telefono = telefono;
        this.email = email;
        this.descripcion = "";
        this.direccion = "";
    }
    
    public Contacto(Persona persona, String telefono) {
        Input.testPhone(telefono);
        
        this.persona = persona;
        this.telefono = telefono;
        this.email = "";
        this.descripcion = "";
        this.direccion = "";
    }

    public Persona getPersona() {
        return persona;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        Input.testPhone(telefono);
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        Input.testEmail(email);
        this.email = email;
    }

    @Override
    public String toString() {
        return numero + ") " + persona.toString() + ": " + telefono + " (" + email + ") - " + direccion + " - " + descripcion;
    }

    @Override
    public boolean equals(Object obj) {
        Contacto other = (Contacto) obj;
        return this.persona.equals(other.persona) && this.descripcion.equalsIgnoreCase(other.descripcion);
    }
}