package principal;

import formulario.CursoForm;
import formulario.Segmento;

public class Principal {
	public static void main(String[] args) {
		Segmento s = new Segmento();
		s.setVisible(false);
		CursoForm c = new CursoForm();
		c.setVisible(true);
	}
}
