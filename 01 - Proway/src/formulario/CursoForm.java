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

public class CursoForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtValor;
	private JTable Tabela;

	public CursoForm() {
		SegmentoDao segmentoDao = new SegmentoDao();
		CursoDao cursoDao = new CursoDao();
		
		setTitle("Cadastrar Cursos");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 327, 488);
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
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				beans.Segmento segmento = (beans.Segmento) cmbSegmento.getSelectedItem();
				
				//criar objeto cursoBean
				Curso c = new Curso(txtNome.getText(), Double.parseDouble(txtValor.getText()), segmento.getId());				
				
				//excecutar cadastro
				boolean valida = cursoDao.cadastrar(c);
				
				//mensagem
				JOptionPane.showMessageDialog(null, valida == true ? "Cadastro ok" : "Falha no cadastro");
				
				//limpar os campos e focus
				txtNome.setText("");
				txtValor.setText("");
				txtNome.requestFocus();
				
				//atualizar table
				Tabela.setModel(cursoDao.exibirCursos());
			}
		});
		getRootPane().setDefaultButton(btnCadastrar);
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCadastrar.setBounds(68, 125, 151, 35);
		contentPane.add(btnCadastrar);
		
		JScrollPane barraRolagem = new JScrollPane();
		barraRolagem.setBounds(10, 178, 291, 260);
		contentPane.add(barraRolagem);
		
		Tabela = new JTable();
		Tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//obter linha selecionada
				int linha = Tabela.getSelectedRow();

			}
		});
		barraRolagem.setViewportView(Tabela);
		Tabela.setModel(cursoDao.exibirCursos());
	}
}
