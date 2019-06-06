package formulario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import beans.Aluno;
import beans.Curso;
import conexao.Conexao;
import dao.AlunoDao;
import dao.CursoDao;

public class SelecionarCurso extends JFrame {
    static int row, id; // pegar linha selecionada e id do curso
    String cpf;

    JFrame f = new JFrame();
    JButton btnCadastrar = new JButton("Cadastrar Turma");
    JLabel lblALuno = new JLabel();

    public SelecionarCurso() {
        System.out.println("selecionar "+row);

        setLayout(null);
        setSize(300, 280);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        CursoDao cd = new CursoDao();
        JComboBox<Curso> cmbCurso = new JComboBox<Curso>();
        cmbCurso.setBounds(0, 0, 280, 30);
        cmbCurso.setModel(cd.cmbModel());

        // pegar aluno para mostrar na label
        AlunoDao ad = new AlunoDao();
        try {
            ArrayList<Aluno> alunos = ad.selecionar();
            lblALuno.setText(alunos.get(row).getNome());
            cpf = alunos.get(row).getCpf();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        lblALuno.setBounds(50, 60, 160, 30);

        btnCadastrar.setBounds(50, 90, 160, 40);

        btnCadastrar.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                //valida
                boolean valida = false;

                //conexao
                Conexao c = new Conexao();
                try {
                    //sql
                    String sql = "INSERT INTO turmas (cpfAluno, idCurso) VALUES (?, ?)";

                    //definir id
                    CursoDao cd = new CursoDao();
                    ArrayList<Curso> cursos = cd.selecionar();
                    id = cursos.get(cmbCurso.getSelectedIndex()).getIdCurso();

                    PreparedStatement pstmt = c.con().prepareStatement(sql);
                    pstmt.setString(1, cpf);
                    pstmt.setInt(2, id);
                    pstmt.execute();

                    valida = true;
                    c.con().close();
                } catch (Exception e1) {
                    System.out.println(e1.getMessage());
                }

                JOptionPane.showMessageDialog(null, valida == false ? "Erro ao cadastrar na turma" : "Cadastrado na turma com sucesso" );
                setVisible(false);
            }
        });

        add(lblALuno);
        add(btnCadastrar);
        add(cmbCurso);
    }
}