package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import beans.Segmento;
import conexao.Conexao;

public class SegmentoDao {
	// cadastrar segmento
	public boolean cadastrar(String nomeSegmento) {

		// verificar cadsatro
		boolean valida = false;

		// tentativa de cadastro
		try {
			// sql
			String sql = "INSERT INTO segmentos (nomeSegmento) VALUES (?)";

			// conexao
			Conexao c = new Conexao();

			// executar funcionalidades sql
			PreparedStatement pstmt = c.con().prepareStatement(sql);
			pstmt.setString(1, nomeSegmento);
			pstmt.execute();

			// finalizar conexao
			c.con().close();

			// adicionar o valor verdadeira
			valida = true;

		} catch (Exception e) {
			System.out.println("Falha no cadastro: " + e.getMessage());
		}

		// retorno
		return valida;
	}

	// Selecionar segmento
	public DefaultComboBoxModel<Segmento> Selecionar() {

		// instanciar o obj
		DefaultComboBoxModel<Segmento> segmento = new DefaultComboBoxModel<Segmento>();

		// tentar obter os dados
		try {
			// sql
			String sql = "SELECT * FROM segmentos";

			// conexao
			Conexao c = new Conexao();

			// executando query e retornando dados
			Statement stmt = c.con().createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// finalizar conexao
			c.con().close();

			// percorrer o resultSet
			while (rs.next()) {
				Segmento sg = new Segmento(rs.getInt(1), rs.getString(2));
				segmento.addElement(sg);
			}

		} catch (Exception e) {
			System.out.println("Falha ao obter os segmentos: " + e.getMessage());
		}

		// retorno
		return segmento;
	}

	// arraylist da tabela
	public ArrayList<Segmento> arrayTabela() {
		// arraylist
		ArrayList<Segmento> segmento = new ArrayList<Segmento>();

		try {
			// sql
			String sql = "SELECT * FROM segmentos";

			// conexao
			Conexao c = new Conexao();

			Statement stmt = c.con().createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Segmento s = new Segmento(rs.getInt(1), rs.getString(2));
				segmento.add(s);
			}
		} catch (Exception e) {
			System.out.println("Falha ao criar array: " + e.getMessage());
		}

		return segmento;
	}

	public DefaultTableModel mostrarTabela() {
		DefaultTableModel dados = new DefaultTableModel();
		dados.addColumn("Segmento");

		ArrayList<Segmento> segmento = arrayTabela();

		for (int i = 0; i < segmento.size(); i++) {
			dados.addRow(new Object[] { segmento.get(i).getSegmento(), });
		}

		return dados;
	}

	// alterar tabela
	public boolean alterarTabela(String segmento, int linha) throws SQLException {

		// criar variavel de validação
		boolean valida = false;
		
		// conexao
		Conexao c = new Conexao();

		try {

			// pegar dados do array
			ArrayList<Segmento> segmentos = arrayTabela();

			// sql
			String sql = "UPDATE segmentos SET nomeSegmento = ? WHERE idSegmento = ?";
			PreparedStatement pstmt = c.con().prepareStatement(sql);
			pstmt.setString(1, segmento);
			pstmt.setInt(2, segmentos.get(linha).getId());
			pstmt.execute();

			// atualiza a validação
			valida = true;
		} catch (Exception e) {
			System.out.println("Erro ao alterar segmento: " + e.getMessage());
		}finally{
			c.con().close();
		}

		// retorno
		return valida;
	}

	// deletar segmento
	public boolean deletar(int linha) throws SQLException {
		//criar variavel de validação
		boolean valida = false;

		//conexao
		Conexao c = new Conexao();

		try {
			

			//sql
			String sql = "DELETE FROM segmentos WHERE idSegmento = ?";
			String count = "SELECT COUNT(idSegmento) FROM cursos WHERE idSegmento = ?";

			//arrayList
			ArrayList<Segmento> segmentos = arrayTabela();

			//verifica se o segmento está sendo utilizado em cursos
			PreparedStatement pstmt = c.con().prepareStatement(count);
			pstmt.setInt(1, segmentos.get(linha).getId());
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			if(rs.getInt(1) == 0){
				c.con().close();
				PreparedStatement pstmt2 = c.con().prepareStatement(sql);
				pstmt2.setInt(1, segmentos.get(linha).getId());
				pstmt2.execute();
	
				//atualiza variavel de validação
				valida = true;
			}else{
				JOptionPane.showMessageDialog(null, "O segmento está sendo utilizado, portanto não pode ser deletado.");
			}

		} catch (Exception e) {
			System.out.println("Erro ao deletar: "+e.getMessage());
		}finally{
			c.con().close();
		}

		//retorno
		return valida;
	}

}

