package exceptions;

/**
 * Exception thrown when maximum capacity is reached.
 * For example, when trying to add more items than the array can hold.
 */
public class MaxCapacityException extends AcademiaException {
    
    public MaxCapacityException(String entityType, int maxCapacity) {
        super("Capacidade máxima atingida para " + entityType + 
              ". Máximo: " + maxCapacity);
    }
    
    public MaxCapacityException(String message) {
        super(message);
    }
}
