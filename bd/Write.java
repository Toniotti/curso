package bd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;

public class Write {
	
	String fileName;
	boolean append;
	
	Path path;
	FileWriter writer;
	
	//create the file
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
	public void printIn(String msg, Path path) {
		try {
			createFile(this.fileName, this.append);
			PrintWriter printer = new PrintWriter(writer);
			printer.print(msg);
			printer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void printIn(String msg) {
		try {
			printIn(msg, this.path);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//read file
	//if the file is created by the "createFile" you don't need to specify a path
	
	public String readFile(Path path) {
		String txt="";
		try {
			FileReader reader = new FileReader(path.toString());
			BufferedReader bfr = new BufferedReader(reader);
			String ln = "";
			while((ln = bfr.readLine()) != null) {
				txt += ln;
			}
		} catch (Exception e) {
			txt = "Error";
		}
		
		return txt;
	}
	
	public String readFile() {
		return readFile(this.path);
	}
	//comentario de teste
	
}
