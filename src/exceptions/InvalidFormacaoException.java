package exceptions;

/**
 * Exception thrown when an instructor's formation is invalid.
 */
public class InvalidFormacaoException extends AcademiaException {
    
    public InvalidFormacaoException(String formacao) {
        super("Formação inválida: " + formacao + ". A formação não pode conter caracteres especiais");
    }
}
