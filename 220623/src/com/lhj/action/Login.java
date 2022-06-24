package com.lhj.action;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.lhj.dao.TotalDAO;
import com.lhj.dto.SourceDTO;


class Login implements ActionListener{
	SourceDTO sourceDTO = new SourceDTO();
	TotalDAO totalDAO;

	Map<String,JLabel>labels = new Hashtable<String,JLabel>();
	Map<String,JTextField> textFields = new Hashtable<String,JTextField>();
	Map<String,JButton> buttons = new Hashtable<String,JButton>();
	Map<String,JPasswordField> passwordFields = new Hashtable<String,JPasswordField>();
	JFrame frame = new JFrame("login");

	Login(){
		//DB연결 안되어 있으면 연결
		totalDAO = TotalDAO.connectMysql();
		//보이는 부분 생성 , 이벤트 선언
		setFName();
		//위치 배치 
		setFText();
		//frame 설정
		setFDisplay();
	}

	//보이는 부분 생성 , 이벤트 선언
	void setFName() {
		//Label 생성
		labels.put("로그인타이틀", new JLabel("로그인하세요."));
		labels.put("아이디입력", new JLabel("아이디 입력"));
		labels.put("비밀번호입력", new JLabel("비밀번호 입력."));
		labels.put("공백", new JLabel(""));

		//TextField 생성
		textFields.put("아이디", new JTextField(20));

		//PasswordField 생성
		passwordFields.put("비밀번호", new JPasswordField());

		//Button 생성
		buttons.put("로그인", new JButton("로그인"));
		buttons.put("회원가입", new JButton("회원가입"));
		buttons.put("아이디찾기", new JButton("아이디 찾기"));
		buttons.put("비밀번호찾기", new JButton("비밀번호 찾기"));

		for (String key : buttons.keySet()) {
			buttons.get(key).addActionListener(this);
		}
	}

	//위치 배치
	void setFText() {
		// 서
		JPanel jp2 = new JPanel(new GridLayout(0,1,10,10));
		jp2.add(labels.get("공백"));
		jp2.add(labels.get("아이디입력"));
		jp2.add(labels.get("비밀번호입력"));
		jp2.add(buttons.get("회원가입"));

		// 중앙
		JPanel jp3 = new JPanel(new GridLayout(0,1,10,10));
		jp3.add(labels.get("로그인타이틀"));
		jp3.add(textFields.get("아이디"));
		jp3.add(passwordFields.get("비밀번호"));
		jp3.add(buttons.get("로그인"));

		// 남쪽
		JPanel jp4 = new JPanel(new GridLayout(0,1,10,10));
		jp4.add(buttons.get("아이디찾기"));
		jp4.add(buttons.get("비밀번호찾기"));

		// 방향
		frame.add(jp2,BorderLayout.WEST);
		frame.add(jp3,BorderLayout.CENTER);
		frame.add(jp4,BorderLayout.SOUTH);

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
		if(e.getSource()==buttons.get("로그인")) {
			//			//값을 입력 안했을때
			if (textFields.get("아이디").getText().equals("")
					||String.valueOf(passwordFields.get("비밀번호").getPassword()).equals("")) {
				JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력하세요", "빈칸 오류", JOptionPane.ERROR_MESSAGE);
			}else {
				sourceDTO.setId(textFields.get("아이디").getText());
				sourceDTO.setPassword(String.valueOf(passwordFields.get("비밀번호").getPassword()));
				List<SourceDTO> list = totalDAO.lookUpByIdPassword(sourceDTO);
				//입력된 값이 가입 안되어 있을때
				if(list.size() == 0){
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 틀렸습니다", "계정 조회 실패", JOptionPane.ERROR_MESSAGE);
					//문제 없을때
				} else {
					new Menu(list.get(0));
					frame.setVisible(false);
				}
			}
		}
		//로그인 버튼 눌렀을때 끝	

		//회원가입 버튼 눌렀을때
		if (e.getSource()==buttons.get("회원가입")) {				
			new SignUp();
			frame.setVisible(false);
			//아이디 찾기 버튼 눌렀을때
		}else if (e.getSource()==buttons.get("아이디찾기")){   
			new FindIdPassword(0);
			frame.setVisible(false);
			//비밀번호 찾기 버튼 눌렀을때
		}else if (e.getSource()==buttons.get("비밀번호찾기")){   
			new FindIdPassword(1);
			frame.setVisible(false);
		}
	} 

	public static void main(String[] args) {
		new Login();
	}

}
