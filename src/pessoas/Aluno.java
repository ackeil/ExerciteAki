package pessoas;

import util.Validacoes;
import util.DiaDaSemana;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import historico.Frequencia;
import treino.Treino;

import exceptions.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")

public class Aluno extends Pessoa{

    private String dataNascimento;
    private float altura;

    private List<Treino> treinos;
    private List<Frequencia> frequencias;

    private int frequenciaSequencia = 0;

    public Aluno(){
        super();
        this.treinos     = new ArrayList<Treino>();
        this.frequencias = new ArrayList<Frequencia>();
    }

    public Aluno(String nome, String email, String telefone, String dataNascimento, float altura,
    			 String username, String senha){
        super(nome,email,telefone,username,senha);
        
        Validacoes valida = new Validacoes();

        this.treinos = new ArrayList<Treino>();
        
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
	this.treinos     = new ArrayList<Treino>();
	this.frequencias = new ArrayList<Frequencia>();
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
        Frequencia freq = new Frequencia();

        this.frequencias.add(freq);
    }

    public void addSaida(int posicao) throws IndexOutOfBoundsException{
        try{
            this.frequencias.get(posicao).gravaSaida();
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException();
        }
        
        this.frequenciaSequencia++;
    }

    public void setTreino(DiaDaSemana dia, Treino treino) {
        int indice = dia.getCodigo();

        /* ERRO */
        this.treinos.set(indice, treino);
    }
    
    public Treino getTreino(DiaDaSemana dia) throws IndexOutOfBoundsException{
        int indice = dia.getCodigo();
        try{
            return this.treinos.get(indice);
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException();
        }
    }
    
    public Treino getTreinoPorIndice(int indice) throws IndexOutOfBoundsException{
        try{
            return this.treinos.get(indice);
        }catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException();
        }
    }
    
    public List<Treino> getTreinos(){
        return this.treinos;
    }
    
    public void setTreinos(List<Treino> treinos){
        this.treinos = treinos;
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

        for (Frequencia frequencia : frequencias) {
            if(dataFim != null) {
    			if(dataFim.isBefore(frequencia.getDia())){
    				break;
    			}
    		}

    		Duration t;
    		if(dataInicio.isBefore(frequencia.getDia())){
                t = frequencia.getHorasDiaria();
                horas = horas.plus(t);
                
                if(anterior == null || !frequencia.getDia().equals(anterior)){
                    dias++;
                }
                
                anterior = frequencia.getDia();
    		}
        }

    	mensagem = "A frequencia do aluno é de " + dias + " dias, com um total de " + horas.toHours() + " horas e " + horas.toMinutes() + " minutos";

    	return mensagem;
    }

    public int getSequencia(){
        return this.frequenciaSequencia;
    }
    
    public void setSequencia(int sequencia){
        this.frequenciaSequencia = sequencia;
    }

    @Override
    public String toString(){
        return super.toString() + "\nAltura  : " + String.format("%.2f", this.altura)  + " metros\nData de nascimento: " + this.dataNascimento;
    }
}
