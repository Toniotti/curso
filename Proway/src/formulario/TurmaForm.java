package formulario;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.TurmaDao;

public class TurmaForm extends JFrame{
    JFrame f = new JFrame();
    JScrollPane jp = new JScrollPane();
    JTable tb = new JTable();

    public TurmaForm(){
        setSize(500, 600);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(null);

        jp.setBounds(10, 50, 420, 530);
        TurmaDao td = new TurmaDao();
        tb.setModel(td.turmaModel());
        jp.setViewportView(tb);

        add(jp);

        setVisible(true);
    }
}