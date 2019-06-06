package beans;

public class Aluno{
    private String nome, cpf, tel;

    public Aluno(String nome, String cpf, String tel){
        this.nome = nome;
        this.cpf = cpf;
        this.tel = tel;
    }
    public Aluno(){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    
}