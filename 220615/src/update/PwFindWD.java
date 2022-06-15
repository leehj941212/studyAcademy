package update;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PwFindWD extends JFrame implements ActionListener { 

	JLabel label,label1,label2,label3,label4,label5,label6,label7;
	JTextField text1,text2;
	JButton jb1, jb2, jb3;

	
	
	
	PwFindWD(){
		super("PW_Find");

		setSName();
		setSText();
		setSDisplay();
		
	}

	void setSName() {
		label=new JLabel(""); // 공백


		label1=new JLabel("비밀번호 찾기");
		label2=new JLabel("질문 : ");
		label3=new JLabel("답 :");
		label4=new JLabel("PW : ");
		label5=new JLabel("비밀번호 출력 공간");
		label6=new JLabel("이름 : ");
		label7=new JLabel("나의 보물 1호는~!?!?");
		
		text1=new JTextField(10);
		text2=new JTextField(5);


		jb1=new JButton("취소 및 로그인화면");
		jb2=new JButton("확인");


	}

	void setSText(){

		JPanel jp = new JPanel(new GridLayout(0,1,10,20));// 행, 열, 양옆 간격, 위아래 간격
		JPanel jp2 = new JPanel(new GridLayout(0,1,10,20));// 행, 열, 양옆 간격, 위아래 간격
		jp2.add(label);
		jp2.add(label6);
		jp2.add(label2);
		jp2.add(label3);
		jp2.add(label4);
		

		JPanel jp3 = new JPanel(new GridLayout(0,1,10,20));// 행, 열, 양옆 간격, 위아래 간격
		jp3.add(label1);
		jp3.add(text1);
		jp3.add(label7);
		jp3.add(text2);
		jp3.add(label5);
		
		
		JPanel jp4 = new JPanel(new GridLayout(0,1,10,20));// 행, 열, 양옆 간격, 위아래 간격
		jp4.add(jb2);
		jp4.add(jb1);

		add(jp2,BorderLayout.WEST);
		add(jp3,BorderLayout.CENTER);
		add(jp4,BorderLayout.SOUTH);
		
		
		
		
	}

	void setSDisplay() {

		setVisible(true);  // 화면 출력하는 코드!!!
		setSize(325, 300); // (width, heigth) 크키, 너비 넣어주면 됨!
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 창닫기
		setLocationRelativeTo(null); // 창 가운데로 잡아주는 것
	//	pack(); // 창에 있는 크기를 똑같이 잡아줌.

		jb1.addActionListener(this);
		jb2.addActionListener(this);
	//	jb3.addActionListener(this);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1)
		{   new LoginWD();
		setVisible(false);
		}else if (e.getSource()==jb2)
		{  
			
			
			File dir = new File("member");		// 파일
			File [] filenames = dir.listFiles();
			
			for(int i=0; i<filenames.length;i++) {
				String namePath = "member/"+filenames[i].getName()+"/name.txt"; // 이름의 파일 경로 
				String answerPath = "member/"+filenames[i].getName()+"/questions.txt";  // 답변의 텍스트 경로
				String pwPath = "member/"+filenames[i].getName()+"/password.txt";  // 의 텍스트 경로
			
				
				FileInputStream f = null; // 파일인풋스프림 선언
				FileInputStream d = null; 
				FileInputStream w = null; 

				File na=new File(namePath);
				File t=new File(answerPath);

				File pw=new File(pwPath);

				if(na.exists()) {
//			
			try {  // f : 이름, d: 답, w : id출력
				f=new FileInputStream(na);
				d=new FileInputStream(t);
				w=new FileInputStream(pw);
				byte [] b = new byte [ f.available()]; // 배열 수 만큼의 갯수 available
				byte [] c = new byte [ d.available()];
				byte [] o = new byte [ w.available()];
				System.out.print(new String(c));
				
				while(f.read(b)!=-1) { // 값이 없다는 뜻. 없을때까지 돌아라는 뜻.
				}
				while(d.read(c)!=-1) {
				}
				while(w.read(o)!=-1) {

				}
				
				//if(new String(b).equals(String.valueOf(jpf1.getPassword()))) { 
				
				if(new String(b).equals(String.valueOf(text1.getText())) && new String(c).equals(text2.getText()) ) {  // equals가 String변수 비교해줌.
					
					// 비밀번호 검토 및 확인
					FileInputStream f2 = new FileInputStream(pw);
					label5.setText(new String(o));
					
					
				}else if ( String.valueOf(text2.getText()).equals("") || text2.getText().equals("")){
					JOptionPane.showMessageDialog(null, "값을 입력해야 되요...!!");
					break;
				}else {
					JOptionPane.showMessageDialog(null, "잘 쓰세요.... 없어요...");
					break;
				}
				setDefaultCloseOperation(EXIT_ON_CLOSE);
			}catch(Exception z) {
				System.out.println(z); // try의 catch는 세트 ( else )
			}
			}
			}		
		}else if  (e.getSource()==jb3)
		{   new LoginWD();
		setVisible(false);
		}
	}



}
