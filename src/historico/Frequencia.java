package historico;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Frequencia {

	private LocalDate diaEntrada;
	private LocalTime horarioEntrada;
	private LocalTime horarioSaida;

	public Frequencia() {
		this.diaEntrada = LocalDate.now();
		this.horarioEntrada = LocalTime.now();
	};
	
	public void gravaSaida(){

		this.horarioSaida = LocalTime.now();
	}
	
	public Duration getHorasDiaria(){
		LocalTime aux = null;
		if(this.horarioSaida == null) {
			aux = LocalTime.now();
		}
		
		Duration t;
		if(aux != null) {
			t = java.time.Duration.between(this.horarioEntrada, aux);
		}else {
			t = java.time.Duration.between(this.horarioEntrada, this.horarioSaida);
		}

		return t;
	}

	public LocalDate getDia(){
		return this.diaEntrada;
	}
}
