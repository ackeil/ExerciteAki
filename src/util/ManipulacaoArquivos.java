package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import academia.Academia;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ManipulacaoArquivos {
	
	private ObjectMapper mapper;
	
	public ManipulacaoArquivos() {
		this.mapper = new ObjectMapper();
	}

	public Academia leArquivoJSON(String arquivo) {
		String json = null;
		Academia academia = null;
    	try {
			json = this.leArquivo(arquivo);
			if(!json.isEmpty()){
				academia = this.mapper.readValue(json, Academia.class);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
    	
    	return academia;
	}
	
	private String leArquivo(String nomeArquivo) throws IOException {
    	StringBuilder sb = new StringBuilder();
    	FileInputStream fis = new FileInputStream(nomeArquivo);
    	InputStreamReader isr = new InputStreamReader(fis);
    	BufferedReader br = new BufferedReader(isr);
    	String linha;
    	while((linha = br.readLine()) != null) {
    		sb.append(linha);
    		sb.append("\n");
    	}
    	fis.close();
    	return sb.toString();
    }

	public void gravaJSONPessoa(String nomeArquivo, String json) {
    	try {
    		this.gravaArquivo(nomeArquivo, json);
    	} catch (IOException e) {
    		System.out.println(e.getMessage());
    	}
    }

	private void gravaArquivo(String nomeArquivo, String texto) throws IOException {
    	FileWriter fw = new FileWriter(nomeArquivo);
    	fw.write(texto);
    	fw.close();
    }

}
