package beans;

public class Curso {
	private int idCurso, idSegmento;
	private String nomeCurso, nomeSegmento;
	
	//construtor
	public Curso(String nomeCurso, double valorCurso, int idSegmento) {
		this.nomeCurso = nomeCurso;
		this.valorCurso = valorCurso;
		this.idSegmento = idSegmento;
	}
	//segundo construtor
	public Curso(int idCurso, String nomeCurso, double valorCurso, String nomeSegmento) {
		this.idCurso = idCurso;
		this.nomeCurso = nomeCurso;
		this.valorCurso = valorCurso;
		this.nomeSegmento = nomeSegmento;
	}
	//terciero construtor
	public Curso(int idCurso, String nomeCurso, double valorCurso, int idSegmento){
		this.idCurso = idCurso;
		this.nomeCurso = nomeCurso;
		this.valorCurso = valorCurso;
		this.idSegmento = idSegmento;
	}
	
	public String getNomeSegmento() {
		return nomeSegmento;
	}
	public void setNomeSegmento(String nomeSegmento) {
		this.nomeSegmento = nomeSegmento;
	}
	private double valorCurso;
	
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public int getIdSegmento() {
		return idSegmento;
	}
	public void setIdSegmento(int idSegmento) {
		this.idSegmento = idSegmento;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public double getValorCurso() {
		return valorCurso;
	}
	public void setValorCurso(double valorCurso) {
		this.valorCurso = valorCurso;
	}
}
