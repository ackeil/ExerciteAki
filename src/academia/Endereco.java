package academia;

import util.Validacoes;
import exceptions.*;

public class Endereco {
	
	private String rua;
	private String bairro;
	private Integer nro;
	private String cep;
	private String cidade;
	private String estado;
	private String complemento;
	
	public Endereco()
	{
		
	}
	
	public Endereco(String rua, String bairro, Integer nro, String cep, String cidade, String estado, String complemento)
	{
		this.rua = rua;
		this.bairro = bairro;
		this.nro = nro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.complemento = complemento;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		try {
			if(Validacoes.validaString(rua)) this.rua = rua;
		} catch (EmptyFieldException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro)
	{
		try {
			if(Validacoes.validaString(bairro)) this.bairro = bairro;
		} catch (EmptyFieldException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public Integer getNro() {
		return nro;
	}

	public void setNro(Integer nro) {
		this.nro = nro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		try {
			if(Validacoes.validaString(cep)) this.cep = cep;
		} catch (EmptyFieldException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		try {
			if(Validacoes.validaString(cidade)) this.cidade = cidade;
		} catch (EmptyFieldException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public void setEstado(String estado)
	{
		try {
			if(Validacoes.validaString(estado)) this.estado = estado;
		} catch (EmptyFieldException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public String getEstado()
	{
		return this.estado;
	}
	
	public String getcomplemento() {
		return complemento;
	}
	
	public void setcomplemento(String complemento) {
		try {
			if(Validacoes.validaString(complemento)) this.complemento = complemento;
		} catch (EmptyFieldException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
	public String toString()
	{
		return
				"Rua: " 		+ this.rua + "\n" +
				"Bairro: "  	+ this.bairro + "\n" +
				"Nro: " 		+ this.nro + "\n" + 
				"CEP: " 		+ this.cep + "\n" +
				"Cidade: " 		+ this.cidade + "\n" + 
				"Estado: "      + this.estado + "\n" + 
				"complemento: " 	+ this.complemento + "\n";
	}
}
