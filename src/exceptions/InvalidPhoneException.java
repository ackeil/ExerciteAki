package exceptions;

/**
 * Exception thrown when a phone number is invalid.
 */
public class InvalidPhoneException extends AcademiaException {
    
    public InvalidPhoneException(String telefone) {
        super("Formato de telefone inválido: " + telefone);
    }
    
    public InvalidPhoneException(String telefone, String reason) {
        super("Telefone inválido: " + telefone + " - " + reason);
    }
}
