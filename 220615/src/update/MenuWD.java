package update;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuWD extends JFrame implements ActionListener {
 
	JLabel jl = new JLabel ("¸Þ´º");
	JButton jb1 = new JButton ("È¸¿øÁ¤º¸ ¼öÁ¤");
	JButton jb2 = new JButton ("¼ºÀû °ü¸®");
	JButton jb3 = new JButton ("È¸¿ø Å»Åð");
	JButton jb4 = new JButton ("·Î±× ¾Æ¿ô");
	
	String z;
		
	public MenuWD(String x) {
		
		super("¼±ÅÃ ¸Þ´º");
		this.z = x;
		
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		
		jp1.setLayout(new GridLayout(1,1));
		jp2.setLayout(new GridLayout(4,1,20,20));
		
		jp1.add(jl);
		jp2.add(jb1);
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		
		setLayout(new BorderLayout());
		
		add(jp1,"North");
		add(jp2,"Center");
		
		jl.setHorizontalAlignment(JLabel.CENTER);
		
		Font letter = new Font("¸¼Àº °íµñ",Font.BOLD, 15); 
		
		jl.setFont(new Font("¸¼Àº °íµñ",Font.BOLD, 20));
		
		jb1.setFont(letter);
		jb2.setFont(letter);
		jb3.setFont(letter);
		jb4.setFont(letter);
		
		setSize(400,400);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);
			
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
	   }else if (e.getSource()==jb4)
	   {   new LoginWD();
	   setVisible(false);
	   }
		
	} 



}
