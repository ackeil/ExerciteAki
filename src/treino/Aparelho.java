package treino;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")

public class Aparelho {

	private static int contadorID = 1;
	private int ID;
	private String nome;
	private String descricao;
	private String funcao;

	public Aparelho() {
		this.ID = contadorID++;
	};
	
	public Aparelho(String nome, String descricao, String funcao) {
		super();
		this.ID = contadorID++;
		this.nome = nome;
		this.descricao = descricao;
		this.funcao = funcao;
	}
	
	public int getID(){
		return ID;
	}
	
	public void setID(int ID){
		this.ID = ID;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	@Override
	public String toString()
	{
		return "Nome do aparelho: " + getNome() +
				" Descricao: " + getDescricao() + 
				" Funcao: " + getFuncao();
	}

}
