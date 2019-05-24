package bd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;

import action.Action;

public class Write {
	
	public static String fileName;
	public static boolean append;
	
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
	public void printIn(String msg) {
		try {
			System.out.println(this.fileName);
			createFile(this.fileName, this.append);
			PrintWriter printer = new PrintWriter(writer);
			printer.print(msg);
			printer.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//read file
	public String readFile(Path path) {
		String txt="";
		try {
			FileReader reader = new FileReader(path.toString());
			@SuppressWarnings("resource")
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
