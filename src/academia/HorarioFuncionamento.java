package academia;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import util.DiaDaSemana;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")

public class HorarioFuncionamento {
	
	private DiaDaSemana diaDaSemana;
	private LocalTime horaAbertura;
	private LocalTime horaFechamento;
	
	private static final DateTimeFormatter FORMATO_HORA = 
	        DateTimeFormatter.ofPattern("HH:mm");
	
	public HorarioFuncionamento() {};
	
	public HorarioFuncionamento(DiaDaSemana diaDaSemana, LocalTime horaAbertura, LocalTime horaFechamento)
	{
		this.diaDaSemana = diaDaSemana;
		this.horaAbertura = horaAbertura;
		this.horaFechamento = horaFechamento;
	}

	public DiaDaSemana getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public LocalTime getHoraAbertura() {
		return horaAbertura;
	}

	public void setHoraAbertura(LocalTime horaAbertura) {
		
		if (horaFechamento != null && !horaAbertura.isBefore(horaFechamento)) {
            throw new IllegalArgumentException(
                "Horário de abertura deve ser antes do fechamento");
        }
		else
		{
			this.horaAbertura = horaAbertura;
		}	
	}

	public LocalTime getHoraFechamento() {
		return horaFechamento;
	}

	public void setHoraFechamento(LocalTime horaFechamento) {
		if (horaAbertura != null && !horaFechamento.isAfter(horaAbertura)) {
            throw new IllegalArgumentException(
                "Horário de fechamento deve ser após abertura");
        }
		else
		{
			this.horaFechamento = horaFechamento;
		}
	}
	
	public boolean estaAberto(LocalTime hora) {
        if (hora == null) return false;
        return !hora.isBefore(horaAbertura) && !hora.isAfter(horaFechamento);
    }
	
	 public long getHorasFuncionamento() {
	        return java.time.Duration.between(horaAbertura, horaFechamento).toHours();
    }

	@Override
	public String toString() {
        return String.format("%s: %s às %s",
                           diaDaSemana.getNome(),
                           horaAbertura.format(FORMATO_HORA),
                           horaFechamento.format(FORMATO_HORA));
    }

}
