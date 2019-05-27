package interf;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;

import action.Action;
import bd.Write;
import beans.Assassins;
import dados.Dados;

@SuppressWarnings("serial")
public class Interface extends JFrame {

	private JPanel contentPane;
	private JTextField nomee;
	private JTextField txtNome;
	private JTextField txtIdade;
	private JTextField txtLocal;
	private JTextField txtCusto;

	public static String nome;
	public static int nivel;
	private JTable Table1;
	
	static int row;
	
	public Interface() {
		
		
		setFont(new Font("Dialog", Font.BOLD, 17));
		setForeground(Color.RED);
		setTitle("PROGRAMINHA MATADOR VINDO DIRETO DA DEEPWEB");
		
		JButton btnCadastro = new JButton("Cadastrar");
		btnCadastro.setBackground(Color.RED);
		btnCadastro.setBounds(622, 483, 103, 23);
	
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.RED);
		btnCancelar.setBounds(559, 359, 103, 23);
		
		
		//Ocultar caso usuario nao seja ADMIN
		JButton btnRemover = new JButton("Remover");
		btnRemover.setBackground(Color.RED);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemover.setBounds(459, 359, 90, 23);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(Color.RED);
		btnExcluir.setBounds(534, 483, 89, 23);
		
		
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 556);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Panel1 = new JPanel();
		Panel1.setBackground(Color.RED);
		Panel1.setBounds(449, 11, 350, 337);
	    contentPane.add(Panel1);
		Panel1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Assassinos Disponiveis");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(43, 0, 171, 25);
		Panel1.add(lblNewLabel);
		
		JScrollPane Scroll1 = new JScrollPane();
		Scroll1.setBounds(10, 24, 330, 302);
		Panel1.add(Scroll1);
		
		Table1 = new JTable();
		Scroll1.setViewportView(Table1);
		
		//CADASTRAR NO CARRINHO
		
		JButton CadastrarA = new JButton("") 	;
		CadastrarA.setBackground(Color.BLACK);
		CadastrarA.setIcon(new ImageIcon("C:\\Users\\i3i\\Desktop\\Java\\Loja\\src\\interf\\newx.gif"));
		CadastrarA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = Dados.dadosAssassin.get(row).getNome();
				double valor = Dados.dadosAssassin.get(row).getCustoA();
				
				Assassins a = new Assassins();
				a.setNome(nome);
				a.setCustoA(valor);
				
				
				Action ac = new Action();
				ac.addCarrinho(a);
				
				JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso. =)");
				    btnExcluir.setEnabled(true);
				    CadastrarA.setEnabled(true);
				    btnCadastro.setEnabled(true);
				Panel1.setVisible(true);
		
			}
		});
		JPanel AdminC = new JPanel();
		AdminC.setBorder(new LineBorder(Color.RED));
		AdminC.setForeground(Color.DARK_GRAY);
		AdminC.setBackground(Color.BLACK);
		AdminC.setBounds(10, 42, 290, 227);
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
		
		txtNome = new JTextField();
		txtNome.setForeground(Color.RED);
		txtNome.setBackground(Color.BLACK);
		txtNome.setBounds(61, 34, 96, 20);
		AdminC.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setForeground(Color.RED);
		lblIdade.setBounds(167, 36, 42, 14);
		AdminC.add(lblIdade);
		
		txtIdade = new JTextField();
		txtIdade.setForeground(Color.RED);
		txtIdade.setBackground(Color.BLACK);
		txtIdade.setColumns(10);
		txtIdade.setBounds(201, 33, 48, 20);
		AdminC.add(txtIdade);
		
		JLabel lblLocalDeAo = new JLabel("Local de a\u00E7\u00E3o");
		lblLocalDeAo.setForeground(Color.RED);
		lblLocalDeAo.setBounds(20, 64, 96, 14);
		AdminC.add(lblLocalDeAo);
		
		txtLocal = new JTextField();
		txtLocal.setForeground(Color.RED);
		txtLocal.setBackground(Color.BLACK);
		txtLocal.setColumns(10);
		txtLocal.setBounds(106, 61, 143, 20);
		AdminC.add(txtLocal);
		
		JLabel lblNewLabel_1 = new JLabel("Estilo de Assassinato");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(20, 89, 137, 14);
		AdminC.add(lblNewLabel_1);
		
		JComboBox<String> cmbEstlo = new JComboBox<String>();
		cmbEstlo.setBackground(Color.BLACK);
		cmbEstlo.setForeground(Color.RED);
		cmbEstlo.setBounds(146, 85, 103, 22);
		cmbEstlo.addItem("*Desconhecido*");
		cmbEstlo.addItem("Armas de Fogo");
		cmbEstlo.addItem("Veneno");
		cmbEstlo.addItem("Armas Brancas");
		cmbEstlo.addItem("Atropelamento");
		cmbEstlo.addItem("Explosivos");
		AdminC.add(cmbEstlo);
		
		JLabel lblCustoBase = new JLabel("Custo Base");
		lblCustoBase.setForeground(Color.RED);
		lblCustoBase.setBounds(20, 117, 70, 14);
		AdminC.add(lblCustoBase);
		
		txtCusto = new JTextField();
		txtCusto.setForeground(Color.RED);
		txtCusto.setBackground(Color.BLACK);
		txtCusto.setColumns(10);
		txtCusto.setBounds(93, 114, 76, 20);
		AdminC.add(txtCusto);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Exce\u00E7oes");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(20, 142, 48, 14);
		AdminC.add(lblNewLabel_2);
		;
		
		JComboBox<String> cmbEx = new JComboBox<String>();
		cmbEx.setBackground(Color.BLACK);
		cmbEx.setForeground(Color.RED);
		cmbEx.setBounds(81, 138, 113, 22);
		cmbEx.addItem("Crianças, Idosos...");
		cmbEx.addItem("Politicos");
		cmbEx.addItem("Artistas");
		cmbEx.addItem("Inocentes");
		
		AdminC.add(cmbEx);
		Action a = new Action();
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = txtNome.getText()+";"+txtCusto.getText()+";"+cmbEx.getItemAt(cmbEx.getSelectedIndex())+";"
				+cmbEstlo.getItemAt(cmbEstlo.getSelectedIndex())+";"+txtIdade.getText()+";"+txtLocal.getText()+";"+System.lineSeparator();
				
				Write w = new Write();
				w.createFile("assassinos", true);
				w.printIn(str);
				w.lerAssassino("assassinos.txt");
				Table1.setModel(a.selecionar());
				}
		});
		btnCadastrar.setForeground(Color.RED);
		btnCadastrar.setBounds(93, 193, 89, 23);
		AdminC.add(btnCadastrar);
		CadastrarA.setBounds(310, 30, 129, 136);
		contentPane.add(CadastrarA);
		
		//Ocultar caso usuario nao seja ADMIN
		
		
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelar.setEnabled(true);
				Panel1.setVisible(true);
				AdminC.setVisible(true);
			}
		});
		
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancelar.setEnabled(false);
				
				
				AdminC.setVisible(false);
			    btnExcluir.setEnabled(true);
			    CadastrarA.setEnabled(true);
			    btnCadastro.setEnabled(true);
			}
		});
		
		
		
	
		
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		;
		
		nomee = new JTextField();
		nomee.setText(nome);
		nomee.setBackground(Color.RED);
		nomee.setBounds(10, 484, 158, 20);
		contentPane.add(nomee);
		nomee.setColumns(10);
		
		
		
		
		//Ocultar caso usuario nao seja ADMIN
		
		JLabel lbladmin = new JLabel("*-Admin-*");
		lbladmin.setForeground(Color.RED);
		lbladmin.setBackground(Color.BLACK);
		lbladmin.setBounds(597, 465, 57, 14);
		contentPane.add(lbladmin);
		contentPane.add(btnCadastro);
		contentPane.add(btnRemover);
		contentPane.add(btnCancelar);
		contentPane.add(btnExcluir);
		
		JButton btnCarrinho = new JButton("CARRINHO");
		btnCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Carrinho c = new Carrinho();
				c.setVisible(true);
			}
		});
		btnCarrinho.setBackground(Color.RED);
		btnCarrinho.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCarrinho.setBounds(672, 359, 127, 23);
		contentPane.add(btnCarrinho);
	
		if (nivel == 1) {
			btnCadastro.setVisible(true);
			lbladmin.setVisible(true);
			btnExcluir.setVisible(true);
		}else {
			btnCadastro.setVisible(false);
			lbladmin.setVisible(false);
			btnExcluir.setVisible(false);
		}
		
		
		Table1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				row = Table1.getSelectedRow();
				
				
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
		
		Table1.setModel(a.selecionar());
		
		JLabel lblCliqueAcimaPara = new JLabel("Clique acima para");
		lblCliqueAcimaPara.setForeground(Color.RED);
		lblCliqueAcimaPara.setBounds(310, 177, 129, 14);
		contentPane.add(lblCliqueAcimaPara);
		
		JLabel lblAdicionarAoCarrinho = new JLabel("adicionar ao carrinho");
		lblAdicionarAoCarrinho.setForeground(Color.RED);
		lblAdicionarAoCarrinho.setBounds(310, 202, 129, 14);
		contentPane.add(lblAdicionarAoCarrinho);
	}  
}
