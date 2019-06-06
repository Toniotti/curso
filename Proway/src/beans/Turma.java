package beans;

public class Turma{
    private int idTurma;
    private String cpfAluno, nomeCurso;

    public Turma(int idTurma, String cpfAluno, String nomeCurso) {
        this.idTurma = idTurma;
        this.cpfAluno = cpfAluno;
        this.nomeCurso = nomeCurso;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }
    public String getCpfAluno() {
        return cpfAluno;
    }

    public void setCpfAluno(String cpfAluno) {
        this.cpfAluno = cpfAluno;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    
}