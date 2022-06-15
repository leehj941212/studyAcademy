package update;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;



public class IdFindWD extends JFrame  implements ActionListener { 
	
	JLabel label,label1,label2,label3,label4,label5,label6,label7,label8,label9;
	JTextField text1,text2;
	JButton jb1, jb2, jb3, jb4;
	

	
	IdFindWD(){
		super("ID_Find");
		
		setSName();
		setSText();
		setSDisplay();
		
	}
	
	void setSName() {
		label=new JLabel("");
		label1=new JLabel("아이디 찾기");
		label2=new JLabel("질문 ");
		label3=new JLabel("답 : ");
		label4=new JLabel("ID : ");
		label5=new JLabel("아이디 출력 공간");	
		
		label6=new JLabel("");	// 공백 공간
		
		
		label7=new JLabel("이름"); 
		label8=new JLabel("이름 입력");
		label9=new JLabel("나의 보물 1호는~!?!?");
		
		text1=new JTextField(10);
		text2=new JTextField(5);
				
		
		jb1=new JButton("취소 및 로그인화면");
		jb2=new JButton("확인");
		
		
	}
	
	void setSText() {
		JPanel jp = new JPanel(new GridLayout(0,1,10,20));// 행, 열, 양옆 간격, 위아래 간격
		JPanel jp2 = new JPanel(new GridLayout(0,1,10,20));// 행, 열, 양옆 간격, 위아래 간격
		jp2.add(label);
		jp2.add(label8);
		jp2.add(label2);
		jp2.add(label3);
		jp2.add(label4);
		
		
		JPanel jp3 = new JPanel(new GridLayout(0,1,10,20));// 행, 열, 양옆 간격, 위아래 간격
		jp3.add(label1);
		jp3.add(text1);
		jp3.add(label9);
		jp3.add(text2);
		jp3.add(label5);
		
		JPanel jp4 = new JPanel(new GridLayout(0,1,10,20));// 행, 열, 양옆 간격, 위아래 간격
		jp4.add(jb2);
		jp4.add(jb1);
		add(jp2,BorderLayout.WEST);
		add(jp3,BorderLayout.CENTER);
		add(jp4,BorderLayout.SOUTH);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
//		jb3.addActionListener(this);
		
	}
	
