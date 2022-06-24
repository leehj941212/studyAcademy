package com.lhj.action;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.lhj.dao.TotalDAO;
import com.lhj.dto.SourceDTO;

public class FixWD implements ActionListener{
	SourceDTO sourceDTO = new SourceDTO();
	TotalDAO totalDAO;

	// 각 변수들 생성
	JLabel lbname, lbbirth, lbhakbun, lbphone, lbpw, lbpwcheck, lbalert, lbBlank1, lbBlank2;
	JTextField tfname, tfbirth, tfhakbun, tfphone;
	JPasswordField tfpw, tfpwcheck;
	JButton jbout, jbcancle, jbsave;
	JFrame frame = new JFrame("회원정보 수정");

	FixWD(SourceDTO sourceDTO){
		this.sourceDTO = sourceDTO;
		//DB연결 안되어 있으면 연결
		totalDAO = TotalDAO.connectMysql();
		setUnit();
		setFrame();
		setDisplay();

	}

	//라벨, 텍스트필드, 버튼 안에 내용 및 크기	
	void setUnit() {					
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

	//패널 배분
	void setFrame() {										 
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

		tfname.setText(sourceDTO.getName());			
		tfbirth.setText(String.valueOf(sourceDTO.getBirth()));
		tfhakbun.setText(String.valueOf(sourceDTO.getHakbun()));
		tfphone.setText(String.valueOf(sourceDTO.getCallNum()));

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

		jbout.addActionListener(this);			//액션리스너 메소드 연결
		jbsave.addActionListener(this);
		jbcancle.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {	
		//로그아웃 버튼 누를때
		if (e.getSource() == jbout) {			
			new LoginWD();
			frame.setVisible(false);
			//취소 버튼 누를때
		}else if (e.getSource() == jbcancle){
			new MenuWD(sourceDTO);
			frame.setVisible(false);
			//확인 버튼 누를때
		}else if (e.getSource() == jbsave) {
			// 비밀번호, 비밀번호 확인 값이 같을때
			if (String.valueOf(tfpw.getPassword()).equals(String.valueOf(tfpwcheck.getPassword()))) {
				//비밀번호 확인에 입력안했을때
				if(tfpwcheck.getPassword().length==0) {
					tfpw.setText("");
					tfpwcheck.setText("");
					lbalert.setText("비밀번호를 확인해주세요.");
				}else {						
					sourceDTO.setPassword(String.valueOf(tfpw.getPassword()));
					totalDAO.updatePassword(sourceDTO);
					new LoginWD();			
					frame.setVisible(false);
				}
			}else {
				lbalert.setText("비밀번호를 확인해주세요.");
				tfpw.setText("");
				tfpwcheck.setText("");
			} 
		}
	}

}