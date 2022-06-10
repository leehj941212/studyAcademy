package update;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MenuWD extends JFrame implements ActionListener {

	JButton jb1 = new JButton ("회원정보 수정");
	JButton jb2 = new JButton ("성적 관리");
	JButton jb3 = new JButton ("회원 탈퇴");
		
	public MenuWD() {
		
		super("선택 메뉴");
		
		setLayout(new GridLayout(3,1,30,30));
		
		add(jb1);
		add(jb2);
		add(jb3);
		
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		
	}

public void actionPerformed(ActionEvent e) {
	   if(e.getSource()==jb1)
	   {   new FixWD();
		   setVisible(false);
	   }else if (e.getSource()==jb2)
	   {   new ScoreMWD();
	   setVisible(false);
	   }else if (e.getSource()==jb3)
	   {   new LoginWD();
	   setVisible(false);
	   }
		
	} 

public static void main(String[] args) {
    new MenuWD();
}

}
