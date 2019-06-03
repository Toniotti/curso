package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

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

	//arraylist da tabela
	private ArrayList<Segmento> arrayTabela(){
		//arraylist
		ArrayList<Segmento> segmento = new ArrayList<Segmento>();

		try {
			//sql
		String sql = "SELECT * FROM segmentos";

		//conexao
		Conexao c = new Conexao();

		Statement stmt = c.con().createStatement();

		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
			Segmento s = new Segmento(rs.getInt(1), rs.getString(2));
			segmento.add(s);
		}
		} catch (Exception e) {
			System.out.println("Falha ao criar array: "+e.getMessage());
		}


		return segmento;
	}

	public DefaultTableModel mostrarTabela(){
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("Segmento");

		ArrayList<Segmento> segmento = arrayTabela();
		
		for(int i=0; i < segmento.size(); i++) {
			dados.addRow(new Object[] {
				segmento.get(i).getSegmento(),
			});
		}

		return dados;
	}

	//alterar tabela
	public boolean alterarTabela(int linha){

		//criar variavel de teste
		boolean valida = false;

		try {
			//conexao
			Conexao c = new Conexao();
			
			//pegar dados do array
			ArrayList<Segmento> segmento = arrayTabela();
			segmento.get(linha).getId();

			//sql
			String sql = "UPDATE segmentos SET nomeSegmento = ?";
			PreparedStatement pstmt = 
		} catch (Exception e) {
			//TODO: handle exception
		}

		//retorno
		return valida;
	}

}

