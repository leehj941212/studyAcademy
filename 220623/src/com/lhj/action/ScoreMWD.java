package com.lhj.action;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.lhj.dao.TotalDAO;
import com.lhj.dto.SourceDTO;

public class ScoreMWD implements ActionListener{
	SourceDTO sourceDTO = new SourceDTO();
	TotalDAO totalDAO;

	JFrame frame = new JFrame ("My 성적 관리");
	JFrame messageFrame = new JFrame("안내메세지");
	JLabel idLabel, idBlank,Java, Web, Jsp, alram1, alram2, alram3, alram4;
	JTextField javaJumsu, WebJumsu, JspJumsu;
	JButton save, exit, reset; 
	JButton message;
	JPanel panel1, panel2, panel3 ; 

	public ScoreMWD(SourceDTO sourceDTO) {
		this.sourceDTO = sourceDTO;

		//DB연결 안되어 있으면 연결
		totalDAO = TotalDAO.connectMysql();

		idLabel = new JLabel("아이디");
		Java = new JLabel("Java 과목 점수");
		Web = new JLabel("Web 과목 점수");
		Jsp = new JLabel("Jsp 과목 점수");

		alram1 = new JLabel("* 성적을 입력해주세요 * ");
		alram2 = new JLabel("숫자 외에는 저장 불가합니다"); 
		alram3 = new JLabel(""); 
		alram4 = new JLabel(""); 

		idBlank = new JLabel("");
		javaJumsu = new JTextField(String.valueOf(sourceDTO.getJava()));
		WebJumsu = new JTextField(String.valueOf(sourceDTO.getWeb()));
		JspJumsu = new JTextField(String.valueOf(sourceDTO.getJsp()));

		save= new JButton("저장");
		reset= new JButton("입력값 초기화");
		exit= new JButton("취소");

		message= new JButton("확인");

		Font letter = new Font("맑은 고딕",Font.BOLD, 14); 
		Font letter2 = new Font("맑은 고딕",Font.BOLD, 12); 

		idLabel.setFont(letter);
		Java.setFont(letter);
		Web.setFont(letter);
		Jsp.setFont(letter);
		alram1.setFont(letter);
		alram2.setFont(letter2);
		alram3.setFont(letter2);
		alram4.setFont(letter2);
		idBlank.setFont(letter);
		javaJumsu.setFont(letter);
		WebJumsu.setFont(letter);
		JspJumsu.setFont(letter);
		save.setFont(letter);
		exit.setFont(letter);
		message.setFont(letter);
		reset.setFont(letter);

		alram3.setForeground(Color.BLUE);
		alram4.setForeground(Color.BLUE);

		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null);
		frame.setSize(450,300);

		JPanel left = new JPanel (); 
		left.setLayout(new GridLayout(6,1));

		left.add(alram1);
		left.add(idLabel);
		left.add(Java);
		left.add(Web);
		left.add(Jsp);
		left.add(alram3);

		alram1.setHorizontalAlignment(JLabel.CENTER);
		idLabel.setHorizontalAlignment(JLabel.CENTER);
		Java.setHorizontalAlignment(JLabel.CENTER);
		Web.setHorizontalAlignment(JLabel.CENTER);
		Jsp.setHorizontalAlignment(JLabel.CENTER);
		alram3.setHorizontalAlignment(JLabel.CENTER);

		JPanel right = new JPanel (); 
		right.setLayout(new GridLayout(6,1));

		right.add(alram2);
		right.add(idBlank);
		right.add(javaJumsu);
		right.add(WebJumsu);
		right.add(JspJumsu);
		right.add(alram4);

		JPanel layout = new JPanel ();
		layout.setLayout(new GridLayout(1,2));

		layout.add(left);
		layout.add(right);

		JPanel bottons = new JPanel ();
		bottons.setLayout(new FlowLayout());

		bottons.add(save);
		bottons.add(reset);
		bottons.add(exit);

		frame.add(layout,"Center");
		frame.add(bottons,"South");

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		save.addActionListener(this);
		exit.addActionListener(this);
		reset.addActionListener(this);

		idBlank.setText(sourceDTO.getId());

	}

	void addOutput(){

		sourceDTO.setJava(Integer.parseInt(javaJumsu.getText()));
		sourceDTO.setWeb(Integer.parseInt(WebJumsu.getText()));
		sourceDTO.setJsp(Integer.parseInt(JspJumsu.getText()));
		
		totalDAO.updateJavaWebJsp(sourceDTO);







	}

	void savePopup1(){


		JLabel pm_item1 = new JLabel("저장 되었습니다");

		messageFrame.setLayout(null);
		pm_item1.setBounds(100,30,150,30);
		message.setBounds(40,80,200,50);

		messageFrame.add(pm_item1);
		messageFrame.add(message);
		messageFrame.setSize(300,200);
		messageFrame.setVisible(true);

		messageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		messageFrame.setLocationRelativeTo(null);
		message.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		byte [] javacheck = javaJumsu.getText().getBytes();
		byte [] webcheck = WebJumsu.getText().getBytes();
		byte [] jspcheck = JspJumsu.getText().getBytes();

		if(e.getSource()==save){

			if(javaJumsu.getText().equals("")||WebJumsu.getText().equals("")||JspJumsu.getText().equals("")) {
				alram3.setText("성적 입력해주세요.");
			} else {
				int a = 0;
				for(int i = 0; i < javacheck.length; i++) {
					if(!Character.isDigit(javacheck[i])) {
						alram3.setText("숫자만 입력 가능합니다.");
						a = 1;
						break;
					} else {
						alram3.setText("");
					}
				}

				for(int i = 0; i < webcheck.length; i++) {
					if(!Character.isDigit(webcheck[i])) {
						alram3.setText("숫자만 입력 가능합니다.");
						a = 1;
						break;
					} else {
						alram3.setText("");
					}
				}

				for(int i = 0; i < jspcheck.length; i++) {
					if(!Character.isDigit(jspcheck[i])) {
						alram3.setText("숫자만 입력 가능합니다.");
						a = 1;
						break;
					} else {
						alram3.setText("");
					}
				}

				if (a==1) {
					alram3.setText("오류를 확인하세요");
				} else {
					addOutput();
					savePopup1();

					alram3.setText("");
					alram4.setText("");
				}

			}

		}else if(e.getSource()==message){
			messageFrame.setVisible(false);
		}else if(e.getSource()==exit) {
			new Menu(sourceDTO);
			frame.setVisible(false);
		}else if(e.getSource()==reset) {
			javaJumsu.setText(String.valueOf(sourceDTO.getJava()));
			WebJumsu.setText(String.valueOf(sourceDTO.getWeb()));
			JspJumsu.setText(String.valueOf(sourceDTO.getJsp()));
		}
	}

}