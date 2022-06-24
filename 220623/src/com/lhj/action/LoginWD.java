package com.lhj.action;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.lhj.dao.TotalDAO;
import com.lhj.dto.SourceDTO;


class LoginWD implements ActionListener{
	SourceDTO sourceDTO = new SourceDTO();
	TotalDAO totalDAO;

	JLabel label1,label2,label3,label4;
	JTextField idText;
	JButton jb1, jb2, jb3,jb4;
	JPasswordField passwordText;
	InputStream id;
	JFrame frame = new JFrame("login");

	LoginWD(){
		//DB���� �ȵǾ� ������ ����
		totalDAO = TotalDAO.connectMysql();
		//���̴� �κ� ����
		setFName();
		//��ġ ��ġ �� �̺�Ʈ ����
		setFText();
		//frame ����
		setFDisplay();
	}

	//���̴� �κ� ����
	void setFName() {
		//Label ����
		label1=new JLabel("�α����ϼ���.");
		label2=new JLabel("���̵� �Է�");
		label3=new JLabel("��й�ȣ �Է�");
		label4=new JLabel("");

		//TextField ����
		idText=new JTextField(20);

		//PasswordField ����
		passwordText=new JPasswordField();

		//Button ����
		jb1=new JButton("�α���");
		jb2=new JButton("ȸ������");
		jb3=new JButton("���̵� ã��");
		jb4=new JButton("��й�ȣ ã��");

	}

	//��ġ ��ġ �� �̺�Ʈ ����
	void setFText() {
		// ��
		JPanel jp2 = new JPanel(new GridLayout(0,1,10,10));
		jp2.add(label4);
		jp2.add(label2);
		jp2.add(label3);
		jp2.add(jb2);

		// �߾�
		JPanel jp3 = new JPanel(new GridLayout(0,1,10,10));
		jp3.add(label1);
		jp3.add(idText);

		jp3.add(passwordText);
		jp3.add(jb1);


		// ����
		JPanel jp4 = new JPanel(new GridLayout(0,1,10,10));
		jp4.add(jb3);
		jp4.add(jb4);

		// ����
		frame.add(jp2,BorderLayout.WEST);
		frame.add(jp3,BorderLayout.CENTER);
		frame.add(jp4,BorderLayout.SOUTH);

		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jb4.addActionListener(this);

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
		if(e.getSource()==jb1) {
			//			//���� �Է� ��������
			if (idText.getText().equals("")
					||String.valueOf(passwordText.getPassword()).equals("")) {
				JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ�� �Է��ϼ���");
			}else {
				sourceDTO.setId(idText.getText());
				sourceDTO.setPassword(String.valueOf(passwordText.getPassword()));
				List<SourceDTO> list = totalDAO.lookUpByIdPassword(sourceDTO);
				//�Էµ� ���� ���� �ȵǾ� ������
				if(list.size() == 0){
					JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� Ʋ�Ƚ��ϴ�");
					//���� ������
				} else {
					new MenuWD(list.get(0));
					frame.setVisible(false);
				}
			}
		}
		//�α��� ��ư �������� ��	

		//ȸ������ ��ư ��������
		if (e.getSource()==jb2) {				
			new SignUpWD();
			frame.setVisible(false);
			//���̵� ã�� ��ư ��������
		}else if (e.getSource()==jb3){   
			new IdFindWD();
			frame.setVisible(false);
			//��й�ȣ ã�� ��ư ��������
		}else if (e.getSource()==jb4){   
			new PwFindWD();
			frame.setVisible(false);
		}
	} 

	public static void main(String[] args) {
		new LoginWD();
	}

}
