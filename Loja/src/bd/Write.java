package bd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import beans.Pessoal;
import dados.Dados;

public class Write {
	
	public static String fileName;
	public static boolean append;
	
	Path path;
	FileWriter writer;

	
	//create the file
	@SuppressWarnings("static-access")
	public void createFile(String fileName, boolean append) {
		try {
			this.fileName = fileName;
			this.append = append;
			writer = new FileWriter(fileName+".txt", append);
			this.path = Path.of(fileName+".txt");
			
		} catch (Exception e) {
		}
		
	}
	
	//insert text in file
	//if the file is created by the "createFile" you don't need to specify a path
	@SuppressWarnings("static-access")
	public void printIn(String msg) {
		try {
			createFile(this.fileName, this.append);
			PrintWriter printer = new PrintWriter(writer);
			printer.print(msg);
			printer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//read file
	public void lerUsuario(Path path, boolean cad) {
		try {
			FileReader reader = new FileReader(path.toString());
			@SuppressWarnings("resource")
			BufferedReader bfr = new BufferedReader(reader);
			String ln = "";
			while((ln = bfr.readLine()) != null) {
				if(cad == true) {
					String[] str = ln.split(",");
					Pessoal p = new Pessoal();
					p.setNome(str[0]);
					p.setPass(str[1]);
					p.setNivel(Integer.parseInt(str[2]));
					
					Dados.dadosPessoal.add(p);
				}
			}
		} catch (Exception e) {
		}
	}
	
	@SuppressWarnings("unused")
	public static int lineCounter(Path path) {
		int line = 0;
		try {
		FileReader reader = new FileReader(path.toString());
		@SuppressWarnings("resource")
		BufferedReader bfr = new BufferedReader(reader);
		String ln = "";
		while((ln = bfr.readLine()) != null) {
			line++;
		}
		}catch(Exception e){
			
		}
		
		return line;
	}
	
}
