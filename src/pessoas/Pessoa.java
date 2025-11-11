package pessoas;

import util.Validacoes;
import sistema.Login;

import exceptions.*;

public abstract class Pessoa{

    private String nome;
    private String email;
    private String telefone;
    private Login login;

    public Pessoa(){
    }

    public Pessoa(String nome, String email, String telefone, String username, String senha){
    	Validacoes valida = new Validacoes();
    	
    	try {
            if(!valida.validaNome(nome)){
                return;
            }
        } catch (EmptyFieldException | InvalidNameException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        try {
            if(!valida.validaEmail(email)){
                return;
            }
        } catch (EmptyFieldException | InvalidEmailException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        try {
            if(!valida.validaTelefone(telefone)){
                return;
            }
        } catch (EmptyFieldException | InvalidPhoneException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }
        
        if(username == null || username.trim().isEmpty()) {
    		System.out.println("Erro: O usuário deve ser informado");
    		return;
    	}

    	if(senha == null || senha.trim().isEmpty()) {
    		System.out.println("Erro: A senha deve ser informada");
    		return;
    	}

        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.login = new Login(username, senha);
    }

    public void setNome(String nome){
        if(nome.trim() == null){
            System.out.println("O nome da pessoa precisa ser preenchido.");
            return;
        }

        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setEmail(String email){
    	Validacoes valida = new Validacoes();
    	
    	try {
            if(!valida.validaEmail(email)){
                return;
            }
        } catch (EmptyFieldException | InvalidEmailException e) {
            System.out.println("Erro: " + e.getMessage());
            return;
        }

        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setTelefone(String telefone){
    	Validacoes valida = new Validacoes();
    	
    	 try {
             if(!valida.validaTelefone(telefone)){
                 return;
             }
         } catch (EmptyFieldException | InvalidPhoneException e) {
             System.out.println("Erro: " + e.getMessage());
             return;
         }

        this.telefone = telefone;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public void apagaValores(){
        this.email = null;
        this.nome = null;
        this.telefone = null;
    }

    public Login getLogin(){
        return this.login;
    }

    @Override
    public String toString(){
        return "Nome    : " + this.nome + "\nTelefone: " + this.telefone + "\nE-mail  : " + this.email;
    }
}