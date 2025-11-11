package exceptions;

/**
 * Exception thrown when an entity is not found in the system.
 * Used for searches that don't return results.
 */
public class EntityNotFoundException extends AcademiaException {
    
    public EntityNotFoundException(String entityType, int codigo) {
        super(entityType + " com código " + codigo + " não encontrado(a)");
    }
    
    public EntityNotFoundException(String entityType, String identifier) {
        super(entityType + " com identificador '" + identifier + "' não encontrado(a)");
    }
    
    public EntityNotFoundException(String message) {
        super(message);
    }
}
