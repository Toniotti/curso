package principal;
import java.io.File;
import bd.Write;
import dados.Dados;
import interf.Login;

public class Principal {
	public static void main(String[] args) {
		//criando o primeiro usuario e colocando no banco de dados
		File f = new File("bd.txt");
		if(!f.exists()) {
			Write w = new Write();//instancia a classe write
			
			//cria o banco e escreve o primeiro usuario
			w.createFile("bd", true);
			w.printIn("admin,admin,1,"+System.lineSeparator());
		}
		Write.fileName = "bd";
		Write.append = true;
		
		//le o banco separa as informações e add no ArrayList
		Write w = new Write();
		w.lerUsuario("bd.txt");
		w.lerAssassino("assassinos.txt");
		
		for (int i = 0; i < Dados.dadosAssassin.size(); i++) {
			System.out.println(Dados.dadosAssassin.get(i).getNome());
		}
		Login l = new Login();
		l.setLocationRelativeTo(null);
		l.setVisible(true);
		
	}
}
