package util;

import exceptions.*;

public class Validacoes {
	public Validacoes() {};
	
	/**
	 * Validates a string is not null or empty (STATIC method - unchanged signature)
	 * @throws EmptyFieldException if string is null or empty
	 */
	public static boolean validaString(String string)
	{
		if(string == null || string.trim().isEmpty())
		{
			throw new IllegalArgumentException("Strings nao podem ser vazias!");
		}
		return true;
	}
	
	/**
	 * Validates email format
	 * @throws InvalidEmailException if email format is invalid
	 */
	public boolean validaEmail(String email) {
        if(email == null || email.trim().isEmpty()){
            throw new IllegalArgumentException("O email da pessoa precisa ser preenchido.");
        }
        if(!email.toLowerCase().matches("[a-z0-9._-]+@[a-z0-9.-]+\\.[a-z]{2,}")){
            throw new IllegalArgumentException("Formato de e-mail inválido: " + email);
        }

        return true;
    }

    /**
     * Validates phone format
     * @throws InvalidPhoneException if phone format is invalid
     */
    public boolean validaTelefone(String telefone) {
        if(telefone == null || telefone.trim().isEmpty()){
            throw new IllegalArgumentException("O telefone da pessoa precisa ser preenchido.");
        }

        if(!telefone.matches("[(][0-9]{2}[)] 9[0-9]{4}-[0-9]{4}")){
            throw new IllegalArgumentException("Formato de telefone inválido");
        }

        String ddd = telefone.substring(1,3);
        if(!ddd.matches("([14689][1-9])|(2[12478])|(3[1234578])|(5[1345])|(7[134579])")){
            throw new IllegalArgumentException("DDD inválido");
        }

        return true;
    }

    /**
     * Validates name format
     * @throws InvalidNameException if name contains invalid characters
     */
    public boolean validaNome(String nome) {
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("O nome da pessoa precisa ser preenchido.");
        }

        if(nome.matches(".*[0-9!@#$%¨&*()_+=\\[\\]{}\\\\|;:\",.<>/?`~^].*")){
            throw new IllegalArgumentException("O nome não pode conter números, pontuação ou caracteres especiais: " + nome);
        }

        return true;
    }

    /**
     * Validates date format and validity
     * @throws InvalidDateException if date format or value is invalid
     */
    public boolean validaData(String data) {
        if(data == null || data.trim().isEmpty()){
            throw new IllegalArgumentException("A data precisa ser preenchida");
        }

        if(!data.matches("((0[1-9])|([1-2][0-9])|(3[0-1]))/((0[1-9])|(1[0-2]))/((19[3-9][0-9])|(20[0-1][0-3]))")){
            throw new IllegalArgumentException("Formato da data é inválido");
        }

        String mes = data.substring(3,5);

        if(data.substring(0,2).equals("31")){
            if(mes.equals("02") || mes.equals("04") || mes.equals("06") || mes.equals("09") || mes.equals("11")){
                throw new IllegalArgumentException("Data inválida");
            }
        }

        if(mes.equals("02")){
            if(data.substring(0,2).equals("30")){
                throw new IllegalArgumentException("Data inválida");
            }

            if(data.substring(0,2).equals("29")){
                if((Integer.parseInt(data.substring(6)) % 4) == 0){
                    if((Integer.parseInt(data.substring(6)) % 100) == 0){
                        throw new IllegalArgumentException("Data inválida");
                    }
                }else{
                    if((Integer.parseInt(data.substring(6)) % 400) != 0){
                        throw new IllegalArgumentException("Data inválida");
                    }
                }
            }
        }

        return true;
    }

    /**
     * Validates height value
     * @throws InvalidHeightException if height is invalid
     */
    public boolean validaAltura(float altura) {
        if(altura <= 0.5f){
            throw new IllegalArgumentException("Altura inválida");
        }

        return true;
    }

    /**
     * Validates instructor formation
     * @throws InvalidFormacaoException if formation contains invalid characters
     */
    public boolean validaFormacao(String formacao) {
        if(formacao == null || formacao.trim().isEmpty()){
            throw new IllegalArgumentException("A formação precisa ser informada");
        }

        if(formacao.matches(".*[0-9!@#$%¨&*()_=+{},.;:><?°ªº₢]+.*")){
            throw new IllegalArgumentException("O nome da formação não pode conter caracteres especiais");
        }

        return true;
    }

    /**
     * Validates time format
     */
    public boolean validaHora(String hora) {
        if (hora == null || hora.trim().isEmpty()) {
            throw new IllegalArgumentException("A hora deve ser informada");
        }

        if (!hora.matches("(([0-1][0-9])|(2[0-3])):[0-5][0-9]")) {
            throw new IllegalArgumentException("O formato da hora é inválido");
        }

        return true;
    }

    /**
     * Validates if a date/time combination already exists
     */
    public boolean validaHorarioJaExistente(String[] dataEntrada, String[] horaEntrada,
                                            String novaData, String novaHora) {
        int count = dataEntrada.length;

        boolean achou = false;
        for(int i = 0; i < count; i++){
            if(novaData.equals(dataEntrada[i]) && novaHora.equals(horaEntrada[i])){
                achou = true;
                break;
            }
        }
        if(achou){
            throw new IllegalArgumentException("Essa data e hora já foram incluídos para essa pessoa");
        }

        return true;
    }
    
    /**
     * NEW METHOD: Validates number of repetitions in an exercise
     * @throws ExcessiveRepetitionsException if repetitions exceed maximum
     */
    public boolean validaRepeticoes(int repeticoes) {
        final int MAX_REPETICOES = 50;
        if(repeticoes > MAX_REPETICOES) {
            throw new IllegalArgumentException("Número excessivo de repetições: " + repeticoes + 
                      ". Máximo recomendado: " + MAX_REPETICOES);
        }
        return true;
    }
}
