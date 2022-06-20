package teamProjectDB;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuWD implements ActionListener {
	SourceDTO student = new SourceDTO();

	JLabel jl = new JLabel ("�޴�");
	JButton jb1 = new JButton ("ȸ������ ����");
	JButton jb2 = new JButton ("���� ����");
	JButton jb3 = new JButton ("ȸ�� Ż��");
	JButton jb4 = new JButton ("�α� �ƿ�");
	JFrame frame = new JFrame("���� �޴�");

	public MenuWD(String id) {

		student.setId(id);

		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();

		jp1.setLayout(new GridLayout(1,1));
		jp2.setLayout(new GridLayout(4,1,20,20));

		jp1.add(jl);
		jp2.add(jb1);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);

		frame.setLayout(new BorderLayout());

		frame.add(jp1,"North");
		frame.add(jp2,"Center");

		jl.setHorizontalAlignment(JLabel.CENTER);

		Font letter = new Font("���� ���",Font.BOLD, 15); 

		jl.setFont(new Font("���� ���",Font.BOLD, 20));

		jb1.setFont(letter);
		jb2.setFont(letter);
		jb3.setFont(letter);
		jb4.setFont(letter);

		frame.setSize(400,400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1)
		{   new FixWD(student.getId());
		frame.setVisible(false);
		}else if (e.getSource()==jb2)
		{   new ScoreMWD(student.getId());
		frame.setVisible(false);
		}else if (e.getSource()==jb3)
		{   new DeleteWD(student.getId());
		frame.setVisible(false);
		}else if (e.getSource()==jb4)
		{   new LoginWD();
		frame.setVisible(false);
		}

	} 



}
