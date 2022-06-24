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
	
	JFrame frame = new JFrame("���� �޴�");

	public Menu(SourceDTO sourceDTO) {
		this.sourceDTO = sourceDTO;
		
		labels.put("�޴�",  new JLabel ("�޴�"));
		buttons.put("ȸ����������",  new JButton ("ȸ������ ����"));
		buttons.put("��������",  new JButton ("���� ����"));
		buttons.put("ȸ��Ż��",  new JButton ("ȸ�� Ż��"));
		buttons.put("�α׾ƿ�",  new JButton ("�α� �ƿ�"));
		
		for (String key : buttons.keySet()) {
			buttons.get(key).addActionListener(this);
		}
		
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();

		jp1.setLayout(new GridLayout(1,1));
		jp2.setLayout(new GridLayout(4,1,20,20));

		jp1.add(labels.get("�޴�"));
		jp2.add(buttons.get("ȸ����������"));
		jp2.add(buttons.get("��������"));
		jp2.add(buttons.get("ȸ��Ż��"));
		jp2.add(buttons.get("�α׾ƿ�"));

		frame.setLayout(new BorderLayout());

		frame.add(jp1,"North");
		frame.add(jp2,"Center");

		labels.get("�޴�").setHorizontalAlignment(JLabel.CENTER);

		Font letter = new Font("���� ���",Font.BOLD, 15); 

		labels.get("�޴�").setFont(new Font("���� ���",Font.BOLD, 20));

		buttons.get("ȸ����������").setFont(letter);
		buttons.get("��������").setFont(letter);
		buttons.get("ȸ��Ż��").setFont(letter);
		buttons.get("�α׾ƿ�").setFont(letter);

		frame.setSize(400,400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buttons.get("ȸ����������"))
		{   new ModifyPassword(sourceDTO);
		frame.setVisible(false);
		}else if (e.getSource()==buttons.get("��������"))
		{   new ScoreMWD(sourceDTO);
		frame.setVisible(false);
		}else if (e.getSource()==buttons.get("ȸ��Ż��"))
		{   new Delete(sourceDTO);
		frame.setVisible(false);
		}else if (e.getSource()==buttons.get("�α׾ƿ�"))
		{   new Login();
		frame.setVisible(false);
		}

	} 



}
