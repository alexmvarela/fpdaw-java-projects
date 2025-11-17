package agenda.model.dao;

import agenda.model.Contacto;
import java.util.Arrays;

public class ContactosDAO {
    
    private final Contacto[] agenda;
    
    public ContactosDAO(int capacidadMax) {
        this.agenda = new Contacto[capacidadMax];
    }
    
    public void guardarContacto(Contacto contacto) throws DuplicateElement, StorageFull {
        boolean estaDuplicado = false;
        int posicion = 0;
        
        while (!estaDuplicado && posicion < agenda.length) {
            if (agenda[posicion] != null && agenda[posicion].equals(contacto)) {
                estaDuplicado = true;
            }   
            posicion++;
        }
        
        if (estaDuplicado) {
            throw new DuplicateElement(contacto);
        }
        
        boolean hayContactoVacio = false;
        int posicionLibre = 0;
        
        while (!hayContactoVacio && posicionLibre < agenda.length) {
            if (agenda[posicionLibre] == null) {
                hayContactoVacio = true;
            } else {
                posicionLibre++;
            }
        }
        
        if (!hayContactoVacio) {
            throw new StorageFull();
        }
        
        contacto.setNumero(posicionLibre);
        agenda[posicionLibre] = contacto;
    }
    
    public Contacto[] getContactosByNif(String nif) {
        Contacto[] contactos = new Contacto[agenda.length];
        int encontrados = 0;
         
        for (Contacto contacto : agenda) {
            if (contacto != null && contacto.getPersona().getNif().equalsIgnoreCase(nif)) {
                contactos[encontrados] = contacto;
                encontrados++;
            }
        }
        
        return encontrados == 0 ? null : Arrays.copyOf(contactos, encontrados);
    }
    
    public Contacto[] getContactosByTelefono(String telefono) {
        Contacto[] contactos = new Contacto[agenda.length];
        int encontrados = 0;
         
        for (Contacto contacto : agenda) {
            if (contacto != null && contacto.getTelefono().equalsIgnoreCase(telefono)) {
                contactos[encontrados] = contacto;
                encontrados++;
            }
        }
        
        return encontrados == 0 ? null : Arrays.copyOf(contactos, encontrados);
    }
    
    public Contacto[] getContactosByEmail(String email) {
        Contacto[] contactos = new Contacto[agenda.length];
        int encontrados = 0;
         
        for (Contacto contacto : agenda) {
            if (contacto != null && contacto.getEmail().equalsIgnoreCase(email)) {
                contactos[encontrados] = contacto;
                encontrados++;
            }
        }
        
        return encontrados == 0 ? null : Arrays.copyOf(contactos, encontrados);
    }
    
    public Contacto[] getContactosByDescripcion(String palabra) {
        Contacto[] contactos = new Contacto[agenda.length];
        int encontrados = 0;

        for (Contacto contacto : agenda) {
            if (contacto != null && contacto.getDescripcion().toLowerCase().contains(palabra.toLowerCase())) {
                contactos[encontrados] = contacto;
                encontrados++;
            }
        }

        return encontrados == 0 ? null : Arrays.copyOf(contactos, encontrados);
    }
    
    public Contacto getContactoByNumero(int numero) {
        return (numero < 0 || numero >= agenda.length) ? null : agenda[numero];
    }
    
    public Contacto[] getAllContactos() {
        Contacto[] contactos = new Contacto[agenda.length];
        int encontrados = 0;
         
        for (Contacto contacto : agenda) {
            if (contacto != null) {
                contactos[encontrados] = contacto;
                encontrados++;
            }
        }
        
        return encontrados == 0 ? null : Arrays.copyOf(contactos, encontrados);
    }
    
    public Contacto eliminarContactoByNumero(int numero) {
        if ((numero < 0 || numero >= agenda.length) || agenda[numero] == null) {
            return null;
        }
        
        Contacto contactoEliminado = agenda[numero];
        agenda[numero] = null;
        return contactoEliminado;
    }
    
    public void eliminarAllContactos() {
        for (int i = 0; i < agenda.length; i++) {
            agenda[i] = null;
        }
    }
}
