package exceptions;

/**
 * Exception thrown when a date is invalid.
 */
public class InvalidDateException extends AcademiaException {
    
    public InvalidDateException(String data) {
        super("Data inválida: " + data);
    }
    
    public InvalidDateException(String data, String reason) {
        super("Data inválida: " + data + " - " + reason);
    }
}
