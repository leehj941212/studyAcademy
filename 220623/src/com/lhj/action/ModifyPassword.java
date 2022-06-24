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

	// �� ������ ����
	Map<String,JLabel>labels = new Hashtable<String,JLabel>();
	Map<String,JTextField> textFields = new Hashtable<String,JTextField>();
	Map<String,JPasswordField> passwordFields = new Hashtable<String,JPasswordField>();
	Map<String,JButton> buttons = new Hashtable<String,JButton>();
	JFrame frame = new JFrame("ȸ������ ����");

	ModifyPassword(SourceDTO sourceDTO){
		this.sourceDTO = sourceDTO;
		//DB���� �ȵǾ� ������ ����
		totalDAO = TotalDAO.connectMysql();
		setUnit();
		setFrame();
		setDisplay();

	}

	//��, �ؽ�Ʈ�ʵ�, ��ư �ȿ� ���� �� ũ��	
	void setUnit() {				
		labels.put("�̸�", new JLabel("�̸�"));
		labels.put("�������", new JLabel("�������"));
		labels.put("�й�", new JLabel("�й�"));
		labels.put("����ó", new JLabel("����ó"));
		labels.put("��й�ȣ", new JLabel("��й�ȣ"));
		labels.put("��й�ȣȮ��", new JLabel("��й�ȣ Ȯ��"));
		labels.put("����1", new JLabel(""));
		labels.put("����2", new JLabel(""));
		labels.put("����üũ", new JLabel(""));
		
		textFields.put("�̸�", new JTextField(sourceDTO.getName() ,15));
		textFields.put("�������", new JTextField(String.valueOf(sourceDTO.getBirth()) ,15));
		textFields.put("�й�", new JTextField(String.valueOf(sourceDTO.getHakbun()) ,15));
		textFields.put("����ó", new JTextField(String.valueOf(sourceDTO.getCallNum()) ,15));
		
		passwordFields.put("��й�ȣ", new JPasswordField());
		passwordFields.put("��й�ȣȮ��", new JPasswordField());
		
		buttons.put("�α׾ƿ�", new JButton("�α׾ƿ�"));
		buttons.put("���", new JButton("���"));
		buttons.put("Ȯ��", new JButton("Ȯ��"));
	}

	//�г� ���
	void setFrame() {										 
		JPanel jp1 = new JPanel(new GridLayout(0,1,10,20));
		jp1.add(labels.get("�̸�"));
		jp1.add(labels.get("�������"));
		jp1.add(labels.get("�й�"));
		jp1.add(labels.get("����ó"));
		jp1.add(labels.get("��й�ȣ"));
		jp1.add(labels.get("��й�ȣȮ��"));
		jp1.add(labels.get("����1"));

		JPanel jp2 = new JPanel(new GridLayout(0,1,10,20));
		jp2.add(textFields.get("�̸�"));
		jp2.add(textFields.get("�������"));
		jp2.add(textFields.get("�й�"));
		jp2.add(textFields.get("����ó"));
		jp2.add(passwordFields.get("��й�ȣ"));
		jp2.add(passwordFields.get("��й�ȣȮ��"));
		jp2.add(labels.get("����üũ"));

		JPanel jp3 = new JPanel();
		jp3.add(buttons.get("�α׾ƿ�"));

		JPanel jp4 = new JPanel();
		jp4.add(buttons.get("Ȯ��"));
		jp4.add(buttons.get("���"));

		JPanel jp5 = new JPanel();
		jp5.add(labels.get("����2"));						//����־ ��¦ ������

		textFields.get("�̸�").setEditable(false);				//���� �Ұ�
		textFields.get("�������").setEditable(false);
		textFields.get("�й�").setEditable(false);
		textFields.get("����ó").setEditable(false);
		frame.add(jp1, BorderLayout.WEST);			//�г� ��ġ
		frame.add(jp2, BorderLayout.CENTER);
		frame.add(jp3, BorderLayout.EAST);
		frame.add(jp4, BorderLayout.SOUTH);
		frame.add(jp5, BorderLayout.NORTH);
	}

	//�������� ����
	void setDisplay() {	
		frame.setVisible(true);						
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����ư ������ ����
		frame.setLocationRelativeTo(null);			//â�㶧 �߾ӿ� �߱�
		frame.setResizable(false);					//â ������ ����
		frame.pack();									//���빰�� ���缭 â ũ�� ����

		buttons.get("�α׾ƿ�").addActionListener(this);			//�׼Ǹ����� �޼ҵ� ����
		buttons.get("Ȯ��").addActionListener(this);
		buttons.get("���").addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {	
		//�α׾ƿ� ��ư ������
		if (e.getSource() == buttons.get("�α׾ƿ�")) {			
			new Login();
			frame.setVisible(false);
			//��� ��ư ������
		}else if (e.getSource() == buttons.get("���")){
			new Menu(sourceDTO);
			frame.setVisible(false);
			//Ȯ�� ��ư ������
		}else if (e.getSource() == buttons.get("Ȯ��")) {
			// ��й�ȣ, ��й�ȣ Ȯ�� ���� ������
			if (String.valueOf(passwordFields.get("��й�ȣ").getPassword()).equals(String.valueOf(passwordFields.get("��й�ȣȮ��").getPassword()))) {
				//��й�ȣ Ȯ�ο� �Է¾�������
				if(passwordFields.get("��й�ȣȮ��").getPassword().length==0) {
					passwordFields.get("��й�ȣ").setText("");
					passwordFields.get("��й�ȣȮ��").setText("");
					labels.get("����üũ").setText("��й�ȣ�� Ȯ�����ּ���.");
				}else {						
					sourceDTO.setPassword(String.valueOf(passwordFields.get("��й�ȣȮ��").getPassword()));
					totalDAO.updatePassword(sourceDTO);
					new Login();			
					frame.setVisible(false);
				}
			}else {
				labels.get("����üũ").setText("��й�ȣ�� Ȯ�����ּ���.");
				passwordFields.get("��й�ȣ").setText("");
				passwordFields.get("��й�ȣȮ��").setText("");
			} 
		}
	}

}