package dao;

import java.sql.PreparedStatement;

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
}
