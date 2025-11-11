package historico;

import java.time.LocalDate;

public class Historico {
	
	private double peso;
	private double massaMuscular;
	private LocalDate data;
	
	public Historico() {};
	
	public Historico(double peso, double massaMuscular, LocalDate data) {
		super();
		this.setPeso(peso);
		this.setMassaMuscular(massaMuscular);
		this.data = data;
	}
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		if(peso > 0)this.peso = peso;
	}
	public double getMassaMuscular() {
		return massaMuscular;
	}
	public void setMassaMuscular(double massaMuscular) {
		if(massaMuscular > 0)this.massaMuscular = massaMuscular;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public double getMassaMagraKg() 
	{
        return peso * (massaMuscular / 100.0);
    }
	
	@Override
	public String toString() {
		return "No dia " + getData() + 
				" aluno pesava " + getPeso() + 
				" com massa muscular de " + getMassaMuscular() + 
				"!\n";
				
	}

}
