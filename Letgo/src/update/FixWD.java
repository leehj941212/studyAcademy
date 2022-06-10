package update;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class FixWD extends JFrame{			// 각 변수들 생성
	JLabel lbname, lbbirth, lbhakbun, lbphone, lbpw, lbpwcheck;
	JTextField tfname, tfbirth, tfhakbun, tfphone, tfpw, tfpwcheck;
	JButton jbout, jbcancle, jbsave;
	
	FixWD(){			// 생성자
		setUnit();
		setFrame();
		setDisplay();
	}
	
	void setUnit() {					// 라벨, 텍스트필드, 버튼 안에 내용 및 크기	
		lbname = new JLabel("이름");
		lbbirth = new JLabel("생년월일");
		lbhakbun = new JLabel("학번");
		lbphone = new JLabel("연락처");
		lbpw = new JLabel("비밀번호");
		lbpwcheck = new JLabel("비밀번호 확인");
		tfname = new JTextField(10);	
		tfbirth = new JTextField(10);
		tfhakbun = new JTextField(10);
		tfphone = new JTextField(10);
		tfpw = new JTextField(10);
		tfpwcheck = new JTextField(10);
		jbout = new JButton("로그아웃");
		jbcancle = new JButton("취소");
		jbsave = new JButton("확인");
	}
	void setFrame() {										// 패널 배분. 
		JPanel jp1 = new JPanel(new GridLayout(0,1,10,20));
		jp1.add(lbname);
		jp1.add(lbbirth);
		jp1.add(lbhakbun);
		jp1.add(lbphone);
		jp1.add(lbpw);
		jp1.add(lbpwcheck);
		//jp1.setBorder(new TitledBorder(""));
		
		JPanel jp2 = new JPanel(new GridLayout(0,1,10,20));
		jp2.add(tfname);
		jp2.add(tfbirth);
		jp2.add(tfhakbun);
		jp2.add(tfphone);
		jp2.add(tfpw);
		jp2.add(tfpwcheck);
		//jp2.setBorder(new TitledBorder(""));
		
		JPanel jp3 = new JPanel();
		jp3.add(jbout);
		//jp3.setBorder(new TitledBorder(""));
		
		JPanel jp4 = new JPanel();
		jp4.add(jbsave);
		jp4.add(jbcancle);
		//jp4.setBorder(new TitledBorder(""));
		
		add(jp1, BorderLayout.WEST);			// 배널 위치
		add(jp2, BorderLayout.CENTER);
		add(jp3, BorderLayout.EAST);
		add(jp4, BorderLayout.SOUTH);
	}
	void setDisplay() {
		setTitle("회원정보 수정");					// 창이름 
		setVisible(true);						// 보여지기
		setDefaultCloseOperation(EXIT_ON_CLOSE);//
		setLocationRelativeTo(null);
		//setResizable(false);
		//setSize(200, 400);
		pack();
	}
	void setInput() {
		
	}
	public static void main(String[] args) {
		new FixWD();
	}
}
