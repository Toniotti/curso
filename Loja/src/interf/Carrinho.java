package interf;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import action.Action;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class Carrinho extends JFrame {
    int row;
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
		scrollPane.setBounds(10, 21, 414, 348);
		contentPane.add(scrollPane);
		
		tbl2 = new JTable();
		scrollPane.setViewportView(tbl2);
		Action a = new Action();
		tbl2.setModel(a.Carrinho());
		
		tbl2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				row = tbl2.getSelectedRow();
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Action a = new Action();
			a.excluir(row);
			tbl2.setModel(a.Carrinho());
			
			
			}
		});
		btnExcluir.setBounds(10, 380, 89, 23);
		contentPane.add(btnExcluir);
	}
}
