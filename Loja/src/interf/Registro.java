package interf;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import bd.Write;

@SuppressWarnings("serial")
public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField CLogin;
	private JTextField txtSenha;

	
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
		txtSenha = new JTextField();
		txtSenha.setForeground(Color.RED);
		txtSenha.setBackground(Color.BLACK);
		txtSenha.setColumns(10);
		txtSenha.setBounds(70, 92, 138, 24);
		contentPane.add(txtSenha);
		
		JButton btnR = new JButton("Registrar");
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				Registro r = new Registro();//mostra o painel de cadsatro
				
				//pega dados
				String log = CLogin.getText();
				String pass = txtSenha.getText();
				Write w = new Write();
				w.printIn(log+","+pass+","+"0,"+System.lineSeparator());
				w.lerUsuario("bd.txt");
				
				dispose();//fecha o painel de cadastro
			}
		});
		btnR.setBackground(Color.BLACK);
		btnR.setForeground(Color.RED);
		btnR.setBounds(10, 133, 89, 23);
		contentPane.add(btnR);
		
		setLocationRelativeTo(null);
		
	}
}
