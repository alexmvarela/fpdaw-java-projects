package agenda.model.dao;

import agenda.model.Contacto;

public class DuplicateElement extends Exception {
    
    public DuplicateElement(Contacto contacto) {
        super("No se puede guardar: contacto duplicado.");
    }
}
