package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class CursoForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtValor;

	public CursoForm() {
		setTitle("Cadastrar Cursos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 327, 274);
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
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCadastrar.setBounds(68, 177, 151, 35);
		contentPane.add(btnCadastrar);
	}
}
