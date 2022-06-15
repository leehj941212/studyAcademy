package update;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MenuWD extends JFrame implements ActionListener {
 
	JLabel jl = new JLabel ("�޴�");
	JButton jb1 = new JButton ("ȸ������ ����");
	JButton jb2 = new JButton ("���� ����");
	JButton jb3 = new JButton ("ȸ�� Ż��");
	String z;
		
	public MenuWD(String x) {
		
		super("���� �޴�");
		this.z = x;
		
		setLayout(new GridLayout(4,1,30,30));
		
		add(jl);
		add(jb1);
		add(jb2);
		add(jb3);
		
		jl.setHorizontalAlignment(JLabel.CENTER);
		
		Font letter = new Font("���� ���",Font.BOLD, 15); 
		
		jl.setFont(new Font("���� ���",Font.BOLD, 20));
		
		jb1.setFont(letter);
		jb2.setFont(letter);
		jb3.setFont(letter);
		
		setSize(400,400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		
	}

public void actionPerformed(ActionEvent e) {
	   if(e.getSource()==jb1)
	   {   new FixWD(z);
		   setVisible(false);
	   }else if (e.getSource()==jb2)
	   {   new ScoreMWD(z);
	   setVisible(false);
	   }else if (e.getSource()==jb3)
	   {   new DeleteWD(z);
	   setVisible(false);
	   }
		
	} 



}
