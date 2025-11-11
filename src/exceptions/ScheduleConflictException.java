package exceptions;

import java.time.LocalTime;
import util.DiaDaSemana;

/**
 * Exception thrown when there's a schedule conflict.
 * For example, overlapping operating hours or conflicting appointments.
 */
public class ScheduleConflictException extends AcademiaException {
    
    public ScheduleConflictException(DiaDaSemana dia) {
        super("Já existe um horário definido para " + dia.getNome());
    }
    
    public ScheduleConflictException(LocalTime hora1, LocalTime hora2) {
        super("Conflito de horário entre " + hora1 + " e " + hora2);
    }
    
    public ScheduleConflictException(String message) {
        super(message);
    }
}
