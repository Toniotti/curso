package principal;

import beans.Pessoal;
import dados.Dados;
import interf.Login;

public class Principal {
	public static void main(String[] args) {
		Pessoal p = new Pessoal();//instancia a classe "Pessoal"
		//matheus gota de furry
		//seta o primeiro usuario, no caso o administrador
		p.setNome("admin");
		p.setPass("admin");
		Dados.dadosPessoal.add(p);
		
		Login l = new Login();
		l.setLocationRelativeTo(null);
		l.setVisible(true);
		
	}
}
