package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.SegmentoDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Segmento extends JFrame {

	private JPanel contentPane;
	private JTextField txtSegmento;


	public Segmento() {
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 558, 205);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSegmento = new JLabel("Informe o nome do segmento:");
		lblSegmento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSegmento.setBounds(10, 23, 199, 22);
		contentPane.add(lblSegmento);
		
		txtSegmento = new JTextField();
		txtSegmento.setBounds(219, 26, 274, 20);
		contentPane.add(txtSegmento);
		txtSegmento.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//obeter segmento
				String nomeSegmento = txtSegmento.getText();
				
				//realizar o cadastro
				SegmentoDao seg = new SegmentoDao();
				boolean valida = seg.cadastrar(nomeSegmento);
				
				//eibir mensagem
				JOptionPane.showMessageDialog(null, valida == true ? "Cadastro ok" : "Falha ao cadastrar");
				
				//limpar o campo e focus
				txtSegmento.setText("");
				txtSegmento.requestFocus();
			}
		});
		getRootPane().setDefaultButton(btnCadastrar);
		btnCadastrar.setBounds(206, 87, 112, 44);
		contentPane.add(btnCadastrar);
	}
}
