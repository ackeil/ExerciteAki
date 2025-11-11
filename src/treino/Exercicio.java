package treino;

public class Exercicio {
	
	private Aparelho aparelho;
	private double carga;
	private int repeticoes;
	
	public Exercicio() {};
	
	public Exercicio(Aparelho aparelho, double carga, int repeticoes)
	{
		this.aparelho = aparelho;
		this.setCarga(carga);
		this.setRepeticoes(repeticoes);
	}

	public Aparelho getAparelho() {
		return aparelho;
	}

	public void setAparelho(Aparelho aparelho) {
		this.aparelho = aparelho;
	}

	public double getCarga() {
		return carga;
	}

	public void setCarga(double carga) {
		if(carga > 0)this.carga = carga;
	}

	public int getRepeticoes() {
		return repeticoes;
	}

	public void setRepeticoes(int repeticoes) {
		if(repeticoes > 0)this.repeticoes = repeticoes;
	}

	@Override
	public String toString() {
		return "Exercicio [aparelho=" + aparelho.getNome() + ", carga=" + carga + ", repeticoes=" + repeticoes + "]";
	}
	
	

}
