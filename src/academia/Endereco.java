package academia;

import util.Validacoes;

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
		if(Validacoes.validaString(rua))this.rua = rua;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro)
	{
		if(Validacoes.validaString(bairro))this.bairro = bairro;
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
		if(Validacoes.validaString(cep))this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		if(Validacoes.validaString(cidade))this.cidade = cidade;
	}
	
	public void setEstado(String estado)
	{
		if(Validacoes.validaString(estado))this.estado = estado;
	}
	
	public String getEstado()
	{
		return this.estado;
	}
	
	public String getcomplemento() {
		return complemento;
	}
	
	public void setcomplemento(String complemento) {
		if(Validacoes.validaString(complemento))this.complemento = complemento;
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
