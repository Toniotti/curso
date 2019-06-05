package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import beans.Aluno;
import conexao.Conexao;

public class AlunoDao {
    // selecionar do banco de dados
    public ArrayList<Aluno> selecionar() throws SQLException {
        // conexao
        Conexao c = new Conexao();

        // arraylist
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();

        try {
            // sql
            String sql = "SELECT * FROM alunos";

            Statement stmt = c.con().createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Aluno a = new Aluno(rs.getString(1), rs.getString(3), rs.getString(2));
                alunos.add(a);
            }

        } catch (Exception e) {
            System.out.println("try do selecionar: " + e.getMessage());
        }finally{
            c.con().close();
        }

        // retorno
        return alunos;
    }

    // cria modelo de tabela
    public DefaultTableModel modeloTabela() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("Telefone");
        modelo.addColumn("CPF");

        try {
            for (int i = 0; i < selecionar().size(); i++) {
                modelo.addRow(new Object[] { selecionar().get(i).getNome(), selecionar().get(i).getTel(),
                        selecionar().get(i).getCpf() });
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // retorno
        return modelo;
    }

    // cadastrar
    public boolean cadastrarAluno(Aluno a) throws SQLException {
        //criar variavel de validação
        boolean valida = false;

        //Conexao 
        Conexao c = new Conexao();

        try {
            //sql
            String sql = "INSERT INTO alunos(nomeAluno, telefoneAluno, cpfAluno) VALUES (?, ?, ?)";
            PreparedStatement pstmt = c.con().prepareStatement(sql);
            pstmt.setString(1, a.getNome());
            pstmt.setString(2, a.getTel());
            pstmt.setString(3, a.getCpf());
            pstmt.execute();
        } catch (Exception e) {
            System.out.println("Try do cadastrarAluno: "+e.getMessage());
        }finally{
            c.con().close();
        }


        //retorno
        return valida;
    }

    //alterar
    public boolean alterarALuno(Aluno a) throws SQLException {
        //criar variavel de validação
        boolean valida = false;

        //conexao
        Conexao c = new Conexao();

        try {
            //sql
            String sql = "UPDATE alunos SET nomeAluno = ?, telefoneAluno = ? WHERE cpfAluno = ?";

            //executar
            PreparedStatement pstmt = c.con().prepareStatement(sql);
            pstmt.setString(1, a.getNome());
            pstmt.setString(2, a.getTel());
            pstmt.setString(3, a.getCpf());
            pstmt.execute();

            valida = true;
        } catch (Exception e) {
            System.out.println("try do alterarAluno: "+e.getMessage());
        }finally{
            c.con().close();
        }

        //retorno
        return valida;
    }

    //excluir
    public boolean excluirAluno(int linha) throws SQLException {
        //criar varivel de validação
        boolean valida = false;

        //conexao
        Conexao c = new Conexao();

        try {
            //array
            ArrayList<Aluno> alunos = selecionar();

            //sql
            String sql = "DELETE FROM alunos WHERE cpfAluno = ?";

            //executar
            PreparedStatement pstmt = c.con().prepareStatement(sql);
            pstmt.setString(1, alunos.get(linha).getCpf());
            pstmt.execute();

            valida = true;
        } catch (Exception e) {
            System.out.println("try deletarAluno: "+e.getMessage());
        }finally{
            c.con().close();
        }

        //retorno
        return valida;
    }
}