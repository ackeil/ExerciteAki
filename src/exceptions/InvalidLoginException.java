package exceptions;

/**
 * Exception thrown when login credentials are invalid.
 */
public class InvalidLoginException extends AcademiaException {
    
    public InvalidLoginException() {
        super("Usuário e/ou senha inválidos");
    }
    
    public InvalidLoginException(String username) {
        super("Falha na autenticação para o usuário: " + username);
    }
}
