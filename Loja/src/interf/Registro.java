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

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 216);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(10, 51, 132, 30);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("New label");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(10, 92, 132, 30);
		contentPane.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Registrar");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(10, 11, 191, 30);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setForeground(Color.RED);
		textField.setBackground(Color.BLACK);
		textField.setBounds(104, 51, 138, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.RED);
		textField_1.setBackground(Color.BLACK);
		textField_1.setColumns(10);
		textField_1.setBounds(104, 92, 138, 24);
		contentPane.add(textField_1);
	}
}
