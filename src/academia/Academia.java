package academia;

import treino.Aparelho;
import pessoas.Aluno;
import pessoas.Instrutor;
import util.Validacoes;
import exceptions.*;

public class Academia {
	
	public static final int MAX_APARELHOS = 254;
	public static final int MAX_ALUNOS = 254;
	public static final int MAX_INSTRUTORES = 254;
	
	private String nome;
	private Endereco endereco;
	private String telefone;
	private String website;
	private HorarioFuncionamento[] horariosFuncionamento;
	private Aparelho[] aparelhos;
	private Aluno[] alunos;
	private Instrutor[] instrutores;
	private int ultimoAparelho = 0;
	private int ultimoAluno = 0;
	private int ultimoInstrutor = 0;

	public Academia() {}

	public Academia(String nome, Endereco endereco, String telefone, String website) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.website = website;
		this.horariosFuncionamento = new HorarioFuncionamento[7];
		this.aparelhos = new Aparelho[MAX_APARELHOS];
		this.alunos = new Aluno[MAX_ALUNOS];
		this.instrutores = new Instrutor[MAX_INSTRUTORES];
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

	public HorarioFuncionamento[] getHorariosFuncionamento() {
		return horariosFuncionamento;
	}
	
	public HorarioFuncionamento getHorarioFuncionamento(int index) {
	    if(index >= 0 && index < 7) {  
	        return this.horariosFuncionamento[index];
	    }
	    return null;
	}
	
	public void setHorarioFuncionamento(int index, HorarioFuncionamento nHorario)
	{
		if(index >= 0 && index < 7)
		{
			this.horariosFuncionamento[index] = nHorario;
		}
	}

	public Aparelho[] getAparelhos() {
		return aparelhos;
	}
	
	public void addAparelho(Aparelho nAparelho)
	{
		if(this.ultimoAparelho < MAX_APARELHOS)
		{
			this.aparelhos[this.ultimoAparelho++] = nAparelho;
		}
	}
	
	public Aparelho buscarAparelhoPorCodigo(int ID) {
	    for (int i = 0; i < ultimoAparelho; i++) {
	        if (aparelhos[i].getID() == ID) {
	            return aparelhos[i];
	        }
	    }
	    return null;
	}

	public Aparelho buscarAparelhoPorNome(String nome) {
	    if (nome == null || nome.trim().isEmpty()) return null;
	    
	    String nomeBusca = nome.trim().toLowerCase();
	    for (int i = 0; i < ultimoAparelho; i++) {
	        if (aparelhos[i].getNome().toLowerCase().contains(nomeBusca)) {
	            return aparelhos[i];
	        }
	    }
	    return null;
	}
	
	public boolean removerAparelho(int ID) {
	    for (int i = 0; i < ultimoAparelho; i++) {
	        if (aparelhos[i].getID() == ID) {
	            // Shift
	            for (int j = i; j < ultimoAparelho - 1; j++) {
	                aparelhos[j] = aparelhos[j + 1];
	            }
	            aparelhos[--ultimoAparelho] = null;
	            return true;
	        }
	    }
	    return false;
	}
	
	public boolean alterarAparelho(int codigo, String novoNome, String novaDescricao, String novaFuncao) {
        Aparelho aparelho = buscarAparelhoPorCodigo(codigo);
        if (aparelho == null) return false;
        
        if (novoNome != null && !novoNome.trim().isEmpty()) {
            aparelho.setNome(novoNome);
        }
        if (novaDescricao != null) {
            aparelho.setDescricao(novaDescricao);
        }
        if (novaFuncao != null) {
            aparelho.setFuncao(novaFuncao);
        }
        
        return true;
    }
	
	public int getQuantAparelhos()
	{
		return this.ultimoAparelho;
	}
	
