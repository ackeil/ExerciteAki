package principal;

import java.io.File;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import pessoas.Aluno;
import pessoas.Instrutor;
import academia.Academia;
import academia.Endereco;
import academia.HorarioFuncionamento;
import treino.Aparelho;
import treino.Exercicio;
import treino.Treino;
import util.DiaDaSemana;
import util.Validacoes;
import util.ManipulacaoArquivos;
import historico.Historico;

import exceptions.*;

public class Principal {
	
	private static final String USERNAME_ADMIN = "admin";
	private static final String SENHA_ADMIN = "1234";
	private static final String caminho_arquivo = "dados/DadosSalvos.txt";

	private ObjectMapper mapper;
	
	public Principal() {
		this.mapper = new ObjectMapper();
	}
	
	private void dadosDeTeste(Academia academia) {
	    System.out.println("--- CADASTRANDO APARELHOS ---\n");
	    
	    Aparelho supino = new Aparelho(
	        "Supino Reto",
	        "Banco horizontal para desenvolvimento do peitoral",
	        "Peitoral, tríceps e ombros"
	    );
	    academia.addAparelho(supino);
	    System.out.println("Aparelho cadastrado: " + supino.toString());
	    
	    Aparelho legPress = new Aparelho(
	        "Leg Press 45°",
	        "Plataforma inclinada para fortalecimento de pernas",
	        "Quadríceps, glúteos e posterior"
	    );
	    academia.addAparelho(legPress);
	    System.out.println("Aparelho cadastrado: " + legPress.toString());
	    
	    Aparelho esteira = new Aparelho(
	        "Esteira",
	        "Equipamento de cardio para corrida/caminhada",
	        "Sistema cardiovascular"
	    );
	    academia.addAparelho(esteira);
	    System.out.println("Aparelho cadastrado: " + esteira.toString());
	    
	    System.out.println("\nTotal de aparelhos: " + academia.getQuantAparelhos());
	    
	    System.out.println("\n--- CADASTRANDO INSTRUTORES ---\n");
	    
	    Instrutor instrutor1 = new Instrutor(
	        "Carlos Silva",
	        "carlos.silva@exerciteaki.com.br",
	        "(54) 99111-1111",
	        "Educação Física",
	        "carlos",
	        "1234"
	    );
	    academia.addInstrutor(instrutor1);
	    System.out.println("Instrutor cadastrado: " + instrutor1.toString());
	    System.out.println("   Username: carlos | Senha: 1234\n");
	    
	    Instrutor instrutor2 = new Instrutor(
	        "Maria Santos",
	        "maria.santos@exerciteaki.com.br",
	        "(54) 99222-2222",
	        "Fisioterapia",
	        "maria",
	        "1234"
	    );
	    academia.addInstrutor(instrutor2);
	    System.out.println("Instrutor cadastrado: " + instrutor2.toString());
	    System.out.println("   Username: maria | Senha: 1234\n");
	    
	    System.out.println("Total de instrutores: " + academia.getQuantInstrutores());
	    
	    System.out.println("\n--- CADASTRANDO ALUNOS ---\n");
	    
	    Aluno aluno1 = new Aluno(
	        "João Pedro",
	        "joao.pedro@email.com.br",
	        "(54) 99333-3333",
	        "15/03/2000",
	        1.75f,
	        "joao",
	        "1234"
	    );
	    academia.addAluno(aluno1);
	    System.out.println("Aluno cadastrado: " + aluno1.toString());
	    System.out.println("   Username: joao | Senha: 1234\n");
	    
	    Aluno aluno2 = new Aluno(
	        "Ana Carolina",
	        "ana.carolina@email.com.br",
	        "(54) 99444-4444",
	        "22/07/1998",
	        1.65f,
	        "ana",
	        "1234"
	    );
	    academia.addAluno(aluno2);
	    System.out.println("Aluno cadastrado: " + aluno2.toString());
	    System.out.println("   Username: ana | Senha: 1234\n");
	    
	    Aluno aluno3 = new Aluno(
	        "Lucas Ferreira",
	        "lucas.ferreira@email.com.br",
	        "(54) 99555-5555",
	        "10/11/2001",
	        1.80f,
	        "lucas",
	        "1234"
	    );
	    academia.addAluno(aluno3);
	    System.out.println("Aluno cadastrado: " + aluno3.toString());
	    System.out.println("   Username: lucas | Senha: 1234\n");
	    
	    Aluno aluno4 = new Aluno(
	        "Beatriz Oliveira",
	        "beatriz.oliveira@email.com.br",
	        "(54) 99666-6666",
	        "05/04/1999",
	        1.68f,
	        "beatriz",
	        "1234"
	    );
	    academia.addAluno(aluno4);
	    System.out.println("Aluno cadastrado: " + aluno4.toString());
	    System.out.println("   Username: beatriz | Senha: 1234\n");
	    
	    Aluno aluno5 = new Aluno(
	        "Rafael Costa",
	        "rafael.costa@email.com.br",
	        "(54) 99777-7777",
	        "18/09/2002",
	        1.78f,
	        "rafael",
	        "1234"
	    );
	    academia.addAluno(aluno5);
	    System.out.println("Aluno cadastrado: " + aluno5.toString());
	    System.out.println("   Username: rafael | Senha: 1234\n");
	    
	    System.out.println("Total de alunos: " + academia.getQuantAlunos());
	    
	    System.out.println("Aparelhos: " + academia.getQuantAparelhos());
	    System.out.println("Instrutores: " + academia.getQuantInstrutores());
	    System.out.println("Alunos: " + academia.getQuantAlunos());
	    System.out.println("\n--- CREDENCIAIS DE ACESSO ---");
	    System.out.println("Admin: username='admin' | senha='1234'");
	    System.out.println("\nInstrutores:");
	    System.out.println("  - username='carlos' | senha='1234'");
	    System.out.println("  - username='maria' | senha='1234'");
	    System.out.println("\nAlunos:");
	    System.out.println("  - username='joao' | senha='1234'");
	    System.out.println("  - username='ana' | senha='1234'");
	    System.out.println("  - username='lucas' | senha='1234'");
	    System.out.println("  - username='beatriz' | senha='1234'");
	    System.out.println("  - username='rafael' | senha='1234'");
	    System.out.println("═══════════════════════════════════════\n");
	}
	
	public static void main(String[] args) throws Exception {
	    Scanner sc = new Scanner(System.in);
	    Academia academia = criarAcademia();
	    
	    Principal p = new Principal();
	    
	    File f = new File(caminho_arquivo);
	    try {
	    
	    	if(!f.exists()) {
	    		if(!f.createNewFile()) {
	    			System.out.println("Erro na leitura do arquivo: \"Dados Salvos\".");
	    		}
	    	}
	    }catch(Exception e) {
	    	System.out.println(e.getMessage());
	    }

		ManipulacaoArquivos arq = new ManipulacaoArquivos();
		academia = arq.leArquivoJSON(caminho_arquivo);
		
		if(academia == null) {
		    System.out.println("\n1  AVISO: Não foi possível carregar dados do arquivo.");
		    System.out.println("Criando academia nova com dados de teste...\n");
		    academia = criarAcademia();
		    p.dadosDeTeste(academia);
		}

		/*
		p.dadosDeTeste(academia); 
		*/
	    
	    System.out.println("═══════════════════════════════════════");
	    System.out.println("    BEM-VINDO AO SISTEMA EXERCITEAKI    ");
	    System.out.println("═══════════════════════════════════════");
	    
	    boolean continuar = true;
	    
	    while(continuar) {
	        continuar = p.menuPrincipal(sc, academia);
	    }
	    
	    System.out.println("\nObrigado por usar o sistema ExerciteAki!");
	    sc.close();
	}
	
	public boolean menuPrincipal(Scanner sc, Academia academia) {
	    System.out.println("\n═══ MENU PRINCIPAL ═══");
	    System.out.println("[1] - Login");
	    System.out.println("[0] - Sair do Sistema");
	    System.out.print("Escolha uma opção: ");
	    
	    int opcao = -1;
	    try {
	        opcao = sc.nextInt();
	        sc.nextLine();
	    } catch(Exception e) {
	        System.out.println("Erro: Digite apenas números!");
	        sc.nextLine();
	        return true;
	    }
	    
	    switch(opcao) {
	        case 1:
	            realizarLogin(sc, academia);
	            break;
	        case 0:
	            return false;
	        default:
	            System.out.println("Opção inválida!");
	    }
	    
	    return true;
	}

	public static void realizarLogin(Scanner sc, Academia academia) {
	    System.out.println("\n═══ LOGIN ═══");
	    System.out.print("Username: ");
	    String username = sc.nextLine();
	    
	    System.out.print("Senha: ");
	    String senha = sc.nextLine();
	    
	    // Se admin
	    if(verificaLoginAdmin(username, senha)) {
	        System.out.println("\nLogin realizado com sucesso!");
	        System.out.println("Bem-vindo, Administrador!");
	        menuAdministrador(sc, academia);
	        return;
	    }
	    
	    // Se instrutor
	    for(int i = 0; i < academia.getQuantInstrutores(); i++) {
	        Instrutor instrutor = academia.buscarInstrutorPorIndice(i);
	        if(instrutor != null && instrutor.getLogin() != null) {
	            if(instrutor.getLogin().realizaLogin(username, senha)) {
	                System.out.println("\nLogin realizado com sucesso!");
	                System.out.println("Bem-vindo, " + instrutor.getNome() + "!");
	                menuInstrutor(sc, academia, instrutor);
	                return;
	            }
	        }
	    }
	    
	    // Se aluno
	    for(int i = 0; i < academia.getQuantAlunos(); i++) {
	        Aluno aluno = academia.buscarAlunoPorIndice(i);
	        if(aluno != null && aluno.getLogin() != null) {
	            if(aluno.getLogin().realizaLogin(username, senha)) {
	                System.out.println("\nLogin realizado com sucesso!");
	                System.out.println("Bem-vindo, " + aluno.getNome() + "!");
	                menuAluno(sc, academia, aluno);
	                return;
	            }
	        }
	    }
	    
	    System.out.println("\nUsuário e/ou senha inválidos!");
	}
	
