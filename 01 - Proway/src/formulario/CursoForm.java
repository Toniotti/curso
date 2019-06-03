package formulario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beans.Curso;
import dao.CursoDao;
import dao.SegmentoDao;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class CursoForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtValor;
	private JTable Tabela;
	private int linha;

	// limpar os campos e focus
	private void limparCampos(){
		txtNome.setText("");
		txtValor.setText("");
		txtNome.requestFocus();
	}


	public CursoForm() {
		SegmentoDao segmentoDao = new SegmentoDao();
		CursoDao cursoDao = new CursoDao();

		setTitle("Cadastrar Cursos");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 550, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(10, 19, 54, 20);
		contentPane.add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(68, 21, 207, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValor.setBounds(10, 50, 48, 14);
		contentPane.add(lblValor);

		txtValor = new JTextField();
		txtValor.setBounds(68, 44, 207, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);

		JLabel lblSegmento = new JLabel("Segmento:");
		lblSegmento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSegmento.setBounds(10, 76, 83, 21);
		contentPane.add(lblSegmento);

		JComboBox cmbSegmento = new JComboBox();
		cmbSegmento.setBounds(103, 75, 172, 22);
		contentPane.add(cmbSegmento);
		cmbSegmento.setModel(segmentoDao.Selecionar());

		JButton btnCadastrar = new JButton("Cadastrar");
		getRootPane().setDefaultButton(btnCadastrar);
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastrar.setBounds(10, 125, 120, 30);
		contentPane.add(btnCadastrar);

		JScrollPane barraRolagem = new JScrollPane();
		barraRolagem.setBounds(10, 178, 515, 260);
		contentPane.add(barraRolagem);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(140, 125, 120, 30);
		add(btnAlterar);
		

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(270, 125, 120, 30);
		add(btnExcluir);

		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beans.Segmento segmento = (beans.Segmento) cmbSegmento.getSelectedItem();

				// criar objeto cursoBean
				Curso c = new Curso(txtNome.getText(), Double.parseDouble(txtValor.getText()), segmento.getId());

				// excecutar cadastro
				boolean valida = cursoDao.cadastrar(c);

				// mensagem
				JOptionPane.showMessageDialog(null, valida == true ? "Cadastro ok" : "Falha no cadastro");

				limparCampos();

				// atualizar table
				Tabela.setModel(cursoDao.exibirCursos());
			}
		});

		btnAlterar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ArrayList<Curso> cursos = cursoDao.selecionar();
				beans.Segmento segmento = (beans.Segmento) cmbSegmento.getSelectedItem();

				Curso c = new Curso(cursos.get(linha).getIdCurso(), txtNome.getText(), Double.parseDouble(txtValor.getText()), segmento.getId());

				boolean	valida = cursoDao.alterarCurso(c);
				JOptionPane.showMessageDialog(null, valida == true ? "Alterar ok" : "Falha ao alterar");

				limparCampos();

				Tabela.setModel(cursoDao.exibirCursos());

			}
		});

		btnExcluir.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Curso> cursos = cursoDao.selecionar();
				int id = cursos.get(linha).getIdCurso();

				boolean valida = cursoDao.deletarCurso(id);
				System.out.println(valida == true ? "Deletado com sucesso": "Falha ao deletar");

				limparCampos();

				Tabela.setModel(cursoDao.exibirCursos());
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(405, 125, 120, 30);
		add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				limparCampos();

				btnAlterar.setEnabled(false);
				btnCadastrar.setEnabled(true);
				btnCancelar.setEnabled(false);
				btnExcluir.setEnabled(false);
			}
		});
		
		Tabela = new JTable();
		Tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//obter linha selecionada
				linha = Tabela.getSelectedRow();
				
				//obter o ArrayList
				ArrayList<Curso> cursos = cursoDao.selecionar();

				//atribuir valores aos campos
				txtNome.setText(cursos.get(linha).getNomeCurso());
				txtValor.setText(Double.toString(cursos.get(linha).getValorCurso()));

				for(int i=0; i < cursos.size(); i++){
					String opcaoCombo = cmbSegmento.getItemAt(i).toString();
					if(opcaoCombo.equals(cursos.get(linha).getNomeSegmento())){
						cmbSegmento.setSelectedIndex(i);
						break;
					}
				}

				btnAlterar.setEnabled(true);
				btnCadastrar.setEnabled(false);
				btnCancelar.setEnabled(true);
				btnExcluir.setEnabled(true);
			}
		});
		barraRolagem.setViewportView(Tabela);
		Tabela.setModel(cursoDao.exibirCursos());
	}
}
