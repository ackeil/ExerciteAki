package treino;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.DiaDaSemana;

public class Treino {
	private List<Exercicio> exercicios;
	private int quantExercicios = 0;
	private DiaDaSemana diaDaSemana;
	
	public Treino() {
		this.exercicios = new ArrayList<Exercicio>();
	}
	
	public Treino(DiaDaSemana diaDaSemana) {
		this();
		this.diaDaSemana = diaDaSemana;
	}
	
	public void addExercicio(Exercicio exer) throws Exception{
		try {
			this.exercicios.add(exer);
		}catch(UnsupportedOperationException e) {
			throw new Exception("Não é possivel adicionar mais um exercicio.");
		}catch(NullPointerException e) {
			throw new Exception("Não é possível adicionar um exercício vazio.");
		}catch(Exception e) {
			throw new Exception("Exercício inválido.");
		}
	}
	
	public boolean removeExercicio(int indice) throws Exception{
		try {
			this.exercicios.remove(indice);
		}catch(UnsupportedOperationException e) {
			throw new Exception("Erro ao remover exercicio");
		}catch(IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException();
		}
		return true;

	}
	
	public Exercicio getExercicio(int index) throws IndexOutOfBoundsException{
		try {
			return this.exercicios.get(index);
		}catch(IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public List<Exercicio> getExercicios() {
        return this.exercicios;
    }
	
	public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }
	
	public int getQuantExercicios(){
		return this.quantExercicios;
	}
	
	public void setQuantExercicios(int qtdDias){
		this.quantExercicios = qtdDias;
	}

	public DiaDaSemana getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	@Override
	public String toString() {
		return "Treino [exercicios=" + exercicios.toString() + ", quantExercicios=" + quantExercicios
				+ ", diaDaSemana=" + diaDaSemana + "]";
	}
	
}
