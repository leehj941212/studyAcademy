package teamProjectDB;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class IdFindWD  implements ActionListener { 
	SourceDTO student = new SourceDTO();
	MemberAct act = new MemberAct();

	JLabel label,label1,label2,label3,label4,label5,label6,label7,label8,label9;
	JTextField text1,text2;
	JButton jb1, jb2, jb3, jb4;
	JFrame frame = new JFrame("ID_Find");

	IdFindWD(){
		act.connectMysql();
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

		frame.add(jp2,BorderLayout.WEST);  // 자리지정
		frame.add(jp3,BorderLayout.CENTER);
		frame.add(jp4,BorderLayout.SOUTH);

		jb1.addActionListener(this);
		jb2.addActionListener(this);

	}

	void setSDisplay() {

		frame.setVisible(true);  // 화면 출력하는 코드!!!
		frame.setSize(325, 300); // (width, heigth) 크키, 너비 넣어주면 됨!
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창닫기
		frame.setLocationRelativeTo(null); // 창 가운데로 잡아주는 것
		//	pack(); // 창에 있는 크기를 똑같이 잡아줌.

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		//취소 및 로그인화면 버튼 눌렀을때
		if(e.getSource()==jb1) {
			new LoginWD();
			frame.setVisible(false);
			//확인 버튼 눌렀을때
		} else if (e.getSource()==jb2){
			//값을 입력안했을때
			if (text1.getText().equals("")
					||text2.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "값을 입력해야 돼요...!!");
			}else {
				student.setName(text1.getText()); 
				student.setQuestions(text2.getText());
				student.setId(act.findIdByNameQuestions(student.getName() , student.getQuestions()));
				//조회 안될때
				if (student.getId().equals("")) {
					JOptionPane.showMessageDialog(null, "잘 쓰세요...잘못 입력햇어요..."); // try의 catch는 세트 ( else )
					//조회 성공일때
				} else {
					label5.setText(student.getId());
				}
			}
		}

	}
}