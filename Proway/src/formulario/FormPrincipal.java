package formulario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormPrincipal extends JFrame {

	private JPanel contentPane;

	public FormPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 285, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//botao curso
		JButton btnCurso = new JButton("Curso");
		btnCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CursoForm c = new CursoForm();
				c.setVisible(true);
			}
		});
		btnCurso.setBounds(10, 10, 120, 40);
		contentPane.add(btnCurso);
		
		//botao segmento
		JButton btnSegmento = new JButton("Segmento");
		btnSegmento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Segmento s = new Segmento();
				s.setVisible(true);
			}
		});
		btnSegmento.setBounds(140, 10, 120, 40);
		contentPane.add(btnSegmento);

		//botao alunos
		JButton btnAlunos = new JButton("Alunos");
		btnAlunos.setBounds(10, 60, 120, 40);
		add(btnAlunos);

		btnAlunos.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				AlunoForm af = new AlunoForm();
				af.setVisible(true);
			}
		});

		JButton btnTurmas = new JButton("Turmas");
		btnTurmas.setBounds(140, 60, 120, 40);
		add(btnTurmas);

		btnTurmas.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				TurmaForm tf = new TurmaForm();
			}
		});
	}
}
