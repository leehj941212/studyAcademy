import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.util.ArrayList;

import javax.swing.*;



public class Login implements ActionListener,KeyListener{
	JFrame jf = new JFrame();
	JButton jbmk = new JButton("회원가입");
	JButton jblogin = new JButton("로그인");
	JLabel jltitle=new JLabel("로그인");
	JLabel jlid=new JLabel("아이디: ");
	JLabel jlpwd=new JLabel("비밀번호: ");
	JTextField jtid = new JTextField(10);
	JTextField jtpwd = new JTextField(10);
	
	Font titlefont = new Font("고딕", Font.BOLD, 40);
	
	void lgin() {
	
	jltitle.setFont(titlefont);
	jf.setSize(400,500);
	jf.setLayout(new GridLayout(3,1));
	JPanel jptxt1 = new JPanel();
	JPanel jptxt2 = new JPanel();
	JPanel jpbu = new JPanel();
	jltitle.setHorizontalAlignment(JLabel.CENTER);
	jptxt1.setLayout(new FlowLayout(2));
	jptxt2.setLayout(new FlowLayout());
	jpbu.setLayout(new FlowLayout());
	jptxt1.add(jlid);
	jptxt1.add(jtid);
	jtid.addKeyListener(this);
	jptxt1.add(jlpwd);
	jtpwd.addKeyListener(this);
	jptxt1.add(jtpwd);
	jbmk.addActionListener(this);
	jpbu.add(jbmk);
	jblogin.addActionListener(this);
	jpbu.add(jblogin);
	jf.add(jltitle);
	jf.add(jptxt1);
	jf.add(jpbu);
	jf.setVisible(true);
	jf.setLocationRelativeTo(null);
	jf.setResizable(false);
	jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
	
	}
	public void keyPressed(KeyEvent e) { 
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			jblogin.doClick();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {if(e.getSource()==jbmk)
		{	jf.dispose();
			Makeid mkid = new Makeid();
			mkid.idmake();
		}
		if(e.getSource()==jblogin){
			String id =jtid.getText();
			String pwd =jtpwd.getText();
			ArrayList<String>info=new ArrayList<String>();
			try {File f = new File(id+".txt");
				BufferedReader br = new BufferedReader(new FileReader(f));
				String str;
				while((str= br.readLine())!=null){
					info.add(str);
				}
			}catch (Exception e2) {}
			if(pwd.equals(info.get(0))) {
				jf.dispose();
				MainBu complog=new MainBu();
				complog.callbu(id);
			}else {
				JOptionPane.showMessageDialog(null,"아이디 또는 비밀번호가 잘못되었습니다","로그인 오류",JOptionPane.ERROR_MESSAGE);
			}
		}
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null,"아이디 또는 비밀번호가 잘못되었습니다","로그인 오류",JOptionPane.ERROR_MESSAGE);
			
		}
		
		
	}
	
	public static void main(String[] args) {
		Login lo=new Login();
		lo.lgin();
	}
	
}
