package update;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class LoginWD extends JFrame{
	JLabel label1,label2,label3,label4;
	JTextField text1,text2;
	JButton jb1, jb2, jb3;

	LoginWD(){
	
		setFName();
		setFText();
		setFDisplay();
	}
	
	void setFName() {
		label1=new JLabel("로그인하세요.");
		label2=new JLabel("아이디 입력");
		label3=new JLabel("비밀번호 입력");
		label4=new JLabel("");

		text1=new JTextField(20);
		text2=new JTextField(5);

		jb1=new JButton("로그인");
		jb2=new JButton("회원가입");
		jb3=new JButton("아이디 및 비밀번호 찾기");
	}

	void setFText() {
		// 북
//		JPanel jp = new JPanel(new GridLayout(1,1,10,10)); // 행, 열, 양옆 간격, 위아래 간격
//		jp.add(label1);		
//		jp.setBorder(new TitledBorder("")); // 이 칸이 어떤칸인지 보여주는 클래스?

		// 서
		JPanel jp2 = new JPanel(new GridLayout(0,1,10,10)); // 행, 열, 양옆 간격, 위아래 간격
		jp2.add(label4);
		jp2.add(label2);
		jp2.add(label3);
		jp2.add(jb2);
	//	jp.setBorder(new TitledBorder(""));

		// 중앙
		JPanel jp3 = new JPanel(new GridLayout(0,1,10,10)); // 행, 열, 양옆 간격, 위아래 간격
		jp3.add(label1);
		jp3.add(text1);
		jp3.add(text2);
		jp3.add(jb1);
	//	jp.setBorder(new TitledBorder(""));

		// 남
		JPanel jp4 = new JPanel(new GridLayout(0,1,10,10)); // 행, 열, 양옆 간격, 위아래 간격
		jp4.add(jb3);
	//	jp.setBorder(new TitledBorder(""));

		// 방향
	//	add(jp,BorderLayout.NORTH);
		add(jp2,BorderLayout.WEST);
		add(jp3,BorderLayout.CENTER);
		add(jp4,BorderLayout.SOUTH);
		
	}

	void setFDisplay() {

		setTitle("login"); // 생성자에서 super("login")하면 똑같이 뜸.

		setVisible(true);  // 화면 출력하는 코드!!!
		setSize(600, 400); // (width, heigth) 크키, 너비 넣어주면 됨!
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		pack();
	}
	public static void main(String[]args) {
		new LoginWD();


	}

}
