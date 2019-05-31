package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import beans.Segmento;
import conexao.Conexao;

public class SegmentoDao {
	//cadastrar segmento
	public  boolean cadastrar(String nomeSegmento) {
		
		//verificar cadsatro
		boolean valida = false;
		
		
		//tentativa de cadastro
		try {
			//sql
			String sql = "INSERT INTO segmentos (nomeSegmento) VALUES (?)";
			
			//conexao
			Conexao c = new Conexao();
			
			//executar funcionalidades sql
			PreparedStatement pstmt = c.con().prepareStatement(sql);
			pstmt.setString(1, nomeSegmento);
			pstmt.execute();
			
			//finalizar conexao
			c.con().close();
			
			//adicionar o valor verdadeira
			valida = true;
			
		} catch (Exception e) {
			System.out.println("Falha no cadastro: "+e.getMessage());
		}
		
		
		//retorno
		return valida;
	}
	
	//Selecionar segmento
	public DefaultComboBoxModel<Segmento> Selecionar(){
		
		//instanciar o obj
		DefaultComboBoxModel<Segmento> segmento = new DefaultComboBoxModel<Segmento>();
		
		//tentar obter os dados
		try {
			//sql
			String sql = "SELECT * FROM segmentos";
			
			//conexao
			Conexao c = new Conexao();
			
			//executando query e retornando dados
			Statement stmt = c.con().createStatement();
			ResultSet rs =  stmt.executeQuery(sql);
			
			//finalizar conexao
			c.con().close();
			
			//percorrer o resultSet
			while(rs.next()) {
				Segmento sg = new Segmento(rs.getInt(1), rs.getString(2));
				segmento.addElement(sg);
			}
			
		} catch (Exception e) {
			System.out.println("Falha ao obter os segmentos: "+e.getMessage());
		}
		
		//retorno
		return segmento;
	}

}

