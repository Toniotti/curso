package bd;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;

public class Write {
	
	Path path;
	FileWriter writer;
	
	public void createFile(String fileName, boolean append) {
		
		try {
			writer = new FileWriter(fileName+".txt", append);
			this.path = Path.of(fileName+".txt");
		} catch (Exception e) {
		}
	}
	
	//if the file is created by the "createFile" you don't need to specify a path
	public void printIn(String msg, Path path) {
		try {
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
	
}
