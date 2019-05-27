package interf;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import action.Action;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Carrinho extends JFrame {

	private JPanel contentPane;
	private JTable tbl2;

	public Carrinho() {
		
		setTitle("Carrinho");
		setBounds(100, 100, 450, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 21, 400, 371);
		contentPane.add(scrollPane);
		
		tbl2 = new JTable();
		scrollPane.setViewportView(tbl2);
		Action a = new Action();
		tbl2.setModel(a.Carrinho());
	}
}