	void setSDisplay() {
		
		setVisible(true);  // 화면 출력하는 코드!!!
		setSize(325, 300); // (width, heigth) 크키, 너비 넣어주면 됨!
		setDefaultCloseOperation(EXIT_ON_CLOSE); // 창닫기
		setLocationRelativeTo(null); // 창 가운데로 잡아주는 것
	//	pack(); // 창에 있는 크기를 똑같이 잡아줌.
		
	}
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb1) {
			new LoginWD();
		setVisible(false);
		} else if (e.getSource()==jb2){
		
			
//			String path = "C:/Users/Administrator/eclipse-workspace/Letgo/member"; // 멤버까지의 주소 가져오고 /로 바꿔줌.
//			File dir = new File(path);		// 파일
//			String[] filenames = dir.list();	// id
//			
//			ArrayList<String> namePaths = new ArrayList<String>();	// 모든 id의 name.txt까지의 경로
//			ArrayList<String> answerPaths = new ArrayList<String>();	// 모든 id의 name.txt까지의 경로
//			ArrayList<String> idPaths = new ArrayList<String>();
//			
//			for(int i=0; i<filenames.length; i++)   // id들
//			{
//				String namePath = "member/"+filenames[i]+"/name.txt"; // 이름의 파일 경로 
//				String answerPath = "member/"+filenames[i]+"/t.txt";  // 답변의 텍스트 경로
//				String idPath = "member/"+filenames[i]+"/id.txt";  // id의 텍스트 경로
//				namePaths.add(namePath);		// namePaths안에 namePath를 넣어주면서 모든 이름들이 넘어감
//				answerPaths.add(answerPath);	// answerPaths 안에 answerPath를 넣어주면서 모든 답변들이 넘어감.
//				idPaths.add(idPath);
//				
//				
//				
//			}
//			
//			// 여기서부터 HashMap으로 키와 벨류를 설정해줌.
//			HashMap<String, String> answerByName = new HashMap<String, String>();
//			for(int i=0; i<filenames.length; i++) // 위에있는 filenames의 배열의 수로 돌림 ( 회원가입 후 생긴 모든 파일 돌리기 )
//			{
//				try {
//					// 이름
//					FileInputStream fis = new FileInputStream(namePaths.get(i)); // fis 객체를 생성하면서 namePaths에 파일배열이 돌아가게함.
//					byte[] b = new byte[fis.available()]; // 그 fis를 byte배열 b에 넣어줌.
//					while(fis.read(b) != -1) {}		// != -1을 하면서 들어있는 데이터들을 모조리 다 한번씩 읽게 설정.
//					String s = new String(b); // 그 값을 모두 s에 넣어줌.
//					
//					// 답변
//					FileInputStream fis2 = new FileInputStream(answerPaths.get(i)); // 위와 내동은 같습니다.
//					byte[] b2 = new byte[fis2.available()];
//					while(fis2.read(b2) != -1) {}
//					String s2 = new String(b2);
//					
//					FileInputStream fis3 = new FileInputStream(idPaths.get(i)); // 위와 내동은 같습니다.
//					byte[] b3 = new byte[fis3.available()];
//					while(fis2.read(b3) != -1) {}
//					label5.setText(new String(b3));
//					
//					
//					answerByName.put(s, s2); // 키(s)와, 벨류(s2)를 가져옴
//					
////					if() {
////						label5.setText(s3);
////					}else {
////						JOptionPane.showMessageDialog(null, "질문의 답과 일치하지 않습돠~!! 다시 써줍소!!");
////					}
//					
////					if(new String(b).equals(String.valueOf(text1.getText())) && new String(b2).equals(label5.getText()) ) {  // equals가 String변수 비교해줌.
////						// 비밀번호 검토 및 확인
////						String st =new String(s);
////						label5.setText(st);
////
////					}
//				} catch (FileNotFoundException e1) {
//					// TODO Auto-generated catch block
////					JOptionPane.showMessageDialog(null, "질문의 답과 일치하지 않습돠~!! 다시 써줍소!!");
//					e1.printStackTrace();
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//				
//			}
//		//	JOptionPane.showMessageDialog(null, "아이디 및 비밀번호가 틀렸습니다."); 
//			
//			
//			System.out.println(answerByName.toString()); // 이름이랑 답을 같이 띄움.
////			
////			for(String s : answerByName.keySet()) 		// 키(이름),벨류(답)을 한하나 띄어줌
////			{
////				System.out.println(s);
////				System.out.println(answerByName.get(s));
////			}
			
			String path = "C:/Users/Administrator/eclipse-workspace/Letgo/member"; // 멤버까지의 주소 가져오고 /로 바꿔줌.
			File dir = new File(path);		// 파일
			String[] filenames = dir.list();
			
			for(String filename : filenames) {
				
				String namePath = "member/"+filename+"/name.txt"; // 이름의 파일 경로 
				String answerPath = "member/"+filename+"/questions.txt";  // 답변의 텍스트 경로
				String idPath = "member/"+filename+"/id.txt";  // id의 텍스트 경로
			
				
				FileInputStream f = null; // 파일인풋스프림 선언
				FileInputStream d = null; 
				FileInputStream w = null; 

				File na=new File(namePath);
				File t=new File(answerPath);

				File id=new File(idPath);

				if(na.exists()) {
//			
			try {  // f : 이름, d: 답, w : id출력
				f=new FileInputStream(na);
				d=new FileInputStream(t);
				w=new FileInputStream(id);
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
					FileInputStream f2 = new FileInputStream(id);
					label5.setText(new String(o));
					
					//JOptionPane.showMessageDialog(null, "잘 쓰세요.... 없어요...");
				}
	
				setDefaultCloseOperation(EXIT_ON_CLOSE);
			}catch(Exception i) {
				System.out.println(i); // try의 catch는 세트 ( else )
			}
			}
				
		}
	}

	}

	
}
