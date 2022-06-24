package com.lhj.action;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.lhj.dto.SourceDTO;

public class Menu implements ActionListener {
	SourceDTO sourceDTO = new SourceDTO();
	
	Map<String,JLabel>labels = new Hashtable<String,JLabel>();
	Map<String,JButton> buttons = new Hashtable<String,JButton>();
	
	JFrame frame = new JFrame("선택 메뉴");

	public Menu(SourceDTO sourceDTO) {
		this.sourceDTO = sourceDTO;
		
		labels.put("메뉴",  new JLabel ("메뉴"));
		buttons.put("회원정보수정",  new JButton ("회원정보 수정"));
		buttons.put("성적관리",  new JButton ("성적 관리"));
		buttons.put("회원탈퇴",  new JButton ("회원 탈퇴"));
		buttons.put("로그아웃",  new JButton ("로그 아웃"));
		
		for (String key : buttons.keySet()) {
			buttons.get(key).addActionListener(this);
		}
		
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();

		jp1.setLayout(new GridLayout(1,1));
		jp2.setLayout(new GridLayout(4,1,20,20));

		jp1.add(labels.get("메뉴"));
		jp2.add(buttons.get("회원정보수정"));
		jp2.add(buttons.get("성적관리"));
		jp2.add(buttons.get("회원탈퇴"));
		jp2.add(buttons.get("로그아웃"));

		frame.setLayout(new BorderLayout());

		frame.add(jp1,"North");
		frame.add(jp2,"Center");

		labels.get("메뉴").setHorizontalAlignment(JLabel.CENTER);

		Font letter = new Font("맑은 고딕",Font.BOLD, 15); 

		labels.get("메뉴").setFont(new Font("맑은 고딕",Font.BOLD, 20));

		buttons.get("회원정보수정").setFont(letter);
		buttons.get("성적관리").setFont(letter);
		buttons.get("회원탈퇴").setFont(letter);
		buttons.get("로그아웃").setFont(letter);

		frame.setSize(400,400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buttons.get("회원정보수정"))
		{   new ModifyPassword(sourceDTO);
		frame.setVisible(false);
		}else if (e.getSource()==buttons.get("성적관리"))
		{   new ScoreMWD(sourceDTO);
		frame.setVisible(false);
		}else if (e.getSource()==buttons.get("회원탈퇴"))
		{   new Delete(sourceDTO);
		frame.setVisible(false);
		}else if (e.getSource()==buttons.get("로그아웃"))
		{   new Login();
		frame.setVisible(false);
		}

	} 



}
