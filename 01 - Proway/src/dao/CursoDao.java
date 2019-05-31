package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import beans.Curso;
import conexao.Conexao;

public class CursoDao {
	//cadastrar curso
	public boolean cadastrar(Curso c) {
		
		//validar
		boolean valida = false;
		
		//tentativa de cadastro
		try {
			//sql
			String sql = "INSERT INTO cursos (nomeCurso, valorCurso, idSegmento) VALUES (?, ?, ?)";
			
			//conexao
			Conexao connect = new Conexao();
			
			//realizar cadastro
			PreparedStatement pstmt = connect.con().prepareStatement(sql);
			pstmt.setString(1, c.getNomeCurso());
			pstmt.setDouble(2, c.getValorCurso());
			pstmt.setInt(3, c.getIdSegmento());
			pstmt.execute();
			
			//finaliza a conexao
			connect.con().close();
			
			//atualiza retorno
			valida = true;
		} catch (Exception e) {
			System.out.println("Erro no cadastro: "+e.getMessage());
		}
		
		return valida;
	}
	
	//obter cursos
	public ArrayList<Curso> selecionar(){
		//array list
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		
		
		
		//tentativa
		try {
			//sql
			String sql = "SELECT cursos.idCurso, cursos.nomeCurso, cursos.valorCurso, segmentos.nomeSegmento FROM cursos INNER JOIN segmentos ON cursos.idSegmento = segmentos.idSegmento";
			
			//conexao
			Conexao con = new Conexao();
			
			//executar
			Statement stmt = con.con().createStatement();
			
			//obeter resultado
			ResultSet rs = stmt.executeQuery(sql);
			
			//fechar conexao
			con.con().close();
			
			//madionar elementos ao arraylist
			while (rs.next()) {
				Curso c = new Curso(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4));
				cursos.add(c);
			}
			
		} catch (Exception e) {
			System.out.println("Falha no selecionar cursos: "+e.getMessage());
		}
		
		//retorno
		return cursos;
	}
	
	//exibir dados
	public DefaultTableModel exibirCursos(){
		//table model
		DefaultTableModel dados = new DefaultTableModel();
		
		//colunas
		dados.addColumn("Curso");
		dados.addColumn("Valor");
		dados.addColumn("Segmento");
		
		//adicionar dados
		ArrayList<Curso> cursos = selecionar();
		
		for(int i=0; i < cursos.size(); i++) {
			dados.addRow(new Object[] {
					cursos.get(i).getNomeCurso(),
					cursos.get(i).getValorCurso(),
					cursos.get(i).getNomeSegmento(),
			});
		}
		
		
		//retorno
		return dados;
	}
}
