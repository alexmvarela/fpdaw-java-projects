package agenda.model.dao;

public class StorageFull extends Exception {
    
    public StorageFull() {
        super("No se puede guardar: la agenda está completa.");
    }
}
