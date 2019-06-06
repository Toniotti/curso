package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import beans.Curso;
import beans.Turma;
import conexao.Conexao;

public class TurmaDao {
    // selecionar
    public ArrayList<Turma> selecionarTurma() {
        // criar array
        ArrayList<Turma> turmas = new ArrayList<Turma>();

        // conexao
        Conexao c = new Conexao();

        // pegar info do banco de dados
        try {
            // sql
            String sql = "SELECT turmas.idTurma, alunos.nomeAluno, cursos.nomeCurso FROM turmas INNER JOIN alunos ON alunos.cpfAluno = turmas.cpfAluno INNER JOIN cursos ON cursos.idCurso = turmas.idCurso";

            Statement stmt = c.con().createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Turma t = new Turma(rs.getInt(1), rs.getString(2), rs.getString(3));
                turmas.add(t);
            }

        } catch (Exception e) {
            System.out.println("erro: " + e.getMessage());
        }

        // retorno
        return turmas;

    }

    // table model
    public DefaultTableModel turmaModel() {
        // criar table model
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("CPF");
        model.addColumn("Curso");

        //array
        ArrayList<Turma> turmas = selecionarTurma();

        for(int i = 0; i < turmas.size(); i++){

            model.addRow(new Object[]{
                turmas.get(i).getIdTurma(),
                turmas.get(i).getCpfAluno(),
                turmas.get(i).getNomeCurso()
            });
        }

        //retorno
        return model;
    }
}