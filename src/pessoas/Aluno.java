package pessoas;

import util.Validacoes;
import util.DiaDaSemana;

import java.time.Duration;
import java.time.LocalDate;

import historico.Frequencia;
import treino.Treino;

import exceptions.*;

public class Aluno extends Pessoa{

    private String dataNascimento;
    private float altura;

    private Treino[] treinos;
    private Frequencia[] frequencia;

    private int frequenciaSequencia = 0;

    private static final int MAX_TREINOS = 7;
    private static final int MAX_FREQUENCIAS = 50;

    public Aluno(){
        super();
        this.treinos = new Treino[MAX_TREINOS];
        this.frequencia = new Frequencia[MAX_FREQUENCIAS];
    }

    public Aluno(String nome, String email, String telefone, String dataNascimento, float altura,
    			 String username, String senha){
        super(nome,email,telefone,username,senha);
        
        Validacoes valida = new Validacoes();

        this.treinos = new Treino[MAX_TREINOS];
        
        if(this.getNome() == null){
            return;
        }

        try {
            if(!valida.validaAltura(altura)){
                apagaValores();
                return;
            }
        } catch (InvalidHeightException e) {
            System.out.println("Erro: " + e.getMessage());
            apagaValores();
            return;
        }

        try {
            if(!valida.validaData(dataNascimento)){
                apagaValores();
                return;
            }
        } catch (EmptyFieldException | InvalidDateException e) {
            System.out.println("Erro: " + e.getMessage());
            apagaValores();
            return;
        }

        this.altura = altura;
        this.dataNascimento = dataNascimento;
	this.treinos = new Treino[MAX_TREINOS];
	this.frequencia = new Frequencia[MAX_FREQUENCIAS];
    }

    public String getDataNascimento(){
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento){
    	Validacoes valida = new Validacoes();
    	
    	try {
            if(!valida.validaData(dataNascimento)){
                return;
            }
        } catch (EmptyFieldException | InvalidDateException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        this.dataNascimento = dataNascimento;
    }

    public float getAltura(){
        return this.altura;
    }

    public void setAltura(float altura){
    	Validacoes valida = new Validacoes();
    	
    	try {
            if(!valida.validaAltura(altura)){
                return;
            }
        } catch (InvalidHeightException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        this.altura = altura;
    }

    public void addEntrada(){
        if(this.frequencia[MAX_FREQUENCIAS-1] != null){
            System.out.println("Não podem ser cadastradas mais frequencias");
            return;
        }

        Frequencia freq = new Frequencia();

        this.frequencia[this.frequenciaSequencia] = freq;
    }

    public void addSaida(int posicao){
        this.frequencia[posicao].gravaSaida();
        this.frequenciaSequencia++;
    }

    public void setTreino(DiaDaSemana dia, Treino treino) {
        int indice = dia.getCodigo();
        if(indice >= 0 && indice < MAX_TREINOS) {
            this.treinos[indice] = treino;
        }
    }
    
    public Treino getTreino(DiaDaSemana dia) {
        int indice = dia.getCodigo();
        if(indice >= 0 && indice < MAX_TREINOS) {
            return this.treinos[indice];
        }
        return null;
    }
    
    public Treino getTreinoPorIndice(int indice) {
        if(indice >= 0 && indice < MAX_TREINOS) {
            return this.treinos[indice];
        }
        return null;
    }
    
    public Treino[] getTreinos() {
        return this.treinos;
    }

    public String verificaFrequencia(LocalDate dataInicio, LocalDate dataFim){
    	if(dataInicio == null){
    		System.out.println("A data de inicio precisa ser informada");
    		return "";
    	}

    	String mensagem = null;
    	int dias  = 0;
    	Duration horas = Duration.ZERO;
    	LocalDate anterior = null;

    	for(int i = 0;i <= this.frequencia.length; i++){
    		if(this.frequencia[i] == null){
    			break;
    		}
    		
    		if(dataFim != null) {
    			if(dataFim.isBefore(this.frequencia[i].getDia())){
    				break;
    			}
    		}

    		Duration t;
    		if(dataInicio.isBefore(this.frequencia[i].getDia())){
                t = this.frequencia[i].getHorasDiaria();
                horas = horas.plus(t);
                
                if(anterior == null || !this.frequencia[i].getDia().equals(anterior)){
                    dias++;
                }
                
                anterior = this.frequencia[i].getDia();
    		}
    	}
    	mensagem = "A frequencia do aluno é de " + dias + " dias, com um total de " + horas.toHours() + " horas e " + horas.toMinutes() + " minutos";

    	return mensagem;
    }

    public int getSequencia(){
        return this.frequenciaSequencia;
    }

    @Override
    public String toString(){
        return super.toString() + "\nAltura  : " + String.format("%.2f", this.altura)  + " metros\nData de nascimento: " + this.dataNascimento;
    }
}
