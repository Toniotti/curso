package beans;

public class Segmento {
	//atributos
	private int id;
	private String segmento;
	
	//construtor
	public Segmento(int id, String segmento) {
		this.id = id;
		this.segmento = segmento;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSegmento() {
		return segmento;
	}
	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}
	
	
}
