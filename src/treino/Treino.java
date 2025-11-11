package treino;

import java.util.Arrays;
import util.DiaDaSemana;

public class Treino {
	
	public static final int MAX_EXERCICIOS = 25;
	
	private Exercicio[] exercicios;
	private int quantExercicios = 0;
	private DiaDaSemana diaDaSemana;
	
	public Treino() {
		this.exercicios = new Exercicio[MAX_EXERCICIOS];
	}
	
	public Treino(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
		this.exercicios = new Exercicio[MAX_EXERCICIOS];
	}
	
	public boolean addExercicio(Exercicio e)
	{
		if(this.quantExercicios < MAX_EXERCICIOS)
		{
			this.exercicios[this.quantExercicios++] = e;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean removeExercicio(int indice)
	{
		if(indice < 0 || indice >= quantExercicios)
		{
			return false;
		}
		
		for(int i = indice; i < quantExercicios - 1; i++)
		{
			exercicios[i] = exercicios[i + 1];
		}
		
		exercicios[--quantExercicios] = null;
		return true;
	}
	
	public Exercicio getExercicio(int index)
	{
		if(index >= 0 && index < this.quantExercicios)
		{
			return this.exercicios[index];
		}
		else
		{
			return null;
		}
	}
	
	public Exercicio[] getExercicios() {
        Exercicio[] validos = new Exercicio[quantExercicios];
        System.arraycopy(exercicios, 0, validos, 0, quantExercicios);
        return validos;
    }
	
	public int getQuantExercicios()
	{
		return this.quantExercicios;
	}

	public DiaDaSemana getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	@Override
	public String toString() {
		return "Treino [exercicios=" + Arrays.toString(exercicios) + ", quantExercicios=" + quantExercicios
				+ ", diaDaSemana=" + diaDaSemana + "]";
	}
	
}
