package interf;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Interface extends JFrame {

	private JPanel contentPane;
	private JTextField nomee;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public static String nome;
	public static int nivel;
	
	
	public Interface() {
		
		setFont(new Font("Dialog", Font.BOLD, 17));
		setForeground(Color.RED);
		setTitle("PROGRAMINHA MATADOR VINDO DIRETO DA DEEPWEB");
		
		JButton btnNewButton_1 = new JButton("Cadastrar");
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(622, 483, 82, 23);
	
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setBounds(601, 359, 103, 23);
		
		
		//Ocultar caso usuario nao seja ADMIN
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBackground(Color.RED);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemover.setBounds(501, 359, 90, 23);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(Color.RED);
		btnExcluir.setBounds(534, 483, 89, 23);
		
		
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 556);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(449, 11, 255, 337);
	    contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(120, 11, 2, 2);
		panel.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("Assassinos Disponiveis");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(43, 0, 171, 25);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 24, 235, 302);
		panel.add(scrollPane_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(449, 11, 255, 337);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblB = new JLabel("B");
		lblB.setBounds(124, 5, 6, 14);
		panel_1.add(lblB);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 26, 225, 300);
		panel_1.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		JButton btnNewButton = new JButton("") 	;
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\i3i\\Desktop\\Java\\Loja\\src\\interf\\newx.gif"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				    
				    btnExcluir.setEnabled(true);
				    btnNewButton.setEnabled(true);
				    btnNewButton_1.setEnabled(true);
				panel.setVisible(true);
			panel_1.setVisible(false);
			}
		});
		JPanel AdminC = new JPanel();
		AdminC.setBorder(new LineBorder(Color.RED));
		AdminC.setForeground(Color.DARK_GRAY);
		AdminC.setBackground(Color.BLACK);
		AdminC.setBounds(10, 42, 290, 173);
		contentPane.add(AdminC);
		AdminC.setLayout(null);
		AdminC.setVisible(false);
		
		JLabel lblaaa = new JLabel("             *-------Cadastro-------*");
		lblaaa.setForeground(Color.RED);
		lblaaa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblaaa.setBounds(10, 11, 344, 14);
		AdminC.add(lblaaa);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.RED);
		lblNome.setBounds(20, 36, 42, 14);
		AdminC.add(lblNome);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.RED);
		textField_1.setBackground(Color.BLACK);
		textField_1.setBounds(61, 34, 96, 20);
		AdminC.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setForeground(Color.RED);
		lblIdade.setBounds(167, 36, 42, 14);
		AdminC.add(lblIdade);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.RED);
		textField_2.setBackground(Color.BLACK);
		textField_2.setColumns(10);
		textField_2.setBounds(201, 33, 48, 20);
		AdminC.add(textField_2);
		
		JLabel lblLocalDeAo = new JLabel("Local de a\u00E7\u00E3o");
		lblLocalDeAo.setForeground(Color.RED);
		lblLocalDeAo.setBounds(20, 64, 96, 14);
		AdminC.add(lblLocalDeAo);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.RED);
		textField_3.setBackground(Color.BLACK);
		textField_3.setColumns(10);
		textField_3.setBounds(106, 61, 143, 20);
		AdminC.add(textField_3);
		
		JLabel lblNewLabel_1 = new JLabel("Estilo de Assassinato");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(20, 89, 137, 14);
		AdminC.add(lblNewLabel_1);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.BLACK);
		comboBox.setForeground(Color.RED);
		comboBox.setBounds(146, 85, 103, 22);
		comboBox.addItem("*Desconhecido*");
		comboBox.addItem("Armas de Fogo");
		comboBox.addItem("Veneno");
		comboBox.addItem("Armas Brancas");
		comboBox.addItem("Atropelamento");
		comboBox.addItem("Explosivos");
		AdminC.add(comboBox);
		
		JLabel lblCustoBase = new JLabel("Custo Base");
		lblCustoBase.setForeground(Color.RED);
		lblCustoBase.setBounds(20, 117, 70, 14);
		AdminC.add(lblCustoBase);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.RED);
		textField_4.setBackground(Color.BLACK);
		textField_4.setColumns(10);
		textField_4.setBounds(93, 114, 76, 20);
		AdminC.add(textField_4);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Exce\u00E7oes");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(20, 142, 48, 14);
		AdminC.add(lblNewLabel_2);
		;
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBackground(Color.BLACK);
		comboBox_1.setForeground(Color.RED);
		comboBox_1.setBounds(81, 138, 113, 22);
		comboBox_1.addItem("Crianças, Idosos...");
		comboBox_1.addItem("Politicos");
		comboBox_1.addItem("Artistas");
		comboBox_1.addItem("Inocentes");
		
		AdminC.add(comboBox_1);
		btnNewButton.setBounds(310, 30, 116, 136);
		contentPane.add(btnNewButton);
		
		//Ocultar caso usuario nao seja ADMIN
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelar.setEnabled(true);
				panel.setVisible(true);
				panel_1.setVisible(false);
				AdminC.setVisible(true);
			}
		});
		
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelar.setEnabled(false);
				
				
				AdminC.setVisible(false);
			    btnExcluir.setEnabled(true);
			    btnNewButton.setEnabled(true);
			    btnNewButton_1.setEnabled(true);
			}
		});
		
		
		
	
		
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		;
		
		nomee = new JTextField();
		nomee.setBackground(Color.RED);
		nomee.setEditable(false);
		nomee.setBounds(10, 484, 158, 20);
		contentPane.add(nomee);
		nomee.setColumns(10);
		
		//Ocultar caso usuario nao seja ADMIN
		
		JLabel lbladmin = new JLabel("*-Admin-*");
		lbladmin.setForeground(Color.RED);
		lbladmin.setBackground(Color.BLACK);
		lbladmin.setBounds(597, 465, 57, 14);
		contentPane.add(lbladmin);
		contentPane.add(btnNewButton_1);
		contentPane.add(btnRemover);
		contentPane.add(btnCancelar);
		contentPane.add(btnExcluir);
		
		JButton btnNewButton_2 = new JButton("PEDIDOS");
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(501, 393, 203, 23);
		contentPane.add(btnNewButton_2);
	}
}
