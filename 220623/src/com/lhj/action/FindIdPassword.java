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
	String result = "���̵�";

	Map<String,JLabel>labels = new Hashtable<String,JLabel>();
	Map<String,JTextField> textFields = new Hashtable<String,JTextField>();
	Map<String,JButton> buttons = new Hashtable<String,JButton>();
	JFrame frame = new JFrame("ID_Find");

	FindIdPassword(int idOrPassword){
		if (idOrPassword != 0) {
			result = "��й�ȣ";
			frame.setTitle("PW_Find");
		}
		//DB���� �ȵǾ� ������ ����
		totalDAO = TotalDAO.connectMysql();
		setName();
		setText();
		setDisplay();
	}

	void setName() {
		labels.put("����A", new JLabel(""));
		labels.put("ã��", new JLabel("ã��"));
		labels.put("����", new JLabel("����"));
		labels.put("��", new JLabel("�� : "));
		labels.put("���", new JLabel(result+" : "));
		labels.put("������", new JLabel("��� ����"));
		labels.put("����B", new JLabel(""));
		labels.put("�̸�", new JLabel("�̸�"));
		labels.put("�̸��Է�", new JLabel("�̸� �Է�"));
		labels.put("����", new JLabel("���� ���� 1ȣ��~!?!?"));
		
		textFields.put("�̸�", new JTextField(10));
		textFields.put("��", new JTextField(5));
		
		buttons.put("���", new JButton("��� �� �α���ȭ��"));
		buttons.put("Ȯ��", new JButton("Ȯ��"));
		
		for (String key : buttons.keySet()) {
			buttons.get(key).addActionListener(this);
		}
	}

	void setText() {
		JPanel jp2 = new JPanel(new GridLayout(0,1,10,20));// ��, ��, �翷 ����, ���Ʒ� ����
		jp2.add(labels.get("����A"));
		jp2.add(labels.get("�̸��Է�"));
		jp2.add(labels.get("����"));
		jp2.add(labels.get("��"));
		jp2.add(labels.get("���"));
		
		JPanel jp3 = new JPanel(new GridLayout(0,1,10,20));// ��, ��, �翷 ����, ���Ʒ� ����
		jp3.add(labels.get("ã��"));
		jp3.add(textFields.get("�̸�"));
		jp3.add(labels.get("����"));
		jp3.add(textFields.get("��"));
		jp3.add(labels.get("������"));

		JPanel jp4 = new JPanel(new GridLayout(0,1,10,20));// ��, ��, �翷 ����, ���Ʒ� ����
		jp4.add(buttons.get("Ȯ��"));
		jp4.add(buttons.get("���"));

		frame.add(jp2,BorderLayout.WEST);  // �ڸ�����
		frame.add(jp3,BorderLayout.CENTER);
		frame.add(jp4,BorderLayout.SOUTH);

	}

	void setDisplay() {
		frame.setVisible(true);  // ȭ�� ����ϴ� �ڵ�!!!
		frame.setSize(325, 300); // (width, heigth) ũŰ, �ʺ� �־��ָ� ��!
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // â�ݱ�
		frame.setLocationRelativeTo(null); // â ����� ����ִ� ��
		//	pack(); // â�� �ִ� ũ�⸦ �Ȱ��� �����.
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//��� �� �α���ȭ�� ��ư ��������
		if(e.getSource()==buttons.get("���")) {
			new Login();
			frame.setVisible(false);
			//Ȯ�� ��ư ��������
		} else if (e.getSource()==buttons.get("Ȯ��")){
			//���� �Է¾�������
			if (textFields.get("�̸�").getText().equals("")
					||textFields.get("��").getText().equals("")) {
				JOptionPane.showMessageDialog(null, "���� �Է��ؾ� �ſ�...!!");
			}else {
				sourceDTO.setName(textFields.get("�̸�").getText()); 
				sourceDTO.setQuestions(textFields.get("��").getText());
				List<SourceDTO> list = totalDAO.lookUpByNameQuestions(sourceDTO);
				//��ȸ �ȵɶ�
				if (list.size() == 0) {
					JOptionPane.showMessageDialog(null, "�� ������...�߸� �Է��޾��..."); // try�� catch�� ��Ʈ ( else )
					//��ȸ �����϶�
				} else {
					if (result.equals("���̵�")) {
						labels.get("������").setText(list.get(0).getId());
					} else {
						labels.get("������").setText(list.get(0).getPassword());
					}
					
				}
			}
		}

	}
}