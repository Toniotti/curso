package principal;
import java.io.File;
import java.nio.file.Path;
import bd.Write;
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
		w.lerUsuario(Path.of("bd.txt"), true);
		
		Login l = new Login();
		l.setLocationRelativeTo(null);
		l.setVisible(true);
		
	}
}
