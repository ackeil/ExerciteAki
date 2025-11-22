package academia;

import treino.Aparelho;
import pessoas.Aluno;
import pessoas.Instrutor;
import util.Validacoes;
import exceptions.*;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")

public class Academia {

	private String nome;
	private Endereco endereco;
	private String telefone;
	private String website;
	private List<HorarioFuncionamento> horariosFuncionamento;
	private List<Aparelho> aparelhos;
	private List<Aluno> alunos;
	private List<Instrutor> instrutores;
	private int ultimoAparelho = 0;
	private int ultimoAluno = 0;
	private int ultimoInstrutor = 0;

	public Academia() {
		this.horariosFuncionamento = new ArrayList<HorarioFuncionamento>();
		this.aparelhos 			   = new ArrayList<Aparelho>();
		this.alunos 			   = new ArrayList<Aluno>();
		this.instrutores		   = new ArrayList<Instrutor>();
	}

	public Academia(String nome, Endereco endereco, String telefone, String website) {
		this();
		this.nome 				   = nome;
		this.endereco			   = endereco;
		this.telefone 			   = telefone;
		this.website 			   = website;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		try {
			if(Validacoes.validaString(nome)) this.nome = nome;
		} catch (EmptyFieldException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		try {
			if(Validacoes.validaString(telefone)) this.telefone = telefone;
		} catch (EmptyFieldException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public String getWebsite() {
		return website;
	}
	
	public void setWebsite(String website)
	{
		try {
			if(Validacoes.validaString(website)) this.website = website;
		} catch (EmptyFieldException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public List<HorarioFuncionamento> getHorariosFuncionamento() {
		return this.horariosFuncionamento;
	}
	
	public void setHorariosFuncionamento(List<HorarioFuncionamento> horarios) {
		this.horariosFuncionamento = horarios;
	}
	
	public HorarioFuncionamento getHorarioFuncionamento(int index) throws IndexOutOfBoundsException{
	    try {
	    	return this.horariosFuncionamento.get(index);
	    }catch(IndexOutOfBoundsException e) {
	    	throw new IndexOutOfBoundsException();
	    }
	}
	
	public void setHorarioFuncionamento(int index, HorarioFuncionamento nHorario)
	{
		if(index >= 0 && index < 7)
		{
			this.horariosFuncionamento.add(index, nHorario);
		}
	}

	public List<Aparelho> getAparelhos() {
		return aparelhos;
	}
	
	public void setAparelhos(List<Aparelho> aparelhos) {
		this.aparelhos = aparelhos;
	}
	
	public void addAparelho(Aparelho nAparelho){
		this.aparelhos.add(nAparelho);
	}
	
	public Aparelho buscarAparelhoPorCodigo(int ID) {
        if (aparelhos.size() <= ID) {
	        return aparelhos.get(ID);
	    }
	    return null;
	}

	public Aparelho buscarAparelhoPorNome(String nome) {
	    if (nome.isEmpty() || nome.isBlank()){
			return null;
		}
	    
		Aparelho auxAparelho = null;
		nome = nome.trim();

		for (Aparelho aparelho : aparelhos) {
			if(aparelho.getNome().trim().equalsIgnoreCase(nome)){
				auxAparelho = aparelho;
				break;
			}
		}

	    return auxAparelho;
	}
	
	public boolean removerAparelho(int ID) throws IndexOutOfBoundsException{
		try{
			aparelhos.remove(ID);
		}catch(IndexOutOfBoundsException e){
			throw new IndexOutOfBoundsException();
		}

	    return true;
	}
	
	public boolean alterarAparelho(int codigo, String novoNome, String novaDescricao, String novaFuncao) {
        Aparelho aparelho = buscarAparelhoPorCodigo(codigo);
        if (aparelho == null){
			return false;
		}
        
        if (!novoNome.isEmpty() && !novoNome.isBlank()) {
            aparelho.setNome(novoNome);
        }
        if (!novaDescricao.isEmpty() && !novaDescricao.isBlank()) {
            aparelho.setDescricao(novaDescricao);
        }
        if (!novaFuncao.isBlank() && !novaFuncao.isEmpty()) {
            aparelho.setFuncao(novaFuncao);
        }
        
        return true;
    }
	
	public int getQuantAparelhos(){
		return this.ultimoAparelho;
	}
	
	public void setQuantAparelhos(int quantAparelhos){
		this.ultimoAparelho = quantAparelhos;
	}
	
	public void listarAparelhos() {
        System.out.println("\n═══ APARELHOS CADASTRADOS ═══\n");
        if (ultimoAparelho == 0) {
            System.out.println("(Nenhum aparelho cadastrado)");
			return;
        }

		for (Aparelho aparelho : aparelhos) {
			System.out.println(aparelho.toString());
		}

        System.out.println("\nTotal: " + ultimoAparelho + ".");
    }
	
	public List<Aparelho> buscaAparelhosLista(String nome) {
        if (nome.isEmpty() || nome.isBlank()) {
        	return null;
        }
        
        List<Aparelho> aparelhosEncontrados = new ArrayList<Aparelho>();
	    
	    String nomeBusca = nome.trim().toLowerCase();

		for (Aparelho aparelho : aparelhos) {
			if (aparelho.getNome().toLowerCase().contains(nomeBusca)) {
	        	aparelhosEncontrados.add(aparelho);
	        }
		}
	   
	    return aparelhosEncontrados;
	}

	public boolean addAluno(Aluno novoAluno) {
	    if(novoAluno == null) {
	        System.out.println("Aluno não pode ser nulo!");
	        return false;
	    }
	    
		this.alunos.add(novoAluno);
		return true;
	}

	public Aluno buscarAlunoPorNome(String nome) {
	    if(nome.isBlank() || nome.isEmpty()) {
	        return null;
	    }
	    
	    String nomeBusca = nome.trim().toLowerCase();
		for (Aluno aluno : alunos) {
			if(aluno.getNome().toLowerCase().contains(nomeBusca)) {
	            return aluno;
	        }
		}

	    return null;
	}

	public Aluno buscarAlunoPorEmail(String email) {
	    if(email == null || email.trim().isEmpty()) {
	        return null;
	    }
	    
	    String emailBusca = email.trim().toLowerCase();
		for (Aluno aluno : alunos) {
			if(aluno.getEmail().toLowerCase().contains(emailBusca)) {
	            return aluno;
	        }
		}

	    return null;
	}

	public Aluno buscarAlunoPorIndice(int indice) throws IndexOutOfBoundsException{
		try{
			return alunos.get(indice);
		}catch(IndexOutOfBoundsException e){
			throw new IndexOutOfBoundsException();
		}
	}

	public boolean removerAluno(String email) {
	    if(email.isBlank() || email.isEmpty()) {
	        return false;
	    }

	    String emailBusca = email.trim();

		for (Aluno aluno : alunos) {
			if(aluno.getEmail().equalsIgnoreCase(emailBusca)) {
	            alunos.remove(aluno);
	            return true;
	        }
		}

	    return false;
	}

	public boolean alterarAluno(String emailAtual, String novoNome, String novoEmail, 
	                            String novoTelefone, String novaDataNascimento, float novaAltura) {
	    Aluno aluno = buscarAlunoPorEmail(emailAtual);
	    if(aluno == null) {
	        System.out.println("Aluno não encontrado!");
	        return false;
	    }
	    
	    if(!novoNome.isBlank() && !novoNome.isEmpty()) {
	        aluno.setNome(novoNome);
	    }
	    
	    if(!novoEmail.isBlank() && !novoEmail.isEmpty()) {
	        aluno.setEmail(novoEmail);
	    }
	    
	    if(!novoTelefone.isBlank() && !novoTelefone.isEmpty()) {
	        aluno.setTelefone(novoTelefone);
	    }
	    
	    if(!novaDataNascimento.isBlank() && !novaDataNascimento.isEmpty()) {
	        aluno.setDataNascimento(novaDataNascimento);
	    }
	    
	    if(novaAltura > 0) {
	        aluno.setAltura(novaAltura);
	    }
	    
	    return true;
	}

	public void listarAlunos() {
	    System.out.println("\n═══ ALUNOS CADASTRADOS ═══\n");
	    if(ultimoAluno == 0) {
	        System.out.println("(Nenhum aluno cadastrado)");
			return;
	    }

		int cont = 0;
		for (Aluno aluno : alunos) {
			cont++;
			System.out.println(cont+ ")" + aluno.toString() + "\n");
		}
		
	    System.out.println("\nTotal: " + cont + ".");
	}

	public int getQuantAlunos() {
	    return this.ultimoAluno;
	}
	
	public void setQuantAlunos(int quantAlunos) {
	    this.ultimoAluno = quantAlunos;
	}

	public List<Aluno> getAlunos() {
	    return alunos;
	}
	
	public void setAlunos(List<Aluno> alunos) {
	    this.alunos = alunos;
	}
	
	public boolean addInstrutor(Instrutor novoInstrutor) {
	    if(novoInstrutor == null) {
	        System.out.println("Instrutor não pode ser nulo!");
	        return false;
	    }
	    
		this.instrutores.add(novoInstrutor);
		return true;
	}

	public Instrutor buscarInstrutorPorNome(String nome) {
	    if(nome == null || nome.trim().isEmpty()) {
	        return null;
	    }
	    
	    String nomeBusca = nome.trim().toLowerCase();
		for (Instrutor instrutor : instrutores) {
			if(instrutor.getNome().toLowerCase().contains(nomeBusca)){
				return instrutor;
			}
		}

	    return null;
	}

	public Instrutor buscarInstrutorPorEmail(String email) {
	    if(email.isBlank() || email.isEmpty()) {
	        return null;
	    }
	    
	    String emailBusca = email.trim().toLowerCase();
		for (Instrutor instrutor : instrutores) {
			if(instrutor.getEmail().toLowerCase().contains(emailBusca)) {
	            return instrutor;
	        }
		}

	    return null;
	}

	public Instrutor buscarInstrutorPorIndice(int indice) throws IndexOutOfBoundsException{
		try{
			return instrutores.get(indice);
		}catch(IndexOutOfBoundsException e){
			throw new IndexOutOfBoundsException();
		}
	}

	public boolean removerInstrutor(String email) {
	    if(email.isBlank() || email.isEmpty()) {
	        return false;
	    }
	    
	    String emailBusca = email.trim();
	    
		for (Instrutor instrutor : instrutores) {
			if(instrutor.getEmail().equalsIgnoreCase(emailBusca)) {
				instrutores.remove(instrutor);
	            return true;
	        }
		}

	    return false;
	}

	public boolean alterarInstrutor(String emailAtual, String novoNome, String novoEmail, 
	                               String novoTelefone, String novaFormacao) {
	    Instrutor instrutor = buscarInstrutorPorEmail(emailAtual);
	    if(instrutor == null) {
	        System.out.println("Instrutor não encontrado!");
	        return false;
	    }

	    if(!novoNome.isBlank() && !novoNome.isEmpty()) {
	        instrutor.setNome(novoNome);
	    }

	    if(!novoEmail.isBlank() && !novoEmail.isEmpty()) {
	        instrutor.setEmail(novoEmail);
	    }

	    if(!novoTelefone.isBlank() && !novoTelefone.isEmpty()) {
	        instrutor.setTelefone(novoTelefone);
	    }

	    if(!novaFormacao.isBlank() && !novaFormacao.isEmpty()) {
	        instrutor.setFormacao(novaFormacao);
	    }

	    return true;
	}

	public void listarInstrutores() {
	    System.out.println("\n═══ INSTRUTORES CADASTRADOS ═══\n");
	    if(ultimoInstrutor == 0) {
	        System.out.println("(Nenhum instrutor cadastrado)");
			return;
	    }

		int count = 0;
		for (Instrutor instrutor : instrutores) {
			count++;
			System.out.println(count + ") " + instrutor.toString() + "\n");
		}

	    System.out.println("\nTotal: " + count + ".");
	}

	public int getQuantInstrutores() {
	    return this.ultimoInstrutor;
	}
	
	public void setQuantInstrutores(int quantInstrutores) {
	    this.ultimoInstrutor = quantInstrutores;
	}

	public List<Instrutor> getInstrutores() {
	    return instrutores;
	}
	
	public void setInstrutores(List<Instrutor> instrutores) {
	    this.instrutores = instrutores;
	}
	
	@Override
    public String toString() {
        return "Academia: " + nome + "\n" +
               "Endereço: " + endereco + "\n" +
               "Telefone: " + telefone + "\n" +
               "Website: " + website + "\n" +
               "Aparelhos: " + ultimoAparelho;
    }
}
