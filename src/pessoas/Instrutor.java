package pessoas;

import util.Validacoes;

public class Instrutor extends Pessoa{

    private String formacao;

    public Instrutor(){
        super();
    }

    public Instrutor(String nome, String email, String telefone, String formacao, 
    			     String username, String senha){
        super(nome,email,telefone, username, senha);
        
        Validacoes valida = new Validacoes();

        if(this.getNome() == null){
            apagaValores();
            return;
        }

        if(!valida.validaFormacao(formacao)){
            apagaValores();
            return;
        }

        this.formacao = formacao;
    }

    public void setFormacao(String formacao){
    	Validacoes valida = new Validacoes();
    	
        if(!valida.validaFormacao(formacao)){
            return;
        }

        this.formacao = formacao;
    }

    @Override
    public String toString(){
        return super.toString() + "\nFormação: " + this.formacao;
    }
}
