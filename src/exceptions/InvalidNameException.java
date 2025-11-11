package exceptions;

/**
 * Exception thrown when a name is invalid.
 */
public class InvalidNameException extends AcademiaException {
    
    public InvalidNameException(String nome) {
        super("Nome inválido: " + nome + ". O nome não pode conter números, pontuação ou caracteres especiais");
    }
    
    public InvalidNameException() {
        super("O nome precisa ser preenchido");
    }
}
