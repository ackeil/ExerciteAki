package sistema;

public class Login{

	private String username;
    private String senha;
    
    public Login() {}
    
    public Login(String user, String senha) {
        this.username = user;
        this.senha = senha;
    }
    
    public boolean realizaLogin(String username, String senha) {
        return this.username.equals(username) && this.senha.equals(senha);
    }
    
    public String getUsername() {
        return this.username;
    }
   
    public void setUsername(String user) {
        this.username = user;
    }
    
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
