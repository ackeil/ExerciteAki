package pessoas;

import util.Validacoes;
import sistema.Login;

public abstract class Pessoa{

    private String nome;
    private String email;
    private String telefone;
    private Login login;

    public Pessoa(){
    }

    public Pessoa(String nome, String email, String telefone, String username, String senha){
    	Validacoes valida = new Validacoes();
    	
        if(!valida.validaNome(nome)){
            return;
        }

        if(!valida.validaEmail(email)){
            return;
        }

        if(!valida.validaTelefone(telefone)){
            return;
        }
        
        if(username.trim() == "") {
    		System.out.println("O usuário deve ser informado");
    		return;
    	}

    	if(senha.trim() == "") {
    		System.out.println("A senha deve ser informada");
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
    	
        if(!valida.validaEmail(email)){
            return;
        }

        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setTelefone(String telefone){
    	Validacoes valida = new Validacoes();
    	
        if(!valida.validaTelefone(telefone)){
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