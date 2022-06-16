package update;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class LoginWD extends JFrame implements ActionListener{
	private static final boolean FileNotFoundException = false;
	JLabel label1,label2,label3,label4;
	JTextField text1;
	JButton jb1, jb2, jb3,jb4;
	JPasswordField jpf1;
	//	SourceDTO sDTO;
	InputStream id;

	
	
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

		jpf1=new JPasswordField();

		jb1=new JButton("로그인");
		jb2=new JButton("회원가입");
		jb3=new JButton("아이디 찾기");
		jb4=new JButton("비밀번호 찾기");

	}

	void setFText() {
		// 북쪽
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

		jp3.add(jpf1);
		jp3.add(jb1);

		//	jp.setBorder(new TitledBorder(""));

		// 남쪽
		JPanel jp4 = new JPanel(new GridLayout(0,1,10,10)); // 행, 열, 양옆 간격, 위아래 간격
		jp4.add(jb3);
		jp4.add(jb4);
		//	jp.setBorder(new TitledBorder(""));

		// 방향
		//	add(jp,BorderLayout.NORTH);
		add(jp2,BorderLayout.WEST); // 그리드를 사용했기에 자리 값을 설정해줌.
		add(jp3,BorderLayout.CENTER);
		add(jp4,BorderLayout.SOUTH);

		jb1.addActionListener(this); // 엑션 메소드로 나의 값을 넘겨준다는 뜻. 
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);



		/*	try {

			f = new FileInputStream("asd");
			System.out.println("availabe = "+f.available()); // 읽을 수 있는 byte의 수(한글은 2공간 영어는1)
			byte b[] = new byte [ f.available()]; // 만약 java면 4글자니까 4개의 공간을 만든다는 뜻.

			while(f.read(b)!=-1) {
			}
			String data = new String(b);
			System.out.println(b);
			System.out.println(data);

		}catch(FileNotFoundException e) {  // 여기 아래에 catch는 안써도 괜춘.괄호안에 다 지우고 Exception e만써도 됨.
			System.out.println(e+" => 파일생성 실패");
		}catch(IOException e) {
			System.out.println(e+" =>파일 읽기 실패");
		}finally {
			try {
			f.close();
		}catch(Exception e) {
			System.out.println(e+" => 닫기 실패");
			}

		}
		 */	
	}

	void Process() {




	}

	void setFDisplay() {

		setTitle("login"); // 생성자에서 super("login")하면 똑같이 뜸.

		setVisible(true);  // 화면 출력하는 코드!!!
		setSize(600, 400); // (width, heigth) 크키, 너비 넣어주면 됨!
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		pack();

	}

	void addres() {

	}

	public void actionPerformed(ActionEvent e) {
		
//		String path = "C:/Users/Administrator/eclipse-workspace/Letgo/member"; // 멤버까지의 주소 가져오고 /로 바꿔줌.
//		File dir = new File(path);		// 파일
//		String[] filenames = dir.list();
		
//		for(Stirng filename:filenames) {
		String idPath = "member/"+text1.getText(); // 아이디 파일 경로
		String pwPath = "member/"+text1.getText()+"/password.txt"; // 
//		String pwPath = "member/"+filename+"/password.txt";
		
		File id=new File(idPath); // 경로에 있는 파일 넣어놓기

		FileInputStream f = null; // 파일인풋스프림 선언하고

		/*
		 try {
			FileInputStream fis = new  FileInputStream(idPath);
			System.out.println(fis.available());
		} catch (java.io.FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 */  // 버튼으로 넘겨주는 공간 및 클릭했을때 일어나는 일들
		if(e.getSource()==jb1) {
			if(false==id.exists()) {
				JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다."); // 왼쪽은 상위 구성요소(라벨이나 버튼 같은것들)을쓰고, 오른쪽은 메세지
				
			}else {
				try {
					f=new FileInputStream(pwPath); // 파일인풋스트림에 파일 넣어주기

					byte [] b = new byte [ f.available()]; // 배열 수 만큼의 갯수 available 바이트 배열에 b넣어주기
					// System.out.print(new String(c));
					while(f.read(b)!=-1) { // 값이 없다는 뜻. 없을때까지 돌아라는 뜻.  byte배열을 하나하나 돌아보고오기.
					}

					if(new String(b).equals(String.valueOf(jpf1.getPassword()))) {  // equals가 String변수 비교해줌.
						String asd = text1.getText();								// (byte배열과 비밀번호를 스트링으로 변환)
						new MenuWD(asd);									// 비밀번호 검토 및 확인
						setVisible(false); 
					}else {
						JOptionPane.showMessageDialog(null, "비밀번호가 틀렸어부러~~"); // 팝업만들어주는 코드.
					}

				}catch(Exception i) {

					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력해 줍소..!!"); // try의 catch는 세트 ( else ) // 예외처리 확인
				}
			}
		}else if (e.getSource()==jb2) 
		{   new SignUpWD();
		setVisible(false);
		}else if (e.getSource()==jb3)
		{   new IdFindWD();
		setVisible(false);
		}else if (e.getSource()==jb4)
		{   new PwFindWD();
		setVisible(false);
		}
	} 

	private void JOptionPane() {

	}

	public static void main(String[]args) {
		new LoginWD();

	}
}
