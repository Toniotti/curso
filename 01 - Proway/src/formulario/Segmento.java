package formulario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import dao.SegmentoDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Segmento extends JFrame {

	private JPanel contentPane;
	private JTextField txtSegmento;

	private int linha;

	public Segmento() {
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 558, 400);
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
		
		getRootPane().setDefaultButton(btnCadastrar);
		btnCadastrar.setBounds(10, 87, 120, 30);
		contentPane.add(btnCadastrar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(140, 87, 120, 30);
		add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(270, 87, 120, 30);
		add(btnExcluir);

		//scrol pane
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(10, 120, 525, 235);
		scroll.setBackground(Color.BLACK);
		
		//tabela
		JTable table = new JTable();
		SegmentoDao sd = new SegmentoDao();
		scroll.setViewportView(table);
		
		btnAlterar.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

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
				table.setModel(sd.mostrarTabela());
			}
		});

		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e){
				linha = table.getSelectedRow();
			}
		});

		table.setModel(sd.mostrarTabela());
		add(scroll);

	}
}
