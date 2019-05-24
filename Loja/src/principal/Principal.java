package principal;
import java.io.File;

import action.Action;
import bd.Write;
import beans.Pessoal;
import dados.Dados;
import interf.Login;

public class Principal {
	public static void main(String[] args) {
		//criando o primeiro usuario e colocando no banco de dados
		File f = new File("bd.txt");
		if(!(f.exists())) {
			Pessoal p = new Pessoal();//instancia a classe "Pessoal"
			Write w = new Write();//instancia a classe write
			
			//cria o banco e escreve o primeiro usuario
			w.createFile("bd", true);
			w.printIn("admin,admin,1");
		}
		
		//le o banco separa as informações e add no ArrayList
		Action a = new Action();
		a.cadastrarUsuario("bd.txt");
		
		Login l = new Login();
		l.setLocationRelativeTo(null);
		l.setVisible(true);
		
	}
}
