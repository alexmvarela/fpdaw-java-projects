package agenda.model.forms;

import agenda.model.Persona;
import agenda.model.Contacto;
import com.iesrodeira.utils.Input;
import com.iesrodeira.utils.CancelException;

public class Forms {
    
    public static Persona personaForm() throws CancelException {
        String nif = Input.readNif("Introducir NIF.");
        String apellidos = Input.readText("Introducir apellidos.");
        String nombre = Input.readText("Introducir nombre.");               
      
        return new Persona(nif, apellidos, nombre);
    }
    
    public static Contacto contactoForm(Contacto contacto) throws CancelException {
        System.out.println("¿Modificar contacto? " + contacto);
        boolean modificar = Input.areYouSure();
        
        if (modificar) {
            String telefono = Input.readPhone("Introducir nuevo teléfono. (Enter para omitir): ", contacto.getTelefono());
            String email = Input.readEmail("Introducir nuevo email. (Enter para omitir): ", contacto.getEmail());
            String descripcion = Input.readText("Introducir nueva descripción. (Enter para omitir): ", contacto.getDescripcion());
                       
            contacto.setTelefono(telefono);
            contacto.setEmail(email);
            contacto.setDescripcion(descripcion);
        } else {
            throw new CancelException("Acción cancelada por el usuario.");
        }
        
        return contacto;
    }
    
    public static Contacto contactoForm(Persona persona) throws CancelException {
        String telefono = Input.readPhone("Introducir teléfono.");
        String email = Input.readEmail("Introducir email.");
        String descripcion = Input.readText("Introducir descripción.");
        String direccion = Input.readText("Introducir dirección.");
        
        return new Contacto(persona, telefono, email, descripcion, direccion);
    }
    
    public static Contacto contactoForm() throws CancelException {
        Persona persona = personaForm();
       
        return contactoForm(persona);
    }
}