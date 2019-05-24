package interf;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import action.Action;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtPass;
	
	public Login() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tela de Login");
		setBounds(100, 100, 288, 228);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 76, 88, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.RED);
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 20));
		lblSenha.setBounds(10, 110, 88, 23);
		contentPane.add(lblSenha);
		
		txtLogin = new JTextField();
		txtLogin.setForeground(Color.RED);
		txtLogin.setBackground(Color.BLACK);
		txtLogin.setBounds(79, 76, 176, 24);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		
		txtPass = new JTextField();
		txtPass.setForeground(Color.RED);
		txtPass.setBackground(Color.BLACK);
		txtPass.setColumns(10);
		txtPass.setBounds(79, 110, 176, 24);
		contentPane.add(txtPass);
		
		JLabel lblA = new JLabel("SEDEathX");
		lblA.setForeground(Color.RED);
		lblA.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblA.setBounds(20, 11, 176, 62);
		contentPane.add(lblA);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(Color.BLACK);
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEntrar.setForeground(Color.RED);
		btnEntrar.setBounds(166, 144, 89, 34);
		contentPane.add(btnEntrar);
		
		txtLogin.requestFocus();
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Registro r = new Registro();
			r.setVisible(true);
			}
		});
		
		btnRegistrar.setForeground(Color.RED);
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRegistrar.setBackground(Color.BLACK);
		btnRegistrar.setBounds(10, 155, 99, 23);
		contentPane.add(btnRegistrar);
		getRootPane().setDefaultButton(btnEntrar);
		
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ((txtLogin.getText().equals("") || (txtPass.getText().equals("")))){
					JOptionPane.showMessageDialog(null, "Informe TODOS OS DADOS");
				}else {
					Action a = new Action();
					if(a.validaLogin(txtLogin.getText(), txtPass.getText()) == 1) {	
						Login.super.setVisible(false);
						
						Interface i = new Interface();
						i.setLocationRelativeTo(null);
						i.setVisible(true);
					}else if(a.validaLogin(txtLogin.getText(), txtPass.getText()) == 2){
						JOptionPane.showMessageDialog(null, "Senha incorreta.");
					}else if(a.validaLogin(txtLogin.getText(), txtPass.getText()) == 3) {
						JOptionPane.showMessageDialog(null, "Usuario não encontrado.");
					}
				}
			}
		});

	 
	}
}


