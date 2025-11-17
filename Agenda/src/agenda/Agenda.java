package agenda;

import com.iesrodeira.utils.Input;
import com.iesrodeira.utils.CancelException;
import agenda.model.dao.ContactosDAO;
import agenda.model.dao.DuplicateElement;
import agenda.model.dao.StorageFull;
import agenda.model.Contacto;
import agenda.model.forms.Forms;


public class Agenda {
    
    private static final int CAPACIDAD_MAXIMA = 50;
    private static final ContactosDAO dao = new ContactosDAO(CAPACIDAD_MAXIMA);
    
    public static void main(String[] args) {
        boolean optionSalir = false;
        
        while (!optionSalir) {
            System.out.println("======= AGENDA =======");
            System.out.println("1.- Listar Contactos");
            System.out.println("2.- Alta de Contactos");
            System.out.println("3.- Buscar Contactos");
            System.out.println("4.- Salir");
            System.out.println("======================");
            
            try {
                String option = Input.option("Introduce una opción del menú.", "1234");
                
                switch (option) {
                    case "1":
                        listarContactos();
                        break;
                    case "2":
                        crearContacto();
                        break;
                    case "3":
                        buscarContactos();
                        break;
                    case "4":
                        optionSalir = true;
                        break;
                }
            } catch(CancelException e) {
                System.out.println(e.getMessage());
            }
        }
        
        System.out.println("Saliendo de AGENDA...");
    }
    
    private static void listarContactos() {
        Contacto[] contactos = dao.getAllContactos();
        
        if (contactos == null) {
            System.out.println("La agenda está vacía.");
        } else {
            System.out.println("===== LISTA DE CONTACTOS =====");
            
            for (Contacto contacto : contactos) {
                System.out.println(contacto);
            }
        }
        
        Input.waitEnter();
    }
    
    private static void listarContactos(Contacto[] contactos) {
        System.out.println("===== CONTACTOS ENCONTRADOS (" + contactos.length + ") =====");
        
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
        
        Input.waitEnter();
    }
    
    private static void crearContacto() throws CancelException {
        Contacto contacto = Forms.contactoForm();
        
        try {
            dao.guardarContacto(contacto);
            System.out.println("Contacto guardado correctamente: " + contacto);
        } catch(DuplicateElement | StorageFull e) {
            System.out.println(e.getMessage());
        }
        
        Input.waitEnter();
    }
    
    private static void buscarContactos() throws CancelException {
        System.out.println("======= BUSCAR CONTACTOS =======");
        System.out.println("1.- Buscar por NIF");
        System.out.println("2.- Buscar por EMAIL");
        System.out.println("3.- Buscar por TELÉFONO");
        System.out.println("4.- Buscar por DESCRIPCIÓN");
        System.out.println("5.- Volver al menú principal");
        System.out.println("=================================");
        
        String optionBuscar = Input.option("Introduce una opción del menú.", "12345");
        
        if (!optionBuscar.equals("5")) {
            Contacto[] contactosEncontrados = buscarContactosByOption(optionBuscar);
            
            if (contactosEncontrados == null) {
                System.out.println("No se encontraron contactos.");
            } else {
                listarContactos(contactosEncontrados);
                
                System.out.println("======= ACCIONES DISPONIBLES =======");
                System.out.println("1.- Modificar contacto");
                System.out.println("2.- Borrar contacto");
                System.out.println("3.- Volver al menú principal");
                System.out.println("=====================================");
                
                /*  NOTA:
                    El enunciado indica que las acciones MODIFICAR Y BORRAR se hacen tras una búsqueda,
                    pero no especifica si sólo se pueden aplicar a los contactos encontrados o a los de toda la agenda.
                    En mi solución he optado por aplicarlas a todos los contactos existentes en la agenda porque me parece más práctico.
                */
                
                String optionAccion = Input.option("Introduce una opción del menú.", "123");
                
                if (optionAccion.equals("1")) {
                    modificarContacto();
                } else if (optionAccion.equals("2")) {
                    borrarContacto();
                }
            }
        }
    }
    
    private static Contacto[] buscarContactosByOption(String option) throws CancelException {
        switch (option) {
            case "1": 
                String nif = Input.readNif("Introducir NIF.");
                return dao.getContactosByNif(nif);
            case "2": 
                String email = Input.readEmail("Introducir email.");
                return dao.getContactosByEmail(email);
            case "3":
                String telefono = Input.readPhone("Introducir teléfono.");
                return dao.getContactosByTelefono(telefono);
            case "4":
                String descripcion = Input.readText("Introducir el texto a buscar en la descripción.");
                return dao.getContactosByDescripcion(descripcion);
            default:
                return null;
        }
    }
    
    private static void modificarContacto() throws CancelException {
        Contacto contactoModificado = null;
        
        while(contactoModificado == null) {
            try {
                int numero = Integer.parseInt(Input.readText("Introduce el número de contacto a MODIFICAR."));
                Contacto contacto = dao.getContactoByNumero(numero);
                if (contacto == null) {
                    System.out.println("Error: no existe el contacto número " + numero);
                } else {
                    contactoModificado = Forms.contactoForm(contacto);
                }
            } catch(NumberFormatException e) {
                System.out.println("Error: El valor introducido no es un número entero.");
            }    
        }
        
        System.out.println("Contacto modificado correctamente: " + contactoModificado);
        Input.waitEnter();
    }
    
    private static void borrarContacto() throws CancelException {        
        Contacto contactoEliminado = null;
        
        while(contactoEliminado == null) {
            try {
                int numero = Integer.parseInt(Input.readText("Introduce el número de contacto a ELIMINAR."));
                System.out.println("¿Eliminar contacto número " + numero + "?");
                boolean confirmaEliminar = Input.areYouSure();
                if (confirmaEliminar) {
                    contactoEliminado = dao.eliminarContactoByNumero(numero);
                    if (contactoEliminado == null) {
                        System.out.println("Error: no existe el número de contacto " + numero);
                    }
                } else {
                    throw new CancelException("Acción cancelada por el usuario.");
                }
            } catch(NumberFormatException e) {
                System.out.println("Error: El valor introducido no es un número entero.");
            }    
        }
        
        System.out.println("Contacto eliminado correctamente: " + contactoEliminado);   
        Input.waitEnter();
    }
}
