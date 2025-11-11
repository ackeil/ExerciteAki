package exceptions;

/**
 * Exception thrown when an exercise has an excessive number of repetitions.
 * This helps prevent injuries and ensures proper workout planning.
 */
public class ExcessiveRepetitionsException extends AcademiaException {
    
    private static final int MAX_REPETICOES = 50;
    
    public ExcessiveRepetitionsException(int repeticoes) {
        super("Número excessivo de repetições: " + repeticoes + 
              ". Máximo recomendado: " + MAX_REPETICOES);
    }
    
    public ExcessiveRepetitionsException(String aparelhoNome, int repeticoes) {
        super("Número excessivo de repetições no exercício " + aparelhoNome + 
              ": " + repeticoes + ". Máximo recomendado: " + MAX_REPETICOES);
    }
    
    public static int getMaxRepeticoes() {
        return MAX_REPETICOES;
    }
}
