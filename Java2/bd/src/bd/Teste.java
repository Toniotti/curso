package bd;

public class Teste {
	
	
	public static void main(String[] args) {
		Write w = new Write();
		w.createFile("testing", true);
		w.printIn("NOVAX"+System.lineSeparator());
		w.printIn("NOVAX22"+System.lineSeparator());
	}
}
