package util;

public enum DiaDaSemana {
    DOMINGO("Domingo", 0, "Dom"),
    SEGUNDA("Segunda-feira", 1, "Seg"),
    TERCA("Terça-feira", 2, "Ter"),
    QUARTA("Quarta-feira", 3, "Qua"),
    QUINTA("Quinta-feira", 4, "Qui"),
    SEXTA("Sexta-feira", 5, "Sex"),
    SABADO("Sábado", 6, "Sáb");
    
    private final String nome;
    private final int codigo;
    private final String sigla;
    
    DiaDaSemana(String nome, int codigo, String sigla) {
        this.nome = nome;
        this.codigo = codigo;
        this.sigla = sigla;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getSigla() {
        return sigla;
    }
    
    @Override
    public String toString() {
        return nome;
    }
    
    public boolean isDiaUtil() {
        return this != DOMINGO && this != SABADO;
    }
}