	public void listarAparelhos() {
        System.out.println("\n═══ APARELHOS CADASTRADOS ═══\n");
        if (ultimoAparelho == 0) {
            System.out.println("(Nenhum aparelho cadastrado)");
        } else {
            for (int i = 0; i < ultimoAparelho; i++) {
                System.out.println(aparelhos[i].toString());
            }
        }
        System.out.println("\nTotal: " + ultimoAparelho + "/" + MAX_APARELHOS);
    }
	
	public Aparelho[] buscaAparelhosLista(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
        	return null;
        }
        
        Aparelho[] aparelhosEncontrados = new Aparelho[MAX_APARELHOS];
        int posicaoEncontrada = 0;
	    
	    String nomeBusca = nome.trim().toLowerCase();
	    for (int i = 0; i < ultimoAparelho; i++) {
	        if (aparelhos[i].getNome().toLowerCase().contains(nomeBusca)) {
	        	aparelhosEncontrados[posicaoEncontrada] = aparelhos[i];
	        	posicaoEncontrada++;
	        }
	    }
	   
	    return aparelhosEncontrados;
	}

	public boolean addAluno(Aluno novoAluno) {
	    if(novoAluno == null) {
	        System.out.println("Aluno não pode ser nulo!");
	        return false;
	    }
	    
	    if(this.ultimoAluno < MAX_ALUNOS) {
	        this.alunos[this.ultimoAluno++] = novoAluno;
	        return true;
	    } else {
	        System.out.println("Capacidade máxima de alunos atingida!");
	        return false;
	    }
	}

	public Aluno buscarAlunoPorNome(String nome) {
	    if(nome == null || nome.trim().isEmpty()) {
	        return null;
	    }
	    
	    String nomeBusca = nome.trim().toLowerCase();
	    for(int i = 0; i < ultimoAluno; i++) {
	        if(alunos[i].getNome().toLowerCase().contains(nomeBusca)) {
	            return alunos[i];
	        }
	    }
	    return null;
	}

	public Aluno buscarAlunoPorEmail(String email) {
	    if(email == null || email.trim().isEmpty()) {
	        return null;
	    }
	    
	    String emailBusca = email.trim().toLowerCase();
	    for(int i = 0; i < ultimoAluno; i++) {
	        if(alunos[i].getEmail().toLowerCase().contains(emailBusca)) {
	            return alunos[i];
	        }
	    }
	    return null;
	}

	public Aluno buscarAlunoPorIndice(int indice) {
	    if(indice >= 0 && indice < ultimoAluno) {
	        return alunos[indice];
	    }
	    return null;
	}

	public boolean removerAluno(String email) {
	    if(email == null || email.trim().isEmpty()) {
	        return false;
	    }
	    
	    String emailBusca = email.trim().toLowerCase();
	    
	    for(int i = 0; i < ultimoAluno; i++) {
	        if(alunos[i].getEmail().toLowerCase().equals(emailBusca)) {
	            for(int j = i; j < ultimoAluno - 1; j++) {
	                alunos[j] = alunos[j + 1];
	            }
	            alunos[--ultimoAluno] = null;
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
	    
	    if(novoNome != null && !novoNome.trim().isEmpty()) {
	        aluno.setNome(novoNome);
	    }
	    
	    if(novoEmail != null && !novoEmail.trim().isEmpty()) {
	        aluno.setEmail(novoEmail);
	    }
	    
	    if(novoTelefone != null && !novoTelefone.trim().isEmpty()) {
	        aluno.setTelefone(novoTelefone);
	    }
	    
	    if(novaDataNascimento != null && !novaDataNascimento.trim().isEmpty()) {
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
	    } else {
	        for(int i = 0; i < ultimoAluno; i++) {
	            System.out.println((i + 1) + ")\n" + alunos[i].toString() + "\n");
	        }
	    }
	    System.out.println("\nTotal: " + ultimoAluno + "/" + MAX_ALUNOS);
	}

	public int getQuantAlunos() {
	    return this.ultimoAluno;
	}

	public Aluno[] getAlunos() {
	    Aluno[] alunosValidos = new Aluno[ultimoAluno];
	    System.arraycopy(alunos, 0, alunosValidos, 0, ultimoAluno);
	    return alunosValidos;
	}
	
	public boolean addInstrutor(Instrutor novoInstrutor) {
	    if(novoInstrutor == null) {
	        System.out.println("Instrutor não pode ser nulo!");
	        return false;
	    }
	    
	    if(this.ultimoInstrutor < MAX_INSTRUTORES) {
	        this.instrutores[this.ultimoInstrutor++] = novoInstrutor;
	        return true;
	    } else {
	        System.out.println("Capacidade máxima de instrutores atingida!");
	        return false;
	    }
	}

	public Instrutor buscarInstrutorPorNome(String nome) {
	    if(nome == null || nome.trim().isEmpty()) {
	        return null;
	    }
	    
	    String nomeBusca = nome.trim().toLowerCase();
	    for(int i = 0; i < ultimoInstrutor; i++) {
	        if(instrutores[i].getNome().toLowerCase().contains(nomeBusca)) {
	            return instrutores[i];
	        }
	    }

	    return null;
	}

	public Instrutor buscarInstrutorPorEmail(String email) {
	    if(email == null || email.trim().isEmpty()) {
	        return null;
	    }
	    
	    String emailBusca = email.trim().toLowerCase();
	    for(int i = 0; i < ultimoInstrutor; i++) {
	        if(instrutores[i].getEmail().toLowerCase().contains(emailBusca)) {
	            return instrutores[i];
	        }
	    }
	    return null;
	}

	public Instrutor buscarInstrutorPorIndice(int indice) {
	    if(indice >= 0 && indice < ultimoInstrutor) {
	        return instrutores[indice];
	    }
	    return null;
	}

	public boolean removerInstrutor(String email) {
	    if(email == null || email.trim().isEmpty()) {
	        return false;
	    }
	    
	    String emailBusca = email.trim().toLowerCase();
	    
	    for(int i = 0; i < ultimoInstrutor; i++) {
	        if(instrutores[i].getEmail().toLowerCase().equals(emailBusca)) {
	            for(int j = i; j < ultimoInstrutor - 1; j++) {
	                instrutores[j] = instrutores[j + 1];
	            }
	            instrutores[--ultimoInstrutor] = null;
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
	    
	    if(novoNome != null && !novoNome.trim().isEmpty()) {
	        instrutor.setNome(novoNome);
	    }
	    
	    if(novoEmail != null && !novoEmail.trim().isEmpty()) {
	        instrutor.setEmail(novoEmail);
	    }
	    
	    if(novoTelefone != null && !novoTelefone.trim().isEmpty()) {
	        instrutor.setTelefone(novoTelefone);
	    }
	    
	    if(novaFormacao != null && !novaFormacao.trim().isEmpty()) {
	        instrutor.setFormacao(novaFormacao);
	    }
	    
	    return true;
	}

	public void listarInstrutores() {
	    System.out.println("\n═══ INSTRUTORES CADASTRADOS ═══\n");
	    if(ultimoInstrutor == 0) {
	        System.out.println("(Nenhum instrutor cadastrado)");
	    } else {
	        for(int i = 0; i < ultimoInstrutor; i++) {
	            System.out.println((i + 1) + ")\n" + instrutores[i].toString() + "\n");
	        }
	    }
	    System.out.println("\nTotal: " + ultimoInstrutor + "/" + MAX_INSTRUTORES);
	}

	public int getQuantInstrutores() {
	    return this.ultimoInstrutor;
	}

	public Instrutor[] getInstrutores() {
	    Instrutor[] instrutoresValidos = new Instrutor[ultimoInstrutor];
	    System.arraycopy(instrutores, 0, instrutoresValidos, 0, ultimoInstrutor);
	    return instrutoresValidos;
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