	public static void menuAdministrador(Scanner sc, Academia academia) {
	    boolean continuar = true;
	    
	    while(continuar) {
	        System.out.println("\n═══ MENU ADMINISTRADOR ═══");
	        System.out.println("[1] - Gerenciar Academia");
	        System.out.println("[2] - Gerenciar Aparelhos");
	        System.out.println("[3] - Gerenciar Instrutores");
	        System.out.println("[4] - Gerenciar Alunos");
	        System.out.println("[0] - Logout");
	        System.out.print("Escolha uma opção: ");
	        
	        int opcao = -1;
	        try {
	            opcao = sc.nextInt();
	            sc.nextLine();
	        } catch(Exception e) {
	            System.out.println("Erro: Digite apenas números!");
	            sc.nextLine();
	            continue;
	        }
	        
	        switch(opcao) {
	            case 1:
	                menuGerenciarAcademia(sc, academia);
	                break;
	            case 2:
	                menuGerenciarAparelhos(sc, academia);
	                break;
	            case 3:
	                menuGerenciarInstrutores(sc, academia);
	                break;
	            case 4:
	                menuGerenciarAlunos(sc, academia);
	                break;
	            case 0:
	                System.out.println("Logout realizado com sucesso!");
	                continuar = false;
	                break;
	            default:
	                System.out.println("Opção inválida!");
	        }
	    }
	}
	
	public static void menuGerenciarAcademia(Scanner sc, Academia academia) {
	    boolean continuar = true;
	    
	    while(continuar) {
	        System.out.println("\n═══ GERENCIAR ACADEMIA ═══");
	        System.out.println("[1] - Cadastrar/Alterar Dados da Academia");
	        System.out.println("[2] - Consultar Dados da Academia");
	        System.out.println("[3] - Definir Horários de Funcionamento");
	        System.out.println("[4] - Consultar Horários");
	        System.out.println("[0] - Voltar");
	        System.out.print("Escolha uma opção: ");
	        
	        int opcao = -1;
	        try {
	            opcao = sc.nextInt();
	            sc.nextLine();
	        } catch(Exception e) {
	            System.out.println("Erro: Digite apenas números!");
	            sc.nextLine();
	            continue;
	        }
	        
	        switch(opcao) {
	            case 1:
	                cadastrarAcademia(sc, academia);
	                break;
	            case 2:
	                consultarAcademia(academia);
	                break;
	            case 3:
	                definirHorarios(sc, academia);
	                break;
	            case 4:
	                consultarHorarios(academia);
	                break;
	            case 0:
	                continuar = false;
	                break;
	            default:
	                System.out.println("Opção inválida!");
	        }
	    }
	}
	
	public static void menuGerenciarAparelhos(Scanner sc, Academia academia) {
	    boolean continuar = true;
	    
	    while(continuar) {
	        System.out.println("\n═══ GERENCIAR APARELHOS ═══");
	        System.out.println("[1] - Cadastrar Aparelho");
	        System.out.println("[2] - Consultar Aparelho");
	        System.out.println("[3] - Alterar Aparelho");
	        System.out.println("[4] - Remover Aparelho");
	        System.out.println("[5] - Listar Todos os Aparelhos");
	        System.out.println("[0] - Voltar");
	        System.out.print("Escolha uma opção: ");
	        
	        int opcao = -1;
	        try {
	            opcao = sc.nextInt();
	            sc.nextLine();
	        } catch(Exception e) {
	            System.out.println("Erro: Digite apenas números!");
	            sc.nextLine();
	            continue;
	        }
	        
	        switch(opcao) {
	            case 1:
	                cadastrarAparelho(sc, academia);
	                break;
	            case 2:
	                consultarAparelho(sc, academia);
	                break;
	            case 3:
	                alterarAparelho(sc, academia);
	                break;
	            case 4:
	                removerAparelho(sc, academia);
	                break;
	            case 5:
	                listarAparelhos(academia);
	                break;
	            case 0:
	                continuar = false;
	                break;
	            default:
	                System.out.println("Opção inválida!");
	        }
	    }
	}
	
	public static void menuGerenciarInstrutores(Scanner sc, Academia academia) {
	    boolean continuar = true;
	    
	    while(continuar) {
	        System.out.println("\n═══ GERENCIAR INSTRUTORES ═══");
	        System.out.println("[1] - Cadastrar Instrutor");
	        System.out.println("[2] - Consultar Instrutor");
	        System.out.println("[3] - Alterar Instrutor");
	        System.out.println("[4] - Remover Instrutor");
	        System.out.println("[5] - Listar Todos os Instrutores");
	        System.out.println("[0] - Voltar");
	        System.out.print("Escolha uma opção: ");
	        
	        int opcao = -1;
	        try {
	            opcao = sc.nextInt();
	            sc.nextLine();
	        } catch(Exception e) {
	            System.out.println("Erro: Digite apenas números!");
	            sc.nextLine();
	            continue;
	        }
	        
	        switch(opcao) {
	            case 1:
	                cadastrarInstrutor(sc, academia);
	                break;
	            case 2:
	                consultarInstrutor(sc, academia);
	                break;
	            case 3:
	                alterarInstrutor(sc, academia);
	                break;
	            case 4:
	                removerInstrutor(sc, academia);
	                break;
	            case 5:
	                academia.listarInstrutores();
	                break;
	            case 0:
	                continuar = false;
	                break;
	            default:
	                System.out.println("Opção inválida!");
	        }
	    }
	}
	
	public static void menuGerenciarAlunos(Scanner sc, Academia academia) {
	    boolean continuar = true;
	    
	    while(continuar) {
	        System.out.println("\n═══ GERENCIAR ALUNOS ═══");
	        System.out.println("[1] - Cadastrar Aluno");
	        System.out.println("[2] - Consultar Aluno");
	        System.out.println("[3] - Alterar Aluno");
	        System.out.println("[4] - Remover Aluno");
	        System.out.println("[5] - Listar Todos os Alunos");
	        System.out.println("[0] - Voltar");
	        System.out.print("Escolha uma opção: ");
	        
	        int opcao = -1;
	        try {
	            opcao = sc.nextInt();
	            sc.nextLine();
	        } catch(Exception e) {
	            System.out.println("Erro: Digite apenas números!");
	            sc.nextLine();
	            continue;
	        }
	        
	        switch(opcao) {
	            case 1:
	                cadastrarAluno(sc, academia);
	                break;
	            case 2:
	                consultarAluno(sc, academia);
	                break;
	            case 3:
	                alterarAluno(sc, academia);
	                break;
	            case 4:
	                removerAluno(sc, academia);
	                break;
	            case 5:
	                academia.listarAlunos();
	                break;
	            case 0:
	                continuar = false;
	                break;
	            default:
	                System.out.println("Opção inválida!");
	        }
	    }
	}
	
	public static void menuInstrutor(Scanner sc, Academia academia, Instrutor instrutor) {
	    boolean continuar = true;
	    
	    while(continuar) {
	        System.out.println("\n═══ MENU INSTRUTOR ═══");
	        System.out.println("[1] - Cadastrar Aluno");
	        System.out.println("[2] - Consultar Aluno");
	        System.out.println("[3] - Definir Treino para Aluno");
	        System.out.println("[4] - Consultar Treino de Aluno");
	        System.out.println("[5] - Registrar Evolução do Aluno");
	        System.out.println("[6] - Consultar Evolução do Aluno");
	        System.out.println("[7] - Listar Aparelhos Disponíveis");
	        System.out.println("[0] - Logout");
	        System.out.print("Escolha uma opção: ");
	        
	        int opcao = -1;
	        try {
	            opcao = sc.nextInt();
	            sc.nextLine();
	        } catch(Exception e) {
	            System.out.println("Erro: Digite apenas números!");
	            sc.nextLine();
	            continue;
	        }
	        
	        switch(opcao) {
	            case 1:
	                cadastrarAluno(sc, academia);
	                break;
	            case 2:
	                consultarAluno(sc, academia);
	                break;
	            case 3:
	                definirTreinoAluno(sc, academia);
	                break;
	            case 4:
	                consultarTreinoAluno(sc, academia);
	                break;
	            case 5:
	                registrarEvolucaoAluno(sc, academia);
	                break;
	            case 6:
	                consultarEvolucaoAluno(sc, academia);
	                break;
	            case 7:
	                listarAparelhos(academia);
	                break;
	            case 0:
	                System.out.println("Logout realizado com sucesso!");
	                continuar = false;
	                break;
	            default:
	                System.out.println("Opção inválida!");
	        }
	    }
	}
	
