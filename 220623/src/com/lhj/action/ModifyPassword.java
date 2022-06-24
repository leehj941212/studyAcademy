package com.lhj.action;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.lhj.dao.TotalDAO;
import com.lhj.dto.SourceDTO;

public class ModifyPassword implements ActionListener{
	SourceDTO sourceDTO = new SourceDTO();
	TotalDAO totalDAO;

	// 각 변수들 생성
	Map<String,JLabel>labels = new Hashtable<String,JLabel>();
	Map<String,JTextField> textFields = new Hashtable<String,JTextField>();
	Map<String,JPasswordField> passwordFields = new Hashtable<String,JPasswordField>();
	Map<String,JButton> buttons = new Hashtable<String,JButton>();
	JFrame frame = new JFrame("회원정보 수정");

	ModifyPassword(SourceDTO sourceDTO){
		this.sourceDTO = sourceDTO;
		//DB연결 안되어 있으면 연결
		totalDAO = TotalDAO.connectMysql();
		setUnit();
		setFrame();
		setDisplay();

	}

	//라벨, 텍스트필드, 버튼 안에 내용 및 크기	
	void setUnit() {				
		labels.put("이름", new JLabel("이름"));
		labels.put("생년월일", new JLabel("생년월일"));
		labels.put("학번", new JLabel("학번"));
		labels.put("연락처", new JLabel("연락처"));
		labels.put("비밀번호", new JLabel("비밀번호"));
		labels.put("비밀번호확인", new JLabel("비밀번호 확인"));
		labels.put("공백1", new JLabel(""));
		labels.put("공백2", new JLabel(""));
		labels.put("오류체크", new JLabel(""));
		
		textFields.put("이름", new JTextField(sourceDTO.getName() ,15));
		textFields.put("생년월일", new JTextField(String.valueOf(sourceDTO.getBirth()) ,15));
		textFields.put("학번", new JTextField(String.valueOf(sourceDTO.getHakbun()) ,15));
		textFields.put("연락처", new JTextField(String.valueOf(sourceDTO.getCallNum()) ,15));
		
		passwordFields.put("비밀번호", new JPasswordField());
		passwordFields.put("비밀번호확인", new JPasswordField());
		
		buttons.put("로그아웃", new JButton("로그아웃"));
		buttons.put("취소", new JButton("취소"));
		buttons.put("확인", new JButton("확인"));
	}

	//패널 배분
	void setFrame() {										 
		JPanel jp1 = new JPanel(new GridLayout(0,1,10,20));
		jp1.add(labels.get("이름"));
		jp1.add(labels.get("생년월일"));
		jp1.add(labels.get("학번"));
		jp1.add(labels.get("연락처"));
		jp1.add(labels.get("비밀번호"));
		jp1.add(labels.get("비밀번호확인"));
		jp1.add(labels.get("공백1"));

		JPanel jp2 = new JPanel(new GridLayout(0,1,10,20));
		jp2.add(textFields.get("이름"));
		jp2.add(textFields.get("생년월일"));
		jp2.add(textFields.get("학번"));
		jp2.add(textFields.get("연락처"));
		jp2.add(passwordFields.get("비밀번호"));
		jp2.add(passwordFields.get("비밀번호확인"));
		jp2.add(labels.get("오류체크"));

		JPanel jp3 = new JPanel();
		jp3.add(buttons.get("로그아웃"));

		JPanel jp4 = new JPanel();
		jp4.add(buttons.get("확인"));
		jp4.add(buttons.get("취소"));

		JPanel jp5 = new JPanel();
		jp5.add(labels.get("공백2"));						//공백넣어서 살짝 공간줌

		textFields.get("이름").setEditable(false);				//수정 불가
		textFields.get("생년월일").setEditable(false);
		textFields.get("학번").setEditable(false);
		textFields.get("연락처").setEditable(false);
		frame.add(jp1, BorderLayout.WEST);			//패널 위치
		frame.add(jp2, BorderLayout.CENTER);
		frame.add(jp3, BorderLayout.EAST);
		frame.add(jp4, BorderLayout.SOUTH);
		frame.add(jp5, BorderLayout.NORTH);
	}

	//보여지기 여부
	void setDisplay() {	
		frame.setVisible(true);						
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//종료버튼 누르면 종료
		frame.setLocationRelativeTo(null);			//창뜰때 중앙에 뜨기
		frame.setResizable(false);					//창 사이즈 고정
		frame.pack();									//내용물에 맞춰서 창 크기 설정

		buttons.get("로그아웃").addActionListener(this);			//액션리스너 메소드 연결
		buttons.get("확인").addActionListener(this);
		buttons.get("취소").addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {	
		//로그아웃 버튼 누를때
		if (e.getSource() == buttons.get("로그아웃")) {			
			new Login();
			frame.setVisible(false);
			//취소 버튼 누를때
		}else if (e.getSource() == buttons.get("취소")){
			new Menu(sourceDTO);
			frame.setVisible(false);
			//확인 버튼 누를때
		}else if (e.getSource() == buttons.get("확인")) {
			// 비밀번호, 비밀번호 확인 값이 같을때
			if (String.valueOf(passwordFields.get("비밀번호").getPassword()).equals(String.valueOf(passwordFields.get("비밀번호확인").getPassword()))) {
				//비밀번호 확인에 입력안했을때
				if(passwordFields.get("비밀번호확인").getPassword().length==0) {
					passwordFields.get("비밀번호").setText("");
					passwordFields.get("비밀번호확인").setText("");
					labels.get("오류체크").setText("비밀번호를 확인해주세요.");
				}else {						
					sourceDTO.setPassword(String.valueOf(passwordFields.get("비밀번호확인").getPassword()));
					totalDAO.updatePassword(sourceDTO);
					new Login();			
					frame.setVisible(false);
				}
			}else {
				labels.get("오류체크").setText("비밀번호를 확인해주세요.");
				passwordFields.get("비밀번호").setText("");
				passwordFields.get("비밀번호확인").setText("");
			} 
		}
	}

}