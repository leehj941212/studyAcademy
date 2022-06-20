package teamProjectDB;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DeleteCheckWD implements ActionListener{
	SourceDTO student = new SourceDTO();
	MemberAct act = new MemberAct();

	JLabel jl, jlalert;
	JButton jbyes, jbno;
	JFrame frame = new JFrame("Å»Åð È®ÀÎ");

	DeleteCheckWD(String id) {
		act.connectMysql();
		student.setId(id);
		checkset();
		checkPanel();
		checksetDisplay();
	}
	void checkset() {
		jl = new JLabel("Á¤¸» Å»ÅðÇÏ½Ã°Ú½À´Ï±î?");
		jbyes = new JButton("È®ÀÎ");
		jbno = new JButton("Ãë¼Ò");
		jlalert = new JLabel("");
	}

	void checkPanel() {
		JPanel jp1 = new JPanel();
		jp1.add(jl);

		JPanel jp3 = new JPanel();
		jp3.add(jbyes);
		jp3.add(jbno);

		frame.add(jp1, BorderLayout.NORTH);
		//		add(jp2, BorderLayout.CENTER);
		frame.add(jp3, BorderLayout.SOUTH);
	}

	void checksetDisplay() {
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);		
		//setSize(300, 100);
		frame.pack();
		jbno.addActionListener(this);
		jbyes.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbno) {
			new DeleteWD(student.getId());
			frame.setVisible(false);
		}else if(e.getSource() == jbyes) {	//È®ÀÎ¹öÆ° ´©¸¦¶§
			String sql = "delete from teamproject where id = '"+student.getId()+"'";
			act.executeMysql(sql);

			DeleteWD dl = new DeleteWD(student.getId());
			new LoginWD();
			dl.frame.setVisible(false);
			frame.setVisible(false);

			JOptionPane.showMessageDialog(null, "Å»ÅðÇÏ¼Ì½À´Ï´Ù");


		}
	}
}