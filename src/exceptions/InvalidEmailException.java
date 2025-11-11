package exceptions;

/**
 * Exception thrown when an email address is invalid.
 */
public class InvalidEmailException extends AcademiaException {
    
    public InvalidEmailException(String email) {
        super("Formato de e-mail inválido: " + email);
    }
}
