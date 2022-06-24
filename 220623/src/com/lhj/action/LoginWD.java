package com.lhj.action;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.lhj.dao.TotalDAO;
import com.lhj.dto.SourceDTO;


class LoginWD implements ActionListener{
	SourceDTO sourceDTO = new SourceDTO();
	TotalDAO totalDAO;

	JLabel label1,label2,label3,label4;
	JTextField idText;
	JButton jb1, jb2, jb3,jb4;
	JPasswordField passwordText;
	InputStream id;
	JFrame frame = new JFrame("login");

	LoginWD(){
		//DB연결 안되어 있으면 연결
		totalDAO = TotalDAO.connectMysql();
		//보이는 부분 생성
		setFName();
		//위치 배치 및 이벤트 선언
		setFText();
		//frame 설정
		setFDisplay();
	}

	//보이는 부분 생성
	void setFName() {
		//Label 생성
		label1=new JLabel("로그인하세요.");
		label2=new JLabel("아이디 입력");
		label3=new JLabel("비밀번호 입력");
		label4=new JLabel("");

		//TextField 생성
		idText=new JTextField(20);

		//PasswordField 생성
		passwordText=new JPasswordField();

		//Button 생성
		jb1=new JButton("로그인");
		jb2=new JButton("회원가입");
		jb3=new JButton("아이디 찾기");
		jb4=new JButton("비밀번호 찾기");

	}

	//위치 배치 및 이벤트 선언
	void setFText() {
		// 서
		JPanel jp2 = new JPanel(new GridLayout(0,1,10,10));
		jp2.add(label4);
		jp2.add(label2);
		jp2.add(label3);
		jp2.add(jb2);

		// 중앙
		JPanel jp3 = new JPanel(new GridLayout(0,1,10,10));
		jp3.add(label1);
		jp3.add(idText);

		jp3.add(passwordText);
		jp3.add(jb1);


		// 남쪽
		JPanel jp4 = new JPanel(new GridLayout(0,1,10,10));
		jp4.add(jb3);
		jp4.add(jb4);

		// 방향
		frame.add(jp2,BorderLayout.WEST);
		frame.add(jp3,BorderLayout.CENTER);
		frame.add(jp4,BorderLayout.SOUTH);

		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);

	}

	//frame 설정
	void setFDisplay() {
		frame.setVisible(true);
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();

	}

	public void actionPerformed(ActionEvent e) {
		// 로그인 버튼 눌렀을때 시작
		if(e.getSource()==jb1) {
			//			//값을 입력 안했을때
			if (idText.getText().equals("")
					||String.valueOf(passwordText.getPassword()).equals("")) {
				JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력하세요");
			}else {
				sourceDTO.setId(idText.getText());
				sourceDTO.setPassword(String.valueOf(passwordText.getPassword()));
				List<SourceDTO> list = totalDAO.lookUpByIdPassword(sourceDTO);
				//입력된 값이 가입 안되어 있을때
				if(list.size() == 0){
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 틀렸습니다");
					//문제 없을때
				} else {
					new MenuWD(list.get(0));
					frame.setVisible(false);
				}
			}
		}
		//로그인 버튼 눌렀을때 끝	

		//회원가입 버튼 눌렀을때
		if (e.getSource()==jb2) {				
			new SignUpWD();
			frame.setVisible(false);
			//아이디 찾기 버튼 눌렀을때
		}else if (e.getSource()==jb3){   
			new IdFindWD();
			frame.setVisible(false);
			//비밀번호 찾기 버튼 눌렀을때
		}else if (e.getSource()==jb4){   
			new PwFindWD();
			frame.setVisible(false);
		}
	} 

	public static void main(String[] args) {
		new LoginWD();
	}

}
