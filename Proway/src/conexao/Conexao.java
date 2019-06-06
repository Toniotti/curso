package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	//metodo de conexao
	public Connection con() {
		//dados de acesso ao bd
		String user = "root";
		String pass = "";
		String host = "jdbc:mysql://localhost/proway";
		
		//variavel de conexao
		Connection conexao = null;
		
		//tentativa de conexao
		try {
			conexao = DriverManager.getConnection(host, user, pass);
		} catch (Exception e) {
			System.out.println("Falha na conexao: "+e.getMessage());
		}
		
		//return 
		return conexao;
	}
	
}
