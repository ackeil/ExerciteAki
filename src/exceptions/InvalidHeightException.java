package exceptions;

/**
 * Exception thrown when a height value is invalid.
 */
public class InvalidHeightException extends AcademiaException {
    
    public InvalidHeightException(float altura) {
        super("Altura inválida: " + altura + " metros. Altura deve ser maior que 0.5m");
    }
}
