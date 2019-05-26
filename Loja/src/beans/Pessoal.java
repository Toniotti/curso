package beans;

public class Pessoal {
	//variables
	private String local;
	private int idade, nivel;
	private String name, pass;
	
	
	//set and get
	
	public String getNome() {
		return name;		
	}
	@SuppressWarnings("static-access")
	public void setNome(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	@SuppressWarnings("static-access")
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
}
