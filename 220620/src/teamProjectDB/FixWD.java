package teamProjectDB;
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

public class FixWD implements ActionListener{
	SourceDTO student = new SourceDTO();
	MemberAct act = new MemberAct();

	// �� ������ ����
	JLabel lbname, lbbirth, lbhakbun, lbphone, lbpw, lbpwcheck, lbalert, lbBlank1, lbBlank2;
	JTextField tfname, tfbirth, tfhakbun, tfphone;
	JPasswordField tfpw, tfpwcheck;
	JButton jbout, jbcancle, jbsave;
	JFrame frame = new JFrame("ȸ������ ����");

	FixWD(String id){
		student.setId(id);
		act.connectMysql();
		setUnit();
		setFrame();
		setDisplay();

	}

	//��, �ؽ�Ʈ�ʵ�, ��ư �ȿ� ���� �� ũ��	
	void setUnit() {					
		lbname = new JLabel("�̸�");
		lbbirth = new JLabel("�������");
		lbhakbun = new JLabel("�й�");
		lbphone = new JLabel("����ó");
		lbpw = new JLabel("��й�ȣ");
		lbpwcheck = new JLabel("��й�ȣ Ȯ��");
		lbalert = new JLabel("");
		lbBlank1 = new JLabel(""); 
		lbBlank2 = new JLabel(""); 
		tfname = new JTextField(15);	
		tfbirth = new JTextField(15);
		tfhakbun = new JTextField(15);
		tfphone = new JTextField(15);
		tfpw = new JPasswordField();
		tfpwcheck = new JPasswordField("");
		jbout = new JButton("�α׾ƿ�");
		jbcancle = new JButton("���");
		jbsave = new JButton("Ȯ��");

	}

	//�г� ���
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

		student.setName(act.nameValue(student.getId()));
		student.setBirth(act.birthValue(student.getId()));
		student.setHakbun(act.hakbunValue(student.getId()));
		student.setCallNum(act.callNumValue(student.getId()));

		tfname.setText(student.getName());			
		tfbirth.setText(String.valueOf(student.getBirth()));
		tfhakbun.setText(String.valueOf(student.getHakbun()));
		tfphone.setText(String.valueOf(student.getCallNum()));

		JPanel jp3 = new JPanel();
		jp3.add(jbout);

		JPanel jp4 = new JPanel();
		jp4.add(jbsave);
		jp4.add(jbcancle);

		JPanel jp5 = new JPanel();
		jp5.add(lbBlank2);						//����־ ��¦ ������

		tfname.setEditable(false);				//���� �Ұ�
		tfbirth.setEditable(false);
		tfhakbun.setEditable(false);
		tfphone.setEditable(false);
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

		jbout.addActionListener(this);			//�׼Ǹ����� �޼ҵ� ����
		jbsave.addActionListener(this);
		jbcancle.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {	
		try {
			//�α׾ƿ� ��ư ������
			if (e.getSource() == jbout) {			
				new LoginWD();
				frame.setVisible(false);
				//��� ��ư ������
			}else if (e.getSource() == jbcancle){
				new MenuWD(student.getId());
				frame.setVisible(false);
				//Ȯ�� ��ư ������
			}else if (e.getSource() == jbsave) {
				// ��й�ȣ, ��й�ȣ Ȯ�� ���� ������
				if (new String(tfpw.getPassword()).equals(new String(tfpwcheck.getPassword()))) {
					//��й�ȣ Ȯ�ο� �Է¾�������
					if(tfpwcheck.getPassword().length==0) {
						tfpw.setText("");
						tfpwcheck.setText("");
						lbalert.setText("��й�ȣ�� Ȯ�����ּ���.");
					}else {						
						String sql = "update teamproject set password = " 
								+ String.valueOf(tfpw.getPassword())+ " where id = '"+student.getId()+"'";

						act.executeMysql(sql);

						new LoginWD();			
						frame.setVisible(false);
					}
				}else {
					lbalert.setText("��й�ȣ�� Ȯ�����ּ���.");
					tfpw.setText("");
					tfpwcheck.setText("");
				} 
			}
		}catch (Exception o) {
			System.out.println(o + " => ���Ͼ��� ����");
		}
	}

}