	public static void menuAluno(Scanner sc, Academia academia, Aluno aluno) {
	    boolean continuar = true;
	    
	    while(continuar) {
	        System.out.println("\n═══ MENU ALUNO ═══");
	        System.out.println("[1] - Consultar Meu Treino");
	        System.out.println("[2] - Consultar Minha Evolução");
	        System.out.println("[3] - Registrar Frequência (Check-in)");
	        System.out.println("[4] - Consultar Meus Dados");
	        System.out.println("[5] - Consultar Horários da Academia");
	        System.out.println("[0] - Logout");
	        System.out.print("Escolha uma opção: ");
	        
	        int opcao = -1;
	        try {
	            opcao = sc.nextInt();
	        } catch(Exception e) {
	            System.out.println("Erro: Digite apenas números!");
	            continue;
	        }
	        
	        switch(opcao) {
	            case 1:
	                consultarMeuTreino(sc, aluno);
	                break;
	            case 2:
	                consultarMinhaEvolucao(aluno);
	                break;
	            case 3:
	                registrarFrequencia(sc, aluno);
	                break;
	            case 4:
	                System.out.println("\n=== MEUS DADOS ===");
	                System.out.println(aluno.toString());
	                break;
	            case 5:
	                consultarHorarios(academia);
	                break;
	            case 0:
	                System.out.println("Logout realizado com sucesso!");
	                continuar = false;
	                break;
	            default:
	                System.out.println("Opção inválida!");
	        }
	    }
	}
	
