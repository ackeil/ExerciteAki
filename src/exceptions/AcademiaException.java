package exceptions;

/**
 * Base exception class for the Academia system.
 * All custom exceptions should extend this class.
 */
public class AcademiaException extends Exception {
	
    public AcademiaException(String message) {
        super(message);
    }
    
    public AcademiaException(String message, Throwable cause) {
        super(message, cause);
    }
}
