package exceptions;

import util.DiaDaSemana;

/**
 * Exception thrown when there's a workout schedule conflict.
 * For example, when trying to assign a workout to a day that already has one.
 */
public class WorkoutConflictException extends AcademiaException {
    
    public WorkoutConflictException(DiaDaSemana dia) {
        super("Aluno já possui treino cadastrado para " + dia.getNome());
    }
    
    public WorkoutConflictException(String alunoNome, DiaDaSemana dia) {
        super("O aluno " + alunoNome + " já possui treino cadastrado para " + dia.getNome());
    }
}
