package exceptions;

/**
 * Exception thrown when a required field is empty or null.
 */
public class EmptyFieldException extends AcademiaException {
    
    public EmptyFieldException(String fieldName) {
        super("O campo '" + fieldName + "' é obrigatório e não pode estar vazio");
    }
    
    public EmptyFieldException(String fieldName, String context) {
        super("O campo '" + fieldName + "' é obrigatório em " + context + 
              " e não pode estar vazio");
    }
}
