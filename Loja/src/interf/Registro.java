package interf;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField CLogin;
	private JTextField textField_1;

	
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 232, 216);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("Login");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl1.setForeground(Color.RED);
		lbl1.setBounds(10, 51, 95, 30);
		contentPane.add(lbl1);
		
		JLabel CSenha = new JLabel("Senha");
		CSenha.setForeground(Color.RED);
		CSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CSenha.setBounds(10, 92, 95, 30);
		contentPane.add(CSenha);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastro");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_1.setBounds(10, 11, 191, 30);
		contentPane.add(lblNewLabel_1);
		
		CLogin = new JTextField();
		CLogin.setForeground(Color.RED);
		CLogin.setBackground(Color.BLACK);
		CLogin.setBounds(70, 51, 138, 24);
		contentPane.add(CLogin);
		CLogin.setColumns(10);
		CLogin.requestFocus();
		textField_1 = new JTextField();
		textField_1.setForeground(Color.RED);
		textField_1.setBackground(Color.BLACK);
		textField_1.setColumns(10);
		textField_1.setBounds(70, 92, 138, 24);
		contentPane.add(textField_1);
		
		JButton btnR = new JButton("Registrar");
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro r = new Registro();
				
				
				
				
	       dispose();
			}
		});
		btnR.setBackground(Color.BLACK);
		btnR.setForeground(Color.RED);
		btnR.setBounds(10, 133, 89, 23);
		contentPane.add(btnR);
		
		setLocationRelativeTo(null);
		
	}
}
