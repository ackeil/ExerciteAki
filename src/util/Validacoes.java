package util;

import exceptions.*;

public class Validacoes {
	public Validacoes() {};
	
	/**
	 * Validates a string is not null or empty (STATIC method)
	 * @throws EmptyFieldException if string is null or empty
	 */
	public static boolean validaString(String string) throws EmptyFieldException
	{
		if(string == null || string.trim().isEmpty())
		{
			throw new EmptyFieldException("Campo texto");
		}
		return true;
	}
	
	/**
	 * Validates email format
	 * @throws EmptyFieldException if email is null or empty
	 * @throws InvalidEmailException if email format is invalid
	 */
	public boolean validaEmail(String email) throws EmptyFieldException, InvalidEmailException {
        if(email == null || email.trim().isEmpty()){
            throw new EmptyFieldException("email");
        }
        if(!email.toLowerCase().matches("[a-z0-9._-]+@[a-z0-9.-]+\\.[a-z]{2,}")){
            throw new InvalidEmailException(email);
        }

        return true;
    }

    /**
     * Validates phone format
     * @throws EmptyFieldException if phone is null or empty
     * @throws InvalidPhoneException if phone format is invalid or DDD is invalid
     */
    public boolean validaTelefone(String telefone) throws EmptyFieldException, InvalidPhoneException {
        if(telefone == null || telefone.trim().isEmpty()){
            throw new EmptyFieldException("telefone");
        }

        if(!telefone.matches("[(][0-9]{2}[)] 9[0-9]{4}-[0-9]{4}")){
            throw new InvalidPhoneException(telefone);
        }

        String ddd = telefone.substring(1,3);
        if(!ddd.matches("([14689][1-9])|(2[12478])|(3[1234578])|(5[1345])|(7[134579])")){
            throw new InvalidPhoneException(telefone, "DDD inválido");
        }

        return true;
    }

    /**
     * Validates name format
     * @throws EmptyFieldException if name is null or empty
     * @throws InvalidNameException if name contains invalid characters
     */
    public boolean validaNome(String nome) throws EmptyFieldException, InvalidNameException {
        if(nome == null || nome.trim().isEmpty()){
            throw new EmptyFieldException("nome");
        }

        if(nome.matches(".*[0-9!@#$%¨&*()_+=\\[\\]{}\\\\|;:\",.<>/?`~^].*")){
            throw new InvalidNameException(nome);
        }

        return true;
    }

    /**
     * Validates date format and validity
     * @throws EmptyFieldException if date is null or empty
     * @throws InvalidDateException if date format or value is invalid
     */
    public boolean validaData(String data) throws EmptyFieldException, InvalidDateException {
        if(data == null || data.trim().isEmpty()){
            throw new EmptyFieldException("data");
        }

        if(!data.matches("((0[1-9])|([1-2][0-9])|(3[0-1]))/((0[1-9])|(1[0-2]))/((19[3-9][0-9])|(20[0-1][0-3]))")){
            throw new InvalidDateException(data, "Formato da data é inválido");
        }

        String mes = data.substring(3,5);

        if(data.substring(0,2).equals("31")){
            if(mes.equals("02") || mes.equals("04") || mes.equals("06") || mes.equals("09") || mes.equals("11")){
                throw new InvalidDateException(data, "Dia inválido para o mês informado");
            }
        }

        if(mes.equals("02")){
            if(data.substring(0,2).equals("30")){
                throw new InvalidDateException(data, "Fevereiro não tem 30 dias");
            }

            if(data.substring(0,2).equals("29")){
                int ano = Integer.parseInt(data.substring(6));
                if((ano % 4) == 0){
                    if((ano % 100) == 0 && (ano % 400) != 0){
                        throw new InvalidDateException(data, "Ano não é bissexto");
                    }
                }else{
                    throw new InvalidDateException(data, "Ano não é bissexto");
                }
            }
        }

        return true;
    }

    /**
     * Validates height value
     * @throws InvalidHeightException if height is invalid
     */
    public boolean validaAltura(float altura) throws InvalidHeightException {
        if(altura <= 0.5f){
            throw new InvalidHeightException(altura);
        }

        return true;
    }

    /**
     * Validates instructor formation
     * @throws EmptyFieldException if formation is null or empty
     * @throws InvalidFormacaoException if formation contains invalid characters
     */
    public boolean validaFormacao(String formacao) throws EmptyFieldException, InvalidFormacaoException {
        if(formacao == null || formacao.trim().isEmpty()){
            throw new EmptyFieldException("formação");
        }

        if(formacao.matches(".*[0-9!@#$%¨&*()_=+{},.;:><?°ªº₢]+.*")){
            throw new InvalidFormacaoException(formacao);
        }

        return true;
    }

    /**
     * Validates time format
     * @throws EmptyFieldException if time is null or empty
     * @throws InvalidDateException if time format is invalid (reusing exception for time)
     */
    public boolean validaHora(String hora) throws EmptyFieldException, InvalidDateException {
        if (hora == null || hora.trim().isEmpty()) {
            throw new EmptyFieldException("hora");
        }

        if (!hora.matches("(([0-1][0-9])|(2[0-3])):[0-5][0-9]")) {
            throw new InvalidDateException(hora, "O formato da hora é inválido");
        }

        return true;
    }

    /**
     * Validates if a date/time combination already exists
     * @throws ScheduleConflictException if the date/time already exists
     */
    public boolean validaHorarioJaExistente(String[] dataEntrada, String[] horaEntrada,
                                            String novaData, String novaHora) throws ScheduleConflictException {
        int count = dataEntrada.length;

        for(int i = 0; i < count; i++){
            if(novaData.equals(dataEntrada[i]) && novaHora.equals(horaEntrada[i])){
                throw new ScheduleConflictException("Essa data e hora já foram incluídos para essa pessoa");
            }
        }

        return true;
    }
    
    /**
     * Validates number of repetitions in an exercise
     * @throws ExcessiveRepetitionsException if repetitions exceed maximum
     */
    public boolean validaRepeticoes(int repeticoes) throws ExcessiveRepetitionsException {
        final int MAX_REPETICOES = 50;
        if(repeticoes > MAX_REPETICOES) {
            throw new ExcessiveRepetitionsException(repeticoes);
        }
        return true;
    }
}
