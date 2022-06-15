package update;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystemNotFoundException;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.xml.soap.Text;


public class FixWD extends JFrame implements ActionListener{			// 각 변수들 생성
	JLabel lbname, lbbirth, lbhakbun, lbphone, lbpw, lbpwcheck, lbalert, lbBlank1, lbBlank2;
	JTextField tfname, tfbirth, tfhakbun, tfphone;
	JPasswordField tfpw, tfpwcheck;
	JButton jbout, jbcancle, jbsave;
	String z;
	
	FixWD(String x){			// 생성자
		this.z=x;
		setUnit();
		setFrame();
		setDisplay();
		
	}
		
	void setUnit() {					//라벨, 텍스트필드, 버튼 안에 내용 및 크기	
		lbname = new JLabel("이름");
		lbbirth = new JLabel("생년월일");
		lbhakbun = new JLabel("학번");
		lbphone = new JLabel("연락처");
		lbpw = new JLabel("비밀번호");
		lbpwcheck = new JLabel("비밀번호 확인");
		lbalert = new JLabel("");
		lbBlank1 = new JLabel(""); 
		lbBlank2 = new JLabel(""); 
		tfname = new JTextField(15);	
		tfbirth = new JTextField(15);
		tfhakbun = new JTextField(15);
		tfphone = new JTextField(15);
		tfpw = new JPasswordField();
		tfpwcheck = new JPasswordField("");
		jbout = new JButton("로그아웃");
		jbcancle = new JButton("취소");
		jbsave = new JButton("확인");
		
	}
	void setFrame() {										//패널 배분. 
		JPanel jp1 = new JPanel(new GridLayout(0,1,10,20));
		jp1.add(lbname);
		jp1.add(lbbirth);
		jp1.add(lbhakbun);
		jp1.add(lbphone);
		jp1.add(lbpw);
		jp1.add(lbpwcheck);
		jp1.add(lbBlank1);
		
		JPanel jp2 = new JPanel(new GridLayout(0,1,10,20));
		jp2.add(tfname);
		jp2.add(tfbirth);
		jp2.add(tfhakbun);
		jp2.add(tfphone);
		jp2.add(tfpw);
		jp2.add(tfpwcheck);
		jp2.add(lbalert);
		FileInputStream f = null; // 파일인풋스트림 선언

		// 이름 생년월일 학번 연락처 불러오기. 한글 이름 깨져 나오는거  => 이름 영어로 하기로 함.
		try {
			if (new File("."+File.separator+"member/").exists()){
				String folderPath = "."+File.separator+"member"+File.separator;		
//				String abc = folderPath;											
				f = new FileInputStream("member"+File.separator+this.z+File.separator+"name.txt"); //경로
				byte b1[] = new byte [f.available()]; //b1이라는 배열에 텍스트내용 쌓아놓기
				while (f.read(b1) != -1) {}				// while문을 이용해 b1에 쌓아놓은 내용을 남김없이 읽어와라
				String data1 = new String(b1);			// b1에 쌓인 내용을 data1에 저장.
				tfname.setText(data1);					// 텍스트필드에 data1에 저장한 내용을 넣어라.
				f = new FileInputStream("member"+File.separator+this.z+File.separator+"birth.txt");
				byte b2[] = new byte [f.available()];
				while (f.read(b2) != -1) {}
				String data2 = new String(b2);
				tfbirth.setText(data2);
				f = new FileInputStream("member"+File.separator+this.z+File.separator+"hakbun.txt");
				byte b3[] = new byte [f.available()];
				while (f.read(b3) != -1) {}
				String data3 = new String(b3);
				tfhakbun.setText(data3);
				f = new FileInputStream("member"+File.separator+this.z+File.separator+"callNum.txt");
				byte b4[] = new byte [f.available()];
				while (f.read(b4) != -1) {}
				String data4 = new String(b4);
				tfphone.setText(data4);
			}
			
//			
			}catch (FileNotFoundException e) {
				System.out.println(e+ " => 파일생성 실패");
			}catch(IOException e) {
				System.out.println(e+ " => 파일읽기 실패");
			}finally {
				try {
				f.close();
			}catch (Exception e) {
				System.out.println(e+ " => 닫기 실패");
			}
		}
		JPanel jp3 = new JPanel();
		jp3.add(jbout);
		
		JPanel jp4 = new JPanel();
		jp4.add(jbsave);
		jp4.add(jbcancle);
		
		JPanel jp5 = new JPanel();
		jp5.add(lbBlank2);						//공백넣어서 살짝 공간줌
		
		tfname.setEditable(false);				//수정 불가
		tfbirth.setEditable(false);
		tfhakbun.setEditable(false);
		tfphone.setEditable(false);
		add(jp1, BorderLayout.WEST);			//패널 위치
		add(jp2, BorderLayout.CENTER);
		add(jp3, BorderLayout.EAST);
		add(jp4, BorderLayout.SOUTH);
		add(jp5, BorderLayout.NORTH);
	}
	
	void setDisplay() {
		setTitle("회원정보 수정");					//창이름 
		setVisible(true);						//보여지기 여부
		setDefaultCloseOperation(EXIT_ON_CLOSE);//종료버튼 누르면 종료
		setLocationRelativeTo(null);			//창뜰때 중앙에 뜨기
		setResizable(false);					//창 사이즈 고정
		pack();									//내용물에 맞춰서 창 크기 설정
		
		jbout.addActionListener(this);			//액션리스너 메소드 연결
		jbsave.addActionListener(this);
		jbcancle.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		FileOutputStream f = null;		
		try {
		if (e.getSource() == jbout) {			//로그인 화면으로
												//로그아웃 누르면 정보 끊고 나가지는거 구현해야됨.
			new LoginWD();
			setVisible(false);
		}else if (e.getSource() == jbcancle){	//메뉴 화면으로
			new MenuWD(this.z);
			setVisible(false);
		}else if (e.getSource() == jbsave) {	//비밀번호 수정. 저장 후 로그인화면으로
			if (new String(tfpw.getPassword()).equals(new String(tfpwcheck.getPassword()))) {		// 비밀번호, 비밀번호 확인 값이 같을때
				if(tfpwcheck.getPassword().length==0) {
					tfpw.setText("");
					tfpwcheck.setText("");
					lbalert.setText("비밀번호를 확인해주세요.");
				}else if(new String(tfpw.getPassword()).equals(new String(tfpwcheck.getPassword()))) {
				f = new FileOutputStream("member"+File.separator+this.z+File.separator+"password.txt");// 지정해둔 경로에 텍스파일 수정.
				byte b[] = String.valueOf(tfpw.getPassword()).getBytes();	// b[] 배열에 dto에 저장해둔값 쌓아놓기
				f.write(b);							// 지정해둔 경로의 파일에 b값 쓰기
				f.close();							// 폴더 닫기
				new LoginWD();			
				setVisible(false);
				}
				}else {
				lbalert.setText("비밀번호를 확인해주세요.");
				tfpw.setText("");
				tfpwcheck.setText("");
			} 
			}
		}catch (Exception o) {
			System.out.println(o + " => 파일쓰기 실패");
		}
		}
	
}