package formulario;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import beans.Aluno;
import dao.AlunoDao;

public class AlunoForm extends JFrame {
    JFrame f = new JFrame();
    JLabel lblNome = new JLabel("Nome:");
    JLabel lblCpf = new JLabel("CPF:");
    JLabel lblTelefone = new JLabel("Tele:");

    JTextField txtNome = new JTextField();
    JTextField txtCpf = new JTextField();
    JTextField txtTelefone = new JTextField();

    JButton btnCadastrar = new JButton("Cadastrar");
    JButton btnAlterar = new JButton("Alterar");
    JButton btnExcluir = new JButton("Excluir");
    JButton btnTurma = new JButton("Adicionar Turma");

    int linha;
    AlunoDao alunoDao = new AlunoDao();

    public void limparCampos(){
        txtCpf.setText("");
        txtNome.setText("");
        txtTelefone.setText("");
    }

    public AlunoForm() {
        setLayout(null);
        setSize(500, 400);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setTitle("Alunos");


        lblNome.setBounds(5, 5, 60, 30);
        lblNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtNome.setBounds(70, 10, 150, 20);

        lblCpf.setBounds(5, 40, 60, 30);
        lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtCpf.setBounds(70, 50, 150, 20);

        lblTelefone.setBounds(5, 75, 60, 30);
        lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtTelefone.setBounds(70, 90, 150, 20);

        JScrollPane scroll = new JScrollPane();
        JTable table = new JTable();

        // botao cadastrar
        btnCadastrar.setBounds(10, 125, 120, 40);
        btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnCadastrar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno a = new Aluno(txtNome.getText(), txtCpf.getText(), txtTelefone.getText());
                try {
                    boolean valida = alunoDao.cadastrarAluno(a);
                    JOptionPane.showMessageDialog(null, valida == false ? "Cadastro efetuado com sucesso." : "Erro ao cadastrar.");
                } catch (SQLException e1) {
                    System.out.println("Try form aluno cadastrar: "+e1.getMessage());
                }
                limparCampos();
                table.setModel(alunoDao.modeloTabela());
            }
        });

        //botao alterar
        btnAlterar.setBounds(140, 125, 120, 40);
        btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnAlterar.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno a = new Aluno(txtNome.getText(), txtCpf.getText(), txtTelefone.getText());
                try {
                    boolean valida = alunoDao.alterarALuno(a);
                    JOptionPane.showMessageDialog(null, valida == true ? "Alterado com sucesso." : "Erro ao alterar.");
                } catch (Exception e1) {
                    System.out.println(e1.getMessage());
                }
                limparCampos();
                table.setModel(alunoDao.modeloTabela());
            }
        });

        //botao excluir
        btnExcluir.setBounds(270, 125, 120, 40);
        btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnExcluir.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean valida = alunoDao.excluirAluno(linha);
                    JOptionPane.showMessageDialog(null, valida == true ? "Excluido com sucesso." : "Erro ao excluir.");
                } catch (Exception e1) {
                    System.out.println(e1.getMessage());
                }

                limparCampos();
                table.setModel(alunoDao.modeloTabela());
            }
        });


        table.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e){
                linha = table.getSelectedRow();
                try {
                    txtNome.setText(alunoDao.selecionar().get(linha).getNome());
                    txtCpf.setText(alunoDao.selecionar().get(linha).getCpf());
                    txtTelefone.setText(alunoDao.selecionar().get(linha).getTel());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                btnTurma.setEnabled(true);
            }
        });

        btnTurma.setBounds(250, 20, 140, 30);
        btnTurma.setEnabled(false);
        btnTurma.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                SelecionarCurso.row = table.getSelectedRow();
                SelecionarCurso sc = new SelecionarCurso();
                sc.setVisible(true);
            }
        });

        scroll.setBounds(10, 180, 465, 170);
        scroll.setViewportView(table);
        table.setModel(alunoDao.modeloTabela());

        //adds
        add(lblNome);
        add(txtNome);
        add(lblCpf);
        add(txtCpf);
        add(lblTelefone);
        add(txtTelefone);
        add(btnCadastrar);
        add(btnAlterar);
        add(btnExcluir);
        add(btnTurma);
        add(scroll);

    }
}