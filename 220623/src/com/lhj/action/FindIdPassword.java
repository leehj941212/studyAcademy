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
import javax.swing.JTextField;

import com.lhj.dao.TotalDAO;
import com.lhj.dto.SourceDTO;



public class FindIdPassword  implements ActionListener { 
	SourceDTO sourceDTO = new SourceDTO();
	TotalDAO totalDAO;
	String result = "아이디";

	Map<String,JLabel>labels = new Hashtable<String,JLabel>();
	Map<String,JTextField> textFields = new Hashtable<String,JTextField>();
	Map<String,JButton> buttons = new Hashtable<String,JButton>();
	JFrame frame = new JFrame("ID_Find");

	FindIdPassword(int idOrPassword){
		if (idOrPassword != 0) {
			result = "비밀번호";
			frame.setTitle("PW_Find");
		}
		//DB연결 안되어 있으면 연결
		totalDAO = TotalDAO.connectMysql();
		setName();
		setText();
		setDisplay();
	}

	void setName() {
		labels.put("공백A", new JLabel(""));
		labels.put("찾기", new JLabel("찾기"));
		labels.put("질문", new JLabel("질문"));
		labels.put("답", new JLabel("답 : "));
		labels.put("결과", new JLabel(result+" : "));
		labels.put("결과출력", new JLabel("출력 공간"));
		labels.put("공백B", new JLabel(""));
		labels.put("이름", new JLabel("이름"));
		labels.put("이름입력", new JLabel("이름 입력"));
		labels.put("보물", new JLabel("나의 보물 1호는~!?!?"));
		
		textFields.put("이름", new JTextField(10));
		textFields.put("답", new JTextField(5));
		
		buttons.put("취소", new JButton("취소 및 로그인화면"));
		buttons.put("확인", new JButton("확인"));
		
		for (String key : buttons.keySet()) {
			buttons.get(key).addActionListener(this);
		}
	}

	void setText() {
		JPanel jp2 = new JPanel(new GridLayout(0,1,10,20));// 행, 열, 양옆 간격, 위아래 간격
		jp2.add(labels.get("공백A"));
		jp2.add(labels.get("이름입력"));
		jp2.add(labels.get("질문"));
		jp2.add(labels.get("답"));
		jp2.add(labels.get("결과"));
		
		JPanel jp3 = new JPanel(new GridLayout(0,1,10,20));// 행, 열, 양옆 간격, 위아래 간격
		jp3.add(labels.get("찾기"));
		jp3.add(textFields.get("이름"));
		jp3.add(labels.get("보물"));
		jp3.add(textFields.get("답"));
		jp3.add(labels.get("결과출력"));

		JPanel jp4 = new JPanel(new GridLayout(0,1,10,20));// 행, 열, 양옆 간격, 위아래 간격
		jp4.add(buttons.get("확인"));
		jp4.add(buttons.get("취소"));

		frame.add(jp2,BorderLayout.WEST);  // 자리지정
		frame.add(jp3,BorderLayout.CENTER);
		frame.add(jp4,BorderLayout.SOUTH);

	}

	void setDisplay() {
		frame.setVisible(true);  // 화면 출력하는 코드!!!
		frame.setSize(325, 300); // (width, heigth) 크키, 너비 넣어주면 됨!
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창닫기
		frame.setLocationRelativeTo(null); // 창 가운데로 잡아주는 것
		//	pack(); // 창에 있는 크기를 똑같이 잡아줌.
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//취소 및 로그인화면 버튼 눌렀을때
		if(e.getSource()==buttons.get("취소")) {
			new Login();
			frame.setVisible(false);
			//확인 버튼 눌렀을때
		} else if (e.getSource()==buttons.get("확인")){
			//값을 입력안했을때
			if (textFields.get("이름").getText().equals("")
					||textFields.get("답").getText().equals("")) {
				JOptionPane.showMessageDialog(null, "값을 입력해야 돼요...!!");
			}else {
				sourceDTO.setName(textFields.get("이름").getText()); 
				sourceDTO.setQuestions(textFields.get("답").getText());
				List<SourceDTO> list = totalDAO.lookUpByNameQuestions(sourceDTO);
				//조회 안될때
				if (list.size() == 0) {
					JOptionPane.showMessageDialog(null, "잘 쓰세요...잘못 입력햇어요..."); // try의 catch는 세트 ( else )
					//조회 성공일때
				} else {
					if (result.equals("아이디")) {
						labels.get("결과출력").setText(list.get(0).getId());
					} else {
						labels.get("결과출력").setText(list.get(0).getPassword());
					}
					
				}
			}
		}

	}
}