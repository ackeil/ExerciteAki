package exceptions;

/**
 * Exception thrown when trying to register a duplicate entity.
 * For example, a student or instructor that already exists in the system.
 */
public class DuplicateRegistrationException extends AcademiaException {
    
    public DuplicateRegistrationException(String entityType, String identifier) {
        super("Já existe um(a) " + entityType + " cadastrado(a) com o identificador: " + identifier);
    }
    
    public DuplicateRegistrationException(String message) {
        super(message);
    }
}
