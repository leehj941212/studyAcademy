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
		//DB���� �ȵǾ� ������ ����
		totalDAO = TotalDAO.connectMysql();
		//���̴� �κ� ���� , �̺�Ʈ ����
		setFName();
		//��ġ ��ġ 
		setFText();
		//frame ����
		setFDisplay();
	}

	//���̴� �κ� ���� , �̺�Ʈ ����
	void setFName() {
		//Label ����
		labels.put("�α���Ÿ��Ʋ", new JLabel("�α����ϼ���."));
		labels.put("���̵��Է�", new JLabel("���̵� �Է�"));
		labels.put("��й�ȣ�Է�", new JLabel("��й�ȣ �Է�."));
		labels.put("����", new JLabel(""));

		//TextField ����
		textFields.put("���̵�", new JTextField(20));

		//PasswordField ����
		passwordFields.put("��й�ȣ", new JPasswordField());

		//Button ����
		buttons.put("�α���", new JButton("�α���"));
		buttons.put("ȸ������", new JButton("ȸ������"));
		buttons.put("���̵�ã��", new JButton("���̵� ã��"));
		buttons.put("��й�ȣã��", new JButton("��й�ȣ ã��"));

		for (String key : buttons.keySet()) {
			buttons.get(key).addActionListener(this);
		}
	}

	//��ġ ��ġ
	void setFText() {
		// ��
		JPanel jp2 = new JPanel(new GridLayout(0,1,10,10));
		jp2.add(labels.get("����"));
		jp2.add(labels.get("���̵��Է�"));
		jp2.add(labels.get("��й�ȣ�Է�"));
		jp2.add(buttons.get("ȸ������"));

		// �߾�
		JPanel jp3 = new JPanel(new GridLayout(0,1,10,10));
		jp3.add(labels.get("�α���Ÿ��Ʋ"));
		jp3.add(textFields.get("���̵�"));
		jp3.add(passwordFields.get("��й�ȣ"));
		jp3.add(buttons.get("�α���"));

		// ����
		JPanel jp4 = new JPanel(new GridLayout(0,1,10,10));
		jp4.add(buttons.get("���̵�ã��"));
		jp4.add(buttons.get("��й�ȣã��"));

		// ����
		frame.add(jp2,BorderLayout.WEST);
		frame.add(jp3,BorderLayout.CENTER);
		frame.add(jp4,BorderLayout.SOUTH);

	}

	//frame ����
	void setFDisplay() {
		frame.setVisible(true);
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();

	}

	public void actionPerformed(ActionEvent e) {
		// �α��� ��ư �������� ����
		if(e.getSource()==buttons.get("�α���")) {
			//			//���� �Է� ��������
			if (textFields.get("���̵�").getText().equals("")
					||String.valueOf(passwordFields.get("��й�ȣ").getPassword()).equals("")) {
				JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� �Է��ϼ���", "��ĭ ����", JOptionPane.ERROR_MESSAGE);
			}else {
				sourceDTO.setId(textFields.get("���̵�").getText());
				sourceDTO.setPassword(String.valueOf(passwordFields.get("��й�ȣ").getPassword()));
				List<SourceDTO> list = totalDAO.lookUpByIdPassword(sourceDTO);
				//�Էµ� ���� ���� �ȵǾ� ������
				if(list.size() == 0){
					JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� Ʋ�Ƚ��ϴ�", "���� ��ȸ ����", JOptionPane.ERROR_MESSAGE);
					//���� ������
				} else {
					new Menu(list.get(0));
					frame.setVisible(false);
				}
			}
		}
		//�α��� ��ư �������� ��	

		//ȸ������ ��ư ��������
		if (e.getSource()==buttons.get("ȸ������")) {				
			new SignUp();
			frame.setVisible(false);
			//���̵� ã�� ��ư ��������
		}else if (e.getSource()==buttons.get("���̵�ã��")){   
			new FindIdPassword(0);
			frame.setVisible(false);
			//��й�ȣ ã�� ��ư ��������
		}else if (e.getSource()==buttons.get("��й�ȣã��")){   
			new FindIdPassword(1);
			frame.setVisible(false);
		}
	} 

	public static void main(String[] args) {
		new Login();
	}

}