	public static void definirTreinoAluno(Scanner sc, Academia academia) {
	    System.out.println("\n═══ DEFINIR TREINO PARA ALUNO ═══");
	    
	    System.out.print("Digite o email do aluno: ");
	    String email = sc.nextLine();
	    
	    Aluno aluno = academia.buscarAlunoPorEmail(email);
	    if(aluno == null) {
	        System.out.println("Aluno não encontrado!");
	        return;
	    }
	    
	    System.out.println("\nAluno: " + aluno.getNome());
	    
	    System.out.println("\n=== SELECIONE O DIA DA SEMANA ===");
	    for(int i = 0; i < 7; i++) {
	        DiaDaSemana dia = DiaDaSemana.values()[i];
	        System.out.println("[" + i + "] - " + dia.getNome());
	    }
	    System.out.print("Escolha o dia: ");
	    
	    int indiceDia = -1;
	    try {
	        indiceDia = sc.nextInt();
	        sc.nextLine();
	        if(indiceDia < 0 || indiceDia > 6) {
	            System.out.println("Dia inválido!");
	            return;
	        }
	    } catch(Exception e) {
	        System.out.println("Erro: Digite apenas números!");
	        sc.nextLine();
	        return;
	    }
	    
	    DiaDaSemana diaSelecionado = DiaDaSemana.values()[indiceDia];
	    
	    Treino treinoExistente = aluno.getTreino(diaSelecionado);
	    if(treinoExistente != null && treinoExistente.getQuantExercicios() > 0) {
	        System.out.print("\nJá existe um treino para " + diaSelecionado.getNome() + ". Deseja substituir? (S/N): ");
	        String resposta = sc.nextLine();
	        if(!resposta.equalsIgnoreCase("S")) {
	            System.out.println("Operação cancelada!");
	            return;
	        }
	    }
	    
	    Treino novoTreino = new Treino(diaSelecionado);
	    
	    System.out.println("\n=== ADICIONAR EXERCÍCIOS AO TREINO ===\n");
	    boolean adicionarMais = true;
	    
	    while(adicionarMais) {
	        System.out.println("\n--- Exercício " + (novoTreino.getQuantExercicios() + 1) + " ---");
	        
	        System.out.print("\nDigite o nome do aparelho: ");
	        String nomeAparelho = null;
	        try {
	        	nomeAparelho = sc.nextLine();
	        } catch(Exception e) {
	            System.out.println("Erro: Nome inválido!");
	            sc.nextLine();
	            continue;
	        }
	        
	        List<Aparelho> aparelhosEncontrados = academia.buscaAparelhosLista(nomeAparelho);
	        if(aparelhosEncontrados.isEmpty()) {
	        	System.out.println("\nNenhum aparelho encontrado.\n");
	        	continue;
	        }
	        
	        int codigoAparelho;
	        if(aparelhosEncontrados.size() == 1) {
	        	codigoAparelho = aparelhosEncontrados.get(0).getID();
	        }else {
	        	int escolha = 0;
	        	int i = 0;
	        	System.out.println("\n═══ APARELHOS ENCONTRADOS ═══\n");
				for (Aparelho aparelho : aparelhosEncontrados) {
					i++;
					System.out.println(i + ") Nome do aparelho: " + aparelho.getNome() + "\n");
				}

	        	do {
	        		System.out.print("\nSelecione o número do aparelho desejado: ");

	        		try {
	        			escolha = sc.nextInt();
	        		}catch(Exception e) {
	    	            System.out.println("\nErro: Informe apenas números!\ns");
	        		}
	        		
					try{
						if(aparelhosEncontrados.get(escolha-1) == null) {
	        				System.out.println("\nOpção inválida.\n");
	        				continue;
	        			}
					}catch(IndexOutOfBoundsException e){
						System.out.println("\nOpção inválida.\n");
						continue;
					}
	        		
	        	}while(escolha == 0);

				try{
					codigoAparelho = aparelhosEncontrados.get(escolha-1).getID();
				}catch(IndexOutOfBoundsException e){
					System.out.println("Erro ao buscar ao buscar os dados do aparelho.");
					return;
				}
	        	
	        }
	        
	        Aparelho aparelho = academia.buscarAparelhoPorCodigo(codigoAparelho);
	        if(aparelho == null) {
	            System.out.println("Aparelho não encontrado!");
	            continue;
	        }
	        
	        System.out.println("Aparelho selecionado: " + aparelho.getNome());
	        sc.nextLine();
	        
	        double carga = 0;
	        boolean cargaValida = false;
	        while(!cargaValida) {
	            System.out.print("Carga (kg) - use 0 para exercícios sem carga: ");
	            try {
	                String cargaStr = sc.nextLine();
	                cargaStr = cargaStr.replace(',', '.');
	                carga = Double.parseDouble(cargaStr);
	                if(carga >= 0) {
	                    cargaValida = true;
	                } else {
	                    System.out.println("A carga não pode ser negativa!");
	                }
	            } catch(Exception e) {
	                System.out.println("Erro: Digite um número válido!");
	            }
	        }
	        
	        int repeticoes = 0;
	        boolean repeticoesValidas = false;
	        while(!repeticoesValidas) {
	            System.out.print("Repetições (ou minutos para cardio): ");
	            try {
	                repeticoes = sc.nextInt();
	                sc.nextLine();
	                if(repeticoes > 0) {
	                    repeticoesValidas = true;
	                } else {
	                    System.out.println("Repetições devem ser maior que zero!");
	                }
	            } catch(Exception e) {
	                System.out.println("Erro: Digite um número válido!");
	                sc.nextLine();
	            }
	        }
	        
	        Exercicio exercicio = new Exercicio(aparelho, carga, repeticoes);
	        
	        try {
	        	novoTreino.addExercicio(exercicio);
		        System.out.println("Exercício adicionado com sucesso!");
	        }catch(Exception e){
	        	System.out.println(e.getMessage());
	        }
	        
	        System.out.print("\nAdicionar mais exercícios? (S/N): ");
	        String resposta = sc.nextLine();
	        adicionarMais = resposta.equalsIgnoreCase("S");

	    }
	    
	    aluno.setTreino(diaSelecionado, novoTreino);
	    
	    Principal p = new Principal();
		ManipulacaoArquivos arq = new ManipulacaoArquivos();
	    try{
			String json = p.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(academia);
			arq.gravaJSONPessoa(caminho_arquivo, json);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	    
	    System.out.println("\n═══════════════════════════════════");
	    System.out.println("Treino definido com sucesso!");
	    System.out.println("Dia: " + diaSelecionado.getNome());
	    System.out.println("Total de exercícios: " + novoTreino.getQuantExercicios());
	    System.out.println("═══════════════════════════════════");
	}

	public static void consultarTreinoAluno(Scanner sc, Academia academia) {
	    sc.nextLine();
	    
	    System.out.println("\n═══ CONSULTAR TREINO DE ALUNO ═══");
	    
	    System.out.print("Digite o email do aluno: ");
	    String email = sc.nextLine();
	    
	    Aluno aluno = academia.buscarAlunoPorEmail(email);
	    if(aluno == null) {
	        System.out.println("Aluno não encontrado!");
	        return;
	    }
	    
	    System.out.println("\nAluno: " + aluno.getNome());
	    
	    System.out.println("\n=== SELECIONE O DIA DA SEMANA ===");
	    for(int i = 0; i < 7; i++) {
	        DiaDaSemana dia = DiaDaSemana.values()[i];
	        Treino treino = aluno.getTreinoPorIndice(i);
	        String status = (treino != null && treino.getQuantExercicios() > 0) ? 
	                       " (" + treino.getQuantExercicios() + " exercícios)" : " (sem treino)";
	        System.out.println("[" + i + "] - " + dia.getNome() + status);
	    }
	    System.out.print("Escolha o dia: ");
	    
	    int indiceDia = -1;
	    try {
	        indiceDia = sc.nextInt();
	        sc.nextLine(); 
	        if(indiceDia < 0 || indiceDia > 6) {
	            System.out.println("Dia inválido!");
	            return;
	        }
	    } catch(Exception e) {
	        System.out.println("Erro: Digite apenas números!");
	        sc.nextLine();
	        return;
	    }
	    
	    DiaDaSemana diaSelecionado = DiaDaSemana.values()[indiceDia];
	    Treino treino = aluno.getTreino(diaSelecionado);
	    
	    if(treino == null || treino.getQuantExercicios() == 0) {
	        System.out.println("\nNão há treino definido para " + diaSelecionado.getNome());
	        return;
	    }
	    
	    System.out.println("\n═══════════════════════════════════");
	    System.out.println("TREINO DE " + diaSelecionado.getNome().toUpperCase());
	    System.out.println("Aluno: " + aluno.getNome());
	    System.out.println("═══════════════════════════════════");
	    
	    for(int i = 0; i < treino.getQuantExercicios(); i++) {
	        Exercicio ex = treino.getExercicio(i);
	        System.out.println("\n" + (i + 1) + ". " + ex.getAparelho().getNome());
	        System.out.println("   Carga: " + (ex.getCarga() > 0 ? ex.getCarga() + " kg" : "Sem carga"));
	        System.out.println("   Repetições: " + ex.getRepeticoes());
	        System.out.println("   Músculos: " + ex.getAparelho().getFuncao());
	    }
	    
	    System.out.println("\n═══════════════════════════════════");
	    System.out.println("Total de exercícios: " + treino.getQuantExercicios());
	    System.out.println("═══════════════════════════════════");
	}

	public static void consultarMeuTreino(Scanner sc, Aluno aluno) {
	    sc.nextLine(); 
	    
	    System.out.println("\n═══ MEU TREINO ═══");
	    
	    System.out.println("\n=== SELECIONE O DIA DA SEMANA ===");
	    for(int i = 0; i < 7; i++) {
	        DiaDaSemana dia = DiaDaSemana.values()[i];
	        Treino treino = aluno.getTreinoPorIndice(i);
	        String status = (treino != null && treino.getQuantExercicios() > 0) ? 
	                       " (" + treino.getQuantExercicios() + " exercícios)" : " (sem treino)";
	        System.out.println("[" + i + "] - " + dia.getNome() + status);
	    }
	    System.out.print("Escolha o dia: ");
	    
	    int indiceDia = -1;
	    try {
	        indiceDia = sc.nextInt();
	        sc.nextLine(); 
	        if(indiceDia < 0 || indiceDia > 6) {
	            System.out.println("Dia inválido!");
	            return;
	        }
	    } catch(Exception e) {
	        System.out.println("Erro: Digite apenas números!");
	        sc.nextLine();
	        return;
	    }
	    
	    DiaDaSemana diaSelecionado = DiaDaSemana.values()[indiceDia];
	    Treino treino = aluno.getTreino(diaSelecionado);
	    
	    if(treino == null || treino.getQuantExercicios() == 0) {
	        System.out.println("\nVocê não tem treino definido para " + diaSelecionado.getNome());
	        System.out.println("Procure seu instrutor para definir um treino!");
	        return;
	    }
	    
	    System.out.println("\n═══════════════════════════════════");
	    System.out.println("SEU TREINO DE " + diaSelecionado.getNome().toUpperCase());
	    System.out.println("═══════════════════════════════════");
	    
	    for(int i = 0; i < treino.getQuantExercicios(); i++) {
	        Exercicio ex = treino.getExercicio(i);
	        System.out.println("\n" + (i + 1) + ". " + ex.getAparelho().getNome());
	        System.out.println("   Carga: " + (ex.getCarga() > 0 ? ex.getCarga() + " kg" : "Sem carga"));
	        System.out.println("   Repetições/Minutos: " + ex.getRepeticoes());
	        System.out.println("   Músculos trabalhados: " + ex.getAparelho().getFuncao());
	    }
	    
	    System.out.println("\n═══════════════════════════════════");
	    System.out.println("Total de exercícios: " + treino.getQuantExercicios());
	    System.out.println("═══════════════════════════════════");
	}
	
	public static void registrarEvolucaoAluno(Scanner sc, Academia academia) {
	    System.out.println("\n═══ REGISTRAR EVOLUÇÃO DO ALUNO ═══");
	    
	    System.out.print("Digite o email do aluno: ");
	    String email = sc.nextLine();
	    
	    Aluno aluno = academia.buscarAlunoPorEmail(email);
	    if(aluno == null) {
	        System.out.println("\nAluno não encontrado!");
	        return;
	    }
	    
	    System.out.println("\nAluno: " + aluno.getNome());
	    
	    // Show last record if exists
	    Historico ultimo = aluno.getUltimoHistorico();
	    if(ultimo != null) {
	        System.out.println("\n--- Última medição registrada ---");
	        System.out.println("Data: " + ultimo.getData());
	        System.out.println("Peso: " + String.format("%.2f", ultimo.getPeso()) + " kg");
	        System.out.println("Massa Muscular: " + String.format("%.1f", ultimo.getMassaMuscular()) + "%");
	        System.out.println("Massa Magra: " + String.format("%.2f", ultimo.getMassaMagraKg()) + " kg");
	        System.out.println("─────────────────────────────────");
	    }
	    
	    // Input new weight
	    double peso = 0;
	    boolean pesoValido = false;
	    while(!pesoValido) {
	        System.out.print("\nPeso atual (kg): ");
	        try {
	            String pesoStr = sc.nextLine().replace(',', '.');
	            peso = Double.parseDouble(pesoStr);
	            if(peso > 15 && peso < 255) {
	                pesoValido = true;
	            } else {
	                System.out.println("Erro: Digite um peso válido entre 15 e 255 kg!");
	            }
	        } catch(Exception e) {
	            System.out.println("Erro: Digite um número válido!");
	        }
	    }
	    
	    double massaMuscular = 0;
	    boolean massaValida = false;
	    while(!massaValida) {
	        System.out.print("Percentual de massa muscular (%): ");
	        try {
	            String massaStr = sc.nextLine().replace(',', '.');
	            massaMuscular = Double.parseDouble(massaStr);
	            if(massaMuscular > 0 && massaMuscular <= 100) {
	                massaValida = true;
	            } else {
	                System.out.println("Erro: Digite um percentual válido entre 0 e 100%!");
	            }
	        } catch(Exception e) {
	            System.out.println("Erro: Digite um número válido!");
	        }
	    }
	    
	    Historico novoHistorico = new Historico(peso, massaMuscular, LocalDate.now());
	    aluno.addHistorico(novoHistorico);
	    
	    Principal p = new Principal();
	    ManipulacaoArquivos arq = new ManipulacaoArquivos();
	    try{
	        String json = p.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(academia);
	        arq.gravaJSONPessoa(caminho_arquivo, json);
	    }catch(Exception e){
	        System.out.println("Erro ao salvar: " + e.getMessage());
	        return;
	    }
	    
	    System.out.println("\n═══════════════════════════════════");
	    System.out.println("✓ Evolução registrada com sucesso!");
	    System.out.println("═══════════════════════════════════");
	    System.out.println("Data: " + novoHistorico.getData());
	    System.out.println("Peso: " + String.format("%.2f", peso) + " kg");
	    System.out.println("Massa Muscular: " + String.format("%.1f", massaMuscular) + "%");
	    System.out.println("Massa Magra: " + String.format("%.2f", novoHistorico.getMassaMagraKg()) + " kg");
	    
	    // Show progress if there's a previous record
	    if(ultimo != null) {
	        double variacaoPeso = peso - ultimo.getPeso();
	        double variacaoMassa = massaMuscular - ultimo.getMassaMuscular();
	        
	        System.out.println("\n--- Progresso desde última medição ---");
	        System.out.println("Variação de peso: " + 
	            (variacaoPeso >= 0 ? "+" : "") + String.format("%.2f", variacaoPeso) + " kg");
	        System.out.println("Variação de massa muscular: " + 
	            (variacaoMassa >= 0 ? "+" : "") + String.format("%.1f", variacaoMassa) + "%");
	    }
	    System.out.println("═══════════════════════════════════");
	}

	public static void consultarEvolucaoAluno(Scanner sc, Academia academia) {	    
	    System.out.println("\n═══ CONSULTAR EVOLUÇÃO DO ALUNO ═══");
	    
	    System.out.print("Digite o email do aluno: ");
	    String email = sc.nextLine();
	    
	    Aluno aluno = academia.buscarAlunoPorEmail(email);
	    if(aluno == null) {
	        System.out.println("\nAluno não encontrado!");
	        return;
	    }
	    
	    List<Historico> historicos = aluno.getHistoricos();
	    
	    if(historicos == null || historicos.isEmpty()) {
	        System.out.println("\n" + aluno.getNome() + " ainda não possui registros de evolução.");
	        System.out.println("Registre a primeira medição no menu 'Registrar Evolução'.");
	        return;
	    }
	    
	    System.out.println("\n═══════════════════════════════════");
	    System.out.println("EVOLUÇÃO DE " + aluno.getNome().toUpperCase());
	    System.out.println("Total de registros: " + historicos.size());
	    System.out.println("═══════════════════════════════════");
	    
	    // Display all records
	    for(int i = 0; i < historicos.size(); i++) {
	        Historico h = historicos.get(i);
	        System.out.println("\n" + (i + 1) + ". Data: " + h.getData());
	        System.out.println("   Peso: " + String.format("%.2f", h.getPeso()) + " kg");
	        System.out.println("   Massa Muscular: " + String.format("%.1f", h.getMassaMuscular()) + "%");
	        System.out.println("   Massa Magra: " + String.format("%.2f", h.getMassaMagraKg()) + " kg");
	        
	        // Show progress from previous record
	        if(i > 0) {
	            Historico anterior = historicos.get(i - 1);
	            double variacaoPeso = h.getPeso() - anterior.getPeso();
	            double variacaoMassa = h.getMassaMuscular() - anterior.getMassaMuscular();
	            
	            System.out.println("   Progresso: Peso " + 
	                (variacaoPeso >= 0 ? "+" : "") + String.format("%.2f", variacaoPeso) + " kg | " +
	                "Massa " + (variacaoMassa >= 0 ? "+" : "") + String.format("%.1f", variacaoMassa) + "%");
	        }
	    }
	    
	    // Summary statistics
	    if(historicos.size() >= 2) {
	        Historico primeiro = historicos.get(0);
	        Historico ultimo = historicos.get(historicos.size() - 1);
	        
	        double progressoPeso = ultimo.getPeso() - primeiro.getPeso();
	        double progressoMassa = ultimo.getMassaMuscular() - primeiro.getMassaMuscular();
	        
	        System.out.println("\n═══════════════════════════════════");
	        System.out.println("PROGRESSO TOTAL");
	        System.out.println("─────────────────────────────────");
	        System.out.println("Primeira medição: " + primeiro.getData());
	        System.out.println("Última medição: " + ultimo.getData());
	        System.out.println("─────────────────────────────────");
	        System.out.println("Variação de peso: " + 
	            (progressoPeso >= 0 ? "+" : "") + String.format("%.2f", progressoPeso) + " kg");
	        System.out.println("Variação de massa muscular: " + 
	            (progressoMassa >= 0 ? "+" : "") + String.format("%.1f", progressoMassa) + "%");
	    }
	    
	    System.out.println("═══════════════════════════════════");
	}

	public static void consultarMinhaEvolucao(Aluno aluno) {
	    System.out.println("\n═══ MINHA EVOLUÇÃO ═══");
	    
	    List<Historico> historicos = aluno.getHistoricos();
	    
	    if(historicos == null || historicos.isEmpty()) {
	        System.out.println("\nVocê ainda não possui registros de evolução.");
	        System.out.println("Procure seu instrutor para registrar suas medidas!");
	        return;
	    }
	    
	    System.out.println("\n═══════════════════════════════════");
	    System.out.println("SEU PROGRESSO");
	    System.out.println("Total de medições: " + historicos.size());
	    System.out.println("═══════════════════════════════════");
	    
	    // Display all records with visual indicators
	    for(int i = 0; i < historicos.size(); i++) {
	        Historico h = historicos.get(i);
	        System.out.println("\nMedição " + (i + 1) + " - " + h.getData());
	        System.out.println("   Peso: " + String.format("%.2f", h.getPeso()) + " kg");
	        System.out.println("   Massa Muscular: " + String.format("%.1f", h.getMassaMuscular()) + "%");
	        System.out.println("   Massa Magra: " + String.format("%.2f", h.getMassaMagraKg()) + " kg");
	        
	        // Show progress with arrows
	        if(i > 0) {
	            Historico anterior = historicos.get(i - 1);
	            double variacaoPeso = h.getPeso() - anterior.getPeso();
	            double variacaoMassa = h.getMassaMuscular() - anterior.getMassaMuscular();
	            
	            String setaPeso = variacaoPeso > 0 ? "↑" : (variacaoPeso < 0 ? "↓" : "→");
	            String setaMassa = variacaoMassa > 0 ? "↑" : (variacaoMassa < 0 ? "↓" : "→");
	            
	            System.out.println("   " + setaPeso + " Peso: " + 
	                (variacaoPeso >= 0 ? "+" : "") + String.format("%.2f", variacaoPeso) + " kg");
	            System.out.println("   " + setaMassa + " Massa: " + 
	                (variacaoMassa >= 0 ? "+" : "") + String.format("%.1f", variacaoMassa) + "%");
	        }
	    }
	    
	    // Overall progress summary
	    if(historicos.size() >= 2) {
	        Historico primeiro = historicos.get(0);
	        Historico ultimo = historicos.get(historicos.size() - 1);
	        
	        double progressoPeso = ultimo.getPeso() - primeiro.getPeso();
	        double progressoMassa = ultimo.getMassaMuscular() - primeiro.getMassaMuscular();
	        
	        System.out.println("\n═══════════════════════════════════");
	        System.out.println("🎯 PROGRESSO GERAL");
	        System.out.println("─────────────────────────────────");
	        System.out.println("Período: " + primeiro.getData() + " até " + ultimo.getData());
	        System.out.println("─────────────────────────────────");
	        
	        // Weight progress
	        if(progressoPeso > 0) {
	            System.out.println("✓ Ganho de peso: +" + String.format("%.2f", progressoPeso) + " kg");
	        } else if(progressoPeso < 0) {
	            System.out.println("✓ Perda de peso: " + String.format("%.2f", progressoPeso) + " kg");
	        } else {
	            System.out.println("→ Peso mantido");
	        }
	        
	        // Muscle mass progress
	        if(progressoMassa > 0) {
	            System.out.println("✓ Ganho de massa muscular: +" + String.format("%.1f", progressoMassa) + "%");
	        } else if(progressoMassa < 0) {
	            System.out.println("⚠ Perda de massa muscular: " + String.format("%.1f", progressoMassa) + "%");
	        } else {
	            System.out.println("→ Massa muscular mantida");
	        }
	        
	        // Motivational message
	        System.out.println("\n💪 Continue com o bom trabalho!");
	    }
	    
	    System.out.println("═══════════════════════════════════");
	}

	public static void registrarFrequencia(Scanner sc, Aluno aluno) {
	    System.out.println("\n=== REGISTRAR FREQUÊNCIA ===");
	    System.out.println("Funcionalidade em desenvolvimento...");
	}
	
	public static boolean verificaLoginAdmin(String user, String senha)
	{
		return user.equals(USERNAME_ADMIN) && senha.equals(SENHA_ADMIN);
	}
	
	public static void cadastrarAcademia(Scanner sc, Academia academia) {
	    System.out.println("=== CADASTRAR DADOS DA ACADEMIA ===");
	    
	    String nome = "";
	    while(nome.trim().isEmpty()) {
	        System.out.print("Nome da academia: ");
	        nome = sc.nextLine();
	        if(nome.trim().isEmpty()) {
	            System.out.println("Erro: O nome não pode ser vazio!");
	        }
	    }
	    
	    String telefone = "";
	    boolean telefoneValido = false;
	    Validacoes valida = new Validacoes();

	    while(!telefoneValido) {
	        try {
	            System.out.print("Telefone (formato: (XX) 9XXXX-XXXX): ");
	            telefone = sc.nextLine();
	            valida.validaTelefone(telefone);  // Call inside try block
	            telefoneValido = true;  // Only reaches here if valid
	        } catch (EmptyFieldException | InvalidPhoneException e) {
	            System.out.println("Erro: " + e.getMessage());
	            // Loop continues, asking for input again
	        }
	    }
	    
	    String website = "";
	    while(website.trim().isEmpty()) {
	        System.out.print("Website: ");
	        website = sc.nextLine();
	        if(website.trim().isEmpty()) {
	            System.out.println("Erro: O website não pode ser vazio!");
	        }
	    }
	    
	    System.out.println("\n--- ENDEREÇO ---");
	    
	    String rua = "";
	    while(rua.trim().isEmpty()) {
	        System.out.print("Rua: ");
	        rua = sc.nextLine();
	        if(rua.trim().isEmpty()) {
	            System.out.println("Erro: A rua não pode ser vazia!");
	        }
	    }
	    
	    String bairro = "";
	    while(bairro.trim().isEmpty()) {
	        System.out.print("Bairro: ");
	        bairro = sc.nextLine();
	        if(bairro.trim().isEmpty()) {
	            System.out.println("Erro: O bairro não pode ser vazio!");
	        }
	    }
	    
	    int numero = -1;
	    while(numero <= 0) {
	        System.out.print("Número: ");
	        try {
	            numero = sc.nextInt();
	            sc.nextLine();
	            if(numero <= 0) {
	                System.out.println("Erro: O número deve ser maior que zero!");
	            }
	        } catch(Exception e) {
	            System.out.println("Erro: Digite apenas números!");
	            sc.nextLine();
	            numero = -1;
	        }
	    }
	    
	    String cep = "";
	    while(cep.trim().isEmpty() || cep.length() != 8) {
	        System.out.print("CEP (somente números, 8 dígitos): ");
	        cep = sc.nextLine();
	        if(cep.trim().isEmpty()) {
	            System.out.println("Erro: O CEP não pode ser vazio!");
	        } else if(cep.length() != 8 || !cep.matches("[0-9]+")) {
	            System.out.println("Erro: O CEP deve ter exatamente 8 dígitos numéricos!");
	            cep = "";
	        }
	    }
	    
	    String cidade = "";
	    while(cidade.trim().isEmpty()) {
	        System.out.print("Cidade: ");
	        cidade = sc.nextLine();
	        if(cidade.trim().isEmpty()) {
	            System.out.println("Erro: A cidade não pode ser vazia!");
	        }
	    }
	    
	    String estado = "";
	    while(estado.trim().isEmpty() || estado.length() != 2) {
	        System.out.print("Estado (UF - 2 letras): ");
	        estado = sc.nextLine().toUpperCase();
	        if(estado.trim().isEmpty()) {
	            System.out.println("Erro: O estado não pode ser vazio!");
	        } else if(estado.length() != 2) {
	            System.out.println("Erro: Digite a sigla do estado (2 letras)!");
	            estado = "";
	        }
	    }
	    
	    System.out.print("Complemento: ");
	    String complemento = sc.nextLine();
	    
	    Endereco endereco = new Endereco(rua, bairro, numero, cep, cidade, estado, complemento);
	    
	    academia.setNome(nome);
	    academia.setTelefone(telefone);
	    academia.setWebsite(website);
	    academia.setEndereco(endereco);
	    
	    Principal p = new Principal();
		ManipulacaoArquivos arq = new ManipulacaoArquivos();
	    try{
			String json = p.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(academia);
			arq.gravaJSONPessoa(caminho_arquivo, json);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	    
	    System.out.println("\nAcademia cadastrada com sucesso!");
	}
	
	public static void consultarAcademia(Academia academia) {
	    System.out.println("\n=== DADOS DA ACADEMIA ===");
	    System.out.println("Nome: " + academia.getNome());
	    System.out.println("Telefone: " + academia.getTelefone());
	    System.out.println("Website: " + academia.getWebsite());
	    System.out.println("\n--- ENDEREÇO ---");
	    System.out.println(academia.getEndereco());
	}
	
	public static boolean cadastrarAluno(Scanner sc, Academia academia) {
	    String nome, email, telefone, dataNascimento, username, senha;
	    float altura;
	    
	    System.out.println("=== CADASTRO DE ALUNO ===");
	    
	    Validacoes valida = new Validacoes();
	    
	    nome = "";
	    boolean nomeValido = false;

	    while(!nomeValido) {
	        try {
	            System.out.print("Nome: ");
	            nome = sc.nextLine();
	            valida.validaNome(nome);
	            nomeValido = true;
	        } catch (EmptyFieldException | InvalidNameException e) {
	            System.out.println("Erro: " + e.getMessage());
	        }
	    }
	    
	    email = null;	    
	    boolean emailValido = false;

	    while(!emailValido) {
	        try {
	            System.out.print("Email: ");
	            email = sc.nextLine();
	            valida.validaEmail(email);
	            emailValido = true;
	        } catch (EmptyFieldException | InvalidEmailException e) {
	            System.out.println("Erro: " + e.getMessage());
	        }
	    }
	    
	    telefone = null;
	    boolean telefoneValido = false;

	    while(!telefoneValido) {
	        try {
	            System.out.print("Telefone (formato: (XX) 9XXXX-XXXX): ");
	            telefone = sc.nextLine();
	            valida.validaTelefone(telefone);  // Call inside try block
	            telefoneValido = true;  // Only reaches here if valid
	        } catch (EmptyFieldException | InvalidPhoneException e) {
	            System.out.println("Erro: " + e.getMessage());
	            // Loop continues, asking for input again
	        }
	    }
	    
	    dataNascimento = null;
	    boolean dataValida = false;

	    while(!dataValida) {
	        try {
	            System.out.print("Data (DD/MM/AAAA): ");
	            dataNascimento = sc.nextLine();
	            valida.validaData(dataNascimento);
	            dataValida = true;
	        } catch (EmptyFieldException | InvalidDateException e) {
	            System.out.println("Erro: " + e.getMessage());
	        }
	    }
	    
	    altura = 0;
	    boolean alturaValida = false;

	    while(!alturaValida) {
	        try {
	            System.out.print("Altura (ex: 1,75): ");
	            String alturaStr = sc.nextLine().replace(',', '.');
	            altura = Float.parseFloat(alturaStr);
	            valida.validaAltura(altura);
	            alturaValida = true;
	        } catch (InvalidHeightException e) {
	            System.out.println("Erro: " + e.getMessage());
	        } catch (NumberFormatException e) {
	            System.out.println("Erro: Digite um número válido!");
	        }
	    }
	    
	    username = "";
	    while(username.trim().isEmpty()) {
	        System.out.print("Username do Login: ");
	        username = sc.nextLine();
	        if(username.trim().isEmpty()) {
	            System.out.println("Erro: O username não pode ser vazio!");
	        }
	    }
	    
	    senha = "";
	    while(senha.trim().isEmpty()) {
	        System.out.print("Senha: ");
	        senha = sc.nextLine();
	        if(senha.trim().isEmpty()) {
	            System.out.println("Erro: A senha não pode ser vazia!");
	        }
	    }
	    
	    Aluno alunoCriado = new Aluno(nome, email, telefone, dataNascimento, altura, username, senha);
	    
	    if(alunoCriado.getNome() == null) {
	        System.out.println("Erro: Dados inválidos! Aluno não foi criado.");
	        return false;
	    }
	    
	    if(academia.addAluno(alunoCriado)) {
	    	Principal p = new Principal();
			ManipulacaoArquivos arq = new ManipulacaoArquivos();
		    try{
				String json = p.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(academia);
				arq.gravaJSONPessoa(caminho_arquivo, json);
			}catch(Exception e){
				System.out.println(e.getMessage());
				return false;
			}
		    
	        System.out.println("\n" + alunoCriado.toString());
	        return true;
	    } else {
	        return false;
	    }
	}
    
	public static void consultarAluno(Scanner sc, Academia academia) {
	    System.out.println("=== CONSULTAR ALUNO ===");
	    System.out.print("Digite o nome, email ou username do aluno: ");
	    String busca = sc.nextLine();
	    
	    Aluno aluno = academia.buscarAlunoPorEmail(busca);
	    
	    if(aluno == null) {
	        aluno = academia.buscarAlunoPorNome(busca);
	    }
	    
	    if(aluno != null) {
	        System.out.println("\nAluno encontrado:");
	        System.out.println(aluno.toString());
	    } else {
	        System.out.println("Aluno não encontrado!");
	    }
	}

    public static void alterarAluno(Scanner sc, Academia academia) {
        System.out.println("=== ALTERAR ALUNO ===");
        System.out.print("Digite o email do aluno a alterar: ");
        String emailAtual = sc.nextLine();
        
        Aluno aluno = academia.buscarAlunoPorEmail(emailAtual);
        if(aluno == null) {
            System.out.println("Aluno não encontrado!");
            return;
        }
        
        System.out.println("Aluno atual: " + aluno.toString());
        System.out.println("\n(Deixe em branco para manter o valor atual)");
        
        System.out.print("Novo nome: ");
        String novoNome = sc.nextLine();
        
        System.out.print("Novo email: ");
        String novoEmail = sc.nextLine();
        
        System.out.print("Novo telefone: ");
        String novoTelefone = sc.nextLine();
        
        System.out.print("Nova data de nascimento: ");
        String novaData = sc.nextLine();
        
        System.out.print("Nova altura (0 para manter): ");
        float novaAltura = sc.nextFloat();
        
        if(academia.alterarAluno(emailAtual, novoNome, novoEmail, novoTelefone, novaData, novaAltura)) {
        	Principal p = new Principal();
    		ManipulacaoArquivos arq = new ManipulacaoArquivos();
    	    try{
    			String json = p.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(academia);
    			arq.gravaJSONPessoa(caminho_arquivo, json);
    			System.out.println("Aluno alterado com sucesso!");
    		}catch(Exception e){
    			System.out.println(e.getMessage());
    		}
        } else {
            System.out.println("Erro ao alterar aluno!");
        }
    }

    public static void removerAluno(Scanner sc, Academia academia) {
        System.out.println("=== REMOVER ALUNO ===");
        System.out.print("Digite o email do aluno a remover: ");
        String email = sc.nextLine();
        
        Aluno aluno = academia.buscarAlunoPorEmail(email);
        if(aluno != null) {
            System.out.println("Aluno: " + aluno.toString());
            System.out.print("Confirma remoção? (S/N): ");
            String confirmacao = sc.nextLine();
            
            if(confirmacao.equalsIgnoreCase("S")) {
                if(academia.removerAluno(email)) {
                	Principal p = new Principal();
            		ManipulacaoArquivos arq = new ManipulacaoArquivos();
            	    try{
            			String json = p.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(academia);
            			arq.gravaJSONPessoa(caminho_arquivo, json);
            			System.out.println("Aluno removido com sucesso!");
            		}catch(Exception e){
            			System.out.println(e.getMessage());
            		}
                } else {
                    System.out.println("Erro ao remover aluno!");
                }
            } else {
                System.out.println("Operação cancelada!");
            }
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }
    
    public static boolean cadastrarInstrutor(Scanner sc, Academia academia) {
	    String nome, email, telefone, formacao, username, senha;

	    System.out.println("=== CADASTRO DE INSTRUTOR ===");
	    
	    Validacoes valida = new Validacoes();
	    
	    nome = null;
	    boolean nomeValido = false;

	    while(!nomeValido) {
	        try {
	            System.out.print("Nome: ");
	            nome = sc.nextLine();
	            valida.validaNome(nome);
	            nomeValido = true;
	        } catch (EmptyFieldException | InvalidNameException e) {
	            System.out.println("Erro: " + e.getMessage());
	        }
	    }
	    
	    email = null;
	    boolean emailValido = false;

	    while(!emailValido) {
	        try {
	            System.out.print("Email: ");
	            email = sc.nextLine();
	            valida.validaEmail(email);
	            emailValido = true;
	        } catch (EmptyFieldException | InvalidEmailException e) {
	            System.out.println("Erro: " + e.getMessage());
	        }
	    }
	    
	    telefone = null;
	    boolean telefoneValido = false;

	    while(!telefoneValido) {
	        try {
	            System.out.print("Telefone (formato: (XX) 9XXXX-XXXX): ");
	            telefone = sc.nextLine();
	            valida.validaTelefone(telefone);  // Call inside try block
	            telefoneValido = true;  // Only reaches here if valid
	        } catch (EmptyFieldException | InvalidPhoneException e) {
	            System.out.println("Erro: " + e.getMessage());
	            // Loop continues, asking for input again
	        }
	    }
	    
	    formacao = null;
	    boolean formacaoValida = false;
	    while(!formacaoValida) {
	    	try {
	    		System.out.print("Formação: ");
		        formacao = sc.nextLine();
		        valida.validaFormacao(formacao);
		        formacaoValida = true;
	    	} catch (InvalidFormacaoException e)
	    	{
	    		System.out.println("Erro: " + e.getMessage());
	    	}
	    	catch (EmptyFieldException e) {
	            System.out.println("Erro: " + e.getMessage());
	            // Loop continues, asking for input again
	        }
	    }
	    
	    username = "";
	    while(username.trim().isEmpty()) {
	        System.out.print("Username do Login: ");
	        username = sc.nextLine();
	        if(username.trim().isEmpty()) {
	            System.out.println("Erro: O username não pode ser vazio!");
	        }
	    }
	    
	    senha = "";
	    while(senha.trim().isEmpty()) {
	        System.out.print("Senha: ");
	        senha = sc.nextLine();
	        if(senha.trim().isEmpty()) {
	            System.out.println("Erro: A senha não pode ser vazia!");
	        }
	    }
	    
	    Instrutor instrutorCriado = new Instrutor(nome, email, telefone, formacao, username, senha);
	    
	    if(instrutorCriado.getNome() == null) {
	        System.out.println("Erro: Dados inválidos! Instrutor não foi criado.");
	        return false;
	    }
	    
	    if(academia.addInstrutor(instrutorCriado)) {
	    	Principal p = new Principal();
    		ManipulacaoArquivos arq = new ManipulacaoArquivos();
    	    try{
    			String json = p.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(academia);
    			arq.gravaJSONPessoa(caminho_arquivo, json);
    		}catch(Exception e){
    			System.out.println(e.getMessage());
    			return false;
    		}
    	    
	        System.out.println("\nInstrutor cadastrado com sucesso!");
	        System.out.println(instrutorCriado.toString());
	        return true;
	    } else {
	        return false;
	    }
	}

    public static void consultarInstrutor(Scanner sc, Academia academia) {
        System.out.println("=== CONSULTAR INSTRUTOR ===");
        System.out.print("Digite o nome ou email do instrutor: ");
        String busca = sc.nextLine();
        
        Instrutor instrutor = academia.buscarInstrutorPorEmail(busca);
        if(instrutor == null) {
            instrutor = academia.buscarInstrutorPorNome(busca);
        }
        
        if(instrutor != null) {
            System.out.println("\nInstrutor encontrado:");
            System.out.println(instrutor.toString());
        } else {
            System.out.println("Instrutor não encontrado!");
        }
    }

    public static void alterarInstrutor(Scanner sc, Academia academia) {
        System.out.println("=== ALTERAR INSTRUTOR ===");
        System.out.print("Digite o email do instrutor a alterar: ");
        String emailAtual = sc.nextLine();
        
        Instrutor instrutor = academia.buscarInstrutorPorEmail(emailAtual);
        if(instrutor == null) {
            System.out.println("Instrutor não encontrado!");
            return;
        }
        
        System.out.println("Instrutor atual: " + instrutor.toString());
        System.out.println("\n(Deixe em branco para manter o valor atual)");
        
        System.out.print("Novo nome: ");
        String novoNome = sc.nextLine();
        
        System.out.print("Novo email: ");
        String novoEmail = sc.nextLine();
        
        System.out.print("Novo telefone: ");
        String novoTelefone = sc.nextLine();
        
        System.out.print("Nova formação: ");
        String novaFormacao = sc.nextLine();
        
        if(academia.alterarInstrutor(emailAtual, novoNome, novoEmail, novoTelefone, novaFormacao)) {
        	Principal p = new Principal();
    		ManipulacaoArquivos arq = new ManipulacaoArquivos();
    	    try{
    			String json = p.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(academia);
    			arq.gravaJSONPessoa(caminho_arquivo, json);
    			System.out.println("Instrutor alterado com sucesso!");
    		}catch(Exception e){
    			System.out.println(e.getMessage());
    		}
        } else {
            System.out.println("Erro ao alterar instrutor!");
        }
    }

    public static void removerInstrutor(Scanner sc, Academia academia) {
        System.out.println("=== REMOVER INSTRUTOR ===");
        System.out.print("Digite o email do instrutor a remover: ");
        String email = sc.nextLine();
        
        Instrutor instrutor = academia.buscarInstrutorPorEmail(email);
        if(instrutor != null) {
            System.out.println("Instrutor: " + instrutor.toString());
            System.out.print("Confirma remoção? (S/N): ");
            String confirmacao = sc.nextLine();
            
            if(confirmacao.equalsIgnoreCase("S")) {
                if(academia.removerInstrutor(email)) {
                	Principal p = new Principal();
            		ManipulacaoArquivos arq = new ManipulacaoArquivos();
            	    try{
            			String json = p.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(academia);
            			arq.gravaJSONPessoa(caminho_arquivo, json);
            			System.out.println("Instrutor removido com sucesso!");
            		}catch(Exception e){
            			System.out.println(e.getMessage());
            		}
                } else {
                    System.out.println("Erro ao remover instrutor!");
                }
            } else {
                System.out.println("Operação cancelada!");
            }
        } else {
            System.out.println("Instrutor não encontrado!");
        }
    }
    
    public static boolean cadastrarAparelho(Scanner sc, Academia academia) {
	    String nome, descricao, funcao;
	    
	    System.out.println("\n=== CADASTRO DE APARELHO ===\n");
	    
	    nome = "";
	    while(nome.trim().isEmpty()) {
	        System.out.print("Nome do aparelho: ");
	        nome = sc.nextLine();
	        if(nome.trim().isEmpty()) {
	            System.out.println("Erro: O nome não pode ser vazio!");
	        }
	    }
	    
	    descricao = "";
	    while(descricao.trim().isEmpty()) {
	        System.out.print("Descrição: ");
	        descricao = sc.nextLine();
	        if(descricao.trim().isEmpty()) {
	            System.out.println("Erro: A descrição não pode ser vazia!");
	        }
	    }
	    
	    funcao = "";
	    while(funcao.trim().isEmpty()) {
	        System.out.print("Função (músculos trabalhados): ");
	        funcao = sc.nextLine();
	        if(funcao.trim().isEmpty()) {
	            System.out.println("Erro: A função não pode ser vazia!");
	        }
	    }
	    
	    Aparelho aparelhoCriado = new Aparelho(nome, descricao, funcao);
	    
	    academia.addAparelho(aparelhoCriado);
	    
	    Principal p = new Principal();
		ManipulacaoArquivos arq = new ManipulacaoArquivos();
	    try{
			String json = p.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(academia);
			arq.gravaJSONPessoa(caminho_arquivo, json);
			System.out.println("Instrutor alterado com sucesso!");
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	    
	    System.out.println("\nAparelho cadastrado com sucesso!");
	    System.out.println(aparelhoCriado.toString());
	    return true;
	}

    public static void consultarAparelho(Scanner sc, Academia academia) {
        System.out.println("\n=== CONSULTAR APARELHO ===\n");
        System.out.println("[1] - Buscar por código");
        System.out.println("[2] - Buscar por nome");
        System.out.print("Escolha uma opção: ");
        
        int opcao = -1;
        try {
            opcao = sc.nextInt();
            sc.nextLine();
        } catch(Exception e) {
            System.out.println("Erro: Digite apenas números!");
            sc.nextLine();
            return;
        }
        
        Aparelho aparelho = null;
        
        switch(opcao) {
            case 1:
                System.out.print("\nDigite o código do aparelho: ");
                try {
                    int codigo = sc.nextInt();
                    sc.nextLine();
                    aparelho = academia.buscarAparelhoPorCodigo(codigo);
                } catch(Exception e) {
                    System.out.println("Erro: Digite apenas números!");
                    sc.nextLine();
                    return;
                }
                break;
                
            case 2:
                System.out.print("\nDigite o nome do aparelho: ");
                String nome = sc.nextLine();
                aparelho = academia.buscarAparelhoPorNome(nome);
                break;
                
            default:
                System.out.println("\nOpção inválida!");
                return;
        }
        
        if(aparelho != null) {
            System.out.println("\nAparelho encontrado:");
            System.out.println("Código: " + aparelho.getID());
            System.out.println("Nome: " + aparelho.getNome());
            System.out.println("Descrição: " + aparelho.getDescricao());
            System.out.println("Função: " + aparelho.getFuncao());
        } else {
            System.out.println("Aparelho não encontrado!");
        }
    }

    public static void alterarAparelho(Scanner sc, Academia academia) {
	    System.out.println("\n=== ALTERAR APARELHO ===\n");
	    System.out.print("Digite o código do aparelho a alterar: ");
	    
	    int codigo = -1;
	    try {
	        codigo = sc.nextInt();
	        sc.nextLine();
	    } catch(Exception e) {
	        System.out.println("\nErro: Digite apenas números!");
	        sc.nextLine();
	        return;
	    }
	    
	    Aparelho aparelho = academia.buscarAparelhoPorCodigo(codigo);
	    if(aparelho == null) {
	        System.out.println("\nAparelho não encontrado!");
	        return;
	    }
	    
	    System.out.println("\nAparelho atual:");
	    System.out.println("Código: " + aparelho.getID());
	    System.out.println("Nome: " + aparelho.getNome());
	    System.out.println("Descrição: " + aparelho.getDescricao());
	    System.out.println("Função: " + aparelho.getFuncao());
	    
	    System.out.println("\n(Deixe em branco para manter o valor atual)");
	    
	    System.out.print("Novo nome: ");
	    String novoNome = sc.nextLine();
	    
	    System.out.print("Nova descrição: ");
	    String novaDescricao = sc.nextLine();
	    
	    System.out.print("Nova função: ");
	    String novaFuncao = sc.nextLine();
	    
	    if(novoNome.trim().isEmpty()) {
	        novoNome = null;
	    }
	    if(novaDescricao.trim().isEmpty()) {
	        novaDescricao = null;
	    }
	    if(novaFuncao.trim().isEmpty()) {
	        novaFuncao = null;
	    }
	    
	    if(academia.alterarAparelho(codigo, novoNome, novaDescricao, novaFuncao)) {
	    	Principal p = new Principal();
    		ManipulacaoArquivos arq = new ManipulacaoArquivos();
    	    try{
    			String json = p.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(academia);
    			arq.gravaJSONPessoa(caminho_arquivo, json);
    			System.out.println("Instrutor alterado com sucesso!");
    		}catch(Exception e){
    			System.out.println(e.getMessage());
    			return;
    		}
    	    
	        System.out.println("\nAparelho alterado com sucesso!");
	        Aparelho aparelhoAtualizado = academia.buscarAparelhoPorCodigo(codigo);
	        System.out.println(aparelhoAtualizado.toString());
	    } else {
	        System.out.println("Erro ao alterar aparelho!");
	    }
	}

    public static void removerAparelho(Scanner sc, Academia academia) {
	    System.out.println("\n=== REMOVER APARELHO ===\n");
	    System.out.print("Digite o código do aparelho a remover: ");
	    
	    int codigo = -1;
	    try {
	        codigo = sc.nextInt();
	        sc.nextLine();
	    } catch(Exception e) {
	        System.out.println("\nErro: Digite apenas números!");
	        sc.nextLine();
	        return;
	    }
	    
	    Aparelho aparelho = academia.buscarAparelhoPorCodigo(codigo);
	    if(aparelho != null) {
	        System.out.println("\nAparelho:");
	        System.out.println("Código: " + aparelho.getID());
	        System.out.println("Nome: " + aparelho.getNome());
	        System.out.println("Descrição: " + aparelho.getDescricao());
	        System.out.println("Função: " + aparelho.getFuncao());
	        
	        System.out.print("\nConfirma remoção? (S/N): ");
	        String confirmacao = sc.nextLine();
	        
	        if(confirmacao.equalsIgnoreCase("S")) {
	            if(academia.removerAparelho(codigo)) {

	            	Principal p = new Principal();
	        		ManipulacaoArquivos arq = new ManipulacaoArquivos();
	        	    try{
	        			String json = p.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(academia);
	        			arq.gravaJSONPessoa(caminho_arquivo, json);
	        			System.out.println("Instrutor alterado com sucesso!");
	        		}catch(Exception e){
	        			System.out.println(e.getMessage());
	        			return;
	        		}

	                System.out.println("Aparelho removido com sucesso!");
	            } else {
	                System.out.println("Erro ao remover aparelho!");
	            }
	        } else {
	            System.out.println("Operação cancelada!");
	        }
	    } else {
	        System.out.println("Aparelho não encontrado!");
	    }
	}

    public static void listarAparelhos(Academia academia) {
        academia.listarAparelhos();
    }
    
    public static void definirHorarios(Scanner sc, Academia academia) {
        System.out.println("\n=== DEFINIR HORÁRIOS DE FUNCIONAMENTO ===");
        String abre = null;
        Validacoes val = new Validacoes();

        for(int i = 0; i < 7; i++) {
            DiaDaSemana dia = DiaDaSemana.values()[i];
            
			if(abre == null){
				System.out.print("\n" + dia.getNome() + " - A academia abre neste dia? (S/N): ");
				abre = sc.nextLine();
			}
            
            if(abre.equalsIgnoreCase("S")) {
            	String horaAbertura = "";
            	String horaFechamento = "";

            	boolean horaValida = false;
            	
            	while(!horaValida)
            	{
            		try {
	            		System.out.print("Horário de abertura (HH:MM): ");
	                    horaAbertura = sc.nextLine();
	                    val.validaHora(horaAbertura);
	                    horaValida = true;
            		} catch (InvalidDateException e) {
            			System.out.println("Erro: " + e.getMessage());
            		}catch (EmptyFieldException e) {
            			System.out.println("Erro: " + e.getMessage());
            		}
            	} 
            	
            	horaValida = false;
                
            	while(!horaValida)
            	{
            		try {
	            		System.out.print("Horário de abertura (HH:MM): ");
	                    horaFechamento = sc.nextLine();
	                    val.validaHora(horaFechamento);
	                    horaValida = true;
            		} catch (InvalidDateException e) {
            			System.out.println("Erro: " + e.getMessage());
            		}catch (EmptyFieldException e) {
            			System.out.println("Erro: " + e.getMessage());
            		}
            	} 
                
                try {
                    String[] partesAbertura = horaAbertura.split(":");
                    String[] partesFechamento = horaFechamento.split(":");

					if(Integer.parseInt(partesAbertura[0]) < 0 || Integer.parseInt(partesAbertura[0]) > 23 ||
					   Integer.parseInt(partesFechamento[0]) < 0 || Integer.parseInt(partesFechamento[0]) > 23){
						System.out.println("\nAs horas de abertura/fechamento devem estar entre 0 e 23 horas.\n");
						i--;
						continue;
					}

					if(Integer.parseInt(partesAbertura[1]) < 0 || Integer.parseInt(partesAbertura[1]) > 59 ||
					   Integer.parseInt(partesFechamento[1]) < 0 || Integer.parseInt(partesFechamento[1]) > 59){
						System.out.println("\nOs minutos de abertura/fechamento devem estar entre 0 e 59 minutos.\n");
						i--;
						continue;
					}
                    
                    LocalTime abertura = LocalTime.of(
                        Integer.parseInt(partesAbertura[0]), 
                        Integer.parseInt(partesAbertura[1])
                    );
                    
                    LocalTime fechamento = LocalTime.of(
                        Integer.parseInt(partesFechamento[0]), 
                        Integer.parseInt(partesFechamento[1])
                    );

					if(fechamento.isBefore(abertura)){
						System.out.println("\nO horário de fechamento não pode ser antes do horário de abertura.\n");
						i--;
						continue;
					}
                    
                    HorarioFuncionamento horario = new HorarioFuncionamento(dia, abertura, fechamento);
                    academia.setHorarioFuncionamento(i, horario);
                    
                    Principal p = new Principal();
            		ManipulacaoArquivos arq = new ManipulacaoArquivos();
            	    try{
            			String json = p.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(academia);
            			arq.gravaJSONPessoa(caminho_arquivo, json);
            			System.out.println("Instrutor alterado com sucesso!");
            		}catch(Exception e){
            			System.out.println(e.getMessage());
            			return;
            		}
                    
                    System.out.println("\nHorário definido com sucesso!");
                    
                } catch(Exception e) {
                    System.out.println("Erro: Formato de hora inválido! Use HH:MM");
					i--;
					continue;
                }
            }else{
            	if(abre.equalsIgnoreCase("N")) {
            		academia.setHorarioFuncionamento(i, null);
            		
            		Principal p = new Principal();
            		ManipulacaoArquivos arq = new ManipulacaoArquivos();
            	    try{
            			String json = p.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(academia);
            			arq.gravaJSONPessoa(caminho_arquivo, json);
            			System.out.println("Instrutor alterado com sucesso!");
            		}catch(Exception e){
            			System.out.println(e.getMessage());
            			return;
            		}

                    System.out.println("Academia fechada neste dia.");
            	}else {
                    System.out.println("\nValor inválido.");
                    i--;
            	}
                
            }

			abre = null;
        }
        
        System.out.println("\nTodos os horários foram definidos!");
    }

    public static void consultarHorarios(Academia academia) {
        System.out.println("\n=== HORÁRIOS DE FUNCIONAMENTO ===");
        System.out.println("─────────────────────────────────────────");
        
        for(int i = 0; i < 7; i++) {
            DiaDaSemana dia = DiaDaSemana.values()[i];
            HorarioFuncionamento horario = academia.getHorarioFuncionamento(i);
            
            if(horario != null) {
                System.out.println(horario);
            } else {
                System.out.printf("%-15s: FECHADO\n", dia.getNome());
            }
        }
        
        System.out.println("─────────────────────────────────────────");
    }
    
    
    private static Academia criarAcademia() {
        Endereco endereco = new Endereco(
            "Rua Sinimbu",           // rua
            "Centro",                // bairro
            1000,                    // numero
            "95020001",               // cep
            "Caxias do Sul",         // cidade
            "RS",                    // uf
            "Térreo"                // complemento
        );
        
        Academia academia = new Academia(
            "ExerciteAki",
            endereco,
            "(54) 3333-3333",
            "www.exerciteaki.com.br"
        );
        
        System.out.println("Academia criada com sucesso!");
        return academia;
    }
    
}